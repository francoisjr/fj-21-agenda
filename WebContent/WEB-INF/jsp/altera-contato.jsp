<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Altera Contato</title>
<link  href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
</head>
<body>

<c:import url="cabecalho.jsp"/>
	
		<form action="mvc?logica=AdicionaAlteraContatoLogic" method="POST">
		ID: <input type="text" name="id" value="${id}" readonly /><br>
		Nome: <input type="text" name="nome" value="${nome}" /><br>
		E-mail: <input	type="text" name="email" value="${email}" /><br> 
		Endereço: <input type="text" name="endereco" value="${endereco}" /><br> 
		Data Nascimento: <caelum:mostraData id="dataNasc" /><br>
		<input type="submit" value="Confirmar Alteração">
	</form>

	<c:import url="rodape.jsp"/>
</body>
</html>