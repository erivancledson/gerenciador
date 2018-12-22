package com.erivan.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erivan.gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicoServlet
 */
@WebServlet("/unicoServlet")
public class UnicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   //do tipo service pois ele aceita get e post
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   String paramAcao = request.getParameter("acao");
	
		String nomeDaClasse = "com.erivan.gerenciador.acao." + paramAcao;
		//listar empresas /gerenciador/unicoServlet?acao=ListaEmpresas
		//unicoServlet?acao=LoginForm
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);//carrega a classe com o nome 
			//cria uma nova instancia, pega da interface
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request,response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		//separa apois atraves dos : a posicao no array
		String[] tipoEEndereco = nome.split(":");
		//1 é redirect ou forward
		if(tipoEEndereco[0].equals("forward")) {
			//encaminha a resposta para lista-empresas
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
		
	}

}
