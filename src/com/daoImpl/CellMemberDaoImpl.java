package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.beans.CellMember;
import com.beans.Company;
import com.beans.student;

public class CellMemberDaoImpl {

	CellMember cm = new CellMember();
	
	//Change status of Student if they get placed:set placement status=1 and set placementCompany and salary
		public int changeStudentPlacementStatus(Connection con,String company, String sid) 
		{
			int n = 0;
			try 
			{
				Statement stmt = con.createStatement();
				//int cid;
				double slry = 0;
				String s1 = "select * from Student where sid='" + sid + "'";
				Statement stm1 = con.createStatement();
				ResultSet rs1 = stm1.executeQuery(s1);
				while (rs1.next()) 
				{
					String sql = "select * from Company where cname='" + company + "'";
					ResultSet res = stmt.executeQuery(sql);
					while (res.next()) 
					{
						//cid = res.getInt("cIN");
						slry = res.getDouble("salary");
						Statement stmt1 = con.createStatement();
						Statement stmt2 = con.createStatement();
						Statement stmt3 = con.createStatement();
						String sql1 = "update Student set placementStatus=1 where sid='" + sid + "'";
						stmt1.executeUpdate(sql1);
						String sql2 = "update Student set salary='" + slry + "' where sid='" + sid + "'";
						stmt2.executeUpdate(sql2);
						String sql3 = "update Student set placedCompany='" + company + "' where sid='" + sid + "'";
						stmt3.executeUpdate(sql3);
						n = 1;
					}
				}
			} 
			catch (SQLException ex) 
			{
				ex.printStackTrace();
				n = 0;
			}
			return n;
		}
	//To insert a new company and setting all their attributes
		public int insertCompanyDetails(Connection con,Company comp) 
		{
			int n = 0;
			System.out.println("id is =" + comp.getId());
			try 
			{
				String a = "insert into Company values(?,?,?,?,?,?,?,?,?)";

				PreparedStatement preparedStmt = con.prepareStatement(a);
				preparedStmt.setString(1, comp.getId());
				preparedStmt.setString(2, comp.getName());
				preparedStmt.setString(3, comp.getEmailId());
				preparedStmt.setString(4, comp.getCpi());
				preparedStmt.setString(5, comp.getCity());
				preparedStmt.setString(6, comp.getVisitdate());
				preparedStmt.setString(7, comp.getSalary());
				preparedStmt.setString(8, comp.getBranch());
				preparedStmt.setString(9, comp.getReq());
				
				preparedStmt.execute();
				n = 1;
			} 
			catch (SQLException e) 
			{
				n = 0;
				System.out.println("hello");
				e.printStackTrace();
				n = 0;
			}
			System.out.println(n);
			return n;
		}
		
	//To edit any attribute of existing company
		public int editCompanyDetails(Connection con,String field, int cIN, String attribute) 
		{
			int n = 0;
			int count = 0;
			try 
			{
				String sql;
				PreparedStatement ps;
				Statement stmt1 = con.createStatement();
				ResultSet rs1 = stmt1.executeQuery("select count(*) from Company where cIN='" + cIN + "'");
				// int count=rs1.getInt("count(*)");
				while (rs1.next()) 
				{
					count = rs1.getInt("count(*)");
				}
				if (count > 0) 
				{
					if (field.equals("cname")) 
					{
						sql = "UPDATE Company set cname= ? where cIN=?";
						ps = con.prepareStatement(sql);
						ps.setString(1, attribute);
						ps.setInt(2, cIN);
						ps.executeUpdate();
						n = 1;
					}
					if (field.equals("cpiCriteria")) 
					{
						sql = "UPDATE Company set cpiCriteria= ? where cIN=?";
						ps = con.prepareStatement(sql);
						double cpi = Double.parseDouble(attribute);
						System.out.println("hello cpi");
						ps.setDouble(1, cpi);
						ps.setInt(2, cIN);
						ps.executeUpdate();
						n = 1;
					}
					if (field.equals("salary")) 
					{
						sql = "UPDATE Company set salary= ? where cIN=?";
						ps = con.prepareStatement(sql);
						double salary = Double.parseDouble(attribute);
						ps.setDouble(1, salary);
						ps.setInt(2, cIN);
						ps.executeUpdate();
						n = 1;
					}
					if (field.equals("cEmailId")) 
					{
						sql = "UPDATE Company set cEmailId= ? where cIN=?";
						ps = con.prepareStatement(sql);
						ps.setString(1, attribute);
						ps.setInt(2, cIN);
						ps.executeUpdate();
						n = 1;
					}
					if (field.equals("city")) 
					{
						sql = "UPDATE Company set city= ? where cIN=?";
						ps = con.prepareStatement(sql);
						ps.setString(1, attribute);
						ps.setInt(2, cIN);
						ps.executeUpdate();
						n = 1;
					}
					if (field.equals("visitDate")) 
					{
						sql = "UPDATE Company set visitDate= ? where cIN=?";
						ps = con.prepareStatement(sql);
						//SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
						//java.util.Date date1;
						try 
						{
							//date1 = sdf1.parse(attribute);
							//java.sql.Date sqlStartDate1 = new java.sql.Date(date1.getTime());
							ps.setString(1, attribute);
							ps.setInt(2, cIN);
							ps.executeUpdate();
							n = 1;
						} 
						catch (SQLException e) 
						{
							e.printStackTrace();
							n = 0;
						}
					}
					if (field.equals("requirements")) 
					{
						sql = "UPDATE Company set requirements= ? where cIN=?";
						ps = con.prepareStatement(sql);
						ps.setString(1, attribute);
						ps.setInt(2, cIN);
						ps.executeUpdate();
						n = 1;
					}
					if (field.equals("branch")) 
					{
						sql = "UPDATE Company set branch= ? where cIN=?";
						ps = con.prepareStatement(sql);
						ps.setString(1, attribute);
						ps.setInt(2, cIN);
						ps.executeUpdate();
						n = 1;
					}
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				n = 0;
			}
			return n;
		}
	
		//this method provides cell members an option to change their password.
		public int changePasswordCellMember(Connection con,String id, String oldp, String newp) 
		{
			int n = 0;
				try 
				{
					Statement stmt = con.createStatement();
					ResultSet res;
					String pswd = null;
					String sql = "select * from CellMember where cid='" + id + "' ";
					res = stmt.executeQuery(sql);
					while (res.next()) 
					{
						pswd = res.getString("cpassword");
					}
					if (pswd.equals(oldp)) 
					{
						Statement stmt1 = con.createStatement();
						String sql1 = "update CellMember set cpassword='" + newp + "' where cid='" + id + "'";
						stmt1.executeUpdate(sql1);
						n = 1;
					}
				
				}
				catch (SQLException e) 
				{
					n = 0;
					e.printStackTrace();
					return n;
				}
			System.out.println(n);
			return n;
		}

		//it will display the status of students who are placed in given company
		public student[] placedStudent(Connection con,String comName) 
		{
				student c[] = new student[20];
				try 
				{
					Statement stmt = con.createStatement();
					String sql = "select * from Student where placedCompany='" + comName + "'";
					ResultSet res = stmt.executeQuery(sql);
					int i = 0;
					while (res.next()) 
					{
						c[i] = new student();
						c[i].setSid(res.getString("sid"));
						c[i].setSname(res.getString("sname"));
						i++;
					}
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
				return c;
		}

		public int deleteCompany(Connection con,String cname) 
		{
			int n = 0;
			int cIN = 0;
			try 
			{
				Statement sm = con.createStatement();
				Statement stmt = con.createStatement();
				String s = "select * from Company where cname='" + cname + "' ";
				ResultSet res = sm.executeQuery(s);
				while (res.next()) 
				{
					cIN = res.getInt("cIN");
					String sql = "delete from Company where cIN='" + cIN + "' ";
					stmt.executeUpdate(sql);
					n = 1;
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				n = 0;
			}
			return n;
		}
}
