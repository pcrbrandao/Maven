<%-- 
    Document   : ListaEntidades
    Created on : 05/02/2016, 15:02:11
    Author     : pcrbrandao
--%>

<%@page import="org.receitas.interfaces.Entidade"%>
<%@page import="java.lang.reflect.Method"%>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Entidades</title>
    </head>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>Lista entidades: ${param.entidade}</h1>
        <table border="0">
            <thead>
                <tr>
                    <th style="width: 80px">Id</th>
                    <th>Nome/Descrição</th>
                </tr>
            </thead>
            <c:forEach var="e" items="${listaEntidades}">
                <tr>
                    <td><a href="/Receitas/ReceitaServlet?logica=Ler${nomeDaEntidade}&id=${e.id}&entidade=${nomeDaEntidade}">${e.id}</a></td>
                    <td>${e}</td>
                </tr>
            </c:forEach>
        </table><br/>
        <a href="jsp/Menu.jsp">Início</a>
    </body>
</html>
