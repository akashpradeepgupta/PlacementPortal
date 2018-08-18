package com.serviceImpl;

import java.sql.Connection;
import com.beans.CellMember;
import com.beans.student;
import com.daoImpl.TpoDaoImpl;
import com.providers.ProviderDao;

public class TpoServiceImpl {
	
	Connection con;
	TpoDaoImpl td=ProviderDao.getObj3();
	public void setCon(Connection con) {
		this.con = con;
	}
	
	public int changeTpoPassword(String id,String oldp,String newp)
	{
		int n=0;
		n=td.changeTpoPassword(con,id,oldp,newp);
		return n;
	}
	public int editStudent(String field,String id,String attribute)
	{
		int n=0;
		n=td.editStudent(con,field,id,attribute);
		return n;
	}
	
	public int editCellMember(String field,String id,String attribute)
	{
		int n=0;
		n=td.editCellMember(con,field,id,attribute);
		return n;
	}
	
	public int insertCellMember(CellMember ceme)
	{
		int n=0;
		n=td.insertCellMember(con,ceme);
		return n;
	}
	
	public int insertStudent(student s)
	{
		int n=0;
		n=td.insertStudent(con,s);
		return n;
	}
	public int deleteStudent(String sid)
	{
		int n=0;
		n=td.deleteStudent(con,sid);
		return n;
	}
	public int deleteCellMember(String cid)
	{
		int n=0;
		n=td.deleteCellMember(con,cid);
		return n;
	}
}
