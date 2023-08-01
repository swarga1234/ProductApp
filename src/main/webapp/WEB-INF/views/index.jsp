<html>
<head>
<%@include file="./base.jsp"%>
</head>
<body>
	<div class="container text-center mt-5 mb-5">
		<h2>AVAILABLE PRODUCTS</h2>
		<table class="table mt-5 mb-5">
			<thead class="thead-dark">
				<tr>
					<th scope="col">ProductID</th>
					<th scope="col">Name</th>
					<th scope="col">Description</th>
					<th scope="col">Price</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>

						<th scope="row">${product.productId}</th>
						<td>${product.productName}</td>
						<td>${product.productDesc}</td>
						<td class="font-weight-bold">&#8377;${product.productPrice}</td>
						<td><a href="delete-product/${product.productId}"> <i
								class="fas fa-trash fa-beat" style="color: #f0210a; font-size: 20px"></i>
						</a> <a href="update-product/${product.productId}"> <i
								class="fas fa-pen-nib fa-beat" style="color: #f0210a; font-size: 20px"></i>
						</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-product-form" class="btn btn-success"> Add Product </a>
	</div>
</body>
</html>
