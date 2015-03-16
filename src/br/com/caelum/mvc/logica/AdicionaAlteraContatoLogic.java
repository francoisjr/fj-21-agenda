package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AdicionaAlteraContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, ClassNotFoundException {

		// buscando os parametros no request com request.getParameter
		String identificador = req.getParameter("id");
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String email = req.getParameter("email");
		String dataEmTexto = req.getParameter("dataNasc");

		Calendar dataNasc = null;

		// fazendo a conversao da data
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNasc = Calendar.getInstance();
			dataNasc.setTime(date);
		} catch (ParseException e) {
			System.out.println("Erro de conversao da data");
			// return;
		}

		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNasc);

		// busca a conexao pendurada na requisicao
		Connection connection = (Connection) req.getAttribute("conexao");
		
		// salva ou altera o contato
		ContatoDao dao = new ContatoDao(connection);
		if (identificador.equals("")) {
			dao.adiciona(contato);
			return "/WEB-INF/jsp/contato-adicionado.jsp";
		} else {
			Long id = Long.parseLong(identificador);
			contato.setId(id);
			dao.altera(contato);
			return "mvc?logica=ListaContatosLogic";
		}

	}
}
