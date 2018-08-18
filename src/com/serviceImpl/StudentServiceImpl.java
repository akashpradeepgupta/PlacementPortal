package com.serviceImpl;

import java.sql.Connection;

import com.beans.Company;
import com.daoImpl.StudentDaoImpl;
import com.providers.ProviderDao;

public class StudentServiceImpl {
	
	Connection con;
	StudentDaoImpl st=ProviderDao.getObj1();
	
	public void setCon(Connection con) 
	{
		this.con = con;
		System.out.println(this.con);
	}

	public int changeStudentPassword(String id, String oldp, String newp)
	{
		int n=0;
		n =st.changeStudentPassword(con,id,oldp,newp);
		return n;
	}
	public Company[] checkCompany()
	{
		Company c[]=new Company[20];
		st.checkCompany(con);
		return c;
	}
	
	public Company[] visitingDate(String d1,String d2)
	{
		Company c[]=new Company[20];
		st.visitingDate(con,d1,d2);
		return c;
	}
}
