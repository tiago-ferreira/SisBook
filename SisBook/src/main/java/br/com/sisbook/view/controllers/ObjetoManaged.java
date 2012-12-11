/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.view.controllers;

import br.com.sisbook.entity.Objeto;
import br.com.sisbook.service.IObjetoService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author tiago
 */
@Named
@SessionScoped
public class ObjetoManaged implements Serializable{
    
    @EJB
    private IObjetoService objetoService;
    private Objeto objeto = new Objeto();
    
    
    
    public String limparObjeto(){
        objeto = new Objeto();
        return "/objeto/form.faces";
    }
    
    
    public String salvar(){
        objetoService.salvar(objeto);
        return "/objeto/lista.xhtml";
    }
    
    
}
