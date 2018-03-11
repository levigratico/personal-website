<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Redirecting</title>
</head>
<body >
	<%
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String middlename = request.getParameter("middlename");
		String address = request.getParameter("address");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String packagename = request.getParameter("package");
		Double price = Double.parseDouble(request.getParameter("price"));
		String desc = request.getParameter("desc");
		String code = String.format("package-2018-%s", request.getParameter("packageId"));
		int orderid = (int)request.getAttribute("orderid");
	%>
	<form id="formCheat" action="http://l3dedvvy-site.btempurl.com/class/index.php" method="post" name="cheatForm">    
      <input type="hidden" name="firstname" value="<%=firstname%>"/>    
      <input type="hidden" name="lastname" value="<%=lastname%>"/>  
      <input type="hidden" name="middlename" value="<%=middlename%>"/>    
      <input type="hidden" name="address" value="<%=address%>"/>  
      <input type="hidden" name="street" value="<%=street%>"/>    
      <input type="hidden" name="city" value="<%=city%>"/>  
      <input type="hidden" name="state" value="<%=state%>"/>    
      <input type="hidden" name="zipcode" value="<%=zipcode%>"/>
      <input type="hidden" name="email" value="<%=email%>"/>
      <input type="hidden" name="contact" value="<%=contact%>"/>   
      <input type="hidden" name="packagename" value="<%=packagename%>"/>   
      <input type="hidden" name="price" value="<%=price%>"/>  
      <input type="hidden" name="code" value="<%=code%>"/> 
      <input type="hidden" name="desc" value="<%=desc%>"/> 
      <input type="hidden" name="orderid" value="<%=orderid%>"/> 
    </form>
    <script type="text/javascript"
		src="<%=request.getAttribute("base_url")%>/resources/lib/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
	   $(function(){
		  $("#formCheat").submit();
	   });
    </script>
    
</body>
</html>