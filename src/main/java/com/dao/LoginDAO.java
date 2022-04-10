package com.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	String sql= "select * from user where userid=? and password=?";
public boolean validateLogin(String UserName, String Password) {
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Learners","root","root");
	PreparedStatement pst = con.prepareStatement(sql);
	pst.setString(1, UserName);
	pst.setString(2, Password);
	ResultSet rs =pst.executeQuery();
	if(rs.next()) {
		return true;
	}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
}
	
}
