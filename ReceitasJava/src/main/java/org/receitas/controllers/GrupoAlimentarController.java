/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.controllers;

import org.receitas.interfaces.EntidadeController;
import java.util.List;
import javax.persistence.EntityManager;
import org.receitas.dominio.GrupoAlimentar;

/**
 *
 * @author pcrbrandao
 */
public class GrupoAlimentarController extends EntidadeController {

    public GrupoAlimentarController(EntityManager em) {
        super(em);
    }
    
    public List<GrupoAlimentar> listaGrupoAlimentar(String q) {
        
        List<GrupoAlimentar> grupos = listaEntidades(q);
        
        return grupos;
    }
}
