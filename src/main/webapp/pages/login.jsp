<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%= request.getAttribute("base_url") %>/resources/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%= request.getAttribute("base_url") %>/resources/css/common.css">
<title>BEVERLY S. CAQUIOA</title>
<style type="text/css">


.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body>
	<jsp:include page="/common/navigation.jsp"></jsp:include>
	<div class="container" style="margin-bottom: 100px;">
		<form class="form-signin" action="<%= request.getAttribute("base_url") %>/login" method="POST">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputUsername" class="sr-only">Username</label> <input
				type="text" id="inputUsername" name="inputUsername" class="form-control"
				placeholder="Username" required="" autofocus=""> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="inputPassword" name="inputPassword" class="form-control"
				placeholder="Password" required="">
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>
	</div>
	<jsp:include page="/common/footer.jsp"></jsp:include>
	<script type="text/javascript"
		src="<%= request.getAttribute("base_url") %>/resources/lib/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="<%= request.getAttribute("base_url") %>/resources/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>