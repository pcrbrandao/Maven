/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.enums.Atributo;
import org.receitas.interfaces.Edita;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Usuario;

/**
 *
 * @author pcrbrandao
 */
public class EditarUsuario extends Edita {
    
    private Usuario u;

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        u = new Usuario();
        u.setId(Long.parseLong(req.getParameter(Atributo.ID.getString())));
        u.setNome(req.getParameter(Atributo.NOME.getString()));
        
        if(u.getId()==null || u.getNome()==null ||
                u.getNome().length()==0)
            u = null;
        
        return (E)u;
    }  
}
