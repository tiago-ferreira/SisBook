/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.service;

import br.com.sisbook.entity.Livro;
import br.com.sisbook.persistence.ILivroDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author tiago
 */
@Stateful
@SessionScoped
public class LivroService implements ILivroService, Serializable {

    private List<Livro> listagem;
    private ILivroDAO livroDAO;

    @Override
    public List<Livro> getListagem() {
        if (listagem == null) {
            atualizaListagem();
        }
        return listagem;
    }

    @Override
    public void atualizaListagem() {
        listagem = livroDAO.recuperarTodos();
    }

    @Override
    public void salvar(Livro livro) {
        livroDAO.salvar(livro);
    }

    @Override
    public void remover(Livro livro) {
        livroDAO.excluir(livro);
    }

    @Override
    public Livro recuperaPorId(Long id) {
        return livroDAO.recuperarPorId(id);
    }
}
