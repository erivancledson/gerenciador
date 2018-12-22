package com.erivan.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erivan.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao{
	
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		//recebe uma string e converte para int
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		//servlet
		return "redirect:unicoServlet?acao=ListaEmpresas";
	}

}
