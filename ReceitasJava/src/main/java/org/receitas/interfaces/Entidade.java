// Abastração para entidades
package org.receitas.interfaces;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author pcrbrandao
 */
@MappedSuperclass
public class Entidade implements Serializable {

    /**
     * é o identificador no DB.
     * */
     
    @Id @GeneratedValue
    private Long id;
    
    public Entidade() {}
    
    public Entidade(Long i) {
        id = i;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
