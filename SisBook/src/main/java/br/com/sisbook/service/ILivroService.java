/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.service;

import br.com.sisbook.entity.Livro;
import java.util.List;

/**
 *
 * @author tiago
 */
public interface ILivroService {
    List<Livro> getListagem();
    void atualizaListagem();
    void salvar(Livro livro);
    void remover(Livro livro);
    Livro recuperaPorId(Long id);
}
