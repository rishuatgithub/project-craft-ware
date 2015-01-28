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
<hr>
Welcome: <span id="welcome_user"></span>








</body>


<!-- Scripting Portion -->
<script>


$('#login').click(function(){
	
	var userName=$('#username').val();
	var password=$('#password').val();
	
	var loginParam="username="+userName+"&password="+password;
	
	var servURL="CWUserLogin?"+loginParam;
	
	$.get(servURL,function(data){
		//alert("a");
		//$('#welcome_user').html(data);
	});
	
	
	//$('#welcome_user').html(loginParam);
});

</script>

</html>