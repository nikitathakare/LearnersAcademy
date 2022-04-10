package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Subject {
	
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
	
	public void AddSubject(String name) throws SQLException {
		pst = con.prepareStatement("insert into Subject(s_Name)values(?)");
		//pst.setInt(1, 3);
		pst.setString(1, name);
		
		//pst.setString(3, sub);
		pst.executeUpdate();
	}
	
	public boolean DeleteSubject(String name) throws SQLException {
		pst = con.prepareStatement("delete from subject where s_name=?");
		
		pst.setString(1, name);
		//pst.setString(3, sub);
		int n =pst.executeUpdate();
		if(n==1) {
			return true;
		}
		return false;
	}

}
