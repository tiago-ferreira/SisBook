/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.view.controllers;

import br.com.sisbook.entity.Cidade;
import br.com.sisbook.service.ICidadeService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

/**
 *
 * @author tiago
 */
@Named
@SessionScoped
public class CidadeManaged implements Serializable{

    @EJB
    private ICidadeService cidadeService;
    private List<SelectItem> ufs;
    private String uf;
    private List<Cidade> cidades = new LinkedList<Cidade>();

    public List<SelectItem> getUfs() {
        if (ufs == null) {
            ufs = new ArrayList<SelectItem>();
            for (Cidade cidade : cidadeService.recuperaUFs()) {
                ufs.add(new SelectItem(cidade.getUf(), cidade.getUf()));
            }
        }
        return ufs;
    }
    
    public void selecionaCidadesUF() {
        cidades = cidadeService.recuperaCidadePorUF(uf);
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}
