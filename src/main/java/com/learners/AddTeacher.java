package com.learners;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.Operations;
import com.dao.Teachers;

/**
 * Servlet implementation class AddTeacher
 */
@WebServlet("/AddTeacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	ServletContext context;
	RequestDispatcher RD ;
	PrintWriter print;
	
	
    public AddTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    Teachers t  = new Teachers();
	public void init(ServletConfig config) throws ServletException {
			
	t.Con();
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String t_name = request.getParameter("t_name");
		String t_email = request.getParameter("t_email");
		//String t_subject = request.getParameter("t_subject");
		print = response.getWriter();
		
	
		try {
			if(t.DeleteTeacher(t_name, t_email)) {
				print.write("<center><span style='color:blue'>Teacher is removed</span></center>");
				RD= request.getRequestDispatcher("DisplayTeacher.jsp");
				RD.include(request, response);
			}
			else {
				print.write("<center><span style='color:red'>Invalid Teacher Details</span></center>");
				RD= request.getRequestDispatcher("DisplayTeacher.jsp");
				RD.include(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String t_name = request.getParameter("TName");
		String t_email = request.getParameter("TEmail");
		String t_subject = request.getParameter("Subject");
		
	     	print = response.getWriter();
		
		
		try {
			t.AddTeacher(t_name, t_email, t_subject);
			print.write("<center><span style='color:blue'>New Teacher Added </span></center>");
			RD= request.getRequestDispatcher("DisplayTeacher.jsp");
			RD.include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
