<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<a style="font-size: 20px" href="SanPhamServlet">Back To Home</a> <br>
	<form action="UpdateProductServlet" method="post" >
	<c:set var="product" value="${requestScope.product}"/>
		<div class="form-group">
			<label> ID </label> <input type="text" name="pid" readonly="readonly"
				class="form-control" value = "${product.id}" placeholder="Enter ID">
			<label> Name </label> 
			<input type="text" name="pname" class="form-control" value = "${product.name}"placeholder="Enter Name">
			<label> Price </label> <input type="text" name="pprice" 
				class="form-control" value = "${product.price}" placeholder="Enter Price">
			<label > Image </label> <input type="file" name="pimg" 
				class="form-control" value = "${product.img}" placeholder="Enter Image">
				<label > Description </label> <input type="text" name="pdes" 
				class="form-control" value = "${product.description}" placeholder="Enter Description">
		</div>
		<input type="submit" class="btn btn-primary">UPDATE</button>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous">
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous">
	</script>
</body>
</html>