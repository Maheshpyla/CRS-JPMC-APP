package com.jpmc.dao;

import java.util.List;

import com.jpmc.model.User;

public interface StudentDao {
	
	public void changePassword();
	
	public User register();
	
	public List<String> viewGradeCard();
	

}
