<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.beverly.personal.common.CommonListModel" %>
<%@page import="com.beverly.personal.model.ServicesCollection" %>
<%@page import="java.util.Iterator" %>
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

.for-hover:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
	background-color: #ccc;
    border-radius: 10px;
    cursor: pointer;
}

.box__uploading,
.box__success,
.box__error {
  display: none;
}

.box {
    font-size: 1.25rem;
    background-color: #c8dadf;
    position: relative;
    padding: 100px 20px;
}

.box.has-advanced-upload {
    outline: 2px dashed #92b0b3;
    outline-offset: -10px;
    -webkit-transition: outline-offset .15s ease-in-out, background-color .15s linear;
    transition: outline-offset .15s ease-in-out, background-color .15s linear;
}

.box.has-advanced-upload .box__icon {
    width: 100%;
    height: 80px;
    fill: #92b0b3;
    display: block;
    margin-bottom: 40px;
}

  .box__file {
    width: 0.1px;
    height: 0.1px;
    opacity: 0;
    overflow: hidden;
    position: absolute;
    z-index: -1;
}

input, textarea, select {
    border-radius: 0;
    border: none;
}
input {
    line-height: normal;
}
button, input, optgroup, select, textarea {
    color: inherit;
    font: inherit;
    margin: 0;
}

.box__file + label {
    max-width: 80%;
    text-overflow: ellipsis;
    white-space: nowrap;
    cursor: pointer;
    display: inline-block;
    overflow: hidden;
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
          <h4 class="modal-title">Upload</h4>
        </div>
        <form action="http://l3dedvvy-site.btempurl.com/uploading/uploading.php" method="post" enctype="multipart/form-data">
        <div class="modal-body">
           <div class="box has-advanced-upload" style="text-align: center;">
			<div class="box__input">
				<svg class="box__icon" xmlns="http://www.w3.org/2000/svg" width="50" height="43" viewBox="0 0 50 43"><path d="M48.4 26.5c-.9 0-1.7.7-1.7 1.7v11.6h-43.3v-11.6c0-.9-.7-1.7-1.7-1.7s-1.7.7-1.7 1.7v13.2c0 .9.7 1.7 1.7 1.7h46.7c.9 0 1.7-.7 1.7-1.7v-13.2c0-1-.7-1.7-1.7-1.7zm-24.5 6.1c.3.3.8.5 1.2.5.4 0 .9-.2 1.2-.5l10-11.6c.7-.7.7-1.7 0-2.4s-1.7-.7-2.4 0l-7.1 8.3v-25.3c0-.9-.7-1.7-1.7-1.7s-1.7.7-1.7 1.7v25.3l-7.1-8.3c-.7-.7-1.7-.7-2.4 0s-.7 1.7 0 2.4l10 11.6z"></path></svg>
				<input type="file" name="fileToUpload" id="file" class="box__file" data-multiple-caption="{count} files selected" multiple="">
				<label for="file" id="label" style="font-size: 20px;"><strong style="color: #4fc3f7">Choose a file</strong><span class="box__dragndrop"> or drag it here</span>.</label>
			</div>
			<div class="box__uploading">Uploading…</div>
			<div class="box__success">Done! <a href="https://css-tricks.com/examples/DragAndDropFileUploading//?submit-on-demand" class="box__restart" role="button">Upload more?</a></div>
			<div class="box__error">Error! <span></span>. <a href="https://css-tricks.com/examples/DragAndDropFileUploading//?submit-on-demand" class="box__restart" role="button">Try again!</a></div>
			<input type="hidden" name="serviceid" value="<%= request.getParameter("id") %>">
			</div>
			<div class="form-group" style="text-align: center; margin-top: 10px;">
		            <label class="control-label">Caption</label>
		            <input name="caption" maxlength="200" type="text" required="required" class="form-control" placeholder="Enter Caption" />
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
	<% CommonListModel<ServicesCollection> data = (CommonListModel<ServicesCollection>) request.getAttribute("model"); %>
	<jsp:include page="/common/navigation.jsp"></jsp:include>
	<h1 style="text-align: center">
		<%=data.getListOfModel().get(0).getServiceTitle() %>
	</h1>
	<div style="width: 50%; text-align: center; margin: 0 auto;">
		<%=data.getListOfModel().get(0).getServiceDescription() %>
	</div>	
	 <div class="row card" style="padding: 10px; margin: 20px;">
	 	<% for(Iterator<ServicesCollection> it = data.getListOfModel().iterator(); it.hasNext();) { 
	 		ServicesCollection tempData = it.next();
	 	%>
	 	<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12 for-hover" style="height: 250px; padding: 20px;">
		  <div style="height: 100%">
		      <img src="<%= tempData.getPicture() %>" class="img-responsive img-rounded" alt="Northern Lights" style="height: 90%; margin: 0 auto">
		    <div class="desc" style="height: auto; text-align: center"><%= tempData.getCaption() %></div>
		  </div>
		</div>
		<% } %>
		<% if((boolean) session.getAttribute("isLogin")) {%>
		<div class="col-lg-3 col-md-4 col-sm-4 col-xs-12" style="height: 250px; padding: 30px;" data-toggle="modal" data-target="#myModal">
		  <div style="height: 100%" class="for-hover">
		     <div style="font-size: 100px; text-align: center; margin-bottom: 20px; padding-top: 20px;"><i class="glyphicon glyphicon-plus"></i></div>
		    <div class="desc" style="height: auto; text-align: center; font-size: 20px;">Add Collections</div>
		  </div>
		</div>
		<%}%>
	 </div>
	<jsp:include page="/common/footer.jsp"></jsp:include>
	<script type="text/javascript"
		src="<%= request.getAttribute("base_url") %>/resources/lib/jquery-3.3.1.min.js"></script>
	<script type="text/javascript"
		src="<%= request.getAttribute("base_url") %>/resources/lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	$(function(){
		
		var form = $("form");
		var $input = $('#file');
		var $label = $('#label');
		
		form.on("dragover", function(event) {
		    event.preventDefault();  
		    event.stopPropagation();
		    $(this).addClass('dragging');
		});

		form.on("dragleave", function(event) {
		    event.preventDefault();  
		    event.stopPropagation();
		    $(this).removeClass('dragging');
		});

		form.on("drop", function(event) {
		    event.preventDefault();  
		    event.stopPropagation();
		    var data = event.originalEvent.dataTransfer.files;
		    document.getElementById("file").files = data;
	        
		});
		
		var showFile = function( files )
		{	
			$label.text(files[ 0 ].name);
		};
		
		 $input.on('change', function(event) {
			 var droppedFiles = event.target.files;
			 showFile(droppedFiles);
		 });
		
	});
	
	
	</script>

</body>
</html>