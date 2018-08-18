package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.student;
import com.providers.ProviderServices;
import com.serviceImpl.TpoServiceImpl;

@WebServlet("/tpoServlet")
public class tpoServlet extends HttpServlet {
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
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		String rollno=req.getParameter("rollno");
		String toEdit=req.getParameter("edit");
		String value=req.getParameter("value");
		System.out.println(rollno);
		TpoServiceImpl t = ProviderServices.getObj3();
		t.setCon(con);
		int a=t.editStudent(toEdit, rollno, value);
		if(a==1)
		{
			resp.sendRedirect("updateSuccessful.html");
		}
		else
		{
			resp.sendRedirect("unupdate.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		student st = (student) request.getAttribute("insertStu");
		System.out.println(st);
		TpoServiceImpl t = ProviderServices.getObj3();
		t.setCon(con);
		int n=t.insertStudent(st);
		if(n==1)
			response.sendRedirect("successful.html");
		else
			response.sendRedirect("unInsert.html");
	}
}
