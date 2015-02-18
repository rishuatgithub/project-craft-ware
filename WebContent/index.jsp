<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/font-awesome/css/font-awesome.min.css">

<script src="Scripts/jquery-1.11.2.min.js"></script>

<style>
.container p{ float:left; padding-right:4px; }
form{ width:50%; 
	margin-top: 50px;
    box-shadow: 0 0 30px green;
    padding:20px;
	z-index:99999;
	position:absolute;
}
.list-group { width:30%;}
.footer {
  position: relative;
  bottom: 0;
  width: 100%;
  /* Set the fixed height of the footer here */
  height: 60px;
  background-color: #f5f5f5;
 
}
.footer > .container {
  padding-right: 15px;
  padding-left: 15px;
  
}
.text-muted { padding-right:20px; }
.test{padding-top:10px; padding-left:10px; padding-right:4px;}

#productlist ul { 
	width:30%; 
	border:0px solid red; 
	display:inline-block; 
	padding-bottom:20px; 
	padding-top:10px; 
	text-align:center;
	list-style-type:none;
}

.prodName{
	font-weight:bold;
	border-bottom:1px solid #ECF0F1;
	color:#34495E;
	padding-bottom:10px;
}
#top { border:0px solid black; padding-top:17px;}
.padd {padding-top:5px;}

</style>

</head>
<body>
<div class="container-fluid"> <!-- start of navigation bar-->
	<nav class="navbar  navbar-default " id="titlenavbar">
		<div id="navbar" class="collapse navbar-collapse">
			<div class="row">
				<div class="col-xs-12 col-sm-6 col-md-8">
					<h3><font color="#34495E">Craft <font color="#D35400">W</font>are</font> <small> An Exclusive Warehouse </small></h3>
				</div>
				<div class="col-xs-6 col-md-4" id="top">
					
					<div class="btn-group" id="welcomeuserdetails"><!-- start of the welcome user message-->
                          <button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false">
                                Welcome <span class="welcome_user"></span><span class="caret"></span>
                          </button>
                          <ul class="dropdown-menu" role="menu" id="tab_access_display">                              
                          
                          </ul>                          
                    </div><!-- end of welcome user -->
					
					<button type="button" class="btn btn-success btn-sm" data-toggle="modal" data-target="#cartModal" id="cart">
						Cart <span class="badge">0</span>
					</button>
					
					<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#loginModal" >
						Login
					</button>
					
					<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#signupModal">
						Register
					</button>
					
				</div>
			</div>
		</div>
	</nav>
</div> <!-- end of top navigation bar-->

<div class="container">
	
	<!-- Start of the category navigation tab -->
	<nav class="navbar  navbar-default "> 
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav" id="selectCatg">
				
				<li><a href="#">Handicraft</a></li>
				<li><a href="#">Wearables</a></li>
				<li><a href="#">Made in India</a></li>
			</ul>
		</div>
	</nav> 
	<!--  end of the category navigation tab -->
		
	<!-- login page -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">Login</h4>
				</div>
				<div class="modal-body">
	
					<div class="form-group">
						<label for="username">User Name:</label>
						<input type="text" class="form-control" id="username" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<input type="password" class="form-control" id="password" placeholder="Enter password">
					</div>
					<div class="checkbox">
						<label><input type="checkbox"> Remember me</label>
					</div>
					<div class="alert" role="alert" id="loginalert">
					
					</div>
			
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" id="login">Submit</button>
				</div>
			</div>
		</div>
	</div><!-- end of login modal page div-->
	
	<!-- signup page -->
	<div class="modal fade" id="signupModal" tabindex="-1" role="dialog" aria-labelledby="signupModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">Register</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="username">User Name:</label>
						<input type="text" class="form-control" id="newUserName" placeholder="Enter unique user name">
					</div>
					<div class="form-group">
						<label for="email">Email address:</label>
						<input type="email" class="form-control" id="newEmailID" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label>
						<input type="password" class="form-control" id="newPassword" placeholder="Enter Password">
					</div>
					<div class="form-group">
						<label for="pwd">Re-Enter Password:</label>
						<input type="password" class="form-control" id="newPasswordRenter" placeholder="Re-Enter Password">
					</div>
					<div class="alert" role="alert" id="signupalert">
					
					</div>
					
				</div>
				<div class="modal-footer">
					
					<button type="submit" class="btn btn-primary" id="signup">Signup</button>
				</div>
			</div>
		</div>
	</div><!-- end of sign up modal page -->
	
	
	<!-- cart details -->
	<div class="modal fade" id="signupModal" tabindex="-1" role="dialog" aria-labelledby="signupModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">Cart details</h4>
				</div>
				<div class="modal-body">
					
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Signup</button>
				</div>
			</div>
		</div>
	</div><!-- end of cart details -->
	
	
	
	
	
	<!-- list product/items here -->
	<div class="container" id="productlist">
			
	</div>
	<!-- end of product listing -->
	<hr>
	
	<!-- recommendation section -->
	<div class="container">
		<p>Recommendation</p>		
	</div>
	<!-- end of recommendation-->
	
</div> <!-- end of master div -->

<footer class="footer">
    <div class="container">
       <p class="text-muted">About Us | </p>
	   <p class="text-muted">Contact Us | </p>
	   <p class="text-muted">24x7 Helpline | </p>
	   <p class="text-muted"><i class="fa fa-facebook"></i> 
							<i class="fa fa-google-plus"></i>  
							<i class="fa fa-pinterest"></i> 
							<i class="fa fa-tumblr"></i>
							<i class="fa fa-twitter"></i>   </p>
    </div>
</footer>
</body>

<!-- Scripting Portion -->
<script>

$(function(){

/*
 * login page 
 */
$('#login').click(function(){
	
	var userName=$('#username').val();
	var password=$('#password').val();
	var userLoginServURL="CWUserLoginServlet";
	var error=null;
	
	if(!userName || !password){
		error=comments(0);
	}
	
	if(error){
		
		erroralert("#loginalert", error,"error");
		return false;
	}
	
	
	/* Calling the servlet to get the Login User*/
	$.post(userLoginServURL,{username:userName, password:password},function(data){

		$.each(data, function(key, value){
		
			if(value.userLoginCount==0){ 
								
				erroralert("#loginalert", comments(6),"error");
				
			}
		
			$('.welcome_user').html(value.userName); 
			//$('#user_role').html(value.userRole); //not required. internally maintained
			
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
			
			$('#tab_access_display').append("<li role=\"presentation\"><a role=\"menuitem\" tabindex=\"-1\" href=\""+value.hyperlink+"\">"+value.tabenable+"</a></li>");
			
		});
		
	});
	
}


$("#selectCatg a").click(function(){
	
	$("#selectCatg li").removeClass("active");
	$(this).closest('li').addClass("active");
	productList($(this).html().toUpperCase());
	
});


/*
 * product listing code
 */
function productList(prodcategory){
	
	var prodlistServURL="CWProductListServlet";
	$("#productlist").empty();
	//$("#categoryselected").html("Category Selected :"+prodcategory); //not in the design yet
	
	$.getJSON(prodlistServURL,{productcategory:prodcategory},function(data){
		
		$.each(data, function(key, value){
			
			$("#productlist").append(
					"<ul>"+
					"<li class=\"prodName\">"+value.productname+"</li>"+
					"<li class=\"padd\"><img src=\""+value.productimglink+"\"/></li>"+
					"<li class=\"padd\">"+value.productprice+" "+value.productcurrtype+" </li>"+
					"<li class=\"padd\"><button class=\"btn btn-warning btn-xs\" type=\"button\" id=\"more\" onclick=\"moreprodetails('"+value.productid+"');\">More</button> "+ 
					" <button class=\"btn btn-warning btn-xs\" type=\"button\" id=\"bagit\">Bag It</button></li>"+
					"</ul>"
			);
			
		});
		
	});
}



/*
 * For sign up page
 */

 $("#signup").click(function(data){
		
		var newUserName=$("#newUserName").val();
		var newEmailID=$("#newEmailID").val();
		var newPassword=$("#newPassword").val();
		var newPasswordRenter=$("#newPasswordRenter").val();
		
		var error=null;
		
		var EMAIL_REGEXP = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,6}$/;
		
		if(!newUserName || !newEmailID || !newPassword || !newPasswordRenter){
			error=comments(0);
		}else if(newUserName != encodeURIComponent(newUserName)){
			error=comments(1);
		}else if(!newEmailID.match(EMAIL_REGEXP)) {
			  error =comments(2);
		} else if (newPassword !== newPasswordRenter) {
		  	error = comments(3);
		}
		
		
		if(error){
			
			erroralert("#signupalert", error,"error");
			return false;
		}
		
		
		var signupServ="CWUserSignUpServlet";
		
		$.post(signupServ,{nwusername:newUserName, nwemailid:newEmailID, nwpassword:newPassword},function(data){
			
			$.each(data, function(key, value){
				
				if(value.signupcount==0){
					//successfuly inserted					
					erroralert("#signupalert",comments(4),"success");
					
					setTimeout(function(){
						window.location="http://localhost:5070/project-craft-ware/";
					},5000);
					
				}else{
					//duplicate user name	
					erroralert("#signupalert",comments(5),"error");
				}
			});
			
		},'json');
});
 
 
 /*
  * utility functions
  */
 function toggleIt(id){
 	$(id).hide();
 }
 
 
 function erroralert(id,msg,type){
	 
	$(id).removeClass();
	$(id).show();
	
	if(type=="error"){
		$(id).html(msg).addClass("alert alert-danger");
	}else if(type=="success"){
		$(id).html(msg).addClass("alert alert-success");
	}else{
		$(id).html(msg).addClass("alert alert-warning");
	}
 	
 }
 
 function comments(id){
	 var comment=new Array();
	 
	 comment[0]="All Fields Are Required";
	 comment[1]="Username may not contain any non-url-safe characters. Prevent Usage of , / ? : @ & = + $ # in the Username.";
	 comment[2]="Email is invalid";
	 comment[3]="Passwords don\'t match";
	 comment[4]="Yayy !! Successfully Signed Up !! You will be redirected in 5 sec.";
	 comment[5]="Duplicate User Name. Try with some different Names.";
	 comment[6]="Wrong UserName or Password";
                 
	 return comment[id];
	
 }
 

/*
 * page initialization code
 */
function init(){
	productList('ALL');
	toggleIt("#loginalert, #signupalert");
	
}
$(window).load(init);

});

function moreprodetails(pid){
	window.location.href="productdetails.jsp?pid="+pid;
}



</script>
<script src="css/bootstrap/js/bootstrap.min.js"></script>

</html>