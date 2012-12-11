/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.service;

import br.com.sisbook.entity.Midia;
import java.util.List;

/**
 *
 * @author tiago
 */
public interface IMidiaService {
    List<Midia> getListagem();
    void atualizaListagem();
    void salvar(Midia midia);
    void remover(Midia midia);
    Midia recuperaPorId(Long id);
}
