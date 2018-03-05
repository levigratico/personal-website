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
.paragraph-custom {
	text-indent: 30px;
	font-size: 20px;
}
</style>
</head>
<body>
	<div>
		<jsp:include page="/common/navigation.jsp"></jsp:include>
		<div class="row" style="margin-right: 0;">
			<div class="col-lg-2 col-lg-offset-1">
				<div class="thumbnail">
					<a
						href="<%= request.getAttribute("base_url") %>/resources/images/27545675_1686871788071871_2817577781743023991_n.jpg"
						target="_blank"> <img
						src="<%= request.getAttribute("base_url") %>/resources/images/27545675_1686871788071871_2817577781743023991_n.jpg"
						alt="Nature" style="height: 400px; border: solid gray;">
					</a>
				</div>
			</div>
			<div class="col-lg-7">
				<h1 style="text-align: center">
					<b>DATABASE &amp; WEB DESIGNER</b>
				</h1>
				<div class="paragraph-custom">
					<p>Hello there! I am Beverly and I am a database designer at
						the same time a web designer. I believe that as a detabase and web
						designer, I act as an analyst that every data should be proper and
						fitted to the module. It is important to know the process of your
						project and the design should be fit to the type of your project.</p>
					<p>I think it is very important to make a website compatible
						with all modern devices, like phones and tabltes</p>

					<p>Feel free to check out my work or view my resume. I am
						currently available for hire, so if it saound fit for your next
						project, dont hesitate to contact me! Im a social person. Or at
						least that's what I keep telling myself. Either way, you can find
						me to my accounts below.</p>

					<h3 style="display: inline-block">
						<b>I can be a</b>
					</h3>
					<span>web designer, database designer and technical support</span>
				</div>
			</div>
		</div>
	    <jsp:include page="/common/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="<%= request.getAttribute("base_url") %>/resources/lib/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="<%= request.getAttribute("base_url") %>/resources/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>