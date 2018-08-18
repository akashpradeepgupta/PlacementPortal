package com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.beans.student;


@WebFilter("/tpoServlet")
public class StudentFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		{
		response.setContentType("text/html");
		String rollno=request.getParameter("rollno");
		String name=request.getParameter("name");
		String emailID=request.getParameter("emailID");
		String password=request.getParameter("password");
		String interest=request.getParameter("interest");
		String branch=request.getParameter("branch");
		String cpi= (request.getParameter("cpi"));
		System.out.println(cpi);
		
		student st = new student();
		st.setSid(rollno);
		st.setSname(name);
		st.setsEmailId(emailID);
		st.setSpassword(password);
		st.setInterest(interest);
		st.setBranch(branch);
		st.setCpi(((cpi)));
		st.setPlacementStatus(0);
		st.setSalary(0);
		
		request.setAttribute("insertStu", st);
		}
		/*else
		{
			response.setContentType("text/html");
			String rollno=request.getParameter("rollno");
			String toEdit=request.getParameter("edit");
			String value=request.getParameter("value");
			
			student st = new student();
			st.s
			
		}*/
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
