/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.util.entity;

import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author tiago
 */
@MappedSuperclass
public class ObjetoDominio implements IObjetoDominio{

    private static final long serialVersionUID = 1L;
    @Basic
    @Column(nullable = false, length = 40)
    protected String uuid;

    public ObjetoDominio() {
        uuid = UUID.randomUUID().toString();
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (!getClass().equals(obj.getClass()))) {
            return false;
        }
        ObjetoDominio o = (ObjetoDominio) obj;

        return uuid.equals(o.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    public int compareTo(ObjetoDominio o) {
        return uuid.compareTo(o.uuid);
    }
}
