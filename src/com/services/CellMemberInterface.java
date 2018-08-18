package com.services;

import com.beans.Company;
import com.beans.student;

public interface CellMemberInterface {
	
	int changeStudentPlacementStatus(String company, String sid);
	int insertCompanyDetails(Company comp);
	int editCompanyDetails(String field, int cIN, String attribute);
	int changePasswordCellMember(String id, String oldp, String newp);
	student[] placedStudent(String comName);
	int deleteCompany(String cname);
}
