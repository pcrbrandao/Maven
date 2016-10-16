<%-- 
    Document   : Editar Receita
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
        <title>Editar Receita</title>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>Faça a alteração e clique em Modificar</h1>
        <a href="/Receitas/ReceitaServlet?logica=ExcluirReceita&id=${receita.id}">Excluir</a><br/>
        <form action="/Receitas/ReceitaServlet?logica=EditarReceita&id=${receita.id}" method="POST"><br/>
            <fieldset >
                <legend>Editar Receita</legend>
                    Id: ${receita.id}<br/>
                    Descricao: <input type="text" name="descricao" value="${receita.descricao}"><br/>
                    Procedimento:<br/>
                    <textarea cols="40" rows="5" name="procedimento">${receita.procedimento}</textarea><br/>
                    <input type="submit" name="OK" value="Modificar">
                    <input type="reset" name="reset" value="Limpa">
            </fieldset>
        </form>
        <fieldset>
            <legend>Ingredientes</legend>
            <table caption="Ingredientes">
                    <thead>
                        <tr>
                            <th>Ingrediente</th>
                            <th>Unidade</th>
                            <th>Quantidade</th>
                        </tr>
                    </thead>
                    <c:forEach var="ri" items="${ingredReceita}">
                        <c:if test="${ri.receita.id == receita.id}">
                        <tr>
                            <td><a href="/Receitas/ReceitaServlet?logica=LerIngredienteNaReceita&receitaId=${receita.id}&ingredienteId=${ri.ingrediente.id}&entidade=IngredienteNaReceita">${ri.ingrediente.descricao}</a></td>
                            <td>${ri.unidade.simbolo}</td>
                            <td>${ri.quantidade}</td>
                        </tr>
                        </c:if>
                    </c:forEach>
                        <tr>
                            <td><a href="/Receitas/ReceitaServlet?logica=PreAdiciona&entidade=IngredienteNaReceita&receitaId=${receita.id}">Adicionar</a></td>
                            <td></td>
                            <td></td>
                        </tr>
                </table>
        </fieldset>
        <p><a href="jsp/Menu.jsp">Inicio</a></p>
    </body>
</html>
