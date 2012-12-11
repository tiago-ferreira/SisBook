/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.persistence;

import br.com.sisbook.entity.Midia;
import br.com.sisbook.util.persistence.BaseDAO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tiago
 */
@Stateless
public class MidiaDAO extends BaseDAO<Midia> implements IMidiaDAO{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Midia> getClasseDominio() {
       return Midia.class;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
