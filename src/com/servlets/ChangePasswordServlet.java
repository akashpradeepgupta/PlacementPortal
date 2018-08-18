package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.serviceImpl.CellMemberServiceImpl;
import com.serviceImpl.StudentServiceImpl;
import com.serviceImpl.TpoServiceImpl;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
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
		String userID=request.getParameter("userID");
		String opass=request.getParameter("opass");
		String npass=request.getParameter("npass");
		String cpass=request.getParameter("cpass");
		if(cpass.equals(npass))
		{
			HttpSession session=request.getSession();
			String des=(String)session.getAttribute("des");
			System.out.println(des);
			if(des.equals("tpo"))
			{
				TpoServiceImpl t=(TpoServiceImpl)session.getAttribute("t");
					t.setCon(con);
					int n=t.changeTpoPassword(userID,opass,npass);
					if(n==1)
					{
						response.sendRedirect("pUpdateSuccess.jsp");
					}
					else
					response.sendRedirect("unupdate.html");
			}
			else if(des.equals("cell_members"))
			{
				CellMemberServiceImpl c=(CellMemberServiceImpl)session.getAttribute("t");
				c.setCon(con);
				int n=c.changePasswordCellMember(userID, opass, npass);
				//System.out.println(n);
				if(n==1)
				{
				response.sendRedirect("pUpdateSuccess.jsp");
				}
				else
					response.sendRedirect("unupdate.html");
			}
			else if(des.equals("student"))
			{
				StudentServiceImpl t=(StudentServiceImpl)session.getAttribute("t");
					t.setCon(con);
					int n=t.changeStudentPassword(userID, opass, npass);
					if(n==1)
					{
						response.sendRedirect("pUpdateSuccess.jsp");
					}
					else
					{
					response.sendRedirect("unupdate.html");
					}
			}
			else
			{
				response.sendRedirect("unupdate.html");
			}
		}
	}
}
