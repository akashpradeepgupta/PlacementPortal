package com.services;

import com.beans.CellMember;
import com.beans.student;

public interface TpoInterface {
	
	int changeTpoPassword(String id,String oldp,String newp );
	int editStudent(String field,String id,String attribute);
	public int insertStudent(student s);
	int editCellMember(String field,String id,String attribute);
	int insertCellMember(CellMember ceme);
	int deleteStudent(String sid);
	int deleteCellMember(String cid);
}
