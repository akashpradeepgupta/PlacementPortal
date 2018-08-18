package com.daoInterface;

import java.sql.Connection;

import com.beans.Company;
import com.beans.student;

public interface CompanyDaoInterface {
	
	Company[] CompanyVisit(Connection con,String d1,String d2);
	student[] selectedCriteriaStudent(Connection con,String company);
}
