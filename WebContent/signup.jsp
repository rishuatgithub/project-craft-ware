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
<h1>New User | Sign Up Page</h1>
<br>
User Name: <input type="text" name="newUserName" id="newUserName"/>
<br>
Email ID: <input type="text" name="newEmailID" id="newEmailID"/>
<br>
Password: <input type="password" name="newPassword" id="newPassword"/>
<br>
Repeat Password: <input type="password" name="newPasswordRenter" id="newPasswordRenter"/>
<br>
<span id="validation-msg"></span>
<br>
<input type="button" value="Sign Up" name="signup" id="signup"/>
<br>
<span id="signup-msg"></span>
</body>
<script>
$("#signup").click(function(data){
	
	var newUserName=$("#newUserName").val();
	var newEmailID=$("#newEmailID").val();
	var newPassword=$("#newPassword").val();
	var newPasswordRenter=$("#newPasswordRenter").val();
	
	var error=null;
	
	var EMAIL_REGEXP = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,6}$/;

	if(!newUserName || !newEmailID || !newPassword || !newPasswordRenter){
		error="All Fields Are Required";
	}else if(newUserName != encodeURIComponent(newUserName)){
		error="Username may not contain any non-url-safe characters. Prevent Usage of , / ? : @ & = + $ # in the Username";
	}else if(!newEmailID.match(EMAIL_REGEXP)) {
		  error = 'Email is invalid';
	} else if (newPassword !== newPasswordRenter) {
	  error = 'Passwords don\'t match';
	}
	
	
	if(error){
		$("#validation-msg").html(error).css("color","red");
		//$("#newUserName").focus();
		return false;
	}
	
	
	var signupServ="CWUserSignUpServlet";
	
	$.post(signupServ,{nwusername:newUserName, nwemailid:newEmailID, nwpassword:newPassword},function(data){
		
		$.each(data, function(key, value){
			
			if(value.signupcount==0){
				//successfuly inserted
				$("#validation-msg").html('');
				$("#signup-msg").html("Yayy !! Successfully Signed Up !!").css("color","green");
				
				setTimeout(function(){
					window.location="http://localhost:5070/project-craft-ware/";
				},5000);
				
			}else{
				//duplicate user name				
				$("#validation-msg").html("Duplicate User Name. Try with some different Names.").css("color","red");
			}
		});
		
	},'json');
	
	
	
});


</script>
</html>