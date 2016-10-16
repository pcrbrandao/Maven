/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.dominio;

import org.receitas.servicos.IngredienteNaReceitaPK;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author pcrbrandao
 */
@Entity
@Table(name = "Receita_Ingrediente")
@IdClass(IngredienteNaReceitaPK.class)
public class IngredienteNaReceita implements Serializable {
    
    @Id
    private Long receitaId;
    
    @Id
    private Long ingredienteId;
    
    @Column(nullable=false)
    private Integer quantidade;
    
    @ManyToOne
    private Unidade unidade;
    
    @ManyToOne
    @JoinColumn(name = "receitas_id")
    private Receita receita;
    
    @ManyToOne
    @JoinColumn(name = "ingredientes_id")
    private Ingrediente ingrediente;
    
    public IngredienteNaReceita() {}
    
    public IngredienteNaReceita(Receita rec, Ingrediente ing, 
            Integer qt, Unidade un) {
        
        receitaId = rec.getId();
        ingredienteId = ing.getId();
        receita = rec;
        ingrediente = ing;
        quantidade = qt;
        unidade = un;
    }
    
    public IngredienteNaReceita(Long recId, Long ingId) {
        receitaId = recId;
        ingredienteId = ingId;
        receita = new Receita(recId);
        ingrediente = new Ingrediente(ingId);
    }
    
    public IngredienteNaReceita(IngredienteNaReceitaPK inNaRecPk) {
        receitaId = inNaRecPk.getReceitaId();
        ingredienteId = inNaRecPk.getIngredienteId();
        receita = new Receita(inNaRecPk.getReceitaId());
        ingrediente = new Ingrediente(inNaRecPk.getIngredienteId());
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Long getReceitaId() {
        return receitaId;
    }

    public void setReceitaId(Long receitaId) {
        this.receitaId = receitaId;
    }

    public Long getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(Long ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
}
