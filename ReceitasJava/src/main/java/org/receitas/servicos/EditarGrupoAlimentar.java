/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.enums.Atributo;
import org.receitas.interfaces.Edita;
import javax.servlet.http.HttpServletRequest;
import org.receitas.interfaces.Entidade;
import org.receitas.dominio.GrupoAlimentar;

/**
 *
 * @author pcrbrandao
 */
public class EditarGrupoAlimentar extends Edita {
    
    private GrupoAlimentar grupo;

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        grupo = new GrupoAlimentar();
        grupo.setId(Long.parseLong(req.getParameter(Atributo.ID.getString())));
        grupo.setDescricao(req.getParameter(Atributo.DESCRICAO.getString()));
        
        if(grupo.getId()==null || grupo.getDescricao()==null || 
                grupo.getDescricao().length()==0)
            grupo = null;
        
        return (E)grupo;
    }
}
