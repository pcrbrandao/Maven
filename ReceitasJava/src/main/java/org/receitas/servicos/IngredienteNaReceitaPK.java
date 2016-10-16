/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author pcrbrandao
 */
public class IngredienteNaReceitaPK implements Serializable{
    
    private Long receitaId;
    private Long ingredienteId;
    
    public IngredienteNaReceitaPK() {}
    
    public IngredienteNaReceitaPK(Long recId, Long ingId) {
        receitaId = recId;
        ingredienteId = ingId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.receitaId);
        hash = 31 * hash + Objects.hashCode(this.ingredienteId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IngredienteNaReceitaPK other = (IngredienteNaReceitaPK) obj;
        if (!Objects.equals(this.receitaId, other.receitaId)) {
            return false;
        }
        if (!Objects.equals(this.ingredienteId, other.ingredienteId)) {
            return false;
        }
        return true;
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
    
    
}
