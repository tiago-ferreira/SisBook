/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.persistence;

import br.com.sisbook.entity.Usuario;
import br.com.sisbook.util.persistence.BaseDAO;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

/**
 *
 * @author tiago
 */
@Stateless
public class UsuarioDAO extends BaseDAO<Usuario> implements IUsuarioDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Usuario> getClasseDominio() {
        return Usuario.class;
    }

    @Override
    public Usuario recuperaPorEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> root = cq.from(Usuario.class);

        EntityType<Usuario> model = root.getModel();
        cq.where(cb.equal(root.get(model.getSingularAttribute("email", String.class)), email));

        Usuario ambulancia = null;
        try {
            ambulancia = em.createQuery(cq).getSingleResult();
        } catch (RuntimeException e) {
        }

        return ambulancia;
    }
}
