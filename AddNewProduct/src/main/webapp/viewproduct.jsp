<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><style>
body{text-align: center}

</style>
<meta charset="ISO-8859-1">
<title>View Product</title>
</head>
<body>

	<h1>Product List</h1>
	
	<table style="margin-left:auto;margin-right:auto;">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
		</tr>
		<c:forEach var="product" items="${product}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.cost}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="productdetails.html">Home</a>
</body>
</html>