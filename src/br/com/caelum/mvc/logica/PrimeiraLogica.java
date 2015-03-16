package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Esta classe pois um méotodo executa que fabrica um 
 * servico e retorna uma página .jsp para a 
 * ControllerServlet
 */
public class PrimeiraLogica implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		System.out.println("Executando a lógica...");

		System.out.println("Retornando o nome da página JSP...");
		return "primeira-logica.jsp";
	}

}
