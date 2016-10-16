/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.dominio;

import org.receitas.interfaces.Entidade;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author pcrbrandao
 */
@NamedQuery(name="Unidade.listarTodos",
        query="select un from Usuario un")
@Entity
public class Unidade extends Entidade {
    
    @Column(unique=true, nullable=false)
    private String simbolo;
    
    @Column(nullable=false)
    private String descricao;
    
    public Unidade() {}
    
    public Unidade(String simb, String desc) {
        simbolo = simb;
        descricao = desc;
    }
    
    /**
     * Gets e Sets
     * @return 
     */
    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s", getDescricao(), getSimbolo());
    }
}
