 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
 <!-- caminho do servlet -->  
<c:url value="/unicoServlet" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="logout-parcial.jsp"/>


<!--  -->
<form action="${linkServletNovaEmpresa}" method="post">
 
    Nome: <input type="text" name="nome"/>
    Data Abertura: <input type="text" name="data"/>
    
    <input type="hidden" name="acao" value="NovaEmpresa"/>
    <input type="submit" value="Cadastrar"/>

</form>

</body>
</html>