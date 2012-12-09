/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.persistence;

import br.com.sisbook.entity.Cidade;
import br.com.sisbook.util.persistence.BaseDAO;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

/**
 *
 * @author tiago
 */
@Stateless
public class CidadeDAO extends BaseDAO<Cidade> implements ICidadeDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Cidade> getClasseDominio() {
        return Cidade.class;
    }

    @Override
    public List<Cidade> recuperaCidadesPorUF(String uf) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cidade> cq = cb.createQuery(Cidade.class);
        Root<Cidade> root = cq.from(Cidade.class);

        EntityType<Cidade> model = root.getModel();
        cq.where(cb.equal(root.get(model.getSingularAttribute("uf", String.class)), uf));

        List<Cidade> cidades = null;
        try {
            cidades = em.createQuery(cq).getResultList();
        } catch (RuntimeException e) {
        }

        return cidades;
    }

    @Override
    public  List<Cidade> recuperaUFs() {
        List<String> strings = getListDistinct("select distinct(c.uf) from Cidade c");
        List<Cidade> cidades = new LinkedList<Cidade>();
        Cidade city;
        for (String string : strings) {
            city = new Cidade();
            city.setUf(string);
            cidades.add(city);
            System.out.println("String Value.: "+string);
        }
        return cidades;
    }
}
