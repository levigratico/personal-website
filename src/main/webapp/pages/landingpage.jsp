<%@page import="com.beverly.personal.model.OrdersModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%= request.getAttribute("base_url") %>/resources/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%= request.getAttribute("base_url") %>/resources/css/common.css">
<title>BEVERLY S. CAQUIOA</title>
</head>
<body>
<jsp:include page="/common/navigation.jsp"></jsp:include>
<% OrdersModel model = (OrdersModel) request.getAttribute("model"); %>
<div class="container">
		<div class="panel panel-default">
	      <div class="panel-heading" style="text-align: center"><h1>Your current order Mr/Ms. <%=model.getName() %></h1></div>
	      <div class="panel-body">
	      	<div class="row">
	      		<div class="col-lg-6 col-lg-offset-3">
	      			<table class="table table-striped">
			    <tbody>
			      <tr>
			        <td>Package Order</td>
			        <td><%=model.getTitle() %></td>
			      </tr>
			      <tr>
			        <td>Ammount</td>
			        <td><%=model.getPrice() %></td>
			      </tr>
			      <tr>
			        <td>Payment Mode</td>
			        <td>Paymaya</td>
			      </tr>
			      <tr>
			      	<td>Payment Date</td>
			        <td><%=model.getDate() %></td>
			      </tr>
			    </tbody>
			  </table>
	      		</div>
	      	</div>
	      	
	      </div>
    	</div>
</div>
<jsp:include page="/common/footer.jsp"></jsp:include>

<script type="text/javascript" src="<%= request.getAttribute("base_url") %>/resources/lib/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="<%= request.getAttribute("base_url") %>/resources/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>