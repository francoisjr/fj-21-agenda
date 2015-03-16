package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Esta classe pois um m�otodo executa que fabrica um 
 * servico e retorna uma p�gina .jsp para a 
 * ControllerServlet
 */
public class PrimeiraLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		System.out.println("Executando a l�gica...");

		System.out.println("Retornando o nome da p�gina JSP...");
		return "primeira-logica.jsp";
	}

}
