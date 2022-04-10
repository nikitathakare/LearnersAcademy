<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Subject</title>
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
.center {
margin-top : 2%;
margin-left :5%
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

<sql:setDataSource user="root"
password="root"
url="jdbc:mysql://localhost:3306/learners"
driver="com.mysql.jdbc.Driver"
/>
<div align ="center" style ="margin-left:10%;">
<h1>Learners Academy Students</h1>
</div>
<sql:query var="resultSet" sql="select * from subjects">
</sql:query>

<div align ="right" style ="margin-right:5%;">
<h2>Available Subject</h2>
</div>
<div style="margin-right:5%;">

	<table border="2" align ="right">
		<tr>
		
			
			<td>Subject</td>
		
			
		</tr>
		<!--Iterating over a resultset  -->
		<c:forEach var="row" items="${resultSet.rows}">
			<tr>
				
				<td><c:out value="${row.name}" /></td>
				
			
			</tr>
		</c:forEach>
	</table>
	</div>


<div align ="center" style="margin-left:15%;">
<h2>Add Student</h2>
<form action="AddStudent" method ="post" >
<input type="text" name="StudName" placeholder="Enter Student Name"/><br/>
<input type ="email" name="StudEmail" placeholder="Enter Student Email"/><br/>

<input type="text" name="Subject" placeholder="Enter Subject Name" /><br/>
<input type="submit" value="Submit"/>
</form>
</div>
<br/>
<div align ="center" style="margin-left:15%;">
<a href="DisplayStudent.jsp">Show All Students</a>
&nbsp; &nbsp;&nbsp;
<a href="DeleteStudent.html">Remove Student</a>
</div>
</body>
</html>