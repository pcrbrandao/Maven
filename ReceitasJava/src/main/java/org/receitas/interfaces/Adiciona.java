/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.interfaces;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.receitas.JPAUtil;
import org.receitas.enums.Arquivo;
import org.receitas.enums.Atributo;
import org.receitas.enums.Mensagem;

/**
 *
 * @author pcrbrandao
 * @param <E>
 */
public abstract class Adiciona< E > extends ComandoRequest implements Preenche {
    
    private E entidade;
    
    @Override
    public abstract < E > E preenche(HttpServletRequest req);
    
    /**
     *Obtém os dados do request, valida e adiciona a entidade
     * @param req
     * @param res
     * @return
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
        // preenche o usuário
        entidade = preenche(req);
        if(entidade == null) {
            setAttributeMensagem(req, Mensagem.ERRO_PARAMETRO);
        } else {
            EntityManager emg = (EntityManager)req.getAttribute(Atributo.ENTITY_MAN.getString());
            if(!emg.isOpen())
                emg = JPAUtil.getEm();
            
            EntidadeController controller = new EntidadeController(emg);
            
            try {
                controller.create(entidade);
                setAttributeMensagem(req, Mensagem.CREATE_SUCESSO);
            } catch (Exception e) {
                setAttributeMensagem(req, Mensagem.CREATE_ERRO, e);
            }
        }
        return Arquivo.RESULT.getArquivoFull();
    }
}
