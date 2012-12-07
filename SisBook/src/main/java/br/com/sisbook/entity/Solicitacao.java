/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.entity;

import br.com.sisbook.type.Status;
import br.com.sisbook.util.persistence.ObjetoPersistente;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author tiago
 */
@Entity
public class Solicitacao extends ObjetoPersistente{

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataSolicitacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataDevolucao;
    @ManyToOne
    private Objeto objeto;
    @ManyToOne
    private Usuario usuario;
    @Enumerated
    private Status status;

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
