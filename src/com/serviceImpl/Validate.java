package com.serviceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Validate {
	
	Connection con=null;
	
	public void connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "admin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		System.out.println(con);
	}
	
	public int validate(String rollno,String pass,String des)
	{
		try 
		{	
			Statement stmt = con.createStatement();
			if (des.equals("student")) 
			{
				ResultSet rs = stmt.executeQuery("select * from Student");

				while (rs.next()) 
				{
					System.out.println("hello all" + rs.getInt("sid") + rs.getString("spassword"));
					if (rs.getString("sid").equals(rollno) & rs.getString("spassword").equals(pass)) 
					{
						System.out.println("in here");
						return 1;
					}
				}
				return 0;
			}
			
			else if (des.equals("tpo")) 
			{
				ResultSet rs = stmt.executeQuery("select * from TPO");
				while (rs.next()) {
					if (rs.getString("TID").equals(rollno) & rs.getString("tpassword").equals(pass)) 
					{
						System.out.println("in here");
						return 1;
					}
				}
				return 0;
			}

			else 
			{
				System.out.println("cell");
				ResultSet rs = stmt.executeQuery("Select * from CellMember");
				while (rs.next()) 
				{
					if (rs.getString("cid").equals(rollno) & rs.getString("cpassword").equals(pass)) 
					{
						System.out.println("in here");
						return 1;
					}
				}
				return 0;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return 0;
		}
	}
}
