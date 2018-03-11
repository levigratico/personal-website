<%@page import="com.beverly.personal.model.OrdersModel"%>
<%@page import="com.beverly.personal.common.CommonListModel"%>
<%@page import="java.util.Iterator" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<%=request.getAttribute("base_url")%>/resources/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getAttribute("base_url")%>/resources/css/common.css">
	<link rel="stylesheet" href="http://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<title></title>
</head>
<body>
	<jsp:include page="/common/navigation.jsp"></jsp:include>
	<div class="container" style="margin: 0 auto; margin-bottom: 20px;">
		<h1 style="text-align: center">
			<br>Orders
		</h1>
		<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
	        <thead>
	            <tr>
	                <th>Name</th>
	                <th>Address</th>
	                <th>Email</th>
	                <th>Contact</th>
	                <th>Package</th>
	                <th>Status</th>
	                <th>Date</th>
	            </tr>
	        </thead>
	        <tbody>
	        <% for(Iterator<OrdersModel> datum = ((CommonListModel<OrdersModel>) request.getAttribute("model")).getListOfModel().iterator(); datum.hasNext();) { 
	        	OrdersModel model = datum.next();
	        %>
	            <tr>
	                <td><%=model.getName() %></td>
	                <td><%=model.getAddress() %></td>
	                <td><%=model.getEmail() %></td>
	                <td><%=model.getContact() %></td>
	                <td><%=model.getTitle() %></td>
	                <td><%=model.getStatus() %></td>
	                <td><%=model.getDate() %></td>
	            </tr>
	            <% } %>
	        </tbody>
	    </table>
	</div>
	<jsp:include page="/common/footer.jsp"></jsp:include>
	<script type="text/javascript"
		src="${base_url}/resources/lib/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="${base_url}/resources/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#example').DataTable();
		});
	</script>
</body>
</html>