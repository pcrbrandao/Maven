/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servicos;

import org.receitas.interfaces.ComandoRequest;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.receitas.dominio.Usuario;
import org.receitas.controllers.UsuarioController;

/**
 *
 * @author pcrbrandao
 */
public class ProcuraUsuarioNome extends ComandoRequest {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {
        
        String n = req.getParameter("nome");
        if(n==null || n.length()==0) {
            req.setAttribute("mensagem", "O nome não pode ser nulo...");
            return "AutenticaErro.jsp";
        } else {
            EntityManager em =(EntityManager)req.getAttribute("entityManager");
            UsuarioController controller = new UsuarioController(em);
            try {
                Usuario u = controller.buscaPorNome(n);
                HttpSession sessao = ((HttpServletRequest)req).getSession();
                sessao.setAttribute("usuario", u);
                sessao.setAttribute("sessao", "Sessao Id: " + sessao.getId());
                return "jsp/AutenticaSucesso.jsp";
            } catch (Exception e) {
                System.out.println("Ocorreu um erro aqui: " + e );
                req.setAttribute("mensagem", "Deu erro quando fiz a busca por nome...");
                return "AutenticaErro.jsp";
            }
        }
    }
    
}
