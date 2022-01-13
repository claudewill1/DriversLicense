<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<title>New Person</title>
</head>
<body>
	<h1>New Person</h1>
	<form:form action="/addPerson" method="POST" modelAttribute="person">
		<div class="form-group row mx-0">
			<form:label path="firstName">First Name:</form:label>
			<div class="col-sm-4">
				<form:input class="form-control" path="firstName"/>
				<form:errors class="small" path="firstName"/>
			</div>
		</div>
		<div class="form-group row mx-0">
			<form:label path="lastName">Last Name:</form:label>
			<div class="col-sm-4">
				<form:input class="form-control" path="lastName"/>
				<form:errors class="small" path="lastName"/>
			</div>
		</div>
		<div class="form-group row mx-0">
			<div class="col-sm-4 offset-sm-1">
				<input class="btn btn-success" type="submit" value="Create"/>
			</div>
		</div>
	</form:form>
</body>
</html>