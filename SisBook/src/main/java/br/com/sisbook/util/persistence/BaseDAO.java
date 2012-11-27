/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.util.persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author tiago
 */
public abstract class BaseDAO<T extends ObjetoPersistente> implements IBaseDAO<T> {

    protected abstract EntityManager getEntityManager();

    protected abstract Class<T> getClasseDominio();

    @Override
    public List<T> recuperarTodos() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(getClasseDominio()));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<T> recuperarAlguns(int[] intervalo) {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(getClasseDominio()));
        Query q = em.createQuery(cq);
        q.setMaxResults(intervalo[1] - intervalo[0]);
        q.setFirstResult(intervalo[0]);
        return q.getResultList();
    }

    @Override
    public T recuperarPorId(Long id) {
        EntityManager em = getEntityManager();
        return (T) em.find(getClasseDominio(), id);
    }

    @Override
    public T salvar(T objeto) {
        EntityManager em = getEntityManager();
        if (objeto.isPersistente()) {
            objeto = em.merge(objeto);
        } else {
            em.persist(objeto);
        }
        return objeto;
    }

    @Override
    public void excluir(T objeto) {
        EntityManager em = getEntityManager();
        em.remove(em.merge(objeto));
    }
}
