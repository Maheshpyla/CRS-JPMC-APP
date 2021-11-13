package com.jpmc.dao;

import java.util.List;

import com.jpmc.model.Student;
import com.jpmc.model.User;

public interface StudentDao {
	
	public void changePassword();
	
	public int register(Student student);
	
	public List<String> viewGradeCard();
	

}
