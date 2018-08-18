package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.providers.ProviderServices;
import com.serviceImpl.TpoServiceImpl;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String rollno=request.getParameter("rollno");
		String des=request.getParameter("Designation");
		TpoServiceImpl t=ProviderServices.getObj3();
		if(des.equals("student"))
		{
			t.setCon(con);
			int n=t.deleteStudent(rollno);
			if(n==1)
			{
				response.sendRedirect("deleteSuccess.html");
			}
			else 
				response.sendRedirect("deleteUnsuccessful.html");
		}
		else if(des.equals("cell_members"))
		{	
			t.setCon(con);;
			int n=t.deleteCellMember(rollno);
			if(n==1)
			{
				response.sendRedirect("deleteSuccess.html");
			}
			else 
				response.sendRedirect("deleteUnsuccessful.html");
		}
	}
}
