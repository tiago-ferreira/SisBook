/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.util.persistence;

import br.com.sisbook.util.entity.IObjetoDominio;

/**
 *
 * @author tiago
 */
public interface IObjetoPersistente extends IObjetoDominio{
    	Long getId();

	Long getVersion();

	boolean isPersistente();
}
