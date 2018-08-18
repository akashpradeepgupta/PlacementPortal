package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.serviceImpl.CompanyServicesImpl;
import com.serviceImpl.DateCheck;
import com.beans.Company;
import com.beans.student;
import com.providers.ProviderServices;

@WebServlet("/companyServlet")
public class companyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
	public void init()throws ServletException
	{
		try
		{
			con=((Connection) getServletContext().getAttribute("DbConnection"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name=request.getParameter("name");
		CompanyServicesImpl c = ProviderServices.getObj4();
		student t[]=new student[10];
		c.setCon(con);
		t=c.selectedCriteriaStudent(name);
		for(int i=0;i<10;i++)
		{
			try
			{
				System.out.println(t[i].getSid()+"  "+t[i].getSname());
			}
			catch(Exception e){}
		}
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		DateCheck q=new DateCheck();
		int z=q.dateCheck(sdate, edate);
		if(z==1)
		{	
			CompanyServicesImpl c= ProviderServices.getObj4();
			Company d[] = new Company[10];
			c.setCon(con);
			d=c.CompanyVisit(sdate, edate);
			HttpSession session=request.getSession();
			session.setAttribute("d", d);
			response.sendRedirect("displayCompanies.jsp");
		}
		else
		{
			response.sendRedirect("invalidDate.html");
		}
	}
}
