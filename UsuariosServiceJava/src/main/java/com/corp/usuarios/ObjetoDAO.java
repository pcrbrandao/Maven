/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corp.usuarios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author pcrbrandao
 * @param <E>
 */
public class ObjetoDAO<E> implements interfaceDAO<E>{

    @Override
    public void criar(E obj) {
        
        EntityManager em = JPAUtil.getEm();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(obj);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Erro tentando criar objeto: " + e);
        } finally {
            em.close();
        }
    }
    
    @Override
    public void excluir(E obj, E id) {
        
        EntityManager em = JPAUtil.getEm();
        E objeto = (E)em.getReference(obj.getClass(), id);
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(objeto);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Erro tentando excluir objeto: " + e);
        } finally {
            em.close();
        }
    }
    
    @Override
    public E busca(E obj, E id) {
        
        EntityManager em = JPAUtil.getEm();
        E objResp = null;
        
        try {
            objResp = (E)em.find(obj.getClass(), id);
            System.out.printf("Objeto encontrado: %s", objResp);
        } catch (Exception e) {
            System.out.printf("Erro ao procurar: %s", e);
        } finally {
            em.close();
        }
        
        return objResp;
    }
    
    public E buscaJPQL(String jpql, E obj) {
        
        EntityManager em = JPAUtil.getEm();
        Query query = queryJPQL(jpql, obj, em);
        
        try {
            E objeto = (E)query.getSingleResult();
            return objeto;
        } catch (Exception e) {
            System.out.printf("Erro buscando JPQL: %s", e);
            return null;
        } finally {
            em.close();
        }
    }
    
    public E buscaCampo(E obj, String jpql, String campo, String conteudo) {
        
        EntityManager em = JPAUtil.getEm();
        
        Query query = queryJPQL(jpql, obj, em);
        query.setParameter(campo, conteudo);
        
        try {
            E objeto = (E)query.getSingleResult();
            return objeto;
        } catch (Exception e) {
            System.out.printf("Erro buscando por campo: %s", e);
            return null;
        } finally {
            em.close();
        }
    }
    
    @Override
    public void editar(E obj, E id) {
        
        EntityManager em = JPAUtil.getEm();
        EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            System.out.printf("Editando id: %s", id);
            
            E objAntigo = busca(obj, id);
            em.detach(objAntigo);
            objAntigo = obj;
            em.merge(objAntigo);
            em.flush();
            tx.commit();
        } catch (Exception e) {
            System.out.printf("Erro tentando editar: %s", e);
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<E> lista(E obj) {
        
        String nomeClasse = obj.getClass().getSimpleName();
        String jpql = String.format("select e from %s e", nomeClasse);

        return listaJPQL(jpql, obj);
    }
    
    public List<E> listaJPQL(String jpql, E obj) {
        
        EntityManager em = JPAUtil.getEm();
        
        Query query = queryJPQL(jpql, obj, em);
        
        try {
            List<E> lista = query.getResultList();
            return lista;
        } catch (Exception e) {
            System.out.printf("Erro tentando listar: %s", e);
            return null;
        } finally {
            em.close();
        }
    }
    
    public Query queryJPQL(String jpql, E obj, EntityManager em) {
        
        Query query;
        
        try {
            query = em.createQuery(jpql, obj.getClass());
            return query;
        } catch (Exception e) {
            System.out.printf("Erro tentanto consulta: %s", e);
            return null;
        }
    }
}
