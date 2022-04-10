package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Teachers {

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
	
public void AddTeacher(String name, String email, String sub)throws SQLException {
		
		pst = con.prepareStatement("insert into teacher(t_Name,t_Email,t_Subject)values(?,?,?)");
		pst.setString(1,name);
		pst.setString(2, email);
		pst.setString(3, sub);
		
		pst.executeUpdate();
		
	}

public boolean DeleteTeacher(String name , String email) throws SQLException {
	pst = con.prepareStatement("delete from teacher where t_Name=? and t_Email=?");
	pst.setString(1,name);
	pst.setString(2, email);
	int n = pst.executeUpdate();
	if(n==1) {
		return true;
	}
	
	return false;
}

}
