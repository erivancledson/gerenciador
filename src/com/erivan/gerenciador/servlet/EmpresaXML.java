package com.erivan.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erivan.gerenciador.modelo.Banco;
import com.erivan.gerenciador.modelo.Empresa;
import com.thoughtworks.xstream.XStream;

/**
 * Servlet implementation class EmpresaXML
 */
@WebServlet("/empresaxml")
public class EmpresaXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Empresa> empresas = new Banco().getEmpresas();
		XStream xsteam = new XStream();
		
		String xml = xsteam.toXML(empresas);
		xsteam.alias("empresa", Empresa.class);
		
		//defini o tipo de conteudo
		response.setContentType("application/xml");
		//imprime o json
		response.getWriter().print(xml);
	}

}
