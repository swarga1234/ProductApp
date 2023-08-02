<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body>
	<div class="container">
		<form action="${pageContext.request.contextPath}/add-product"
			method="post" style="margin: auto; max-width: 800px;">
			<div class="text-center">
				<h1 class="mt-5 mb-5">UPDATE PRODUCT DETAILS</h1>
			</div>
			<div class="form-group">
				<input type="hidden" id="productId" name="productId" value="${product.productId}">
			</div>

			<div class="form-group">
				<label for="productName">Name of the Product</label> <input
					type="text" class="form-control mb-4" id="productName"
					name="productName" value="${product.productName}"
					placeholder="Enter Product Name" required autofocus>
			</div>
			<div class="form-group">
				<label for="productDesc">Product Description</label>
				<textarea class="form-control mb-4" id="productDesc"
					name="productDesc" placeholder="Enter Product Description" rows="6">${product.productDesc} </textarea>
			</div>
			<div class="form-group">
				<label for="productPrice">Price of the Product</label> <input
					type="number" class="form-control mb-4" id="productPrice"
					name="productPrice" min="0" value="${product.productPrice}"
					step=".01" required autofocus>
			</div>
			<div class="container text-center">
				<a href="${pageContext.request.contextPath}/"
					class="btn btn-primary mr-4"> Back </a>

				<button type="submit" class="btn btn-warning">Update</button>
			</div>
		</form>
	</div>
</body>
</html>