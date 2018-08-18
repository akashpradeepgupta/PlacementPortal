package com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.beans.CellMember;

@WebFilter("/CellMemberServlet")
public class CellMemberFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		response.setContentType("text/html");
		String userID=request.getParameter("userID");
		String name=request.getParameter("name");
		String emailID=request.getParameter("emailID");
		String category=request.getParameter("category");
		String password=request.getParameter("password");
		String contact=request.getParameter("contact");
		String gender=request.getParameter("gender");
		String year=request.getParameter("year");

		CellMember ceme=new CellMember();
		ceme.setId(userID);
		ceme.setName(name);
		ceme.setEmailId(emailID);
		ceme.setCategory(category);
		ceme.setPassword(password);
		ceme.setContactNumber(contact);
		ceme.setGender(gender);
		ceme.setYear(year);
		request.setAttribute("insertCell", ceme);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
