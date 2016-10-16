/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knight.dao;

import com.knight.modelo.Livro;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author pcrbrandao
 */
public class LivroDAO extends ObjetoDAO {
    
    private Livro livro;
    
    public LivroDAO() {
        livro = new Livro();
    }
    
    public LivroDAO(Livro li) {
        livro = li;
    }

    public Livro getLivro() {
        return livro;
    }
    
    public Livro getLivro(HttpServletRequest req) {
        setLivro(req);
        return livro;
    }
    
    public void setLivro(HttpServletRequest req) {
        
        Long id;
        String nome;
        
        nome = req.getParameter("nome");
        try {
            id = Long.parseLong(req.getParameter("id"));
            if(id > 0)
                livro.setId(id);
        } catch (Exception e) {
            id = 0L;
        }
        
        if(nome!=null) {
            if(nome.length()>0) {
                livro.setNome(nome);
            }
        } else {
            if(id == 0) {
                livro = null;
            } 
        }
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
}
