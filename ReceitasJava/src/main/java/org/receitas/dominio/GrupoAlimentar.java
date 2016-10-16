/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.dominio;

import org.receitas.interfaces.Entidade;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author pcrbrandao
 */

@Entity
public class GrupoAlimentar extends Entidade {
    
    @Column(unique=true, nullable=true)
    private String descricao;
    
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
    
    @Override
    public String toString() {
        return getDescricao();
    }
}
