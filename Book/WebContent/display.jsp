<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>welcome...</h2>
	
		<table>
    <tr>
        <th colspan="5" style="background-color:#7c2f97;">Books</th>
    </tr>
    <tr style="background-color:#f0a64e;">
        <th class="border">ID</th>
        <th class="border">Author</th>
        <th class="border">Title</th>
    </tr>
    
        <tr>
            <td>${book.getId()}</td>
            <td>${book.getAuthor()}</td>
        
            <td>${book.getTitle()}</td>
        </tr>
</table>
</body>
</html>