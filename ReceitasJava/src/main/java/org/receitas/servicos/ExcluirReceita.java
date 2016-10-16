/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.interfaces.Exclui;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Receita;

/**
 *
 * @author pcrbrandao
 */
public class ExcluirReceita extends Exclui {
    
    private final Receita r;

    public ExcluirReceita() {
        this.r = new Receita();
    }

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        return (E) setEntidadeId(r, req);
    }
    
    
    
}
