/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.entity;

import br.com.sisbook.util.persistence.ObjetoPersistente;
import javax.persistence.Entity;

/**
 *
 * @author tiago
 */
@Entity
public class Uf extends ObjetoPersistente{

    private char sigla;
    private String descricao;

    public char getSigla() {
        return sigla;
    }

    public void setSigla(char sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
