/*
 Entidade JPA 
 */
package org.receitas.interfaces;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.receitas.JPAUtil;
import org.receitas.exceptions.NonexistentEntityException;
import org.receitas.exceptions.RollbackFailureException;

/**
 * @author pcrbrandao
 */
public class EntidadeController implements Serializable {
    
    private EntityManager em = null;

    public EntidadeController(EntityManager em) {
        if(!em.isOpen())
            em = JPAUtil.getEm();
        this.em = em;
    }

    public EntityManager getEntityManager() {
        if(!em.isOpen())
            em = JPAUtil.getEm();
        return em;
    }

    public < E > void create(E entidade) throws 
            RollbackFailureException, Exception {
        if(!em.isOpen())
            em = JPAUtil.getEm();
        try {
            em.getTransaction().begin();
            em = getEntityManager();
            em.persist(entidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException(
                        "Ocorreu um erro ao tentar roll back da transação: ", re);
            }
            throw ex;
        }
    }
       
    public < E > void destroy(E id, E e) 
            throws NonexistentEntityException, 
            RollbackFailureException, Exception {
        
        e = (E)getEntityManager().getReference(e.getClass(), id);
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(e);
        getEntityManager().getTransaction().commit();
    }
       
    /**
     *
     * @param <E>
     * @param instrucao no formato JPQL. Ex. select u from Usuario u
     * @return Uma lista do tipo T
     */
    public < E > List< E > listaEntidades(String instrucao) {
        if(!em.isOpen())
            em = JPAUtil.getEm();
        
        Query q = em.createQuery(instrucao, Entidade.class);
        
        return q.getResultList();
    }
    
    /**
     * Retorna uma lista cujo os valores estejam na lista
     * Ex: obter Ingredientes que estejam na ReceitaIngrediente
     * @param <E>
     * @param instrucao
     * @param lista
     * @return
     */
    public < E > List< E > listaEntidade(String instrucao, E lista) {
        
        if(!em.isOpen())
            em = JPAUtil.getEm();
        
        Query q = em.createQuery(instrucao);
        q.setParameter("lista", lista);
        
        return q.getResultList();
    }
    
    /**
     *
     * @param <E> Qualquer tipo que seja uma Entidade
     * @param entidade Um objeto do tipo T
     * @return Uma lista com objetos do tipo T
     */
    public < E > List<E> listaEntidades( E entidade ) {
        
        E ent = entidade;
        String classe = ent.getClass().getSimpleName();
        String jpql = String.format("select e from %s e", classe);
        if(!em.isOpen())
            em = JPAUtil.getEm();
        Query query = em.createQuery(jpql, ent.getClass());
        
        List<E> entidades = query.getResultList();
        return entidades;
    }
    
    /**
     *
     * @param <E>
     * @param entidade Um objeto do tipo T
     * @param campo O atributo chave da pesquisa. Ex. nome
     * @param valor O conteúdo parâmetro da query. Ex. Pedro
     * @param oper O operador da query. Ex. =, like, >=, etc...
     * @return Uma lista do tipo T caso a consulta retorne valor
     */
    public < E > List<E> listaEntidades( 
             E entidade, String campo, String valor,
            String oper) {
        
        String jpql = String.format("select e from %s e where %s %s :%s", 
                entidade.getClass().getSimpleName(), campo, oper, campo);
        Query query = getEntityManager().createQuery(jpql);
        query.setParameter(campo, valor);
        
        List<E> lista;
        try {
            lista = query.getResultList();
            
            if(lista.isEmpty())
                throw new Exception("A pesquisa não retornou nenhum item...");
            
            System.out.println("A consulta retornou resultados:");
            for( E e : lista )
                System.out.println(e.toString());
            
        } catch (Exception e) {
            System.out.println("Houve um erro aqui: " + e );
            lista = null;
        }
        return lista;
    }

    public <T extends Entidade> T findEntidade(Long id, T e) {
        
        return (T) getEntityManager().find(e.getClass(), id);
    }
    
    public < E > E find( E id, E ent) {
        
        return (E) getEntityManager().find(ent.getClass(), id); 
    }
    
    public int getEntidadeCount() {
        if(!em.isOpen())
            em = JPAUtil.getEm();
        
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<Entidade> rt = cq.from(Entidade.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        
        return ((Number) q.getSingleResult()).intValue();
    }
    
    public < T extends Entidade > void edit( T entidade ) throws
            NonexistentEntityException, 
            RollbackFailureException, Exception {
        if(!em.isOpen())
            em = JPAUtil.getEm();
        Long id = entidade.getId();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        T eAntiga = (T)em.find(entidade.getClass(), id);
        em.detach(eAntiga);
        
        eAntiga = entidade;
        
        T entidadeNova = em.merge(eAntiga);
        System.out.println(entidadeNova);
        tx.commit();
    }
    
    public < T > void edit(T entidade, T id) throws
            NonexistentEntityException, 
            RollbackFailureException, Exception {
        
        if(!em.isOpen())
            em = JPAUtil.getEm();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        T eAntiga = (T)em.find(entidade.getClass(), id);
        em.detach(eAntiga);
        
        eAntiga = entidade;
        
        T entidadeNova = em.merge(eAntiga);
        System.out.println(entidadeNova);
        tx.commit();
    }
}
