/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.interfaces.Exclui;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Ingrediente;

/**
 *
 * @author pcrbrandao
 */
public class ExcluirIngrediente extends Exclui {
    
    private final Ingrediente i;

    public ExcluirIngrediente() {
        this.i = new Ingrediente();
    }

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        return (E) setEntidadeId(i, req);
    }
}
