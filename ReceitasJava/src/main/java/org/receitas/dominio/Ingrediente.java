/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.dominio;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import org.receitas.interfaces.Entidade;

/**
 *
 * @author pcrbrandao
 */
@NamedQuery(name="Ingrediente.listarTodos",
        query="select i from Ingrediente i")
@Entity
public class Ingrediente extends Entidade {
    
    @Column(unique=true, nullable=false)
    private String descricao;
    
    @ManyToOne
    private Alimento alimento;
    
    @ManyToMany(mappedBy="ingredientes")
    private List<Receita> receitas;
    
    public Ingrediente() {}
    
    public Ingrediente(Long i) {
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

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s", getDescricao(), getAlimento());
    }
}
