package org.receitas.servicos;

import org.receitas.interfaces.Adiciona;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Usuario;

/**
 *
 * @author pcrbrandao
 */
public class AdicionaUsuario extends Adiciona {
    
    private Usuario usuario;

    /**
     *Preenche as informações da entidade Usuario.
     * @param req
     * @return 
     */
    @Override
    public Object preenche(HttpServletRequest req) {
        
        String nome = req.getParameter("nome");
        if(nome==null || nome.length()==0) {
            usuario = null;
        } else {
            usuario = new Usuario();
            usuario.setNome(nome);
        }
        return usuario;
    }
}
