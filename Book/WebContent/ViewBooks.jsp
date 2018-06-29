<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>




<%@ page import="booktinz.Data"%>
<%@ page import="booktinz.Book"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.*"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href = "css/bootstrap.min.css" rel = "stylesheet" type = "text/css"/>
<title>All Books</title>
</head>
<body>

	<%
		//this code display all books in the DB.
		Data data = new Data();//Instance of the DAO
		ArrayList<Book> book = data.getAllBooks();//get all books
		
		%>
		<br />
		<div class = "container">
			<div class = "row">
				<div class = "col"><h2>Books</h2></div>
				<div class = "col text-right"><a href = "Insert.jsp" class="btn btn-outline-secondary">Add New Book</a></div>
			</div>
		</div>
		
		
		 <div class="container">
            <div class="row">
                <div class="col-sm-10 offset-sm-1 text-center">
                    <h3 class="display-3">Afolorunsho on point</h3>
        		</div>
			</div>
		</div>
		
		<div class = "container-fluid">
		<table class = "table table-dark">
		<tr><th>ID</th><th>Author</th><th>Title</th><th>Edit</th><th>Delete</th></tr>
		<% 
		for(Book b : book){
%>			
			</tr>
			<td><%=b.getId()%></td>
			<td><%= b.getAuthor()%></td>
			<td><%=b.getTitle()%></td>
			<td><a href='Edit.jsp?id=<%= b.getId() %>&author=<%= b.getAuthor() %>&title=<%= b.getTitle() %>'>Edit</a></td>
			<td><a href='delbook?id=<%= b.getId() %>&author=<%= b.getAuthor() %>&title=<%= b.getTitle() %>'>Delete</a></td>
			</tr>
			<%
		}//How to set query link: SomeActionPage.cfm?param1=value1&param2=value2&param3=value3
	%>
	
	</table>
	</div>

</body>
</html>