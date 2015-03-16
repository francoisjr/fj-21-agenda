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
			 * O objeto do tipo Class representando a classe, uma das informa��es
			 * guardadas pelo objeto do tipo Class � o construtor, n�s podemos
			 * invoc�-lo para instanciar a classe atrav�s do m�todo newInstance()
			 * 
			 * forName() carrega e inicia um objeto da classe cujo nome � passado 
			 * como par�metro 
			 */
			Class classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance(); // instaciando a classe Logica que e uma Interface
			/*
			 * ap�s instaciada podemos chamar o metodo executa, instaciando a 
			 */
			String pagina = logica.executa(request, response);
			/*
			 * O objeto RequestDispatcher � para acessar outro recurso Web, seja
			 * esse recurso uma p�gina JSP ou uma servlet.
			 *  O "forward()" serve para transferir o controle para outro componente web (servlet/JSP). 
			 *  Voc� deve lembrar como ele funciona: redireciona seus objetos request e reponse para 
			 *  o recurso que voc� aponta no getRequestDispatcher.
			 */
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch (Exception e) {
			throw new ServletException(
					"A l�gica de neg�cios causou uma exce��o", e);
		}
	}
}
