/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.interfaces.Adiciona;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Alimento;
import org.receitas.dominio.GrupoAlimentar;

/**
 *
 * @author pcrbrandao
 */
public class AdicionaAlimento extends Adiciona {
    
    private Alimento alimento;

    @Override
    public Object preenche(HttpServletRequest req) {
        
        String descricao = req.getParameter("descricao");
        
        GrupoAlimentar grupo = new GrupoAlimentar();
        grupo.setId(Long.parseLong(req.getParameter("grupoid")));
        grupo = (GrupoAlimentar)buscaEntidade(grupo, req);
        
        if(descricao==null || descricao.length()==0 ||
                grupo == null) {
            alimento = null;
        } else {
            alimento = new Alimento();
            alimento.setDescricao(descricao);
            alimento.setGrupoAlimentar(grupo);
        }
        return alimento;
    }
}
