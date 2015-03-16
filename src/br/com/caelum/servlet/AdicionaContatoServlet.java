package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	//
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a servlet");
	}

	@Override
	public void destroy() {
		super.destroy();
		log("Destruindo a servlet");
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// busca o writter
		PrintWriter out = response.getWriter();

		// buscando os parametros no request com request.getParameter
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNasc");

		Calendar dataNasc = null;

		// fazendo a conversao da data
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNasc = Calendar.getInstance();
			dataNasc.setTime(date);
		} catch (ParseException e) {
			out.println("Erro de conversao da data");
			return;
		}

		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNasc);

		ContatoDao dao = new ContatoDao(null);
		dao.adiciona(contato);

		/*
		 * O objeto RequestDispatcher é para acessar outro recurso Web, seja
		 * esse recurso uma página JSP ou uma servlet:
		 */
		RequestDispatcher rd = request
				.getRequestDispatcher("/contato-adicionado.jsp");
		/*
		 * O foward encaminha os objetos request/response para outro tratador de
		 * requisicao (jsp/servlet)
		 */
		rd.forward(request, response);
		
		 
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
