package com.daoInterface;

import java.sql.Connection;

import com.beans.Company;
import com.beans.student;

public interface CellMemberDaoInterface {
	
	int changeStudentPlacementStatus(Connection con,String company, String sid);
	int insertCompanyDetails(Connection con,Company comp);
	int editCompanyDetails(Connection con,String field, int cIN, String attribute);
	int changePasswordCellMember(Connection con,String id, String oldp, String newp);
	student[] placedStudent(Connection con,String comName);
	int deleteCompany(Connection con,String cname);
}
