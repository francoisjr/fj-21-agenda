<html>
<head>
<title>Projeto fj21-agenda</title>
</head>
<body>
	<h2>Escolha a acão que deseja:</h2>
		<form action="mvc?logica=BotaoAdicionarContatoLogic" method="POST">
		<input type="submit" value="Adicionar Contato">
		</form>
		<br>
		<form action="mvc?logica=ListaContatosLogic" method="POST">
		<input type="submit" value="Listar Contato">
		</form>
</body>
</html>