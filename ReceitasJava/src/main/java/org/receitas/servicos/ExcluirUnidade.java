/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.interfaces.Exclui;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Unidade;

/**
 *
 * @author pcrbrandao
 */
public class ExcluirUnidade extends Exclui {
    
    private final Unidade u;

    public ExcluirUnidade() {
        this.u = new Unidade();
    }

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        return (E) setEntidadeId(u, req);
    } 
}
