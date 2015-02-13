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
#aulid{ border:1px solid #ecf0f1; margin-left:0px;  width:60%; float:left;}
#aulid li{text-align:center; padding-bottom:10px;  margin-left:-50px;}
#masterid{ border:0px solid green; width:30%; display:inline-block; padding:5px;}
#u { border:0px solid yellow; }
.categories li {display:inline-block;}

</style>

<script>

</script>
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
<div class="categories">
	<ul>
		<li><a href="#">HANDICRAFT</a></li>
		<li> | </li>
		<li><a href="#">WEARABLES</a></li>
	</ul>	
</div>

<hr>
Item Lists: <br>
<span id="categoryselected"></span> | 
Filters : 
<select id="filter">
	<option value="F1">Featured</option>
	<option value="F2">Price - High to Low</option>
	<option value="F3">Price - Low to High</option>
	<option value="F4">Popular</option>
	<option value="F5">New Stocks</option>
</select>

<div class="products"><ul id="u">  </ul></div>

<br>


<hr>
Recommendations:
<br>
<hr>
Site Footer



</body>


<!-- Scripting Portion -->
<script>

$(function(){


$('#login').click(function(){

	var userName=$('#username').val();
	var password=$('#password').val();
	var userLoginServURL="CWUserLoginServlet";
	var error=null;
	
	if(!userName || !password){
		error="All Fields are required";
	}
	
	if(error){
		alert(error);
		return false;
	}
		
	/* Calling the servlet to get the Login User*/
	$.post(userLoginServURL,{username:userName, password:password},function(data){
		
		$.each(data, function(key, value){
			if(value.userName==null){ 
				error="Invalid User";
			}
			
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
	$(".products #u").empty();
	$("#categoryselected").html("Category Selected :"+prodcategory);
	
	$.getJSON(prodlistServURL,{productcategory:prodcategory},function(data){
		
		$.each(data, function(key, value){
			
			$(".products #u").append(
					"<li id=\"masterid\">"+					
					"<ul id=\"aulid\">" + 
					"<li>"+value.productname+" </li>" + 
					"<li><img src=\""+value.productimglink+"\"/></li>" +	
					"<li>"+value.productprice+" "+value.productcurrtype+" </li>"+
					"<li><a href=\"#\" id=\"more\" onclick=\"moreprodetails('"+value.productid+"');\">MORE</a> | <a href=\"#\">BAG</a>"+
					//"<li><input type=\"hidden\" name=\"pid\" value=\""+value.productid+"\" id=\"pid\"></input>"+
					"</ul></li>"
			);
			
		});
		
	});
	
		
}
$(window).load(productList('ALL'));



});

function moreprodetails(pid){
	window.location.href="productdetails.jsp?pid="+pid;
}


</script>

</html>