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
public class Endereco extends ObjetoPersistente{

    private String cep;
    private String bairro;
    private String logradouro;
    private String complemento;
    private Integer numero;
    @ManyToOne
    private Cidade cidade;

    public Endereco(){
        this.cidade = new Cidade();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
}
