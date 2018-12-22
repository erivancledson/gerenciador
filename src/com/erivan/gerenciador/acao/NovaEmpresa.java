package com.erivan.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erivan.gerenciador.modelo.Banco;
import com.erivan.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	     String nomeEmpresa = request.getParameter("nome");
	        String dataEmpresa = request.getParameter("data");
	        //converte para o tipo Date
	        Date dataAbertura = null;
	        try {
	        	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				 dataAbertura = sdf.parse(dataEmpresa);
			} catch (ParseException e) {
				throw new ServletException(e);
				
			}
	        
	        Empresa empresa = new Empresa();  
	        empresa.setNome(nomeEmpresa);
	        empresa.setDataAbertura(dataAbertura);
	        
	        Banco banco = new Banco();
	        banco.adiciona(empresa);
	        request.setAttribute("empresa", empresa.getNome());
	        
	        //servlet quando só direciona
	       return "redirect:unicoServlet?acao=ListaEmpresas";
	      
	}

}
