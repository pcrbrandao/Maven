/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knight.servico;

import com.knight.modelo.Livro;
import java.util.List;

/**
 *
 * @author pcrbrandao
 */
public class LivrosCliente {
    
    public List<Livro> lista() {
        
        LivrosOrigemService listaLivrosFactory =
                new LivrosOrigemService();
        Livros listarLivros =
                listaLivrosFactory.getLivrosPort();
        
        List<Livro> livros = listarLivros.listarLivros();
        return livros;
    }
}
