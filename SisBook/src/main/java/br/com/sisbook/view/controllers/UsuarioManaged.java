/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.view.controllers;

import br.com.sisbook.entity.Usuario;
import br.com.sisbook.service.IUsuarioService;
import br.com.sisbook.type.Sexo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author tiago
 */
@Model
public class UsuarioManaged {

    @EJB
    private IUsuarioService usuarioService;
    private Usuario usuario = new Usuario();
    private String sexo;
    private static List<SelectItem> sexos;

    public List<SelectItem> getSexos() {
        if (sexos == null) {
            sexos = new ArrayList<SelectItem>();
            sexos.add(new SelectItem(Sexo.FEMININO.ordinal(), "Feminino"));
            sexos.add(new SelectItem(Sexo.MASCULINO.ordinal(), "Masculino"));
        }
        return sexos;
    }

    public List<Usuario> getListagem() {
        return usuarioService.getListagem();
    }

    public void atualizaListagem() {
        usuarioService.atualizarListagem();
    }

    public String salvar() {
        usuario.setSexo(Sexo.values()[Integer.parseInt(sexo)]);
        usuarioService.criar(usuario);
        return "/usuario/lista.xhtml";
    }

    public void verificaEmail() {
        Usuario user = usuarioService.recuperarPorEmail(usuario.getEmail());
        if (user != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("form:email", new FacesMessage("Já existe um Usuario cadastrado com este Email."));
        }
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
