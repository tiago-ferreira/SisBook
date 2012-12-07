/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.persistence;

import br.com.sisbook.entity.Cidade;
import br.com.sisbook.util.persistence.IBaseDAO;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author tiago
 */
@Local
public interface ICidadeDAO extends IBaseDAO<Cidade> {
    public List<Cidade> recuperaUFs();
    public List<Cidade> recuperaCidadesPorUF(String uf);
}
