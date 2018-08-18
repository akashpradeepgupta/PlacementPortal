package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.beans.student;
import com.serviceImpl.CellMemberServiceImpl;

@WebServlet("/placedStudentServlet")
public class placedStudentServlet extends HttpServlet {
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
		HttpSession session=request.getSession();
		CellMemberServiceImpl c=(CellMemberServiceImpl)session.getAttribute("t");
		student s[]=new student[10];
		c.setCon(con);
		s=c.placedStudent(cname);
		session.setAttribute("std", s);
		response.sendRedirect("placedStudent.jsp");
	}
}
