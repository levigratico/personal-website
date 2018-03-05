<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>BEVERLY S. CAQUIOA</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%= request.getAttribute("base_url") %>/resources/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%= request.getAttribute("base_url") %>/resources/css/common.css">
<style>
	.text-align-custom {
		text-align: center;
	}
</style>
</head>
<body>
	<jsp:include page="/common/navigation.jsp"></jsp:include>
	<div class="text-align-custom">
      <a href="music.html">
      <img src="<%= request.getAttribute("base_url") %>/resources/images/music5.jpg" alt="home" style="width:99%;height:300px; position: relative; border: 7px solid white; float: left;"></a>
      MUSIC
  	</div>
	<div class="text-align-custom">
		<a href="food.html"><img src="<%= request.getAttribute("base_url") %>/resources/images/food3.jpg" alt="home"
			style="width: 99%; height: 300px; position: relative; border: 7px solid white; float: left;"></a>FOOD<br>
		<br>
		<br>
		<br>
	</div>
	<div class="text-align-custom">
      <a href="<%= request.getAttribute("base_url") %>/resources/images/download.jpg" target="_blank">
      <img src="<%= request.getAttribute("base_url") %>/resources/images/movies.jpg" alt="home" style="width:99%;height:300px; position: relative; border: 7px solid white; float: left;"></a><a href="#about"></a>
  	  MOVIES
  	</div>
  	<jsp:include page="/common/footer.jsp"></jsp:include>
  	<script type="text/javascript" src="<%= request.getAttribute("base_url") %>/resources/lib/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="<%= request.getAttribute("base_url") %>/resources/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>