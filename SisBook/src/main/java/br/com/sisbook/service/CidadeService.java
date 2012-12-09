/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.service;

import br.com.sisbook.entity.Cidade;
import br.com.sisbook.persistence.ICidadeDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author tiago
 */
@Stateful
public class CidadeService implements ICidadeService,Serializable {

    @EJB
    private ICidadeDAO cidadeDAO;

    @Override
    public List<Cidade> recuperaUFs() {
        return cidadeDAO.recuperaUFs();
    }

    @Override
    public List<Cidade> recuperaCidadePorUF(String uf) {
        return cidadeDAO.recuperaCidadesPorUF(uf);
    }

}
