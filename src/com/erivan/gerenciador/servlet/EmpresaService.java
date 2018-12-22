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
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

/**
 * Servlet implementation class EmpresaService
 */

//para chamar o json /gerenciador/empresas
@WebServlet("/empresas")
public class EmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empresa> empresas = new Banco().getEmpresas();
	    
		String valor = request.getHeader("Accept");

		if(valor.contains("xml")) { //contais para o navegador receber o xml
             //se for xml
		    XStream xstream = new XStream();
		    xstream.alias("empresa", Empresa.class);
		    String xml = xstream.toXML(empresas); 

		    response.setContentType("application/xml");
		    response.getWriter().print(xml);

		} else if(valor.endsWith("json")) {  //se for json, 
		    Gson gson = new Gson();
		    String json = gson.toJson(empresas); 

		    response.setContentType("application/json");
		    response.getWriter().print(json);

		}else{
			 response.setContentType("application/json");
			 response.getWriter().print("{'message': 'no content'}");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
