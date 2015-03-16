<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Contatos em JSP</title>
</head>
<body>

	<%@ page
		import="java.util.*, java.text.*, br.com.caelum.jdbc.dao.*, br.com.caelum.jdbc.modelo.*"%>

	<table>
		<tr>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereço</th>
			<th>Data de Nascimento</th>
		</tr>

		<%
			ContatoDao dao = new ContatoDao(null);
			List<Contato> contatos = dao.getLista();

			for (Contato contato : contatos) {

				Calendar data = contato.getDataNascimento();

				SimpleDateFormat formataData = new SimpleDateFormat(
						"dd/MM/yyyy");
				String dataEmTexto = formataData.format(data.getTime());
		%>

		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<td><%=dataEmTexto%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>