<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="booktinz.Book"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href = "css/bootstrap.min.css" rel = "stylesheet" type = "text/css"/>
    
	<title>Edit Book Details</title>
</head>
<body>
	<br />
	<!-- Links -->
	<div class="container-fluid">
	<div class = "row">
		<div class = "col"><h2>Edit Book</h2></div>
		<div class = "col text-center"><a href = "Insert.jsp" class="btn">Insert New Book</a></div>
		<div class = "col text-right"><a href = "ViewBooks.jsp" class="btn">View All Books</a></div>
	</div>
	
	
	<!-- Search Box -->
	<div class="container">
            <div class="row">
                <div class="col-sm-10 offset-sm-1 text-center">
                    <h1 class="display-3">Afolorunsho on Point</h1>
                    <div class="info-form">
                    
                        <form action="ProcessData" class="form-inline justify-content-center">
                            <div class="form-group">
                                <input type="text" class="form-control" name = "id" placeholder="Enter Book ID">
                            </div>
                                <!--Search button should fin a book using it book id.-->
        					<div class="btn-group">
            					<input type="submit" name = "oper" class="btn btn-primary" value="Search" />
        					</div>
                        </form>
                        
                    </div>
                    <br />
                </div>
            </div>
        </div>
	
	<!-- Edit form -->
	<% Book iw = (Book)request.getAttribute("iwe"); 
	
	%>


	<div class="justify-content-center align-items-center container ">
	
	<div class="">
	
	<div class="">
		
		<%if((request.getAttribute("iwe")) !=null ){ %>
		
			<div class="field">
			<!-- This scriptlet worked -->
    			<%//= iw.id %>
    			<%//= iw.author %>
    			<%//= iw.getTitle() %>
    			
    			<!-- This didn't work -->
    			${iw.id}
    			${iw.getAuthor }
    			${iw.getTitle }
		</div>
			
			<form method = "" action = "edit">
			<h3>Edit Details</h3>
			
			<h3>The request.getAttribute() return values</h3>
  				<div class="form-group row">
    				<label for="id" class="col-sm-2 col-form-label col-form-label-lg"><b>Book ID</b></label>
    				<div class="col-sm-10">
      					<input type="text" name = "id" value='<%=iw.id %>' class="form-control form-control-lg" readonly />
    				</div>
  				</div>
  				<div class="form-group row">
    				<label for="author" class="col-sm-2 col-form-label col-form-label-lg"><b>Book Author</b></label>
    				<div class="col-sm-10">
      					<input type="text" name = "author" value='<%= iw.author %>' class="form-control form-control-lg" />
    				</div>
  				</div>
  				<div class="form-group row">
    				<label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg"><b>Book Title</b></label>
    				<div class="col-sm-10">
      					<input type="text" name = "title" value='<%= iw.getTitle() %>' class="form-control form-control-lg" />	
    				</div>
  				</div>
  				<div class = "row">
        				<!--Edit button should link a page that Edit file-->
        			 <div class="btn-group col-sm-3">
            			<input type="submit" name = "oper" class="btn btn-primary col-sm-12" value="Edit"/>
        			</div>
        			
				</div>
			</form>
			
			
			<%} else{ %>
			
			<!-- duplicate of the above code, Used by he links in Viewbooks.jsp and other links-->
			<form method = "" action = "edit">
			<h3>The request.getAttribute() Do not return values</h3>
			<h3>Edit Details</h3>
  				<div class="form-group row">
    				<label for="id" class="col-sm-2 col-form-label col-form-label-lg"><b>Book ID</b></label>
    				<div class="col-sm-10">
      					<input type="text" name = "id" value='<%= request.getParameter("id") %>' class="form-control form-control-lg" readonly />
    				</div>
  				</div>
  				<div class="form-group row">
    				<label for="author" class="col-sm-2 col-form-label col-form-label-lg"><b>Book Author</b></label>
    				<div class="col-sm-10">
      					<input type="text" name = "author" value='<%= request.getParameter("author") %>' class="form-control form-control-lg" />
    				</div>
  				</div>
  				<div class="form-group row">
    				<label for="colFormLabelLg" class="col-sm-2 col-form-label col-form-label-lg"><b>Book Title</b></label>
    				<div class="col-sm-10">
      					<input type="text" name = "title" value='<%= request.getParameter("title") %>' class="form-control form-control-lg" />	
    				</div>
  				</div>
  				<div class = "row">
        				<!--Edit button should link a page that Edit file-->
        			 <div class="btn-group col-sm-3">
            			<input type="submit" name = "oper" class="btn btn-primary col-sm-12" value="Edit"/>
        			</div>
        			
				</div>
			</form>
			
			<% } %>
			
		</div>
		
	</div>
	
	</div>
</body>
</html>