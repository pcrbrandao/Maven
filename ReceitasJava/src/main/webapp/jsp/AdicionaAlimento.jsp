<%-- 
    Document   : AdicionaAliemento
    Created on : 30/01/2016, 12:40:23
    Author     : pcrbrandao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adiciona Alimento</title>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>Preencha dos dados e clique em adiciona</h1>
        <form action="/Receitas/ReceitaServlet?logica=AdicionaAlimento" method="POST"><br/>
            <fieldset >
                <legend>Adiciona Alimento</legend>
                    Descrição: <input type="text" name="descricao" value="" />
                    <input type="submit" name="OK" value="Adiciona" />
                    <input type="reset" name="reset" value="Limpa" /><br/>
                    Grupo Alimentar: <select name="grupoid" size="1">
                        <c:forEach var="g" items="${dependencias['GrupoAlimentar']}">
                            <option value="${g.id}">${g}</option>
                        </c:forEach>
                    </select>
            </fieldset>
            <p><a href="jsp/Menu.jsp">Inicio</a></p>
        </form>
    </body>
</html>
