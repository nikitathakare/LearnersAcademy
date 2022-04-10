<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
  margin: 0;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 25%;
  background-color: #f1f1f1;
  position: fixed;
  height: 100%;
  overflow: auto;
}

li a {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

li a.active {
  background-color: #04AA6D;
  color: white;
}

li a:hover:not(.active) {
  background-color: #555;
  color: white;
}


</style>
</head>
<body>
<ul>
  <li><a class="active" href="Student.jsp">Student</a></li>
  <li><a href="Teacher.jsp">Teacher</a></li>
  <li><a href="Subject.jsp">Subject</a></li>
  <li><a href="Classes.jsp">Classes</a></li>
  <li><a href="Logout.html">Logout</a></li>
</ul>
<body>
<sql:setDataSource user="root"
password="root"
url="jdbc:mysql://localhost:3306/learners"
driver="com.mysql.jdbc.Driver"
/>

<div style="margin-left:30%;padding:1px 16px;height:1000px;">
<h1>Student List</h1>
<sql:query var="resultSet" sql="select * from student">
</sql:query>


	<table border="2">
		<tr>
			<td>stud_id</td>
			<td>Student_Name</td>
			<td>Stuent_Email</td>
			<td>Subject</td>
		</tr>
		<!--Iterating over a resultset  -->
		<c:forEach var="row" items="${resultSet.rows}">
			<tr>
				<td><c:out value="${row.stud_id}" /></td>
				<td><c:out value="${row.Student_Name}" /></td>
				<td><c:out value="${row.Student_Email}" /></td>
				<td><c:out value="${row.Subject}" /></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>