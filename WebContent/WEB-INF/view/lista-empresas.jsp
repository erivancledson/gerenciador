    
 <%@ page import="java.util.List, com.erivan.gerenciador.modelo.Empresa" %>   
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Java Standard Taglib</title>
</head>
<body>

<c:import url="logout-parcial.jsp"/>

 Usuário: ${usuarioLogado.login} </br></br></br>
 
<c:if test="${not empty empresa}">



		Empresa  ${empresa} cadastrada com sucesso!
</c:if>
<a href="/gerenciador/unicoServlet?acao=NovaEmpresaForm">Cadastrar nova empresa</a></br>

<h1>Lista de empresas: </h1></br>


 

 <ul>
        <c:forEach items="${empresas}" var="empresa">
        
            <li>
            ${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
             <a href="/gerenciador/unicoServlet?acao=MostraEmpresa&id=${empresa.id}">edita</a>
             <a href="/gerenciador/unicoServlet?acao=RemoveEmpresa&id=${empresa.id}">remove</a>
            </li>
        </c:forEach>
    </ul>


</body>
</html>