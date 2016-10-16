/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.enums.Atributo;
import org.receitas.interfaces.Edita;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Receita;

/**
 *
 * @author pcrbrandao
 */
public class EditarReceita extends Edita {
    
    private Receita r;

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        r = new Receita();
        r.setId(Long.parseLong(req.getParameter(Atributo.ID.getString())));
        r.setDescricao(req.getParameter(Atributo.DESCRICAO.getString()));
        r.setProcedimento(req.getParameter(Atributo.PROCEDIMENTO.getString()));
        
        if(r.getId() == null || r.getDescricao() == null ||
                r.getDescricao().length()==0)
            r = null;
        
        return (E) r;
    }
    
}
