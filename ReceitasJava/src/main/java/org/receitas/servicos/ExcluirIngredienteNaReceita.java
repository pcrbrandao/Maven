/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.receitas.dominio.IngredienteNaReceita;
import org.receitas.enums.Arquivo;
import org.receitas.enums.Atributo;
import org.receitas.enums.Mensagem;
import org.receitas.interfaces.EntidadeController;
import org.receitas.interfaces.Exclui;

/**
 *
 * @author pcrbrandao
 */
public class ExcluirIngredienteNaReceita extends Exclui {
    
    private IngredienteNaReceita ingredienteNaReceita;
    private IngredienteNaReceitaPK ingredienteNaReceitaPK;
    
    private Long receitaId;
    private Long ingredienteId;
    
    public ExcluirIngredienteNaReceita() {
        ingredienteNaReceita = new IngredienteNaReceita();
        ingredienteNaReceitaPK = new IngredienteNaReceitaPK();
        
        receitaId = Long.parseLong("0");
        ingredienteId = Long.parseLong("0");
    }

    @Override
    public <E> E preenche(HttpServletRequest req) {
        
        return (E) getIngredienteNaReceita(req);
    }
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        IngredienteNaReceita entidade = preenche(req);
        
        if(entidade == null) {
            setAttributeMensagem(req, Mensagem.ERRO_PARAMETRO);
        } else {
            EntityManager emg = (EntityManager)req.getAttribute(Atributo.ENTITY_MAN.getString());
            EntidadeController control = new EntidadeController(emg);
            try {
                control.destroy(getIngredienteNaReceitaPK(req), entidade);
                setAttributeMensagem(req, Mensagem.DESTROY_SUCESSO);
            } catch (Exception e) {
                setAttributeMensagem(req, Mensagem.DESTROY_ERRO, e);
            }
        }
        return Arquivo.RESULT.getArquivoFull();
    }

    public IngredienteNaReceita getIngredienteNaReceita() {
        return ingredienteNaReceita;
    }
    
    public IngredienteNaReceita getIngredienteNaReceita(HttpServletRequest req) {
        setIngredienteNaReceita(req);
        return ingredienteNaReceita;
    }

    public void setIngredienteNaReceita(IngredienteNaReceita ingredienteNaReceita) {
        this.ingredienteNaReceita = ingredienteNaReceita;
    }
    
    public void setIngredienteNaReceita(HttpServletRequest req) {
        ingredienteNaReceita.setIngredienteId(getIngredienteId(req));
        ingredienteNaReceita.setReceitaId(getReceitaId(req));
    }

    public IngredienteNaReceitaPK getIngredienteNaReceitaPK() {
        return ingredienteNaReceitaPK;
    }
    
    public IngredienteNaReceitaPK getIngredienteNaReceitaPK(HttpServletRequest req) {
        setIngredienteNaReceitaPK(req);
        return ingredienteNaReceitaPK;
    }

    public void setIngredienteNaReceitaPK(IngredienteNaReceitaPK ingredienteNaReceitaPK) {
        this.ingredienteNaReceitaPK = ingredienteNaReceitaPK;
    }
    
    public void setIngredienteNaReceitaPK(HttpServletRequest req) {
        ingredienteNaReceitaPK = 
                new IngredienteNaReceitaPK(
                        getReceitaId(req), getIngredienteId(req));
    }

    public Long getReceitaId() {
        return receitaId;
    }
    
    public Long getReceitaId(HttpServletRequest req) {
        setReceitaId(req);
        return receitaId;
    }

    public void setReceitaId(Long receitaId) {
        this.receitaId = receitaId;
    }
    
    public void setReceitaId(HttpServletRequest req) {
        receitaId = Long.parseLong(req.getParameter("receitaId"));
    }

    public Long getIngredienteId() {
        return ingredienteId;
    }
    
    public Long getIngredienteId(HttpServletRequest req) {
        setIngredienteId(req);
        return ingredienteId;
    }

    public void setIngredienteId(Long ingredienteId) {
        this.ingredienteId = ingredienteId;
    }
    
    public void setIngredienteId(HttpServletRequest req) {
        ingredienteId = Long.parseLong(req.getParameter("ingredienteId"));
    }
    
}
