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
<h1>Craft-ware | Product Details Page</h1>
<hr>
<br>
<h2>ITEM NAME:<span id="pname"></span></h2>
<br> 
Image:
<span id="pimg"></span>

<br>
<hr>
Product Rating: <span id="prating"></span>
<br>
Product Info: <span id="pinfo"></span>
<br>
Price: <span id="ppric"></span>
<br>
Seller Info: <span id="pseller"></span>
<br>
<a href="#">BUY</a>
<br>
<hr>
USER COMMENTS:

</body>
<script>

var productDetailsServURL="CWProductDetailsServlet";
var pid=location.href.split(/\?/)[1].split(/\=/)[1];

$.post(productDetailsServURL,{productid:pid},function(data){
	$.each(data, function(key, value){
		
		$("#pname").html(value.product_name);
		$("#pimg").html("<img src=\""+value.product_image+"\"/>");
		$("#prating").html(value.product_rating);
		$("#pinfo").html(value.product_descr);
		$("#ppric").html(value.product_price+" "+value.product_currtype);
		$("#pseller").html(value.product_sellername);
	});
},'json');

</script>

</html>