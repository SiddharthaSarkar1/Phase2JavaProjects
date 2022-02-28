package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/loginservlet")
public class LoginFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        String real_Email = "siddhartha@gmail.com";
        String real_Password = "siddhartha@123";
        
        
        if(email.equals(real_Email)&& password.equals(real_Password)){ 
        	
            System.out.println("Login credential are correct.......");

            request.setAttribute("email", email);
            request.setAttribute("password", password);
            chain.doFilter(request, response);
            
	        }  
	        else{  
	              
	            request.getRequestDispatcher("index.html").include(request, response);
	            out.print("<center> <span style='color:red'> Invalid Credentials!!</span></center>");  
	        }  
        out.close();  
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
