/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.view.controllers;

import br.com.sisbook.entity.Livro;
import br.com.sisbook.service.ILivroService;
import br.com.sisbook.type.Genero;
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
public class LivroManaged implements Serializable {

    @EJB
    ILivroService livroService;
    Livro livro = new Livro();
    private String genero;
    private static List<SelectItem> generos;

    public List<SelectItem> getGeneros() {
        if (generos == null) {
            generos = new ArrayList<SelectItem>();
            generos.add(new SelectItem(Genero.ADULTO.ordinal(), "Adulto"));
            generos.add(new SelectItem(Genero.INFANTIL.ordinal(), "Infantil"));
        }
        return generos;
    }

    public String limparLivro() {
        livro = new Livro();
        return "/livro/form.xhtml";
    }

    public String edita(Livro livro) {
        this.setLivro(livro);
        return "/livro/form.xhtml";
    }

    public String remove(Livro livro) {
        livroService.remover(livro);
        atualizaListagem();
        return "/livro/lista.xhtml";
    }

    public List<Livro> getListagem() {
        return livroService.getListagem();
    }

    public void atualizaListagem() {
        livroService.atualizaListagem();
    }

    public String salvar() {
        livro.setGenero(Genero.values()[Integer.parseInt(genero)]);
        livroService.salvar(livro);
        return "/livro/lista.xhtml";
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
