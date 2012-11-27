/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.util.persistence;

import br.com.sisbook.util.entity.ObjetoDominio;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 *
 * @author tiago
 */
@MappedSuperclass
public class ObjetoPersistente extends ObjetoDominio implements IObjetoPersistente, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Version
    @Column(nullable = false)
    private Long version;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public Long getVersion() {
        return version;
    }

    @Override
    public boolean isPersistente() {
        return (id != null);
    }

    @Override
    public String toString() {
        return "Instância de " + getClass().getName() + " (id: " + id + "; uuid: " + uuid + ")";
    }
}
