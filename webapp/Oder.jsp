<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
	<a href="SanPhamServlet" class="btn btn-primary">GO BACK</a>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">Id Oder</th>
				<th scope="col">Date</th>
				<th scope="col">Id Buyer</th>
				<th scope="col">Buyer</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${oder }" var="o">
			<tr>
				<th scope="row">${o.idOder }</th>
				<td>${o.date }</td>
				<td>${o.idBuyer }</td>
				<td>${o.buyer }</td>
				<td><a href="DeleteOder?id=${o.idOder}" class="btn btn-success">Accept</a></td>
			</tr>
		</c:forEach>
		
		</tbody>
	</table>
</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>