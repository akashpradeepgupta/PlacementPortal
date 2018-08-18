package com.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.beans.Company;
import com.beans.student;

public class CompanyDaoImpl {
	
	// this method displays the details of company visiting between specified dates
		 public Company[] CompanyVisit(Connection con,String d1,String d2)      
		 {
			 Company t[]=new Company[10];
				try
				{
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date1 = sdf1.parse(d1);
					java.util.Date date2 = sdf1.parse(d2);
					java.sql.Date sqlStartDate1 = new java.sql.Date(date1.getTime());
					java.sql.Date sqlStartDate2 = new java.sql.Date(date2.getTime());
					Statement stmt= con.createStatement();
					String sql="select * from Company where visitDate>'"+sqlStartDate1+ "' and visitDate < '"+sqlStartDate2+ "'";
					ResultSet res= stmt.executeQuery(sql);
					int i=0;
					while(res.next())
					{
						t[i]=new Company();
						t[i].setName(res.getString("cname"));
						t[i].setVisitdate(res.getString("visitDate"));
						t[i].setCpi(res.getString("cpiCriteria"));
						t[i].setId(res.getString("cIN"));
						t[i].setSalary(res.getString("salary"));
						t[i].setReq(res.getString("requirements"));
						t[i].setBranch(res.getString("branch"));
				    	i++;
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			return t;
		 }
		
		 //this method select the students on the basis of criteria specified by given company
		 public student[] selectedCriteriaStudent(Connection con,String company)
		 {
			 student t[]=new student[10];
			 Company c=new Company();
			 try
			 {
				 Statement stmt=con.createStatement();
				 String sql="select * from Company where cname='"+company+ "'";
				 ResultSet res=stmt.executeQuery(sql);
				 while(res.next())
				 {
					 c.setId(res.getString("cIN"));
					 c.setName(res.getString("cname"));
					 c.setCpi(res.getString("cpiCriteria"));
					 c.setReq(res.getString("requirements"));
					 c.setBranch(res.getString("branch"));
				 }
				 String sql2="select * from Student where cpi>='"+c.getCpi()+ "' and interest='"+c.getReq()+ "' and branch='"+c.getBranch()+ "'and placementStatus=0";
				 Statement stmt2=con.createStatement();
				 ResultSet res2=stmt2.executeQuery(sql2);
				 int i=0;
				 while(res2.next())
				 {
					 t[i]=new student();
					 t[i].setSid(res2.getString("sid"));
					 t[i].setSname(res2.getString("sname"));
					 i++;
				 }
			 }
			 catch(SQLException e)
			 {
				 e.printStackTrace();
			 }
			 return t;
		 }
}
