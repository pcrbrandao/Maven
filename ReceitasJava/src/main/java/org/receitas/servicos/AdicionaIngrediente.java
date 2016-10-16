package org.receitas.servicos;

import org.receitas.interfaces.Adiciona;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Alimento;
import org.receitas.dominio.Ingrediente;

/**
 * Aqui eu crio uma Entidade específica
 * e a preencho com as informações para o método executa.
 * @author pcrbrandao
 */
public class AdicionaIngrediente extends Adiciona {
    
    private Ingrediente i;

    @Override
    public Ingrediente preenche(HttpServletRequest req) {
        
        Alimento alim = new Alimento();
        
        alim.setId(Long.parseLong(req.getParameter("alimentoId")));
        
        alim = (Alimento)buscaEntidade(alim, req);
        
        String descricao = req.getParameter("descricao");
        
        if(descricao==null || descricao.length()==0 || alim==null) {
            i = null;
        } else {
            i = new Ingrediente();
            i.setDescricao(descricao);
            i.setAlimento(alim);
        }
        return i;
    }
    
}
