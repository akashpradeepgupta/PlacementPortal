package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.beans.Company;
import com.providers.ProviderServices;
import com.serviceImpl.CellMemberServiceImpl;
import com.serviceImpl.DateCheck;

@WebServlet("/TechCompanyServlet")
public class TechCompanyServlet extends HttpServlet {
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
		response.setContentType("text/html");
		int cIN=Integer.parseInt(request.getParameter("cIN"));
		String toEdit=request.getParameter("edit");
		String value=request.getParameter("value");
		CellMemberServiceImpl c= ProviderServices.getObj2();
		if (toEdit.equals("visitDate"))
		{
			int y=Integer.parseInt(value.substring(0,4));
			int m=Integer.parseInt(value.substring(5,7));
			int d=Integer.parseInt(value.substring(8,10));
			DateCheck dt=new DateCheck();
			int k=dt.validDate(y,m,d);
			if(k==1)
			{
				c.setCon(con);
				int n=c.editCompanyDetails(toEdit, cIN, value);
				if(n==1)
				{
					response.sendRedirect("updateSuccessful.html");
				}
				else if(n==0)
				{
					response.sendRedirect("unupdate.html");
				}
			}
			else	
			{
				response.sendRedirect("unupdate.html");
			}
		}
		else
		{
			c.setCon(con);
			int n=c.editCompanyDetails(toEdit, cIN, value);
			if(n==1)
			{
				response.sendRedirect("updateSuccessful.html");
			}
			else if(n==0)
			{
				response.sendRedirect("unupdate.html");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		Company comp = (Company) request.getAttribute("insertComp");
		System.out.println(comp);
		CellMemberServiceImpl c= ProviderServices.getObj2();
		int y=Integer.parseInt(comp.getVisitdate().substring(0,4));
		int m=Integer.parseInt(comp.getVisitdate().substring(5,7));
		int d=Integer.parseInt(comp.getVisitdate().substring(8,10));
		DateCheck dt=new DateCheck();
		int k=dt.validDate(y,m,d);
		if(k==1)
		{
			c.setCon(con);
			int n=c.insertCompanyDetails(comp);
			if(n==1)
		{
			response.sendRedirect("successful.html");
		}
		else if(n==0)
		{
			response.sendRedirect("unInsert.html");
		}
		}
		else if(k==0)
		{
			response.sendRedirect("unInsert.html");
		}
}}
