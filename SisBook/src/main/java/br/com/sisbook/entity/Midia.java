/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.entity;

import br.com.sisbook.type.EstiloMidia;
import br.com.sisbook.type.TipoMidia;
import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author tiago
 */
@Entity
public class Midia extends Objeto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String direcao;
    private String faixaEtaria; 
    private TipoMidia tipoMidia;
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
