/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.service;

import br.com.sisbook.entity.Midia;
import br.com.sisbook.persistence.IMidiaDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author tiago
 */
@Stateful
@SessionScoped
public class MidiaService implements IMidiaService,Serializable{

    @EJB
    private IMidiaDAO midiaDAO;
    
    private List<Midia> listagem;
    
    @Override
    public List<Midia> getListagem() {
        if(listagem == null){
            atualizaListagem();
        }
        return listagem;
    }

    @Override
    public void atualizaListagem() {
        listagem = midiaDAO.recuperarTodos();
    }

    @Override
    public void salvar(Midia midia) {
        midiaDAO.salvar(midia);
        listagem = null;
    }

    @Override
    public void remover(Midia midia) {
        midiaDAO.excluir(midia);
    }

    @Override
    public Midia recuperaPorId(Long id) {
        return midiaDAO.recuperarPorId(id);
    }

}
