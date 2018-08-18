package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.beans.CellMember;
import com.beans.student;

public class TpoDaoImpl {
	
	Connection con;	
	//this method is use to change password
		public int changeTpoPassword(Connection con,String id,String oldp,String newp ){
			int n=0;
			try
			{
				Statement stmt=con.createStatement();
				ResultSet res;
				String pswd="";
				String sql="select * from TPO where tid='"+id+ "' ";
				res=stmt.executeQuery(sql);
				while (res.next())
				{
					 pswd=res.getString("tpassword");
				}
				if(pswd.equals(oldp))
				{
					Statement stmt1=con.createStatement();
					String sql1="update TPO set tpassword='"+newp+ "' where tid='"+id+ "'";
					stmt1.executeUpdate(sql1);
					n=1;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				n=0;
			}
			return n;
		}
		
		//this method inserts the technical student 
		public int insertStudent(Connection con,student s)
		{
			int n=0;
				try
				{
					String a="insert into Student values(?,?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement preparedStmt = con.prepareStatement(a);
					  preparedStmt.setString (1,s.getSid());
					  preparedStmt.setString (2,s.getSname());
					  preparedStmt.setString (3, s.getSpassword());
					  preparedStmt.setString (4,s.getsEmailId());
					  preparedStmt.setString(5, s.getCpi());
					  preparedStmt.setInt(6, s.getPlacementStatus());
					  preparedStmt.setString (7,s.getCompany());
					  preparedStmt.setDouble (8,s.getSalary());
					  preparedStmt.setString (9,s.getInterest());
					  preparedStmt.setString (10,s.getBranch());	  
					  preparedStmt.execute();
					  n=1;
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					n=0;
				}
				return n;
		}
		
		public int editStudent(Connection con,String field,String id,String attribute)
		{
			System.out.println(field+id+attribute);
			int n=0;
				try
				{
					String sql;
					PreparedStatement ps;
					Statement stm=con.createStatement();
					String s="select * from Student where sid='"+id+ "'";
					ResultSet rs=stm.executeQuery(s);
					while(rs.next())
					{
					if(field.equals("sname"))
					{
						sql="UPDATE Student set sname= ? where sid=?";
						ps=con.prepareStatement(sql);
						ps.setString(1,attribute);
						ps.setString(2, id);
						ps.executeUpdate();
						n=1;
					}
					if(field.equals("spassword"))
					{
						sql="UPDATE Student set spassword= ? where sid=?";
						ps=con.prepareStatement(sql);
						ps.setString(1,attribute);
						ps.setString(2, id);
						ps.executeUpdate();
						n=1;
					}
					if(field.equals("salary"))
					{
						sql="UPDATE Student set salary= ? where sid=?";
						ps=con.prepareStatement(sql);
						ps.setString(1,attribute);
						ps.setString(2, id);
						ps.executeUpdate();
						n=1;
					}
					if(field.equals("sEmailId"))
					{
						sql="UPDATE Student set sEmailId= ? where sid=?";
						ps=con.prepareStatement(sql);
						ps.setString(1,attribute);
						ps.setString(2, id);
						ps.executeUpdate();
						n=1;
					}
					if(field.equals("cpi"))
					{
						sql="UPDATE Student set cpi= ? where sid=?";
						ps=con.prepareStatement(sql);
						ps.setString(1,attribute);
						ps.setString(2, id);
						ps.executeUpdate();
						n=1;
					}
					if(field.equals("status"))
					{
						sql="UPDATE Student set placementStatus= ? where sid=?";
						ps=con.prepareStatement(sql);
						ps.setString(1,attribute);
						ps.setString(2, id);
						ps.executeUpdate();
						n=1;
					}
					if(field.equals("placedCompany"))
					{
						sql="UPDATE Student set placedCompany= ? where sid=?";
						ps=con.prepareStatement(sql);
						ps.setString(1,attribute);
						ps.setString(2, id);
						ps.executeUpdate();
						n=1;
					}
					if(field.equals("interest"))
					{
						System.out.println("yoyo");
						sql="UPDATE Student set interest= ? where sid=?";
						ps=con.prepareStatement(sql);
						ps.setString(1,attribute);
						ps.setString(2, id);
						ps.executeUpdate();
						n=1;
					}
					if(field.equals("branch"))
					{
						sql="UPDATE Student set branch= ? where sid=?";
						ps=con.prepareStatement(sql);
						ps.setString(1,attribute);
						ps.setString(2, id);
						ps.executeUpdate();
						n=1;
					}}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					n=0;
				}
				return n;
		}
		//edit cell members
		public int editCellMember(Connection con,String field,String id,String attribute)
		{
			int n=0;
			try
			{
				String sql;
				PreparedStatement ps;
				Statement stm=con.createStatement();
				String s="select * from CellMember c where c.cid='"+id+ "'";
				ResultSet rs=stm.executeQuery(s);
				while(rs.next())
				{
				if(field.equals("cname"))
				{
					
					sql="UPDATE CellMember set cname= ? where cid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("cpassword"))
				{
					sql="UPDATE CellMember set cpassword= ? where cid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("ContactNumber"))
				{
					sql="UPDATE CellMember set ContactNumber= ? where cid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("cEmailId"))
				{
					sql="UPDATE CellMember set cEmailId= ? where cid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("year"))
				{
					sql="UPDATE CellMember set year= ? where cid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("gender"))
				{
					sql="UPDATE CellMember set gender= ? where cid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
				if(field.equals("category"))
				{
					sql="UPDATE CellMember set category= ? where cid=?";
					ps=con.prepareStatement(sql);
					ps.setString(1,attribute);
					ps.setString(2, id);
					ps.executeUpdate();
					n=1;
				}
			}}
			catch(SQLException e)
			{
				System.out.println("exception");
				n=0;
			}
			return n;
		}

		//insert cell members
		public int insertCellMember(Connection con,CellMember ceme)
		{	
			int n=0;
				try
				{
					String a="insert into CellMember values(?,?,?,?,?,?,?,?)";
					
					PreparedStatement preparedStmt = con.prepareStatement(a);
					  preparedStmt.setString(1,ceme.getId());
					  preparedStmt.setString (2,ceme.getName());
					  preparedStmt.setString (3, ceme.getPassword());
					  preparedStmt.setString (4,ceme.getEmailId());
					  preparedStmt.setString(5, ceme.getContactNumber());
					  preparedStmt.setString(6,ceme.getBatch());
					  preparedStmt.setString(7,ceme.getGender());
					  preparedStmt.setString(8,ceme.getCategory());
					  preparedStmt.execute();
					  n=1;
				}
				catch(SQLException e)
				{
					e.printStackTrace();
					n=0;
				}
				System.out.println(n);
				return n;
		}

		// delete students from database
		public int deleteStudent(Connection con,String sid)
		{
				 int n=0; 
				 try 
				 {
					 Statement stmt=con.createStatement();
					 Statement s=con.createStatement();
					 String ss="select * from Student where sid='"+sid+ "'";
					 //System.out.println(ss);
					 ResultSet res=s.executeQuery(ss);
					 while(res.next())
					 {
						 //System.out.println("hello");
						 String sql="delete from Student where sid='"+sid+ "' ";
						 stmt.executeUpdate(sql);
						 n=1;
					 }
				 }
				 catch(SQLException e)
				 {
					 e.printStackTrace();
					 n=0;
				 }
				 return n;
		}
		 
		 //delete cell members from database
		public int deleteCellMember(Connection con,String cid)
		{
				 int n=0;
				 try 
				 {
					 Statement stmt=con.createStatement();
					 Statement s=con.createStatement();
					 String ss="select * from CellMember where cid='"+cid+ "'";
					 ResultSet res=s.executeQuery(ss);
					 while(res.next())
					 {
						 String sql="delete from CellMember where cid='"+cid+ "' ";
						 stmt.executeUpdate(sql);
						 n=1;
					 }
				 }
				 catch(SQLException e)
				 {
					 e.printStackTrace();
					 n=0;
				 }
				 return n;
			 }
		}
