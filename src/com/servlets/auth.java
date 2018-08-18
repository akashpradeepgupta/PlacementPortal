package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.providers.ProviderServices;
import com.serviceImpl.CellMemberServiceImpl;
import com.serviceImpl.StudentServiceImpl;
import com.serviceImpl.TpoServiceImpl;


@WebServlet(description = "first servelet", urlPatterns = { "/servletReady" })
public class auth extends HttpServlet {
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
		
		response.setContentType("text/html");
		String des=request.getParameter("Designation");
		System.out.println(des);
		
		HttpSession session=request.getSession();    
		session.setAttribute("des",des);
		
		if(des.equals("student"))
		{
			StudentServiceImpl t = ProviderServices.getObj1();
			System.out.println(con);
			System.out.println(t);
			session.setAttribute("t",t);
			response.sendRedirect("sinfo.jsp");
		}
		else if(des.equals("tpo"))
		{
			TpoServiceImpl t = ProviderServices.getObj3();
			System.out.println(con);
			session.setAttribute("t", t);
			response.sendRedirect("tpo.jsp");
		}
		else if(des.equals("cell_members"))
		{
			CellMemberServiceImpl t = ProviderServices.getObj2();
			System.out.println(con);
			session.setAttribute("t",t);
			response.sendRedirect("CellMemberInfo.jsp");
		}
		else
		{
			response.sendRedirect("invalid.html");
		}
	}
}

