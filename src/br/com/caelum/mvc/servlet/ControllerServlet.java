package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;


@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;

		try {
			/*
			 * O objeto do tipo Class representando a classe, uma das informações
			 * guardadas pelo objeto do tipo Class é o construtor, nós podemos
			 * invocá-lo para instanciar a classe através do método newInstance()
			 * 
			 * forName() carrega e inicia um objeto da classe cujo nome é passado 
			 * como parâmetro 
			 */
			Class classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance(); // instaciando a classe Logica que e uma Interface
			/*
			 * após instaciada podemos chamar o metodo executa, instaciando a 
			 */
			String pagina = logica.executa(request, response);
			/*
			 * O objeto RequestDispatcher é para acessar outro recurso Web, seja
			 * esse recurso uma página JSP ou uma servlet.
			 *  O "forward()" serve para transferir o controle para outro componente web (servlet/JSP). 
			 *  Você deve lembrar como ele funciona: redireciona seus objetos request e reponse para 
			 *  o recurso que você aponta no getRequestDispatcher.
			 */
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch (Exception e) {
			throw new ServletException(
					"A lógica de negócios causou uma exceção", e);
		}
	}
}
