<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pay</title>

<meta name="viewport" content="width=device-width,initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="jumbotron text-center">
		<h1 class="display-3">Thank ${sessionScope.account.user} for your buying!</h1>
		<p class="lead">
			<strong>Please check your email and choose a payment method</strong> The money you must pay: $${sumP}
		</p>
		<hr>
		<p>
			Having trouble? <a href="">0896200798</a>
		</p>
		<form action="SanPhamServlet" method ="post">
		<p class="lead">
			<input type="submit" class="btn btn-primary btn-sm"
				role="button" value="Continue to homepage"/>
		</p>
		</form>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>