package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.beans.CellMember;
import com.providers.ProviderServices;
import com.serviceImpl.TpoServiceImpl;

@WebServlet("/CellMemberServlet")
public class CellMemberServlet extends HttpServlet {
	
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
		String userid=request.getParameter("userid");
		String toEdit=request.getParameter("edit");
		String value=request.getParameter("value");
		System.out.println(userid);
		TpoServiceImpl t = ProviderServices.getObj3();
		t.setCon(con);
		int n=t.editCellMember(toEdit,userid,value);
		if(n==1)
		{
			response.sendRedirect("updateSuccessful.html");
		}
		else
		{
			response.sendRedirect("unupdate.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		CellMember ceme = (CellMember) request.getAttribute("insertCell");
		TpoServiceImpl t = ProviderServices.getObj3();
		t.setCon(con);
		int n=t.insertCellMember(ceme);
		if(n==1)
		{
			response.sendRedirect("successful.html");
		}
		else
		{
			response.sendRedirect("unInsert.html");
		}
	}
}
