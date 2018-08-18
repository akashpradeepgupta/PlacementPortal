package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.providers.ProviderServices;
import com.serviceImpl.CellMemberServiceImpl;

@WebServlet("/placementServlet")
public class placementServlet extends HttpServlet {
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
		String cname=request.getParameter("cname");
		String sid=request.getParameter("sid");
		CellMemberServiceImpl c=ProviderServices.getObj2();
		c.setCon(con);
		int n=c.changeStudentPlacementStatus(cname,sid);
		if(n==1)
		{
			response.sendRedirect("updateSuccessful.html");
		}
		else 
			response.sendRedirect("unupdate.html");
	}
}
