<%@page import="com.beverly.personal.model.PersonalSkills"%>
<%@page import="com.beverly.personal.model.TechnicalSkills"%>
<%@page import="com.beverly.personal.model.Primary"%>
<%@page import="com.beverly.personal.model.Secondary"%>
<%@page import="com.beverly.personal.model.Tertiary"%>
<%@page import="com.beverly.personal.model.Education"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.beverly.personal.model.ProfileModel" %>
<%@ page import="com.beverly.personal.model.Contact" %>
<%@ page import="com.beverly.personal.model.Education" %>
<%@ page import="com.beverly.personal.model.Primary" %>
<%@ page import="com.beverly.personal.model.Secondary" %>
<%@ page import="com.beverly.personal.model.Tertiary" %>
<%@ page import="com.beverly.personal.model.TechnicalSkills" %>
<%@ page import="com.beverly.personal.model.PersonalSkills" %>
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

.card {
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
    transition: 0.3s;
    border-radius: 5px;
    background-color: #ffcdd2;
    margin-right: 20px;
}

.card:hover {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
}

img {
    border-radius: 5px 5px 0 0;
}

.container {
    padding: 2px 16px;
}
</style>
</head>
<body>
	<% ProfileModel model = (ProfileModel)request.getAttribute("model"); %>
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
	<div style="margin-bottom: 10px;">
		<h1 style="text-align: center">ALL ABOUT ME</h1>
		<div class="row">
			<div class="col-lg-4 col-lg-offset-2 card" style="margin-bottom: 10px;">
			  <div class="container">
			    <h2><b>Education</b></h2> 
			    <% for(Iterator<Education> con = model.getEducation().iterator(); con.hasNext();) {  
			    	Education conTemp = con.next();
			    %>
			    	<div>
			    	<% if(conTemp instanceof Tertiary) { 
			    		Tertiary ter = (Tertiary) conTemp;
			    	%>
			    	<h3><b>Tertiary</b></h3>
			    	<p><b><%= ter.getDegree() %></b></p>
			    	
			    	<% } else if(conTemp instanceof Secondary) { %>
			    		<h3><b>Secondary</b></h3>
			    	<% } else if(conTemp instanceof Primary) { %>
			    		<h3><b>Primary</b></h3>
			    	<% } %>
			    	<p><%= conTemp.getContent() %></p>
			    	<p><%= conTemp.getAddress() %></p>
			    	</div>
			 		<% } %>
			  </div>
			</div>
			<div class="col-lg-4 card">
				<h2><b>Technical Skills</b></h2>
				<ul>
					<% for(Iterator<TechnicalSkills> con = model.getTskills().iterator(); con.hasNext();) { 
						TechnicalSkills techSkill = con.next();
					%>
						<li><%= techSkill.getContent() %></li>
					<% } %>
				</ul>
			<h2><b>Personal Skills</b></h2>
			<ul>
				<% for(Iterator<PersonalSkills> con = model.getSkills().iterator(); con.hasNext();) { 
					PersonalSkills perSkill = con.next();
				%>
					<li><%= perSkill.getContent() %></li>
				<% } %>
			</ul>
		   </div>
		   <div class="col-lg-4 col-lg-offset-2 card" style="padding: 10px;">
			    <h2><b>Contact</b></h2>
			    <table style="margin: 0 auto">
			    <% for(Iterator<Contact> con = model.getContacts().iterator(); con.hasNext();) { 
			    		Contact conTemp = con.next();
			    %>
			   		<tr><td><b><%= conTemp.getTitle() %>:</b></td><td style="text-indent: 5px;"><%= conTemp.getContent() %></td></tr>
			   <!--  <p>Interior Designer</p>  -->
			    <% } %>
			    </table>
			</div>
		</div>
		<div class="row">
			
		</div>
	</div>
	<jsp:include page="/common/footer.jsp"></jsp:include>
	<script type="text/javascript" src="<%= request.getAttribute("base_url") %>/resources/lib/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="<%= request.getAttribute("base_url") %>/resources/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>