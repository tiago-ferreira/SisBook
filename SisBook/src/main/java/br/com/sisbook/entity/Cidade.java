/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.entity;

import br.com.sisbook.util.persistence.ObjetoPersistente;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author tiago
 */
@Entity
public class Cidade extends ObjetoPersistente{

    private String descricao;
    @ManyToOne
    private Uf uf;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
    }

}
