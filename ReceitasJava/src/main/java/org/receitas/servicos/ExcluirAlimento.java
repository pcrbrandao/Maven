/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.interfaces.Exclui;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Alimento;

/**
 *
 * @author pcrbrandao
 */
public class ExcluirAlimento extends Exclui {
    
    private final Alimento a;

    public ExcluirAlimento() {
        this.a = new Alimento();
    }

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        return (E) setEntidadeId(a, req);
    }
}
