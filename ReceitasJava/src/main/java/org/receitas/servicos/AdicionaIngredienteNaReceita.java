/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Ingrediente;
import org.receitas.dominio.IngredienteNaReceita;
import org.receitas.dominio.Receita;
import org.receitas.dominio.Unidade;
import org.receitas.interfaces.Adiciona;

/**
 *
 * @author pcrbrandao
 */
public class AdicionaIngredienteNaReceita extends Adiciona {

    @Override
    public Object preenche(HttpServletRequest req) {
        
        IngredienteNaReceita inNaRec;
        Receita receita;
        Ingrediente ingrediente;
        Unidade unidade;
        
        Long receitaId = Long.parseLong(req.getParameter("receitaId"));
        Long ingredienteId = Long.parseLong(req.getParameter("ingredienteId"));
        Long unidadeId = Long.parseLong(req.getParameter("unidadeId"));
        Integer quantidade = Integer.parseInt(req.getParameter("quantidade"));
        
        // dados válidos?
        if(receitaId<=0 || ingredienteId<=0 || unidadeId<=0 ||
                quantidade <= 0) {
            inNaRec = null;
        } else {
            unidade = new Unidade();
            unidade.setId(unidadeId);
            unidade = (Unidade)buscaEntidade(unidade, req);
            
            ingrediente = new Ingrediente();
            ingrediente.setId(ingredienteId);
            ingrediente = (Ingrediente)buscaEntidade(ingrediente, req);
            
            receita = new Receita();
            receita.setId(receitaId);
            receita = (Receita)buscaEntidade(receita, req);
            
            inNaRec = new IngredienteNaReceita(receita, ingrediente,
            quantidade, unidade);

        }
        return inNaRec;
    }
    
}
