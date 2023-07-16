<%@page import="com.entity.Student"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="com.conn.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="all_css.jsp"%>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Student</p>


						<%
						int id = Integer.parseInt(request.getParameter("id"));
						StudentDao dao = new StudentDao(DBConnect.getConnection());
						Student s = dao.getStudentById(id);
						%>

						<form action="update" method="post">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Full
									Name </label> <input type="text" class="form-control" name="name"
									value="<%=s.getFullName()%>">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Date
									of Birth</label> <input type="date" class="form-control" name="dob"
									value="<%=s.getDob()%>">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Address</label>
								<input type="text" class="form-control" name="address"
									value="<%=s.getAddress()%>">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Qualification</label>
								<input type="text" class="form-control" name="qualification"
									value="<%=s.getQualification()%>">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email</label>
								<input type="email" class="form-control" name="email"
									value="<%=s.getEmail()%>">
							</div>

							<input type="hidden" name="id" value="<%=s.getId()%>">
							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>