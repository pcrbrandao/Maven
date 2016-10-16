package org.receitas.servicos;

import org.receitas.interfaces.Adiciona;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Unidade;

/**
 *Aqui eu crio uma Entidade específica
 * e a preencho com as informações para o método executa.
 * @author pcrbrandao
 */
public class AdicionaUnidade extends Adiciona {
    
    private Unidade unidade;

    /**
     *Preenche as informações da entidade Unidade.
     * @param req
     * @return
     */
    @Override
    public Object preenche(HttpServletRequest req) {
        
        String simbolo = req.getParameter("simbolo");
        String descricao = req.getParameter("descricao");
        
        if(simbolo==null || simbolo.length()==0 ||
                descricao==null || descricao.length()==0) {
            unidade = null;
        } else {
            unidade = new Unidade();
            unidade.setSimbolo(simbolo);
            unidade.setDescricao(descricao);
        }
        return unidade;
    }
}
