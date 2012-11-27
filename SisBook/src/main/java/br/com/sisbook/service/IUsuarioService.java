/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.service;

import br.com.sisbook.entity.Usuario;
import java.util.List;

/**
 *
 * @author tiago
 */
public interface IUsuarioService {
    	List<Usuario> getListagem();
	void atualizarListagem();
	void salvar(Usuario usuario);
	Usuario recuperar(Long id);
	Usuario recuperarPorEmail(String email);
        void remover(Usuario usuario);
}
