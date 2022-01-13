<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<h1>New License</h1>
	<form:form action="/addLicense" method="POST" modelAttribute="license">
		<div class="form-group row mx-0">
			<form:label path="person">Person:</form:label>
			<div class="col-sm-4">
				<form:select class="form-control" path="person">
					<c:forEach items="${persons}" var="person">
						<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
					</c:forEach>
				</form:select>
				<form:errors class="small" path="person"/>
			</div>
		</div>
		<div class="form-group row mx-0">
			<form:label path="lastName">State:</form:label>
			<div class="col-sm-4">
				<form:select path="states">
					<c:forEach items="${states}" var="state">
						<form:option value="${state}"><c:out value="${state}"/></form:option>
					</c:forEach>
				</form:select>
				<form:errors class="small" path="state"/>
			</div>
		</div>
		<div class="form-group row mx-0">
			<form:label path="expirationDate">Expiration Date:</form:label>
			<div class="col-sm-4">
				<form:input type="date" path="expirationDate"/>
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