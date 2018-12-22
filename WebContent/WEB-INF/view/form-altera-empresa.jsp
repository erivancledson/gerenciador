 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
 
 <!-- caminho do servlet -->  
<c:url value="/unicoServlet" var="linkServletAlteraEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="logout-parcial.jsp"/>
<!--  -->
<form action="${linkServletAlteraEmpresa}" method="post">
 
    Nome: <input type="text" name="nome" value="${empresa.nome}"/>
    Data Abertura: <input type="text" name="data"  value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>"/>
    <input type="hidden" name="id" value="${empresa.id}">
    <input type="hidden" name="acao" value="AlteraEmpresa">
    <input type="submit" value="Cadastrar"/>

</form>

</body>
</html>