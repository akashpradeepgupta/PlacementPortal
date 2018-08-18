package com.serviceImpl;

import java.sql.Connection;

import com.beans.Company;
import com.beans.student;
import com.daoImpl.CompanyDaoImpl;
import com.providers.ProviderDao;

public class CompanyServicesImpl {
	
	Connection con;
	CompanyDaoImpl cd=ProviderDao.getObj4();
	
	public void setCon(Connection con) {
		this.con = con;
	}

	public Company[] CompanyVisit(String d1,String d2)
	{
		Company c[]=new Company[20];
		c=cd.CompanyVisit(con,d1,d2);
		return c;
	}
	public student[] selectedCriteriaStudent(String company)
	{
		student s[]=new student[20];
		s=cd.selectedCriteriaStudent(con,company);
		return s;
	}
}
