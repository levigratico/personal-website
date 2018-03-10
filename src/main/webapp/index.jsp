<%@page import="com.beverly.personal.model.IntroductionModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.beverly.personal.model.Paragraph" %>
<%@ page import="com.beverly.personal.model.IntroductionModel" %>

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
					<b id="intro-${model.title.id}"> ${model.title.content} </b>
					 <% if((boolean) session.getAttribute("isLogin")) { %>
					<i class="btn btn-default glyphicon glyphicon-pencil edit" data-id="${model.title.id}" style="font-size:20px;"></i>
					<% } %>
				</h1>
				<div class="paragraph-custom">
						
					<% for(Iterator<Paragraph> paragraph = ((IntroductionModel)request.getAttribute("model")).getParagraph().iterator(); paragraph.hasNext();) { 
						Paragraph par = paragraph.next();
					%>
						<div class="row">
							<div class="col-lg-11" id="intro-<%= par.getId() %>"><%= par.getContent() %></div>
							<div class="col-lg-1">
							   <% if((boolean) session.getAttribute("isLogin")) { %>
								<i class="btn btn-default glyphicon glyphicon-pencil edit" data-id="<%= par.getId() %>" style="font-size:20px; text-indent: 0px;"></i>
								<% } %>
							</div>
						</div>
						<br>
					<% } %>
					<h3 style="display: inline-block">
						<b>I can be a</b>
					</h3>
					<span id="intro-${model.skills.id}">${model.skills.content}</span>
					 <% if((boolean) session.getAttribute("isLogin")) { %>
					<i class="btn btn-default glyphicon glyphicon-pencil edit" data-id="${model.skills.id}" style="font-size:20px; text-indent: 0px;"></i>
					<% } %>
				</div>
			</div>
		</div>
	    <jsp:include page="/common/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="<%= request.getAttribute("base_url") %>/resources/lib/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="<%= request.getAttribute("base_url") %>/resources/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(document).on("click", ".edit", function(){
			 var id = $(this).data("id");
			 	var element = $("#intro-" + id);
			 	var text = element.text();
			 	element.html('<textarea style="text-align: center" rows="4" cols="40">'+ text +'</textarea>');
			 	$(this).addClass("glyphicon-save");
			 	$(this).addClass("save");
			 	$(this).removeClass("glyphicon-pencil");
			 	$(this).removeClass("edit");
			});
			
			$(document).on("click", ".save", function(){
				var id = $(this).data("id");
				var element = $("#intro-" + id + " textarea");
			 	var text = element.text();
			 	$("#intro-" + id).html(text);
			 	$(this).addClass("glyphicon-pencil");
			 	$(this).addClass("edit");
			 	$(this).removeClass("glyphicon-save");
			 	$(this).removeClass("save");
			});
			
		});
	</script>
</body>
</html>