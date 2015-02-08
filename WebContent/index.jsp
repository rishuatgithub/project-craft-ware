<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Craft-Ware | A exclusive warehouse of Handicrafts</title>
<script src="Scripts/jquery-1.11.2.min.js"></script>

</head>
<body>
<h1>Welcome to Craft-Ware | A exclusive warehouse of Handicrafts</h1>
<hr>
<br/>

User Login:<br/>
User Name: <input type="text" name="name" id="username"/>
Password : <input type="password" name="password" id="password"/>
<input type="button" name="login" value="Login" id="login"/>
<a href="signup.jsp">sign up</a> <a href="#">Logout</a>

<hr>
Welcome: <span id="welcome_user"></span> <br/>
User Role:<span id="user_role"></span>
<hr>
Tab Access Display Section
<div class="tab_access_display"></div>
<hr>
Item Display Section






</body>


<!-- Scripting Portion -->
<script>


$('#login').click(function(){

	var userName=$('#username').val();
	var password=$('#password').val();
	var userLoginServURL="CWUserLoginServlet";
	
	/* Calling the servlet to get the Login User*/
	$.post(userLoginServURL,{username:userName, password:password},function(data){
		
		$.each(data, function(key, value){
			
			$('#welcome_user').html(value.userName);
			$('#user_role').html(value.userRole);
			
			if(value.userRole!=null){
				displayRoleList(value.userRole);
			}
		});
		
	},'json');
	
});

function displayRoleList(role){
	
	var userRoleServURL="CWUserRoleServlet";
	$('.tab_access_display').empty();
	
	$.get(userRoleServURL,{userRole:role},function(data){
		$.each(data, function(key, value){
			
			$('.tab_access_display').append("<span id=\""+value.spanid+"\"><a href=\""+value.hyperlink+"\">"+value.tabenable+"</a></span><br/>");
		});
		
	});
	
}


</script>

</html>