package org.receitas.interfaces;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.receitas.enums.Arquivo;
import org.receitas.enums.Atributo;
import org.receitas.enums.Mensagem;

/**
 * Essa classe lê uma Entidade com o ID, busca, preenche e retorna a
 * Entidade para o arquivo JSP de edição.
 * @author pcrbrandao
 */
public abstract class Ler extends ComandoRequest implements Preenche {
    
    private Entidade entidadeBusca;
    private Entidade entidadeExist;

    /**
     *
     * @param req
     * @param res
     * @return Arquivo que será despachado pelo servlet.
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        // Entidade
        entidadeBusca = preenche(req);
       
        if(entidadeBusca == null) {
            setAttributeMensagem(req, Mensagem.ERRO_PARAMETRO);
        } else {
            entidadeExist = buscaEntidade(entidadeBusca, req);
            req.setAttribute(entidadeExist.getClass().getSimpleName().toLowerCase()
                , entidadeExist);
            
            // dependencias
            Map<String,List<Entidade>> map = new HashMap<>();
            map = obterDependencias(req);
            req.setAttribute(Atributo.DEPENDENCIAS.getString(), map);
            
        }
         return String.format("%s%s.jsp", 
                Arquivo.EDITAR.getArquivoFull(),
                entidadeExist.getClass().getSimpleName());
    }
}
