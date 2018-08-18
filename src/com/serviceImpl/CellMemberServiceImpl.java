package com.serviceImpl;

import java.sql.Connection;

import com.beans.Company;
import com.beans.student;
import com.daoImpl.CellMemberDaoImpl;
import com.providers.ProviderDao;

public class CellMemberServiceImpl {
	
	Connection con;
	CellMemberDaoImpl cm=ProviderDao.getObj2();
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public int changeStudentPlacementStatus(String company, String sid)
	{
		int n=0;
		n=cm.changeStudentPlacementStatus(con,company,sid);
		return n;
	}
	public int insertCompanyDetails(Company comp)
	{
		int n=0;
		System.out.println(comp);
		n=cm.insertCompanyDetails(con,comp);
		return n;
	}
	
	public int editCompanyDetails(String field, int cIN, String attribute)
	{
		int n=0;
		n=cm.editCompanyDetails(con,field,cIN,attribute);
		return n;
	}
	
	public int changePasswordCellMember(String id, String oldp, String newp)
	{
		int n=0;
		n=cm.changePasswordCellMember(con,id,oldp,newp);
		return n;
	}
	public student[] placedStudent(String comName)
	{
		student s[]=new student[20];
		s=cm.placedStudent(con,comName);
		return s;
	}
	public int deleteCompany(String cname)
	{
		int n=0;
		n=cm.deleteCompany(con,cname);
		return n;
	}
}
