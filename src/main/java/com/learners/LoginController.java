package com.learners;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LoginDAO;

//import com.mysql.cj.xdevapi.PreparableStatement;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	Connection con;
	ServletContext context;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	RequestDispatcher RD; 
 
    	
	
	public void init(ServletConfig config) throws ServletException {

		
	
	}
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	 String email = req.getParameter("email");
     String pass = req.getParameter("pass");
     PrintWriter pw = resp.getWriter();
     
     LoginDAO login =new LoginDAO();
	if(login.validateLogin(email, pass)) {
		RD=req.getRequestDispatcher("Student.jsp");
		RD.forward(req, resp);
	}
	else {
		
		RD=req.getRequestDispatcher("index.html");
		RD.include(req, resp);
		pw.write("<center><span style='color:red'>Invaid User</span></center>");
		
		
	}
    	
    
 }
	
}


