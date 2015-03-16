<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Adicionar Contato</title>
<link  type="text/css" href="css/jquery-ui.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>

</head>

<body>
	<c:import url="cabecalho.jsp"/>
	
	<form action="mvc?logica=AdicionaAlteraContatoLogic" method="POST">
		ID: <input type="text" name="id"><br>
		Nome: <input type="text" name="nome"><br>
		E-mail: <input	type="text" name="email"><br> 
		Endereço: <input type="text" name="endereco"/><br> 
		Data Nascimento: <caelum:campoData id="dataNasc"/><br> 
		<input type="submit" value="Gravar">
	</form>

	<c:import url="rodape.jsp"/>
</body>
</html>