/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.controllers;

import org.receitas.interfaces.EntidadeController;
import javax.persistence.EntityManager;

/**
 *
 * @author pcrbrandao
 */
public class ReceitaController extends EntidadeController {

    public ReceitaController(EntityManager em) {
        super(em);
    }
    
}
