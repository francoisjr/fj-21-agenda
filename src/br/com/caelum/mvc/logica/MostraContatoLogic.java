package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class MostraContatoLogic implements Logica {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse res)
			throws Exception {

		int id = Integer.parseInt(request.getParameter("id"));

		// busca a conexao pendurada na requisicao
		Connection connection = (Connection) request.getAttribute("conexao");

		ContatoDao dao = new ContatoDao(connection);
		Contato contato = dao.getContatoByID(id);

		request.setAttribute("id", id);
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("email", contato.getEmail());
		request.setAttribute("endereco", contato.getEndereco());
		request.setAttribute("dataNascimento", new SimpleDateFormat(
				"dd/MM/yyyy").format(contato.getDataNascimento()
				.getTimeInMillis()));

		return "/WEB-INF/jsp/altera-contato.jsp";
	}
}
