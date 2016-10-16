/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.enums.Atributo;
import org.receitas.interfaces.Edita;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Unidade;

/**
 *
 * @author pcrbrandao
 */
public class EditarUnidade extends Edita {
    
    private Unidade u;

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        u = new Unidade();
        u.setId(Long.parseLong(req.getParameter(Atributo.ID.getString())));
        u.setDescricao(req.getParameter(Atributo.DESCRICAO.getString()));
        u.setSimbolo(req.getParameter(Atributo.SIMBOLO.getString()));
        
        if(u.getId()==null || u.getDescricao()==null ||
                u.getDescricao().length()==0 || u.getSimbolo()==null ||
                u.getSimbolo().length()==0)
            u = null;
        
        return (E)u;
    }
    
}
