/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.util.persistence;

import java.util.List;

/**
 *
 * @author tiago
 */
public interface IBaseDAO<T extends ObjetoPersistente>{
    	List<T> recuperarTodos();

	List<T> recuperarAlguns(int[] intervalo);

	T recuperarPorId(Long id);

	T salvar(T object);

	void excluir(T object);
}
