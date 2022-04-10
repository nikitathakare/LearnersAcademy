package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Operations {
	
	PreparedStatement pst;
	Connection con;
	public void Con() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Learners","root","root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void DisplayStudent() throws SQLException {
		
		
		
	}
	
	public void AddStudent(String name, String email, String sub) throws SQLException {
		pst = con.prepareStatement("insert into Student(student_Name,Student_Email,Subject)values(?,?,?)");
		//pst.setInt(1, 3);
		pst.setString(1, name);
		pst.setString(2, email);
		pst.setString(3, sub);
	
		pst.executeUpdate();
		
	}
	
	public boolean DeleteStudent(String name,String email) throws SQLException {
		pst = con.prepareStatement("delete from student where Student_Name=? and Student_Email=?");
		pst.setString(1, name);
		pst.setString(2, email);
		int n = pst.executeUpdate();	
		if(n==1) {
			return true;
		}
		return false;
	}
	
	

}
