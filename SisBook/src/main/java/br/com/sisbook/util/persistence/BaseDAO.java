/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.util.persistence;

import java.io.Serializable;
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

    @Override
    public <E> List<E> getList(Class<E> classToCast, String query, Object... values) {
        Query qr = createQuery(query, values);
        return qr.getResultList();
    }
    
    @Override
    public List<String> getListDistinct(String query,Object... values){
        Query qr = createQuery(query, values);
        return qr.getResultList();
    }

    @Override
    public List<T> getLimitedList(Class<T> classToCast, String query, int limit, Object... values) {
        Query qr = createQuery(query, values);
        qr.setMaxResults(limit);
        return qr.getResultList();
    }

    @Override
    public List<T> getNamedList(Class<T> classToCast, String namedQuery, Object... values) {
        EntityManager em = getEntityManager();
        Query qr = em.createNamedQuery(namedQuery);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                Object object = values[i];
                qr.setParameter(i + 1, object);
            }
        }
        return qr.getResultList();
    }

    @Override
    public T getPojo(Class<T> classToCast, String query, Object... values) {
        Query qr = createQuery(query, values);
        return (T) qr.getSingleResult();
    }

    @Override
    public T getPojo(Class<T> classToCast, Serializable primaryKey) {
        EntityManager em = getEntityManager();
        return em.find(classToCast, primaryKey);
    }

    @Override
    public int execute(String query, Object... values) {
        Query qr = createQuery(query, values);
        return qr.executeUpdate();
    }

    private Query createQuery(String query, Object[] values) {
        EntityManager em = getEntityManager();
        Query qr = em.createQuery(query);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                Object object = values[i];
                qr.setParameter(i + 1, object);
            }
        }
        return qr;
    }
    
}
