/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.view.controllers;

import br.com.sisbook.entity.Midia;
import br.com.sisbook.service.IMidiaService;
import br.com.sisbook.type.EstiloMidia;
import br.com.sisbook.type.Genero;
import br.com.sisbook.type.TipoMidia;
import java.io.Serializable;
import java.util.ArrayList;
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
public class MidiaManaged implements Serializable {

    @EJB
    IMidiaService midiaService;
    Midia midia = new Midia();
    private String genero;
    private String estiloMidia;
    private String tipoMidia;
    private static List<SelectItem> generos;
    private static List<SelectItem> estiloDeMidias;
    private static List<SelectItem> tipoDeMidias;

    public List<SelectItem> getGeneros() {
        if (generos == null) {
            generos = new ArrayList<SelectItem>();
            generos.add(new SelectItem(Genero.ADULTO.ordinal(), "Adulto"));
            generos.add(new SelectItem(Genero.INFANTIL.ordinal(), "Infantil"));
        }
        return generos;
    }

    public List<SelectItem> getEstiloDeMidias() {
        if (estiloDeMidias == null) {
            estiloDeMidias = new ArrayList<SelectItem>();
            estiloDeMidias.add(new SelectItem(EstiloMidia.DOCUMENTARIO.ordinal(), "Documentario"));
            estiloDeMidias.add(new SelectItem(EstiloMidia.EDUCACIONAL.ordinal(), "Educacional"));
            estiloDeMidias.add(new SelectItem(EstiloMidia.FILME.ordinal(), "Filme"));
            estiloDeMidias.add(new SelectItem(EstiloMidia.REPORTAGEM.ordinal(), "Reportagem"));
        }
        return estiloDeMidias;
    }

    public List<SelectItem> getTipoDeMidias() {
        if (tipoDeMidias == null) {
            tipoDeMidias = new ArrayList<SelectItem>();
            tipoDeMidias.add(new SelectItem(TipoMidia.CD.ordinal(), "CD"));
            tipoDeMidias.add(new SelectItem(TipoMidia.DVD.ordinal(), "DVD"));
            tipoDeMidias.add(new SelectItem(TipoMidia.BLURAY.ordinal(), "BLURAY"));
        }
        return tipoDeMidias;
    }

    public String limparMidia() {
        midia = new Midia();
        return "/midia/form.xhtml";
    }

    public String edita(Midia midia) {
        this.setMidia(midia);
        return "/midia/form.xhtml";
    }

    public String remove(Midia midia) {
        midiaService.remover(midia);
        atualizaListagem();
        return "/midia/lista.xhtml";
    }

    public List<Midia> getListagem() {
        return midiaService.getListagem();
    }

    public void atualizaListagem() {
        midiaService.atualizaListagem();
    }

    public String salvar() {
        midia.setGenero(Genero.values()[Integer.parseInt(genero)]);
        midia.setEstiloMidia(EstiloMidia.values()[Integer.parseInt(estiloMidia)]);
        midia.setTipoMidia(TipoMidia.values()[Integer.parseInt(tipoMidia)]);
        midiaService.salvar(midia);
        return "/midia/lista.xhtml";
    }

    public Midia getMidia() {
        return midia;
    }

    public void setMidia(Midia midia) {
        this.midia = midia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstiloMidia() {
        return estiloMidia;
    }

    public void setEstiloMidia(String estiloMidia) {
        this.estiloMidia = estiloMidia;
    }

    public String getTipoMidia() {
        return tipoMidia;
    }

    public void setTipoMidia(String tipoMidia) {
        this.tipoMidia = tipoMidia;
    }
}
