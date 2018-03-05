<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%= request.getAttribute("base_url") %>/resources/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%= request.getAttribute("base_url") %>/resources/css/common.css">
<title>BEVERLY S. CAQUIOA</title>
<style>

.jumbotron {
	width: 100%;
	background-image:
		url(<%= request.getAttribute("base_url") %>/resources/images/27868134_1686867098072340_9071852376356288100_n.jpg);
	background-size: 50%;
	color: white;
	line-height: 0.5;
	position: relative;
	height: 360px;
	border-radius: 0px;
	border-bottom: 3px solid darkred;
}

.name {
	color: white;
}
</style>
</head>
<body>
	<jsp:include page="/common/navigation.jsp"></jsp:include>
	<div class="jumbotron">
		<div class="container-fluid">
			<div>
				<div class="keme center" style="width: 160px; height: 160px;">
					<a
						href="<%= request.getAttribute("base_url") %>/resources/images/13690696_1759289637624719_800410160839470645_n.jpg"
						target="_blank"> <img
						src="<%= request.getAttribute("base_url") %>/resources/images/13690696_1759289637624719_800410160839470645_n.jpg"
						alt="home"
						style="width: 160px; height: 160px; position: relative; border-radius: 100px; border: 7px solid white;"></a>
				</div>
				<div class="name" style="text-align: center">
					<br> <br> <br> <b>BEVERLY S. CAQUIOA<br> <br>(Shawie)
					</b>
				</div>
			</div>
		</div>
	</div>
	<div>
		<h1 style="text-align: center">ALL ABOUT ME</h1>
		<div class="container">
			<h2 style="text-align: center">Basic Table</h2>
			<p style="text-align: center">The .table class adds basic styling
				(light padding and only horizontal dividers) to a table:</p>
			<table class="table">
				<thead>
					<tr>
						<th>Firstname</th>
						<th>Lastname</th>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td>John</td>
						<td>Doe</td>

					</tr>
					<tr>
						<td>Mary</td>
						<td>Moe</td>

					</tr>
					<tr>
						<td>July</td>
						<td>Dooley</td>

					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/common/footer.jsp"></jsp:include>
	<script type="text/javascript" src="<%= request.getAttribute("base_url") %>/resources/lib/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="<%= request.getAttribute("base_url") %>/resources/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>