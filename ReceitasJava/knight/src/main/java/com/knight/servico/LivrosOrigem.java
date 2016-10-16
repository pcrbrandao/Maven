/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knight.servico;

import com.knight.dao.LivroDAO;
import com.knight.modelo.Livro;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 *
 * @author pcrbrandao
 */
@WebService
@Stateless
public class LivrosOrigem {
    
    public List<Livro> listarLivros() {
        LivroDAO dao = new LivroDAO();
        return dao.listar(dao.getLivro());
    }
    
    public static void iniciarServico() {
        String url = "http://localhost:8090/livros";
        Endpoint.publish(url,
                new LivrosOrigem());
        System.out.printf("Serviço Livros disponível em: %s", url);
    }
}
