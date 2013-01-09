/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.service;

import br.com.sisbook.entity.Cidade;
import java.util.List;

/**
 *
 * @author tiago
 */
public interface ICidadeService {
    
     List<Cidade> recuperaUFs();
     List<Cidade> recuperaCidadePorUF(String uf);
}
