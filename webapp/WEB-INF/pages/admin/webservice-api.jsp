<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<% String access_token = ""; %>

<title>WEB SERVICE API</title>

<style>
::selection {
	background-color: #E13300;
	color: white;
}

::-moz-selection {
	background-color: #E13300;
	color: white;
}

body {
	background-color: #FFF;
	margin: 40px;
	font: 16px/20px normal Helvetica, Arial, sans-serif;
	color: #4F5155;
	word-wrap: break-word;
}

a {
	color: #039;
	background-color: transparent;
	font-weight: normal;
}

h1 {
	color: #444;
	background-color: transparent;
	border-bottom: 1px solid #D0D0D0;
	font-size: 24px;
	font-weight: normal;
	margin: 0 0 14px 0;
	padding: 14px 15px 10px 15px;
}

code {
	font-family: Consolas, Monaco, Courier New, Courier, monospace;
	font-size: 16px;
	background-color: #f9f9f9;
	border: 1px solid #D0D0D0;
	color: #002166;
	display: block;
	margin: 14px 0 14px 0;
	padding: 12px 10px 12px 10px;
}

#body {
	margin: 0 15px 0 15px;
}

p.footer {
	text-align: right;
	font-size: 16px;
	border-top: 1px solid #D0D0D0;
	line-height: 32px;
	padding: 0 10px 0 10px;
	margin: 20px 0 0 0;
}

#container {
	margin: 10px;
	border: 1px solid #D0D0D0;
	box-shadow: 0 0 8px #D0D0D0;
}

form {
	padding: 5px;
}

table {
	width: 98%;
}

textarea {
	width: 98%;
	height: 200px;
	font-size: 16px;
}

iframe {
	width: 98%;
	height: 200px;
	font-size: 16px;
}

iframe html body {
	font-size: 16px;
}
</style>


</head>
<body>



	<center>
		<h1>
			<strong>WEB SERVICE API</strong>
		</h1>
	</center>


	



	<div>
		<strong>(#1. LIST BOOK ==> URL :
			${pageContext.request.contextPath}/api/book/list, METHOD : "GET") </strong> <br />
		<form
			action="${pageContext.request.contextPath}/api/book/list" method="GET"
			class="form">

			<table>
				<tr>
					<td>JSON_REQ</td>
					<td><textarea name="JSONData" class="JSONData">
{}
                    </textarea></td>
				</tr>
				<tr>
					<td><input type="submit" /></td>
				</tr>
				<tr>
					<td>JSON_RES</td>
					<td>
						<!--<iframe name="http://api.senate.gov.kh/index.php/api/users" style="font-size:16px;"></iframe>-->

						<textarea name="JSONResp" class="JSONResp">
                        
                        
                    </textarea>

					</td>
				</tr>
			</table>
		</form>
	</div>
	<hr />



	<div>
		<strong>(#1. ADD BOOK ==> URL :
			${pageContext.request.contextPath}/api/book/add, METHOD : "POST") </strong> <br />
		<form action="${pageContext.request.contextPath}/api/book/add"
			method="POST" 
			class="form">
			<table>
				<tr>
					<td>JSON_REQ</td>
					<td>
						<!--"API_KEY":"2a1814171e4c995cbc1a7950a67d3db45b4fd139",--> <textarea
							name="JSONData" class="JSONData">
{
	"title"  : "JAVA" ,
	"author" : "Vuthea"
}
                    </textarea>
					</td>
				</tr>
				<tr>
					<td><input type="submit" /></td>
				</tr>
				<tr>
					<td>JSON_RES</td>
					<td>
						<!--<iframe name="http://api.senate.gov.kh/index.php/api/users" style="font-size:16px;"></iframe>-->

						<textarea name="JSONResp" class="JSONResp">
                        
                        
                    </textarea>

					</td>
				</tr>
			</table>
		</form>
	</div>
	<hr />



	<div>
		<strong>(#1. UPDATE BOOK ==> URL :
			${pageContext.request.contextPath}/api/book/update/13, METHOD : "PUT") </strong>
		<br />
		<form action="${pageContext.request.contextPath}/api/book/update/13"
			method="PUT" class="form">

			<table>
				<tr>
					<td>JSON_REQ</td>
					<td>
						<!--"API_KEY":"2a1814171e4c995cbc1a7950a67d3db45b4fd139",--> <textarea
							name="JSONData" class="JSONData">
{
	"id"  : 4 ,
	"title"  : "JAVA1" ,
	"author" : "Vuthea1"
}
                    </textarea>
					</td>
				</tr>
				<tr>
					<td><input type="submit" /></td>
				</tr>
				<tr>
					<td>JSON_RES</td>
					<td>
						<!--<iframe name="http://api.senate.gov.kh/index.php/api/users" style="font-size:16px;"></iframe>-->

						<textarea name="JSONResp" class="JSONResp">
                        
                        
                    </textarea>

					</td>
				</tr>
			</table>
		</form>
	</div>
	<hr />


	<div>
		<strong>(#1. DELETE BOOK ==> URL :
			${pageContext.request.contextPath}/api/book/update/{id}, METHOD :
			"DELETE") </strong> <br />
		<form action="${pageContext.request.contextPath}/api/book/delete/13"
			method="DELETE" class="form">

			<table>
				<tr>
					<td>JSON_REQ</td>
					<td>
						<!--"API_KEY":"2a1814171e4c995cbc1a7950a67d3db45b4fd139",--> <textarea
							name="JSONData" class="JSONData">
{
	
}
                    </textarea>
					</td>
				</tr>
				<tr>
					<td><input type="submit" /></td>
				</tr>
				<tr>
					<td>JSON_RES</td>
					<td>
						<!--<iframe name="http://api.senate.gov.kh/index.php/api/users" style="font-size:16px;"></iframe>-->

						<textarea name="JSONResp" class="JSONResp">
                        
                        
                    </textarea>

					</td>
				</tr>
			</table>
		</form>
	</div>
	<hr />

	
	
	
	<% String test = ""; %>

	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
	<script type="text/javascript">
	
	var access_token = "";
	var refresh_token = "";
	
		$(document).ready(
				function() {
						$('.form').submit(
								function(e) {
									_this = $(this);
									e.preventDefault();
									console.log(JSON.stringify(JSON.parse($(this)
											.find(".JSONData").val())));
									var data = JSON.stringify(JSON.parse($(this)
											.find(".JSONData").val()));

									$.ajax({
										url : $(this).attr("action"),
										dataType : "JSON",
										contentType : 'application/json',
										type : $(this).attr("method"),
										data : data,
										success : function(data) {
											console.log(data);
											
											_this.find(".JSONResp").val(
													JSON.stringify(data, undefined,
															4));
										},
										error : function(data) {
											console.log(data);
											_this.find(".JSONResp").val(
													JSON.stringify(
															data.responseJSON,
															undefined, 4));
										}
									});
								});
						
				});
	</script>

</body>
</html>