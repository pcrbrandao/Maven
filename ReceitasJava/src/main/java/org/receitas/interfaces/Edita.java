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
 */
public abstract class Edita extends ComandoRequest implements Preenche {
    
    private Entidade entidade;

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        entidade = preenche(req);
        if(entidade == null) {
            setAttributeMensagem(req, Mensagem.ERRO_PARAMETRO);
        } else {         
            EntityManager emg = (EntityManager)req.getAttribute(Atributo.ENTITY_MAN.getString());
            if(!emg.isOpen())
                emg = JPAUtil.getEm();
            EntidadeController control = new EntidadeController(emg);
            try {
                control.edit(entidade);
                setAttributeMensagem(req, Mensagem.EDIT_SUCESSO);
            } catch (Exception e) {
                setAttributeMensagem(req, Mensagem.ERRO_EDIT, e);
            }
        }
        return Arquivo.RESULT.getArquivoFull();
    }

    @Override
    public abstract < E > E preenche(HttpServletRequest req);
    
}
