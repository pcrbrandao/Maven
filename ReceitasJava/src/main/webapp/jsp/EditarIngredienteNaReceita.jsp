<%-- 
    Document   : Editar IngredienteNaReceita
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
        <title>Editar Ingrediente na Receita</title>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>Faça a alteração e clique em Modificar</h1>
        <a href="/Receitas/ReceitaServlet?logica=ExcluirIngredienteNaReceita&receitaId=${ingredienteNaReceita.receita.id}&ingredienteId=${ingredienteNaReceita.ingrediente.id}">Excluir</a><br/>
        <form action="/Receitas/ReceitaServlet?logica=EditarIngredienteNaReceita&receitaId=${ingredienteNaReceita.receita.id}&ingredienteId=${ingredienteNaReceita.ingrediente.id}" method="POST"><br/>
            <fieldset >
                <legend>Editar Ingrediente na Receita: ${ingredienteNaReceita.receita.descricao}</legend>
                    <input type="hidden" name="receitaId" value="${ingredienteNaReceita.receita.id}" />
                    Ingrediente: <select name="ingredienteId" size="1">
                        <option value="${ingredienteNaReceita.ingrediente.id}">${ingredienteNaReceita.ingrediente.descricao}</option>
                        <c:forEach var="in" items="${dependencias['Ingrediente']}">
                            <option value="${in.id}">${in.descricao}</option>
                        </c:forEach>
                    </select>
                    Unidade: <select name="unidadeId" size="1">
                        <option value="${ingredienteNaReceita.unidade.id}">${ingredienteNaReceita.unidade.simbolo}</option>
                        <c:forEach var="un" items="${dependencias['Unidade']}">
                            <option value="${un.id}">${un}</option>
                        </c:forEach>
                    </select>
                    Quantidade: <input type="number" name="quantidade" value="${ingredienteNaReceita.quantidade}" />
                    <input type="submit" name="OK" value="Modificar">
                    <input type="reset" name="reset" value="Limpa">
            </fieldset>
        </form>
        <p><a href="jsp/Menu.jsp">Inicio</a></p>
    </body>
</html>
