package com.listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConnectionContext implements ServletContextListener {

	Connection con;
    public void contextDestroyed(ServletContextEvent sce)  
    { 
    	con=((Connection)sce.getServletContext().getAttribute("DbConnection"));
    	try 
    	{
			con.close();
		} catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    }

	
    public void contextInitialized(ServletContextEvent sce)  
    {
    	try 
    	{
			String driver = sce.getServletContext().getInitParameter("driver");
			String url = sce.getServletContext().getInitParameter("url");
			String username = sce.getServletContext().getInitParameter("username");
			String password = sce.getServletContext().getInitParameter("password");
			Class.forName(driver);
			con=(DriverManager.getConnection(url, username, password));
		}

    	catch (ClassNotFoundException e) 
    	{
    		e.printStackTrace();
    	}
    	catch (SQLException e) 
    	{
		e.printStackTrace();
    	}	
    	sce.getServletContext().setAttribute("DbConnection",con);
    }
}
