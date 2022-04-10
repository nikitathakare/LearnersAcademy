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
<h1>Learners Academy Teachers</h1>
</div>
<sql:query var="resultSet" sql="select * from subject s left join teacher t on s.s_name = t.t_subject">
</sql:query>

<div align ="right" style ="margin-right:5%;">
<h2>Available Classes</h2>
</div>
<div>

	<table border="2" align ="right">
			
		<tr>
			
			<td>Subject_Name</td>
			<td>Class</td>
			<td>Teacher ID</td>
			<td>Name</td>
			<td>Email</td>

		</tr>
		<!--Iterating over a resultset  -->
		<c:forEach var="row" items="${resultSet.rows}">
			<tr>
				
				<td><c:out value="${row.s_name}" /></td>
				<td><c:out value="${row.s_time}" /></td>
				<td><c:out value="${row.t_id}" /></td>
				<td><c:out value="${row.t_Name}" /></td>
				<td><c:out value="${row.t_Email}" /></td>
				
				
			</tr>
		</c:forEach>
	</table>
	</div>


<div align ="center" style="margin-left:20%;">
<h2>Add Teacher </h2>
<form action="AddTeacher" method ="post">
<input type="text" name="TName" placeholder="Enter Teacher Name"/><br/>
<input type ="email" name="TEmail" placeholder="Enter Teacher Email"/><br/>
<input type="text" name="Subject" placeholder="Enter Subjcet"/>
<br/>
<input type="submit" value="Submit"/>
</form>
</div>
<br/>
<div align ="center" style="margin-left:25%;">
<a href="DisplayTeacher.jsp">Show All Teacher</a>
&nbsp; &nbsp;&nbsp;
<a href="DeleteTeacher.html">Remove Teacher</a>
</div>
</body>
</html>