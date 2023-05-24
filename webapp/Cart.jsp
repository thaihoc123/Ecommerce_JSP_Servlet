<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<section class="h-100" style="background-color: #eee;">
		<div class="container h-100 py-5">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-10">

					<div class="d-flex justify-content-between align-items-center mb-4">
						<h3 class="fw-normal mb-0 text-black">Shopping Cart</h3>
						<div>
							<p class="mb-0">
								<span class="text-muted">Back to:</span> <a
									href="SanPhamServlet" class="text-body">Home </a>
							</p>
						</div>
					</div>
					<c:forEach items="${sessionScope.carts}" var="x">
					<div class="card rounded-3 mb-4">
						<div class="card-body p-4">
							<div
								class="row d-flex justify-content-between align-items-center">
								<div class="col-md-2 col-lg-2 col-xl-2">
									<img
										src="${x.product.img}"
										class="img-fluid rounded-3" alt="Cotton T-shirt">
								</div>
								<div class="col-md-3 col-lg-3 col-xl-3">
									<p class="lead fw-normal mb-2">${x.product.name}</p>
									<!-- <p>
										<span class="text-muted">Size: </span>M <span
											class="text-muted">Color: </span>Grey
									</p> -->
								</div>
								<div class="col-md-3 col-lg-3 col-xl-2 d-flex">
									<button class="btn btn-link px-2">
											<a href="DecreaseServlet?id=${x.product.id}"> <i class="fas fa-minus"></i>
											</a>
										</button>
									<input id="form1" min="0" name="quantity" value="${x.quanlity}"
										type="number" class="form-control form-control-sm" readonly />
									<button class="btn btn-link px-2">
										<a href="IncreaseServlet?id=${x.product.id}">				
										<i class="fas fa-plus"></i>
										</a>
									</button>
								</div>
								<div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
									<h5 class="mb-0">$${x.product.price}</h5>
								</div>
								<div class="col-md-1 col-lg-1 col-xl-1 text-end">
									<a href="DeleteCartServlet?cid=${x.product.id}" class="text-danger"><i
										class="fas fa-trash fa-lg"></i></a>
								</div>
							</div>
						</div>
					</div>
					</c:forEach>
					<div class="float-end" >
						<!-- <p class="mb-0 me-5 d-flex align-items-center">
							<span class="small text-muted me-2">Order total:</span> <span
								class="lead fw-normal">$${sumP}</span>
						</p> -->
						<h4>Order total:$${sumP}</h4>
					</div>
					<c:if test="${sumP!=0 && sumP!=null}">
					<div class="card">
						<div class="card-body">
						<a href="PayServlet?sumP=${sumP}">
							<button type="button" class="btn btn-warning btn-block btn-lg">Proceed
								to Pay</button>
						</div>
						</a>
					</div>
					</c:if>
				</div>
			</div>
		</div>
	</section>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>