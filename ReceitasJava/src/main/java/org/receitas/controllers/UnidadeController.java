/**
 * 
 * Esse é o controller para a entidade Unidade.
 * Ele não possui ainda métodos específicos, mas
 * vou me referir a ele para que se precisar fazer
 * alterações no controller específico eu não vou precisar
 * buscar no código onde estão essas referências.
 * 
 */
package org.receitas.controllers;

import org.receitas.interfaces.EntidadeController;
import javax.persistence.EntityManager;

/**
 *
 * @author pcrbrandao
 */
public class UnidadeController extends EntidadeController {

    public UnidadeController(EntityManager em) {
        super(em);
    } 
}
