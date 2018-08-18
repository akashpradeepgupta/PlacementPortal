package com.services;

import java.sql.Connection;

import com.beans.Company;
import com.beans.student;

public interface CompanyInterface {
	
	void setCon(Connection con);
	Company[] CompanyVisit(String d1,String d2);
	student[] selectedCriteriaStudent(String company);
}
