/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.persistence;

import br.com.sisbook.entity.Objeto;
import br.com.sisbook.util.persistence.BaseDAO;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tiago
 */
public class ObjetoDAO extends BaseDAO<Objeto> implements IObjetoDAO,Serializable{

    @PersistenceContext
    EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Objeto> getClasseDominio() {
        return Objeto.class;
    }
    
}
