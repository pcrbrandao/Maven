/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.receitas.dominio.Ingrediente;
import org.receitas.dominio.Receita;
import org.receitas.dominio.IngredienteNaReceita;
import org.receitas.interfaces.Ler;
import org.receitas.interfaces.Preenche;

/**
 *
 * Retorna as informações para a edição;
 * 1 - Lista com os ingredientes que fazem
 * parte da receita, caso existam;
 * 2 - Lista com os outros ingredientes disponíveis
 * 3 - A entidade preenchida com o id do request.
 * @author pcrbrandao
 */
public class LerReceita extends Ler implements Preenche {
    
    private Receita receita;
    private Ingrediente ingrediente;
    private IngredienteNaReceita receitaIngrediente;

    private List<Ingrediente> ingredientesDisponiveis;
    private List<Ingrediente> ingredientes;
    
    private List<IngredienteNaReceita> receitaIngredientes;
    private List<IngredienteNaReceita> ingredientesNaReceita;

    public LerReceita() {
        receita = new Receita();
        ingrediente = new Ingrediente();
        ingredientesNaReceita = new ArrayList<>();
        ingredientesDisponiveis = new ArrayList<>();
        receitaIngrediente = new IngredienteNaReceita();
        receitaIngredientes = new ArrayList<>();
        ingredientes = new ArrayList<>();
    }

    /**
     * obtém dados e despacha as informações
     * @param <E>
     * @param req
     * @return
     */
    @Override
    public < E > E preenche(HttpServletRequest req) {
        
        // entidade preenchida com o id do request
        setReceita( (Receita)setEntidadeId(getReceita(), req) );
        req.setAttribute("ingredReceita", getIngredientesNaReceita(req));
        req.setAttribute("ingredDisponiveis", getIngredientesDisponiveis(req));
        
        return (E) getReceita();
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public List<IngredienteNaReceita> getIngredientesNaReceita(HttpServletRequest req) {
        if(ingredientesNaReceita.isEmpty()) {
            setIngredientesNaReceita(req);
        }
        return ingredientesNaReceita;
    }
    
    public void setIngredientesNaReceita(HttpServletRequest req) {
        // provisoriamente somente a lista de todos os ingredientes
        // cadastrados
        ingredientesNaReceita = obtemLista(req, getReceitaIngrediente());
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public List<IngredienteNaReceita> getIngredientesNaReceita() {
        return ingredientesNaReceita;
    }

    public void setIngredientesNaReceita(List<IngredienteNaReceita> ingredientesNaReceita) {
        this.ingredientesNaReceita = ingredientesNaReceita;
    }

    public List<Ingrediente> getIngredientesDisponiveis(HttpServletRequest req) {
        if(ingredientesDisponiveis.isEmpty())
            setIngredientesDisponiveis(req);
        
        return ingredientesDisponiveis;
    }
    
    public void setIngredientesDisponiveis(HttpServletRequest req) {
        
        //provisoriamente, todos os ingredientes
        ingredientesDisponiveis = obtemLista(req, getIngrediente());
    }

    public void setIngredientesDisponiveis(List<Ingrediente> in) {
        ingredientesDisponiveis = in;
    }
    
    public IngredienteNaReceita getReceitaIngrediente() {
        return receitaIngrediente;
    }

    public void setReceitaIngrediente(IngredienteNaReceita receitaIngrediente) {
        this.receitaIngrediente = receitaIngrediente;
    }

    public List<IngredienteNaReceita> getReceitaIngredientes(HttpServletRequest req) {
        if(receitaIngredientes.isEmpty()) {
            setReceitaIngredientes(req);
        }
        return receitaIngredientes;
    }

    public void setReceitaIngredientes(List<IngredienteNaReceita> receitaIngredientes) {
        this.receitaIngredientes = receitaIngredientes;
    }
    
    public void setReceitaIngredientes( HttpServletRequest req ) {
        receitaIngredientes = obtemLista(req, getReceitaIngrediente());
    }
    
    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    
    public List<Ingrediente> getIngredientes(HttpServletRequest req) {
        if(ingredientes.isEmpty())
            setIngredientes(req);
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    public void setIngredientes(HttpServletRequest req) {
        ingredientes = obtemLista(req, getIngrediente());
    }
}
