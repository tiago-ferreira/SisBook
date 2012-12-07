/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.util.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author tiago
 */
public interface IBaseDAO<T extends ObjetoPersistente> {

    List<T> recuperarTodos();

    List<T> recuperarAlguns(int[] intervalo);

    T recuperarPorId(Long id);

    T salvar(T object);

    void excluir(T object);

    <E> List<E> getList(Class<E> classToCast, String query, Object... values);
    
    List<String> getListDistinct(String query,Object... values);

    List<T> getLimitedList(Class<T> classToCast, String query, int limit, Object... values);

    List<T> getNamedList(Class<T> classToCast, String namedQuery, Object... values);

    T getPojo(Class<T> classToCast, String query, Object... values);

    T getPojo(Class<T> classToCast, Serializable primaryKey);

    int execute(String query, Object... values);

}
