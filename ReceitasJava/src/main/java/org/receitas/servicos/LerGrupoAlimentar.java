/**
 * Essa classe lê os dados da entidade e encaminha
 * para o jsp de edição.
 */
package org.receitas.servicos;

import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.GrupoAlimentar;
import org.receitas.interfaces.Ler;
import org.receitas.interfaces.Preenche;

/**
 *
 * @author pcrbrandao
 */
public class LerGrupoAlimentar extends Ler implements Preenche {
    
    private final GrupoAlimentar grupo;

    public LerGrupoAlimentar() {
        this.grupo = new GrupoAlimentar();
    }

    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        return (E) setEntidadeId(grupo, req);
    }
}
