/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.enums.Atributo;
import org.receitas.interfaces.Edita;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Alimento;
import org.receitas.interfaces.Entidade;
import org.receitas.dominio.Ingrediente;

/**
 *
 * @author pcrbrandao
 */
public class EditarIngrediente extends Edita {
    
    private Ingrediente in;

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        in = new Ingrediente();
        in.setId(Long.parseLong(req.getParameter(Atributo.ID.getString())));
        in.setDescricao(req.getParameter(Atributo.DESCRICAO.getString()));
        
        Alimento alim = new Alimento();
        
        alim.setId(Long.parseLong(req.getParameter("alimentoId")));
        
        alim = (Alimento)buscaEntidade(alim, req);
        
        in.setAlimento(alim);
        
        if((((in.getId() == null || in.getDescricao() == null) || 
                in.getDescricao().length() <= 0) || in.getAlimento() == null))
            in = null;
        
        return (E)in;
    }
}
