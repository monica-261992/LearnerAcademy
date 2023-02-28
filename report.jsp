<%@page import="org.simplilearn.lms.entities.Student"%>
<%@page import="org.simplilearn.lms.entities.Grade"%>
<%@page import="org.simplilearn.lms.entities.SubjectClassTeacher"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

	<%
	List<Student> students = (List<Student>) request.getAttribute("students");
	List<SubjectClassTeacher> reportList = (List<SubjectClassTeacher>) request.getAttribute("reportList");
	%>

	<div class="container">
		<div class="row">
			<div class="col m6 offset-m3">
				<div class="card">
					<div class="card-content">
						<a href="home.jsp">Go to Home Page</a>
						<table border="1">
							<tr>
								<td>Id</td>
								<td>Name</td>
								<td>Age</td>
								<td>Email</td>
								<td>Address</td>
								<td>Class</td>
							</tr>
							<%
							if(students!=null){
							for (Student student : students) {
							%>
							<tr>
								<td><%=student.getId()%></td>
								<td><%=student.getSt_name()%></td>
								<td><%=student.getAge()%></td>
								<td><%=student.getEmail()%></td>
								<td><%=student.getAddress()%></td>
								<td><%=student.getGrade().getName()%></td>
							</tr>
							<%
							}}
							%>

							

						</table>
						<br><br><br>
						<table border="1">
							<tr>

								<td>Subject</td>
								<td>Teacher</td>

							</tr>
							<%
							if(reportList!=null){
							for (SubjectClassTeacher obj : reportList) {
							%>
							<tr>
								<td><%=obj.getSubject().getName()%></td>
								<td><%=obj.getTeacher().getName()%></td>

							</tr>
							<%	
			}}
		%>


						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>