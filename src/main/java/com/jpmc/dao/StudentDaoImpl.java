package com.jpmc.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpmc.constants.SQLConstants;
import com.jpmc.exception.StudentNotRegisteredException;
import com.jpmc.model.Student;
import com.jpmc.model.User;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Override
	public void changePassword() {
		// TODO Auto-generated method stub
		System.out.println("");
	}

	@Override
	public int register(Student student) throws StudentNotRegisteredException {
		Connection conn = null;//DBUtils.getConnection();
		PreparedStatement stmnt = null;
		int studentId = 0;
		try {
			stmnt = conn.prepareStatement(SQLConstants.GET_ROLENAME);
			stmnt.setInt(1, 3);
			ResultSet rs = stmnt.executeQuery();
			String role = "";
			if (rs.next()) {
				role = rs.getString(1);
			}

			stmnt = conn.prepareStatement(SQLConstants.ADD_USER_QUERY);
			stmnt.setString(1, student.getUserId());
			stmnt.setString(2, student.getPassword());
			stmnt.setString(3, role);

			int rows = stmnt.executeUpdate();
			if (rows == 1) {

				PreparedStatement stmntStud = conn.prepareStatement(SQLConstants.ADD_STUDENT,
						java.sql.Statement.RETURN_GENERATED_KEYS);

				stmntStud.setString(1, student.getName());
				stmntStud.setString(2, student.getEmail());
				stmntStud.setString(3, student.getBranch());
				stmntStud.setString(4, student.getAddress());
				stmntStud.setBoolean(5, false);
				stmntStud.setInt(6, 3);
				stmntStud.executeUpdate();
				ResultSet results = stmntStud.getGeneratedKeys();
				if (results.next())
					studentId = results.getInt(1);
			}

		} catch (SQLException ex) {
			//logger.error(ex.getMessage());
			//throw new StudentNotRegisteredException(student.getName());
		}
		return studentId;
	}


	@Override
	public List<String> viewGradeCard() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
