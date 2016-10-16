/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.interfaces.ComandoRequest;
import org.receitas.controllers.UsuarioController;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.receitas.dominio.Usuario;

/**
 * Esta classe está obsoleta
 * Utilize ListaEntidades
 * @author pcrbrandao
 */
public class ListaUsuarios extends ComandoRequest {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        String jpql = "Usuario.listarTodos";
        
        try {
            EntityManager emg = (EntityManager)req.getAttribute("entityManager");
            UsuarioController controller = new UsuarioController(emg);
        
            List<Usuario> usuarios = controller.listaUsuarios(jpql);
            req.setAttribute("usuarios", usuarios);
        
            return "jsp/ListaUsuarios.jsp";
        } catch (Exception e) {
            req.setAttribute("mensagem", "Houve um erro aqui" );
            System.out.println("Um erro aqui: " + e);
            
            return "jsp/Resultado.jsp";
        }
        
    }
}
