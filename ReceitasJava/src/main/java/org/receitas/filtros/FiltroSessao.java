/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.receitas.dominio.Usuario;

/**
 *
 * @author pcrbrandao
 */
@WebFilter(filterName="FiltroSessao",
        urlPatterns = {"/jsp/*", "/ReceitaServlet/*"},
        servletNames = {"ReceitaServlet"})
public class FiltroSessao implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // não inicia nada
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {
        
        HttpSession session = ((HttpServletRequest)request).getSession();
        Usuario u = (Usuario)session.getAttribute("usuario");
        session.setAttribute("mensagem", "Usuário não autenticado");
        
        if(u==null) {
            System.out.println("Usuário null no filtro: " + u);
            session.setAttribute("mensagem", "Usuário não autenticado");
            ((HttpServletResponse)response).sendRedirect("/Receitas");
        } else {
            //System.out.println("Usuário !null no filtro: " + u);
            //session.setAttribute("mensagem", "Autenticação OK!");
            /** se a condição do filtro está ok então continua o acesso
            * os comandos antes dessa linha serão executados antes
            * do acesso ao ReceitaServlet
            * */
            
            chain.doFilter(request, response);
            
        }
    }

    @Override
    public void destroy() {
        // finalizando o sistema
    }
    
}
