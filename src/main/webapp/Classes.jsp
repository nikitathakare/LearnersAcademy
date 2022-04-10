<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Classes</title>
</head>
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
<div align ="center" style ="margin-left:10%;">
<h1>Learners Academy Students</h1>
</div>

<sql:setDataSource user="root"
password="root"
url="jdbc:mysql://localhost:3306/learners"
driver="com.mysql.jdbc.Driver"
/>
<div align ="right" style ="margin-right:5%;">

<h2>Available Subject</h2>
</div>
<sql:query var="resultSet" sql="select * from subject">
</sql:query>
<div style="margin-right:5%;">

	<table border="2" align ="right">
		<tr>
			<td>s_id</td>
			<td>s_name</td>
			<td>class</td>
		
			
		</tr>
		<!--Iterating over a resultset  -->
		<c:forEach var="row" items="${resultSet.rows}">
			<tr>
				<td><c:out value="${row.subject_id}" /></td>
				<td><c:out value="${row.s_name}" /></td>
				<td><c:out value="${row.s_time}" /></td>
				
			
			</tr>
		</c:forEach>
	</table>
</div>

<div align ="center" style="margin-left:15%;">

<h2> Generate Class Report </h2>
<form action="ClassReport" method ="post">
Enter Subject Name : <input type="text" name="SubName" placeholder="Enter Subject Name"/><br/>
<input type="submit" value="Submit"/>

</form>
<h2> Assign Class for subject</h2>
<form action="ClassReport" method ="get">
Enter Subject Name : <input type="text" name="SubName" placeholder="Enter Subject Name"/><br/>s
Enter Class Time : <input type="text" name="SubTime" placeholder="Enter Subject Time"/><br/>
<input type="submit" value="Submit"/>

</form>

</div>

</body>
</html>