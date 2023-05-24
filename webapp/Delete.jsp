<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/styles.css" rel="stylesheet" />
</head>
<body>
	<a style="font-size: 20px" href="SanPhamServlet">Back To Home</a>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
      <th scope="col">Image</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="x">
    <tr>
      <th scope="row">${x.id}</th>
      <td>${x.name}</td>
      <td>${x.price}</td>
      <td>${x.img}</td>
      <td><a href="DeleteSanPhamServlet?id=${x.id}" style="text-decoration:none;">DELETE</a></td>
      <td><a href="UpdateProductServlet?id=${x.id}" style="text-decoration:none;">UPDATE</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>