/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.receitas.interfaces.Entidade;

/**
 *
 * @author pcrbrandao
 */
@Entity
public class Alimento extends Entidade {
    
    @Column(unique=true, nullable=false)
    private String descricao;
    
    @ManyToOne
    private GrupoAlimentar grupoAlimentar;

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

    public GrupoAlimentar getGrupoAlimentar() {
        return grupoAlimentar;
    }

    public void setGrupoAlimentar(GrupoAlimentar grupoAlimentar) {
        this.grupoAlimentar = grupoAlimentar;
    }
    
    @Override
    public String toString() {
        return String.format("%s: %s", 
                getDescricao(), getGrupoAlimentar().getDescricao());
    }
}
