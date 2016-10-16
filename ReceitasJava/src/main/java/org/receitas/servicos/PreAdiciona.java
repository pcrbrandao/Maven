/**
 * Ler e enviar a lista dos campos que possuem dependência
 * A idéia é obter as dependências a partir da Entidade
 * lendo o enum Dependencia;
 * Tenho que obter o array e fazer um loop; para cada ocorrência
 * obter a lista da entidade correspondente.
 */
package org.receitas.servicos;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.receitas.dominio.Receita;
import org.receitas.enums.Arquivo;
import org.receitas.enums.Atributo;
import org.receitas.enums.Mensagem;
import org.receitas.interfaces.ComandoRequest;

/**
 *
 * @author pcrbrandao
 * @param <E>
 */
public class PreAdiciona< E > extends ComandoRequest {
    
    /**
     *
     * @param req
     * @param res
     * @return O arquivo que será despachado pelo servlet
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        String retorno = String.format("jsp/Adiciona%s.jsp",
                req.getParameter(Atributo.ENTIDADE.getString()) );
        
        String receitaId = null;
        receitaId = req.getParameter("receitaId");
        
        if(receitaId != null) {
            
            Receita receita = new Receita();
            receita.setId(Long.parseLong(receitaId));
            receita = (Receita)buscaEntidade(receita, req);
        
            req.setAttribute("receita", receita);
        }
        
        Map<String,List<E>> map = new HashMap<>();
        try {
            map = obterDependencias(req);
            req.setAttribute(Atributo.DEPENDENCIAS.getString(), map);
            
        } catch (Exception e) {
            setAttributeMensagem(req, Mensagem.LISTA_ERRO, e);
            return Arquivo.RESULT.getArquivoFull();
        }
        return retorno;
    }
}
