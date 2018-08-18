package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.beans.Company;
import com.beans.student;

public class StudentDaoImpl {
	
	student st = new student();
	Connection con;
		// this method will change the password of student
		public int changeStudentPassword(Connection con,String id, String oldp, String newp) 
		{
			int n = 0;
			try 
			{
				Statement stmt = con.createStatement();
				ResultSet res;
				String pswd = null;
				String sql = "select * from Student where sid='" + id + "' ";
				res = stmt.executeQuery(sql);
				while (res.next()) 
				{
					pswd = res.getString("spassword");
				}
				if (pswd.equals(oldp)) 
				{
					Statement stmt1 = con.createStatement();
					String sql1 = "update Student set spassword='" + newp + "' where sid='" + id + "'";
					stmt1.executeUpdate(sql1);
					n = 1;
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return n;
		}
		// it will select companies which satisfy the student requirements 
		public Company[] checkCompany(Connection con)
		{
			int count = 0;
			try
			{
				Statement stmt=con.createStatement();
				Statement stmt1=con.createStatement();
				
				ResultSet rs1=stmt1.executeQuery("select count(*) from Company");
				while(rs1.next())
				{
				count=rs1.getInt("count(*)");
				}
				System.out.println("count ="+count);
				
				Company t[]=new Company[count];
				
				ResultSet rs = stmt.executeQuery("select * from Company where requirements='"+this.st.getInterest()+"' and cpiCriteria<='"+this.st.getCpi()+"' and branch='"+ this.st.getBranch()+"'");
				int i=0;
				try
				{
					while(rs.next())
					{
						t[i]=new Company();
						t[i].setId(rs.getString("cIN"));
						t[i].setName(rs.getString("cname"));
						i++;
					}
					return t;
				}
				catch(Exception e)
				{
				e.printStackTrace();
				return null;
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return null;
			}
		}
		
		//it will display all the companies visiting in between the specified dates 
		public Company[] visitingDate(Connection con,String d1,String d2)
		{
			try
			{
				Statement stmt1=con.createStatement();
				
				ResultSet rs1=stmt1.executeQuery("select count(*) from Company");
				int count=rs1.getInt("count(*)");
				System.out.println("count ="+count);
				
				Company t[]=new Company[count];
				try
				{
					Statement stmt= con.createStatement();
					String sql="select * from Company where visitDate>'"+d1+ "' and visitDate < '"+d2+ "' ";
					ResultSet res= stmt.executeQuery(sql);
					int i=0;
					while(res.next())
					{
						t[i]=new Company();
						t[i].setName(res.getString("cname"));
						t[i].setVisitdate(res.getString("visitDate"));
						i++;
					}
					return t;
				}
				catch(Exception e)
				{
					e.printStackTrace();
					return null;
				}
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
				return null;
			}
		}
}
