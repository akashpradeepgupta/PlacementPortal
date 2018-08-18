package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.beans.Company;
import com.serviceImpl.StudentServiceImpl;

@WebServlet("/selectionServlet")
public class selectionServlet extends HttpServlet {
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
		HttpSession session=request.getSession(); 
		StudentServiceImpl stu =(StudentServiceImpl)session.getAttribute("t");
		stu.setCon(con);
		Company t[]=stu.checkCompany();
		session.setAttribute("q",t);
		response.sendRedirect("selection.jsp");
	}
}
