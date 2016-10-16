/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.receitas.filtros;

import java.io.IOException;
import javax.persistence.EntityManager;
// import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.receitas.JPAUtil;
// import org.receitas.servicos.JPAUtil;

/**
 *
 * @author pcrbrandao
 */
@WebFilter("/*")
public class FiltroController implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, 
            ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        
        EntityManager em = JPAUtil.getEm();
        request.setAttribute("entityManager", em);
        
        chain.doFilter(request, response);
        
        em.close();
    }

    @Override
    public void destroy() {
        
    }
    
}
