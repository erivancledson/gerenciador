package com.erivan.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */

// para defirmos uma ordem dos filtros, devemos utilizar o web.xml se for preciso
@WebFilter("/unicoServlet")
public class AutorizacaoFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutorizacaoFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		//sessão do usuario
	    HttpServletRequest request = (HttpServletRequest) servletRequest;
	    HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
		 
		
		//se o login for nulo vai para o formulario de login
		 HttpSession sessao = request.getSession();
		 boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		 boolean ehUmaAcaoNaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));  
		 
		 if(ehUmaAcaoNaoProtegida && usuarioNaoEstaLogado) {
			 response.sendRedirect("unicoServlet?acao=LoginForm");
			 return;
		   
			}
	
		 
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	

}
