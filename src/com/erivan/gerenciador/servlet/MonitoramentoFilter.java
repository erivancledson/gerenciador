package com.erivan.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//todas as requisi��es que chegar no serlet vai chegar no filter
@WebFilter("/unicoServlet")
public class MonitoramentoFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//mede em milisegundos o tempo de execu��o para as paginas
		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");

		//executa a a��o
		chain.doFilter(request, response);

		long depois = System.currentTimeMillis();

        System.out.println("Tempo de execu��o da a��o (milissegundos)" + acao + " -> " + (depois - antes));
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
