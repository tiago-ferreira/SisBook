/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.entity;

import br.com.sisbook.type.EstiloMidia;
import br.com.sisbook.type.TipoMidia;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author tiago
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
public class Midia extends Objeto {


    private String direcao;
    private String faixaEtaria; 
    @Enumerated
    private TipoMidia tipoMidia;
    @Enumerated
    private EstiloMidia estiloMidia;

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    } 

    public TipoMidia getTipoMidia() {
        return tipoMidia;
    }

    public void setTipoMidia(TipoMidia tipoMidia) {
        this.tipoMidia = tipoMidia;
    }

    public EstiloMidia getEstiloMidia() {
        return estiloMidia;
    }

    public void setEstiloMidia(EstiloMidia estiloMidia) {
        this.estiloMidia = estiloMidia;
    }
}
