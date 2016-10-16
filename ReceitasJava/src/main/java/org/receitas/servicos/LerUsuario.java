/**
 * Essa classe lê o id da entidade obtem os dados e
 * enchaminha para a página de edição.
 */
package org.receitas.servicos;

import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Usuario;
import org.receitas.interfaces.Ler;
import org.receitas.interfaces.Preenche;

/**
 *
 * @author pcrbrandao
 */
public class LerUsuario extends Ler implements Preenche {
    
    private final Usuario u;
        
    public LerUsuario() {
        this.u = new Usuario();
    }

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        return (E) setEntidadeId(u, req);
    }
}
