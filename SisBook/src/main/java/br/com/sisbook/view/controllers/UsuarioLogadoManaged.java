/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.view.controllers;

import br.com.sisbook.entity.Usuario;
import br.com.sisbook.service.IUsuarioService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author tiago
 */
@Named
@SessionScoped
public class UsuarioLogadoManaged implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private IUsuarioService usuarioService;
    private Usuario usuarioLogado;

    public UsuarioLogadoManaged() {
        usuarioLogado = new Usuario();
        Object userLogado = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (userLogado instanceof UserDetails) {
            username = ((UserDetails) usuarioLogado).getUsername();
            usuarioLogado.setEmail(username);
        } else {
            username = userLogado.toString();
            usuarioLogado.setEmail(username);
        }
    }

    public Usuario getUsuarioLogado() {
        return usuarioService.recuperarPorEmail(usuarioLogado.getEmail());
    }

    public boolean isAdmin() {
        if (getUsuarioLogado() != null && getUsuarioLogado().getPapel().equals("ROLE_ADMIN")) {
                return true;
        }
        return false;
    }

    public boolean isUser() {
        if (getUsuarioLogado() != null && getUsuarioLogado().getPapel().equals("ROLE_USER")) {
                return true;
        }
        return false;
    }
}
