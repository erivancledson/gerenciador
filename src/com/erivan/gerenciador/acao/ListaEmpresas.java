package com.erivan.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erivan.gerenciador.modelo.Banco;
import com.erivan.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		
		
		Banco banco = new Banco();
		     List<Empresa> lista = banco.getEmpresas();
		     //key = empresas passa a lista
		     request.setAttribute("empresas", lista);
		     
		     return "forward:lista-empresas.jsp";
		     
	}

}
