/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.interfaces.Adiciona;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.GrupoAlimentar;

/**
 *
 * @author pcrbrandao
 */
public class AdicionaGrupoAlimentar extends Adiciona {
    
    private GrupoAlimentar grupo;

    @Override
    public Object preenche(HttpServletRequest req) {
        
        String descricao = req.getParameter("descricao");
        if(descricao==null || descricao.length()==0) {
            grupo = null;
        } else {
            grupo = new GrupoAlimentar();
            grupo.setDescricao(descricao);
        }
        return grupo;
    }
}
