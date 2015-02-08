<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Craft-Ware | A exclusive warehouse of Handicrafts</title>
<script src="Scripts/jquery-1.11.2.min.js"></script>

<style>
img { background-size:10px 10px;}
li,ul {list-style: none; }
#pchildul {border:0px solid red; width:100px; height:0px; margin:0px; padding-top:5px; position: relative;}
#pparentul li{padding-top:3px;}
</style>
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
Categories
<div class="categories"><ul><li><a href="#">HANDICRAFT</a></li><li><a href="#">WEARABLES</a></li></ul></div>
<br>
<hr>
Item Lists:
<div class="products"></div>

<br>



</body>


<!-- Scripting Portion -->
<script>

$(function(){
	

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


$(".categories ul li a").click(function(){
	productList($(this).html());
	
});

function productList(prodcategory){
	
	var prodlistServURL="CWProductListServlet";
	$(".products").empty();
	
	$(".products").append("<ul id='pparentul'>");
	$.getJSON(prodlistServURL,{productcategory:prodcategory},function(data){
		
		$.each(data, function(key, value){
			
			$(".products").append("<li><ul id='pchildul'>")
			.append("<li>"+value.productname+" </li>")
			.append("<li><img src='"+value.productimglink+"'/></li>")
			.append("<li>"+value.productprice+" "+value.productcurrtype+" </li>")
			.append("<li><a href='#' id='buy'>BUY</a></li>")
			.append("</ul></li>");
		});
		
	});
	$(".products").append("</ul>");
}
$( window ).load(productList('ALL'));

});




</script>

</html>