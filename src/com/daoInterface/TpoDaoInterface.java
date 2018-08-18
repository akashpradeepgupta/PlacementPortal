package com.daoInterface;

import java.sql.Connection;
import com.beans.CellMember;

public interface TpoDaoInterface {
	
	int changeTpoPassword(Connection con,String id,String oldp,String newp );
	public int insertStudent(Connection con,String sid,String sname,String password,String email,double cpi,int status,String company,double salary,String branch,String interest);
	int editStudent(Connection con,String field,String id,String attribute);
	int editCellMember(Connection con,String field,String id,String attribute);
	int insertCellMember(Connection con,CellMember ceme);
	int deleteStudent(Connection con,String sid);
	int deleteCellMember(Connection con,String cid);
}
