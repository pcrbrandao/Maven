/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knight.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author pcrbrandao
 * @param <E>
 */
public class ObjetoDAO< E > {
    
    public void salvar(E obj) {
        
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(obj);
        tx.commit();
        em.close();
    }
    
    public List<E> listar(E obj) {
        
        EntityManager em = JPAUtil.getEntityManager();
        List<E> lista = new ArrayList<>();
        String jsql = String.format("select e from %s e", 
                obj.getClass().getSimpleName());

        Query q =
                em.createQuery(jsql, obj.getClass());
        lista = q.getResultList();
        
        em.close();
        return lista;
    }
    
    public void excluir(E obj, E id) {
        
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        E ent = (E)em.getReference(obj.getClass(), id);
        
        tx.begin();
        em.remove(ent);
        tx.commit();
        
        em.close();
    }
}
