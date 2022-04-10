package com.learners;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Operations;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       RequestDispatcher RD;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }


	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String StudName = request.getParameter("StudName");
		String StudEmail = request.getParameter("StudEmail");
		 PrintWriter pw= response.getWriter();
		Operations op = new Operations();
		op.Con();
		try {
			if(op.DeleteStudent(StudName, StudEmail)) {
				pw.write("<center><span style='color:blue'>Student is Removed</span></center>");
				RD=request.getRequestDispatcher("DisplayStudent.jsp");
				RD.include(request, response);
			}
			else {
				pw.write("<center><span style='color:red'>Incorrect Student Details</span></center>");
				
				RD=request.getRequestDispatcher("DisplayStudent.jsp");
				RD.include(request, response);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter print= response.getWriter();
		String StudName = request.getParameter("StudName");
		String StudEmail = request.getParameter("StudEmail");
		String Subject = request.getParameter("Subject");
		
		Operations op = new Operations();
		op.Con();
		try {
			op.AddStudent(StudName, StudEmail, Subject);
			print.write("<center><span style='color:blue'>New Student Added </span></center>");
			RD=request.getRequestDispatcher("DisplayStudent.jsp");
			RD.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
