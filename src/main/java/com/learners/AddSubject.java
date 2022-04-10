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

import com.dao.Subject;

/**
 * Servlet implementation class Subject
 */
@WebServlet("/Subject")
public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	RequestDispatcher RD;

    public AddSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//int id = Integer.parseInt(request.getParameter("SId"));
		String name = request.getParameter("SName");
		PrintWriter pw = response.getWriter();
		Subject s = new Subject();
		s.Con();
		try {
			if(s.DeleteSubject(name)) {
				pw.write("<center><span style='color:blue'>Subject is Removed</span></center>");
				RD=request.getRequestDispatcher("Subject.jsp");
				RD.include(request, response);
			}
			else {
				pw.write("<center><span style='color:red'>Incorrect Subject Details</span></center>");
				
				RD=request.getRequestDispatcher("Subject.jsp");
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
		String name = request.getParameter("SName");
	//	String time = request.getParameter("STime");
		PrintWriter pw = response.getWriter();
		Subject s = new Subject();
		s.Con();
		try {
			s.AddSubject(name);
			pw.write("<center><span style='color:blue'>Subject Added</span></center>");
			
			RD=request.getRequestDispatcher("Subject.jsp");
			RD.include(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
