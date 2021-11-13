package com.jpmc.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.dao.StudentDao;
import com.jpmc.model.Student;
import com.jpmc.model.User;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentRestController {
	
	@Autowired
	private StudentDao studentDao;
		
	@RequestMapping("/changePassword")
	public void changePassword(String userId, String password) {
		studentDao.changePassword();
	}
	
	@RequestMapping("/register")
	public User register(List<User> list) {
		System.out.println("got the request for registration");
		Student student = null;;
		studentDao.register(student);		
		return null;
	}
	
	@RequestMapping("/viewGrades")
	public List<String> viewGradeCard(int studentId){
		studentDao.viewGradeCard();
		return null;
	};

}
