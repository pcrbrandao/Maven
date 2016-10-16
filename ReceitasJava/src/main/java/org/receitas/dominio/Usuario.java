// Usuario do sistema
package org.receitas.dominio;

import org.receitas.interfaces.Entidade;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

//@author pcrbrandao 
@NamedQuery(name="Usuario.listarTodos",
        query="select u from Usuario u")
@Entity
public class Usuario extends Entidade {
    @Column(unique=true, nullable=false)
    private String nome;
    
    public Usuario(String n) {
        nome = n;
    }
    
    public Usuario() {
        nome = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        String out = String.format("%s", getNome() );
        return out;
    }
}
