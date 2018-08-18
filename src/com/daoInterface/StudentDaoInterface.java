package com.daoInterface;

import java.sql.Connection;

import com.beans.Company;

public interface StudentDaoInterface {
	
	int changeStudentPassword(Connection con,String id, String oldp, String newp);
	Company[] checkCompany(Connection con);
	Company[] visitingDate(Connection con,String d1,String d2);
}
