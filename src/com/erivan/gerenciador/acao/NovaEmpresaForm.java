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

public class NovaEmpresaForm implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    
	        //servlet quando só direciona
	       return "forward:form-nova-empresa.jsp";
	      
	}

}
