/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.receitas.servicos.ProcuraUsuarioNome;

/**
 *
 * @author pcrbrandao
 */
@WebServlet("/AutenticaServlet")
public class AutenticaServlet extends ReceitaServlet {
    
    
    @Override
    protected void processRequest(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // String parametro = request.getParameter("logica");
        // String nomeDaClasse = "org.receitas.servicos." + parametro;
        
        try {
            ProcuraUsuarioNome procura = new ProcuraUsuarioNome();
            // Recebe após execução da lógica
            String pagina = procura.executa(request, response);
            
            request.getRequestDispatcher(pagina).forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Erro na autenticação", e);
        }
    }
}
