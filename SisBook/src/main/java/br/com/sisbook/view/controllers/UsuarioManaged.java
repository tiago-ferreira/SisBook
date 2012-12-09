/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.view.controllers;

import br.com.sisbook.entity.Endereco;
import br.com.sisbook.entity.Usuario;
import br.com.sisbook.service.IUsuarioService;
import br.com.sisbook.type.Sexo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author tiago
 */
@Named
@SessionScoped
public class UsuarioManaged implements Serializable {

    @EJB
    private IUsuarioService usuarioService;
    private Usuario usuario = new Usuario();
    private Endereco endereco = new Endereco();
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

    public String limparUsuario() {
        usuario = new Usuario();
        return "/usuario/form.xhtml";
    }

    public String edita(Usuario usuario) {
        this.setUsuario(usuario);
        return "/usuario/form.xhtml";
    }

    public String remove(Usuario usuario) {
        usuarioService.remover(usuario);
        atualizaListagem();
        return "/usuario/lista.xhtml";
    }

    public List<Usuario> getListagem() {
        return usuarioService.getListagem();
    }

    public void atualizaListagem() {
        usuarioService.atualizarListagem();
    }

    public String salvar() {
        usuario.setSexo(Sexo.values()[Integer.parseInt(sexo)]);
        usuario.setEndereco(endereco);
        usuarioService.salvar(usuario);
        return "/usuario/lista.xhtml";
    }

    public void verificaEmail() {
        Usuario user = usuarioService.recuperarPorEmail(usuario.getEmail());
        if (user != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("form:email", new FacesMessage("Já existe um Usuario cadastrado com este Email."));
        }
    }

    public String onFlowProcess(FlowEvent event) {
        if(event.getNewStep().equals("infoEndereco") && event.getOldStep().equals("infoUsuario")){
            return "infoEndereco";
        }else if(event.getNewStep().equals("infoUsuario") && event.getOldStep().equals("infoEndereco")){
            return "infoUsuario";
        }
        return null;
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
