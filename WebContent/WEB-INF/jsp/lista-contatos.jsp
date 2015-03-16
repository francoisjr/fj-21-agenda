<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- JSTL Core prefixo c, Tags relacionadas à lógica e controle.-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- JSTL Core prefixo fmt, Tags para formatação e internacionalização de dados.-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Contatos usando JSTL</title>
</head>
<body>
	<!-- JSTL (Java Server Pages  Standard Tag Library) Biblioteca Padrão de Tags JSP -->
	<c:import url="cabecalho.jsp" />

	<table border="1">
		<tr>
			<th>Linha</th>
			<th>ID</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data de Nascimento</th>
			<th>Remover Contato</th>
			<th>Alterar Contato</th>
			

		</tr>

		<!-- percorre contatos montando as linhas da tabela 
		c:forEach capaz de iterar por uma coleção
		-->
		<c:forEach var="contato" items="${contatos}" varStatus="id">

			<tr bgcolor="#${id.count % 2 == 0? 'cccccc': 'ffffff' }">
				<td>${id.count}</td>
				<td>${contato.id}</td>
				<td>${contato.nome}</td>

				<td><c:choose>

						<c:when test="${not empty contato.email}">

							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							<label>E-mail não informado</label>
						</c:otherwise>
					</c:choose></td>

				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}"
						pattern="dd/MM/yyyy" /></td>

				<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				<td><a href="mvc?logica=MostraContatoLogic&id=${contato.id}">Alterar</a>
				
				</td>
			</tr>
		</c:forEach>
	</table>

	<c:import url="rodape.jsp" />
</body>
</html>