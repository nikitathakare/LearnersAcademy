package com.learners;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;

/**
 * Servlet implementation class ClassReport
 */
@WebServlet("/ClassReport")
public class ClassReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PreparedStatement pst;
	Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Learners","root","root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter print = response.getWriter();
		
		PrintWriter out = response.getWriter();
		String class_name = request.getParameter("SubName");
		String class_time = request.getParameter("SubTime");
		try {
			pst = con.prepareStatement("update subject set s_time = ? where s_name =?");
			pst.setString(1, class_time);
			pst.setString(2, class_name);
			pst.executeUpdate();  
			print.write("<center><span style='color:blue'>Class assinged</span></center>");
			RequestDispatcher Rd = request.getRequestDispatcher("Classes.jsp");
			Rd.include(request, response);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String class_name = request.getParameter("SubName");
		try {
			pst = con.prepareStatement("select s.s_name,s.s_time , t.t_name,st.student_name from subject s join teacher t on s.s_name = t.t_subject join student st on st.subject=s.s_name where s.s_name=? ");
			pst.setString(1, class_name);
			ResultSet rs=pst.executeQuery();       
			out.println("<center><table border=1 >");
            out.println("<caption><h2>Class Report</h2></caption>");

            out.println("<tr style='background-color:#ffffb3; color:red'>");
            out.println("<th>Subject Name</th>");
            out.println("<th> Class Time</th>");
            out.println("<th> Teacher Name</th>");
            out.println("<th> Student Name</th>");
            out.println("</tr>");

             /* Printing column names */

            while(rs.next()) {
				
				String s_name = rs.getString("s_name");
				String s_time = rs.getString("s_time");
				String t_name = rs.getString("t_name");
				String student_name = rs.getString("student_name");
				//Print.println("\n "+s_name+" "+s_time+" "+t_name+" "+student_name);
             
             
             //Display values
             out.println("<tr style='background-color:#b3ffd9;'>");
             out.println("<td>" + s_name + "</td>");
             out.println("<td>" + s_time + "</td>");
             out.println("<td>" + t_name+ "</td>");
             out.println("<td>" + student_name + "</td>");
             out.println("</tr>");
        }
        out.println("</table></center>");
        out.println("</bod;=y></html>");
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	

}
