/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.dominio;

import org.receitas.interfaces.Entidade;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author pcrbrandao
 */
@Entity
public class Receita extends Entidade {
    
    @Column(unique=true, nullable=false)
    private String descricao;
    
    private String procedimento;
    
    @ManyToMany
    private Set<Ingrediente> ingredientes = new HashSet<>();
    
    public Receita() {}
    
    public Receita(Long i) {
        super(i);
    }
    
    /**
     * Gets e Sets
     * @return 
     */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    @Override
    public String toString() {
        return getDescricao();
    }

}
