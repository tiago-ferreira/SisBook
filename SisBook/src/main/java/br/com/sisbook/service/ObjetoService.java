/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.service;

import br.com.sisbook.entity.Objeto;
import br.com.sisbook.persistence.IObjetoDAO;
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
public class ObjetoService implements IObjetoService,Serializable{

    private List<Objeto> objetos;
    
    @EJB
    IObjetoDAO objetoDAO;
    
    @Override
    public List<Objeto> getListagem() {
        if(objetos == null){
            atualizaListagem();
        }
        return objetos;
    }

    @Override
    public void atualizaListagem() {
        objetos = objetoDAO.recuperarTodos();
    }

    @Override
    public void salvar(Objeto objeto) {
        objetoDAO.salvar(objeto);
    }

    @Override
    public void remover(Objeto objeto) {
        objetoDAO.excluir(objeto);
    }

    @Override
    public Objeto recuperarPorId(Long id) {
        return objetoDAO.recuperarPorId(id);
    }
    
}
