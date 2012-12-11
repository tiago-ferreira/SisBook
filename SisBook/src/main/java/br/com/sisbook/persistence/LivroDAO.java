/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.persistence;

import br.com.sisbook.entity.Livro;
import br.com.sisbook.util.persistence.BaseDAO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tiago
 */
@Stateless
public class LivroDAO extends BaseDAO<Livro> implements ILivroDAO{

    @PersistenceContext
    EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Livro> getClasseDominio() {
        return Livro.class;
    }

}
