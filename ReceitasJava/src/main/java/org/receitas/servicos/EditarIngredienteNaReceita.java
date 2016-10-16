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
import org.receitas.JPAUtil;
import org.receitas.dominio.Ingrediente;
import org.receitas.dominio.IngredienteNaReceita;
import org.receitas.dominio.Receita;
import org.receitas.dominio.Unidade;
import org.receitas.enums.Arquivo;
import org.receitas.enums.Atributo;
import org.receitas.enums.Mensagem;
import org.receitas.interfaces.Edita;
import org.receitas.interfaces.EntidadeController;

/**
 *
 * @author pcrbrandao
 */
public class EditarIngredienteNaReceita extends Edita {
    
    private Ingrediente ingrediente;
    private Receita receita;
    private Unidade unidade;
    private IngredienteNaReceita ingredienteNaReceita;
    private IngredienteNaReceitaPK ingredienteNaReceitaPK;
    
    private Long ingredienteId;
    private Long receitaId;
    private Long unidadeId;
    
    private Integer quantidade;
    
    public EditarIngredienteNaReceita() {
        
        ingrediente = new Ingrediente();
        receita = new Receita();
        ingredienteNaReceita = new IngredienteNaReceita();
        ingredienteNaReceitaPK = new IngredienteNaReceitaPK();
        unidade = new Unidade();
        
        ingredienteId = Long.parseLong("0");
        receitaId = Long.parseLong("0");
        unidadeId = Long.parseLong("0");
        quantidade = 0;
    }

    @Override
    public <E> E preenche(HttpServletRequest req) {
        
        return (E)getIngredienteNaReceita(req);
    }
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        IngredienteNaReceita entidade = preenche(req);
        
        if(entidade == null) {
            setAttributeMensagem(req, Mensagem.ERRO_PARAMETRO);
        } else {         
            EntityManager emg = (EntityManager)req.getAttribute(Atributo.ENTITY_MAN.getString());
            if(!emg.isOpen())
                emg = JPAUtil.getEm();
            EntidadeController control = new EntidadeController(emg);
            try {
                control.edit(entidade, getIngredienteNaReceitaPK(req));
                setAttributeMensagem(req, Mensagem.EDIT_SUCESSO);
            } catch (Exception e) {
                setAttributeMensagem(req, Mensagem.ERRO_EDIT, e);
            }
        }
        return Arquivo.RESULT.getArquivoFull();
    }
    
    /**
     * Sets e Gets
     * @return 
     */
    
    public Ingrediente getIngrediente() {
        return ingrediente;
    }
    
    public Ingrediente getIngrediente(HttpServletRequest req) {
        setIngrediente(req);
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
    
    public void setIngrediente(HttpServletRequest req) {
        
        ingrediente = (Ingrediente)buscaObjeto(
                getIngrediente(), req, getIngredienteId(req)
        );
    }

    public Receita getReceita() {
        return receita;
    }
    
    public Receita getReceita(HttpServletRequest req) {
        setReceita(req);
        return receita;
    }
    
    public void setReceita(HttpServletRequest req) {
        receita = (Receita)buscaObjeto(
                getReceita(), req, getReceitaId(req) 
                );
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public Unidade getUnidade() {
        return unidade;
    }
    
    public Unidade getUnidade(HttpServletRequest req) {
        setUnidade(req);
        return unidade;
    }
    
    public void setUnidade(HttpServletRequest req) {
        unidade = (Unidade)
                buscaObjeto(getUnidade(), 
                        req, getUnidadeId(req));
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
    
    public Long getUnidadeId() {
        return unidadeId;
    }
    
    public Long getUnidadeId(HttpServletRequest req) {
        setUnidadeId(req);
        return unidadeId;
    }
    
    public void setUnidadeId(HttpServletRequest req) {
        unidadeId = Long.parseLong(req.getParameter("unidadeId"));
    }

    public void setUnidadeId(Long unidadeId) {
        this.unidadeId = unidadeId;
    }

    public IngredienteNaReceita getIngredienteNaReceita() {
        return ingredienteNaReceita;
    }
    
    public IngredienteNaReceita getIngredienteNaReceita(HttpServletRequest req) {
        setIngredienteNaReceita(req);
        return ingredienteNaReceita;
    }
    
    public void setIngredienteNaReceita(HttpServletRequest req) {
        ingredienteNaReceita = 
                (IngredienteNaReceita)
                buscaObjeto(
                        getIngredienteNaReceita(),
                        req,
                        getIngredienteNaReceitaPK(req)
                );
        ingredienteNaReceita.setReceita(getReceita(req));
        ingredienteNaReceita.setIngrediente(getIngrediente(req));
        ingredienteNaReceita.setQuantidade(getQuantidade(req));
        ingredienteNaReceita.setUnidade(getUnidade(req));
    }

    public void setIngredienteNaReceita(IngredienteNaReceita ingredienteNaReceita) {
        this.ingredienteNaReceita = ingredienteNaReceita;
    }

    public IngredienteNaReceitaPK getIngredienteNaReceitaPK() {
        return ingredienteNaReceitaPK;
    }
    
    public IngredienteNaReceitaPK getIngredienteNaReceitaPK(HttpServletRequest req) {
        setIngredienteNaReceitaPK(req);
        return ingredienteNaReceitaPK;
    }
    
    public void setIngredienteNaReceitaPK(HttpServletRequest req) {
        ingredienteNaReceitaPK = 
                new IngredienteNaReceitaPK(
                        getReceitaId(req), getIngredienteId(req));
    }

    public void setIngredienteNaReceitaPK(IngredienteNaReceitaPK ingredienteNaReceitaPK) {
        this.ingredienteNaReceitaPK = ingredienteNaReceitaPK;
    }

    public Long getIngredienteId() {
        return ingredienteId;
    }
    
    public Long getIngredienteId(HttpServletRequest req) {
        setIngredienteId(req);
        return ingredienteId;
    }
    
    public void setIngredienteId(HttpServletRequest req) {
        ingredienteId = Long.parseLong(req.getParameter("ingredienteId"));
    }

    public void setIngredienteId(Long ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    public Long getReceitaId() {
        return receitaId;
    }
    
    public Long getReceitaId(HttpServletRequest req) {
        setReceitaId(req);
        return receitaId;
    }
    
    public void setReceitaId(HttpServletRequest req) {
        receitaId = Long.parseLong(req.getParameter("receitaId"));
    }

    public void setReceitaId(Long receitaId) {
        this.receitaId = receitaId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    
    public Integer getQuantidade(HttpServletRequest req) {
        setQuantidade(req);
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public void setQuantidade(HttpServletRequest req) {
        quantidade = Integer.parseInt(req.getParameter("quantidade"));
    }
    
}
