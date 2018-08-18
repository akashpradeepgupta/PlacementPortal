package com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.serviceImpl.Validate;

@WebFilter("/servletReady")
public class ValidationFilter implements Filter {

	private String rollno;
	private String pass;
	private String des;

	public void destroy() 
	{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		rollno = request.getParameter("rollno");
		pass = request.getParameter("password");
		des = request.getParameter("Designation");
		
		Validate v = new Validate();
		v.connect();
		int n=v.validate(rollno,pass,des);
		if(n==1)
		{
		// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("/form.jsp");
			rd.forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}
}
