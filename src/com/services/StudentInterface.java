package com.services;

import java.sql.Connection;

import com.beans.Company;

public interface StudentInterface {
	
	void setCon(Connection con);
	int changeStudentPassword(String id, String oldp, String newp);
	Company[] checkCompany();
	Company[] visitingDate(String d1,String d2);
}
