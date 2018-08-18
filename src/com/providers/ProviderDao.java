package com.providers;

import com.daoImpl.CellMemberDaoImpl;
import com.daoImpl.CompanyDaoImpl;
import com.daoImpl.StudentDaoImpl;
import com.daoImpl.TpoDaoImpl;

public class ProviderDao {
	
	public static StudentDaoImpl getObj1()
	{
		return new StudentDaoImpl();
	}
	
	public static CellMemberDaoImpl getObj2()
	{
		return new CellMemberDaoImpl();
	}
	
	public static TpoDaoImpl getObj3()
	{
		return new TpoDaoImpl();
	}
	
	public static CompanyDaoImpl getObj4()
	{
		return new CompanyDaoImpl();
	}
}
