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
import org.receitas.dominio.GrupoAlimentar;

/**
 *
 * @author pcrbrandao
 */
public class EditarAlimento extends Edita {
    
    private Alimento a;

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        a = new Alimento();
        a.setId(Long.parseLong(req.getParameter(Atributo.ID.getString())));
        a.setDescricao(req.getParameter(Atributo.DESCRICAO.getString()));
        
        GrupoAlimentar grupo = new GrupoAlimentar();
        grupo.setId(Long.parseLong(req.getParameter("grupoid")));
        grupo = (GrupoAlimentar)buscaEntidade(grupo, req);
        
        a.setGrupoAlimentar(grupo);
        
        if(a.getId()==null || a.getDescricao()==null ||
                a.getDescricao().length()==0 ||
                a.getGrupoAlimentar()==null)
            a = null;
        
        return (E) a;
    }
    
    public Alimento getA() {
        return a;
    }

    public void setA(Alimento a) {
        this.a = a;
    }
}
