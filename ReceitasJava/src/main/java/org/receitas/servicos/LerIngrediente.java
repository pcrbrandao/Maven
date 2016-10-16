/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Ingrediente;
import org.receitas.interfaces.Ler;
import org.receitas.interfaces.Preenche;

/**
 *
 * @author pcrbrandao
 */
public class LerIngrediente extends Ler implements Preenche {
    
    private final Ingrediente i;

    public LerIngrediente() {
        this.i = new Ingrediente();
    }

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        return (E) setEntidadeId(i, req);
    }
}
