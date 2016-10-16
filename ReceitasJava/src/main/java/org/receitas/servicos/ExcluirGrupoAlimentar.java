/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.interfaces.Exclui;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.GrupoAlimentar;

/**
 *
 * @author pcrbrandao
 */
public class ExcluirGrupoAlimentar extends Exclui {
    
    private final GrupoAlimentar grupo;

    public ExcluirGrupoAlimentar() {
        this.grupo = new GrupoAlimentar();
    }

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        return (E) setEntidadeId(grupo, req);
    }
    
}
