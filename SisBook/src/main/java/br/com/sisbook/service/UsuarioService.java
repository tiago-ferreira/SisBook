/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.service;

import br.com.sisbook.entity.Usuario;
import br.com.sisbook.persistence.IUsuarioDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author tiago
 */
@Stateful
@SessionScoped
public class UsuarioService implements IUsuarioService,Serializable{

    private List<Usuario> listagem;
    
    @EJB
    private IUsuarioDAO usuarioDAO;
    
    @Override
    public List<Usuario> getListagem() {
        if(listagem == null){
            atualizarListagem();
        }
        return listagem;
    }

    @Override
    public void atualizarListagem() {
        listagem = usuarioDAO.recuperarTodos();
    }

    @Override
    public void criar(Usuario usuario) {
        usuarioDAO.salvar(usuario);
        listagem = null;
    }

    @Override
    public Usuario recuperar(Long id) {
        return usuarioDAO.recuperarPorId(id);
    }

    @Override
    public Usuario recuperarPorEmail(String email) {
       return usuarioDAO.recuperaPorEmail(email);
    }

}
