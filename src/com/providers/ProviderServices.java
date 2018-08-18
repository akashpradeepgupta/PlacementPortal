package com.providers;

import com.serviceImpl.CellMemberServiceImpl;
import com.serviceImpl.CompanyServicesImpl;
import com.serviceImpl.StudentServiceImpl;
import com.serviceImpl.TpoServiceImpl;

public class ProviderServices {
	
	public static StudentServiceImpl getObj1()
	{
		return new StudentServiceImpl();
	}
	
	public static CellMemberServiceImpl getObj2()
	{
		return new CellMemberServiceImpl();
	}
	
	public static TpoServiceImpl getObj3()
	{
		return new TpoServiceImpl();
	}
	
	public static CompanyServicesImpl getObj4()
	{
		return new CompanyServicesImpl();
	}
}
