/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sisbook.persistence;

import br.com.sisbook.entity.Usuario;
import br.com.sisbook.util.persistence.IBaseDAO;
import javax.ejb.Local;

/**
 *
 * @author tiago
 */
@Local
public interface IUsuarioDAO extends IBaseDAO<Usuario> {
     Usuario recuperaPorEmail(String email);
}
