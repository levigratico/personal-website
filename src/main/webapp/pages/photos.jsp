<%@page import="com.beverly.personal.common.CommonListModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator" %>
<%@page import="com.beverly.personal.model.ServicesModel"%>
	
<!DOCTYPE html>
<html>
<head>
<title>BEVERLY S. CAQUIOA</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="<%=request.getAttribute("base_url")%>/resources/lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getAttribute("base_url")%>/resources/css/common.css">
<style>
.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	transition: 0.3s;
	border-radius: 5px;
	background-color: rgba(255,255,255,0.5);
	margin-right: 20px;
}

.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.margin-custom {
	margin: 10px;
}

</style>

</head>
<body>
	<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Request</h4>
        </div>
        <form>
        <div class="modal-body">
          
          	  <div class="input-group margin-custom">
			    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
			    <input id="text" type="text" class="form-control" name="name" placeholder="Name">
			  </div>
			  <div class="input-group margin-custom">
			    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
			    <input id="email" type="text" class="form-control" name="email" placeholder="Email">
			  </div>
			  <div class="input-group margin-custom">
			    <span class="input-group-addon"><i class="glyphicon glyphicon-list-alt"></i></span>
			    <input id="contact" type="text" class="form-control" name="contact" placeholder="#0906...">
			  </div>
			  <div class="input-group margin-custom">
			    <span class="input-group-addon">Other Request</span>
			    <input id="msg" type="text" class="form-control" name="msg" placeholder="Additional Request">
			  </div>
			
        </div>
        <div class="modal-footer">
          <input type="submit" class="btn btn-primary" value="submit">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
        </form>
      </div>
      
    </div>
  </div>
	<jsp:include page="/common/navigation.jsp"></jsp:include>
	<h1 style="text-align: center">
		<br>Services
	</h1>
	<div class="container" style="margin-bottom: 10px;">
		<% for(Iterator<ServicesModel> it = ((CommonListModel<ServicesModel>)request.getAttribute("model")).getListOfModel().iterator(); it.hasNext();) { 
			ServicesModel temp = it.next();
		%>
		<div class="row card" style="height: 300px; padding: 10px; margin: 10px;">
			<div class="col-lg-5 col-sm-5" style="height: 100%">
				<img class="img-responsive img-rounded" style="height: 100%;"
					src="<%= temp.getPicture() %>"
					alt="Chania">
			</div>
			<div class="col-lg-7 col-sm-7" style="text-align: center; height: 100%">
				<h1 style="background-color: #303f9f; color: #fff; border-radius: 5px;"><%= temp.getTitle() %></h1>
				<p style="background-color: rgba(121,134,203,.2); color: #000; border-radius: 5px;"><%= temp.getDescription() %></p>
				<div>
					<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">Request</button>
				</div>
			</div>
		</div>
		<% } %>
	</div>
	<jsp:include page="/common/footer.jsp"></jsp:include>
	<script type="text/javascript"
		src="<%=request.getAttribute("base_url")%>/resources/lib/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getAttribute("base_url")%>/resources/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</body>
</html>