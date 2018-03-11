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

/****for stepper*****/

.stepwizard-step p {
    margin-top: 10px;
}
.stepwizard-row {
    display: table-row;
}
.stepwizard {
    display: table;
    width: 50%;
    position: relative;
}
.stepwizard-step button[disabled] {
    opacity: 1 !important;
    filter: alpha(opacity=100) !important;
}
.stepwizard-row:before {
    top: 14px;
    bottom: 0;
    position: absolute;
    content: " ";
    width: 100%;
    height: 1px;
    background-color: #ccc;
    z-order: 0;
}
.stepwizard-step {
    display: table-cell;
    text-align: center;
    position: relative;
}
.btn-circle {
    width: 30px;
    height: 30px;
    text-align: center;
    padding: 6px 0;
    font-size: 12px;
    line-height: 1.428571429;
    border-radius: 15px;
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
          <h4 class="modal-title">Requesting for: <span id="labelPackage"></span></h4>
          <div class="stepwizard col-md-offset-3">
		    <div class="stepwizard-row setup-panel">
		      <div class="stepwizard-step">
		        <a href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>
		        <p>Step 1</p>
		      </div>
		      <div class="stepwizard-step">
		        <a href="#step-2" type="button" class="btn btn-default btn-circle" disabled="disabled">2</a>
		        <p>Step 2</p>
		      </div>
		      <div class="stepwizard-step">
		        <a href="#step-3" type="button" class="btn btn-default btn-circle" disabled="disabled">3</a>
		        <p>Step 3</p>
		      </div>
		    </div>
		  </div>
        </div>
        <form action="${base_url}/personal/photos" method="post">
        <input type="hidden" name="price" id="priceId" value="">
        <input type="hidden" name="package" id="package" value="">
        <input type="hidden" name="packageId" id="packageId" value="">
        <input type="hidden" name="desc" id="desc" value="">
        <div class="modal-body">
          	 <div class="row setup-content" id="step-1">
		      <div class="col-xs-12">
		        <div class="col-md-12">
		          <h3> Step 1</h3>
		          <div class="form-group">
		            <label class="control-label">First Name</label>
		            <input  maxlength="100" type="text" class="form-control" name="firstname" placeholder="Enter First Name"  />
		          </div>
		          <div class="form-group">
		            <label class="control-label">Last Name</label>
		            <input maxlength="100" type="text" class="form-control" name="lastname" placeholder="Enter Last Name" />
		          </div>
		          <div class="form-group">
		            <label class="control-label">Middle Name</label>
		            <input maxlength="100" type="text" class="form-control" name="middlename" placeholder="Enter Last Name" />
		          </div>
		          <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
		        </div>
		      </div>
		    </div>
          	 <div class="row setup-content" id="step-2">
		      <div class="col-xs-12">
		        <div class="col-md-12">
		          <h3> Step 2</h3>
		          <div class="form-group">
		            <label class="control-label">Address Line1</label>
		            <input name="address" maxlength="200" type="text" required="required" class="form-control" placeholder="Enter Address" />
		          </div>
		          <div class="form-group">
		            <label class="control-label">Street</label>
		            <input name="street" maxlength="200" type="text" required="required" class="form-control" placeholder="Enter Street" />
		          </div>
		          <div class="form-group">
		            <label class="control-label">City</label>
		            <input name="city" maxlength="200" type="text" required="required" class="form-control" placeholder="Enter City"  />
		          </div>
		          <div class="form-group">
		            <label class="control-label">State</label>
		            <input name="state" maxlength="200" type="text" required="required" class="form-control" placeholder="Enter State"  />
		          </div>
		          <div class="form-group">
		            <label class="control-label">Zip code</label>
		            <input name="zipcode" maxlength="4" type="number" required="required" class="form-control" placeholder="Enter State"  />
		          </div>
		          <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
		        </div>
		      </div>
		    </div>
			<div class="row setup-content" id="step-3">
		      <div class="col-xs-12">
		        <div class="col-md-12">
		          <h3> Step 3</h3>
		          <div class="form-group">
		            <label class="control-label">Email</label>
		            <input name="email" maxlength="100" type="text" required="required" class="form-control" placeholder="Enter Email" />
		          </div>
		          <div class="form-group">
		            <label class="control-label">Contact</label>
		            <input name="contact" maxlength="100" type="text" required="required" class="form-control" placeholder="Enter Contact" />
		          </div>
		        </div>
		      </div>
		    </div>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-primary">Submit</button>
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
				<h1 style="background-color: #303f9f; color: #fff; border-radius: 5px;" id="title-<%= temp.getId()%>"><%= temp.getTitle() %></h1>
				<p style="background-color: rgba(121,134,203,.2); color: #000; border-radius: 5px;" id="desc-<%= temp.getId()%>"><%= temp.getDescription() %></p>
				<p><b>Price: </b> <%= temp.getPrice() %></p>
				<div>
					<button class="btn btn-primary setup" data-price="<%= temp.getPrice() %>" data-id="<%= temp.getId()%>" data-toggle="modal" data-target="#myModal">Request</button>
					<a class="btn btn-primary" href="<% out.print(String.format("%s/pages/services/collections?id=%d", request.getAttribute("base_url"), temp.getId())); %>">View Collections</a>
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
	<script type="text/javascript">
		 $(document).ready(function () {
			  var navListItems = $('div.setup-panel div a'),
			          allWells = $('.setup-content'),
			          allNextBtn = $('.nextBtn');
	
			  allWells.hide();
	
			  navListItems.click(function (e) {
			      e.preventDefault();
			      var $target = $($(this).attr('href')),
			              $item = $(this);
	
			      if (!$item.hasClass('disabled')) {
			          navListItems.removeClass('btn-primary').addClass('btn-default');
			          $item.addClass('btn-primary');
			          allWells.hide();
			          $target.show();
			          $target.find('input:eq(0)').focus();
			      }
			  });
	
			  allNextBtn.click(function(){
			      var curStep = $(this).closest(".setup-content"),
			          curStepBtn = curStep.attr("id"),
			          nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
			          curInputs = curStep.find("input[type='text'],input[type='url']"),
			          isValid = true;
	
			      $(".form-group").removeClass("has-error");
			      for(var i=0; i<curInputs.length; i++){
			          if (!curInputs[i].validity.valid){
			              isValid = false;
			              $(curInputs[i]).closest(".form-group").addClass("has-error");
			          }
			      }
	
			      if (isValid)
			          nextStepWizard.removeAttr('disabled').trigger('click');
			  });
	
			  $('div.setup-panel div a.btn-primary').trigger('click');
			  $(document).on("click", ".setup", function() {
				  var title = $("#title-" + $(this).data("id")).text();
				  var desc = $("#desc-" + $(this).data("id")).text();
				  var id = $(this).data("id");
				  var price = $(this).data("price");
				  $("#package").val(title);
				  $("#priceId").val(price);
				  $("#labelPackage").text(title);
				  $("#packageId").val(id);
				  $("#desc").val(desc);
			  });
			  
			}); 
			
	</script>

</body>
</html>