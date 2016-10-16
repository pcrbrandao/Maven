/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.interfaces.Adiciona;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Receita;

/**
 *
 * @author pcrbrandao
 */
public class AdicionaReceita extends Adiciona {
    
    private Receita receita;

    @Override
    public Object preenche(HttpServletRequest req) {
        
        String descricao = req.getParameter("descricao");
        String procedimento = req.getParameter("procedimento");
        
        if(descricao==null || descricao.length()==0) {
            receita = null;
        } else {
            receita = new Receita();
            receita.setDescricao(descricao);
            receita.setProcedimento(procedimento);
        }
        return receita;
    }
    
}
