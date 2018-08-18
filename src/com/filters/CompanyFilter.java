package com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.beans.Company;

@WebFilter("/TechCompanyServlet")
public class CompanyFilter implements Filter {

   	public void destroy() 
   	{
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		response.setContentType("text/html");
		
		String cname=request.getParameter("cname");
		String emailID=request.getParameter("cEmailID");
		String branch=request.getParameter("branch");
		String visitdate=request.getParameter("visitDate");
		String requirements=request.getParameter("requirements");
		String city=request.getParameter("city");
		String salary= request.getParameter("salary");
		String cIN=request.getParameter("cIN");
		String cpi= request.getParameter("cpiCriteria");

		Company c=new Company();
		c.setName(cname);
		c.setEmailId(emailID);
		c.setBranch(branch);
		c.setVisitdate(visitdate);
		c.setReq(requirements);
		c.setCity(city);
		c.setSalary(salary);
		c.setId(cIN);
		c.setCpi(cpi);
		
		request.setAttribute("insertComp", c);
		System.out.println(c);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
		// TODO Auto-generated method stub
	}

}
