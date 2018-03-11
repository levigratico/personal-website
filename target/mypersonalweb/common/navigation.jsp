<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<nav class="navbar navbar-inverse"
	style="background-color: darkred; border-radius: 0px; border-color: #ddd; margin-bottom: 0px;">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand"
				href="<%=request.getAttribute("base_url")%>/index">My Personal
				Website</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li
					class="<%=((int) request.getAttribute("active")) == 0 ? "active-custom" : ""%>">
					<a href="<%=request.getAttribute("base_url")%>/index"
					class="active">HOME</a>
				</li>
				<li
					class="<%=((int) request.getAttribute("active")) == 1 ? "active-custom" : ""%>">
					<a href="<%=request.getAttribute("base_url")%>/personal/profile">PROFILE</a>
				</li>
				<li
					class="<%=((int) request.getAttribute("active")) == 3 ? "active-custom" : ""%>">
					<a href="<%=request.getAttribute("base_url")%>/personal/photos">SERVICES</a>
				</li>
				<% if((boolean) session.getAttribute("isLogin")) {%>
				<li
					class="<%=((int) request.getAttribute("active")) == 2 ? "active-custom" : ""%>">
					<a href="<%=request.getAttribute("base_url")%>/personal/orders">ORDERS</a>
				</li>
				<%}%>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li
					class="<%=((int) request.getAttribute("active")) == 5 ? "active-custom" : ""%>">
					<a href="<%=request.getAttribute("base_url")%>/login"><span class="glyphicon glyphicon-log-<%= ((boolean) session.getAttribute("isLogin")) ? "out" : "in" %>"></span>
						<%= ((boolean) session.getAttribute("isLogin")) ? "Logout" : "Login" %></a>
				</li>
			</ul>
		</div>
	</div>
</nav>