/*
* Provê atributos para um JPAController
 */
package org.receitas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author pcrbrandao
 */
public class JPAUtil {
    
    private static final String persistenceUnit = "receitas";
    private static final EntityManagerFactory emf;
    
    static {
        emf = Persistence.createEntityManagerFactory(persistenceUnit);
    }
    
    public static EntityManager getEm() {
        
        return emf.createEntityManager();
    }
}
