/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.service;

import br.com.sisbook.entity.Objeto;
import java.util.List;

/**
 *
 * @author tiago
 */
public interface IObejtoService {
    List<Objeto> getListagem();
    void atualizaListagem();
    void salvar(Objeto objeto);
    void remover(Objeto objeto);
    Objeto recuperarPorId(Long id);
}
