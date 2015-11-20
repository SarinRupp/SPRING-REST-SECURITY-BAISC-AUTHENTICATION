<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>BOOK MG</title>

</head>
<body>

	<center>
		<h1>
			<strong>BOOK MG</strong>
		</h1>
	</center>


	<table border="1" id="table">
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author</th>
			<th>Posted Date</th>
			<th>Update | Delete</th>
		</tr>
	</table>
	
	
	
	
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
	<script type="text/javascript">
	
	var access_token = "";
	var refresh_token = "";
	var book = {};
	
		$(document).ready(
				function() {
					book.list =	function(){ 
						$.ajax({
										url : "${pageContext.request.contextPath}/list",
										dataType : "JSON",
										contentType : 'application/json',
										type : "GET",
										success : function(data) {
											console.log(data);
											console.log(data.RESP_DATA);
											if(data.RESP_DATA != null ){
												jsonBook = data.RESP_DATA;
												if(jsonBook.length != 0){
													var trHTML = '';
												    $.each(jsonBook, 
												    	function (i, b) {
												        	trHTML += '<tr><td>' + b.id + '</td>'+
												        				  '<td>' + b.title + '</td>'+
												        				  '<td>' + b.author +'</td>'+
												        				  '<td>' + b.postedDate + '</td>'+
												        				  '<td> <a href="#" id="delete" onClick="deleteBook(' + b.id + ')">Delete</a> </td>'+
												        			  '</tr>';
												    });
												    $('#table').append(trHTML);
												}
											}
										},
										error : function(data) {
											console.log(data);
										}
												
											
						});
					}
						
					book.list();	
						
		});
						
				
		function deleteBook(id){
			
			$.ajax({
				url : "${pageContext.request.contextPath}/delete/"+id,
				dataType : "JSON",
				contentType : 'application/json',
				type : "DELETE",
				success : function(data) {
					console.log(data);
					$("#table").empty();
					book.list();
				},
				error : function(data) {
					console.log(data);
				}
			});
		}
	</script>




</body>
</html>