package booktinz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

/**
 * Servlet implementation class ProcessData
 */
@WebServlet("/ProcessData")
public class ProcessData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Call queries from the DAO (Data.java).
	private Data dt = new Data();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		//Write codes here.
response.setContentType("text/html");
		
		//text inputs.
				String id = request.getParameter("id");
				String author = request.getParameter("author");
				String title = request.getParameter("title");
				
				//buttons
				String operate = request.getParameter("oper");
				
				//Instance of Book class/bean
				Book bkdata = new Book(id,author,title);
				
				//Interface to Book class/bean
				bkdata.setId(id);
				bkdata.setAuthor(author);
				bkdata.setTitle(title);
				
				PrintWriter out=response.getWriter(); 
				
				//Helps to choose operation on click
				if(operate.equalsIgnoreCase("Insert")) {
					int status = dt.Insert(bkdata);//Insert data
					//request.setAttribute("book", dt);//help to move objects from one jsp page to another.
					
				    if(status>0){  
				        out.print("<p>Record saved successfully!</p>");  
				        request.getRequestDispatcher("Insert.jsp").include(request, response); 
				    }else{  
				        out.println("Sorry! unable to save record");
				        request.getRequestDispatcher("Insert.jsp").include(request, response); 
				        }  
				          
				    out.close();  
					
				}
				//this method is used if the Book ID is known(Insert.jsp page), then the If section of the form in Edit.jsp is used.
				else if(operate.equalsIgnoreCase("Edit")) {
					Book data = dt.getBook(id);//get one book
					//request.setAttribute("iwe", data);
					
					//attempt to put he result into the Book Object
					Book hn = new Book();
					
					hn.setId(data.id);
					hn.setAuthor(data.author);
					hn.setTitle(data.title);
					request.setAttribute("iwe", hn);
					
					
					//In the getParameter.jsp page create an if else statement for the insert and Edit sphere.
					//dt.Edit(bkdata);//edit a book
					request.getRequestDispatcher("Edit.jsp").forward(request, response);
				}
				else if(operate.equalsIgnoreCase("Delete")) {
					dt.Delete(bkdata);//delete a book
					response.sendRedirect("ViewBooks.jsp");
				}
				else if(operate.equalsIgnoreCase("Search")) {
					Book data = dt.getBook(id);//get one book\
					//SEARCH BY BOOK ID
					request.getRequestDispatcher("Insert.jsp").include(request, response);
					
					out.println("<table class = 'table table-dark' >");
					out.println("<tr>");
					out.println("<th>Book ID</th><th>Book Author</th><th>Book Title</th><th>Edit</th><th>Delete</th>");
					out.println("</tr>");
					out.println("<tr>");
					out.println("<td>"+data.getId()+"</td>");
					out.println("<td>"+data.getAuthor()+"</td>");
					out.println("<td>"+data.getTitle()+"</td>");	
					
				    out.print("<td><a href='Edit.jsp?id="+data.getId()+"&author="+data.getAuthor()+"&title="+data.getTitle()+"'>Edit</a></td>"+  
				                 "<td><a href='delbook.jsp?id="+data.getId()+"&author="+data.getAuthor()+"&title="+data.getTitle()+"'>Delete</a></td>"); 
					
				    out.println("</tr>");
					out.print("</table>");
					
					
				}
				
				/*RequestDispatcher interface provides the facility of dispatching the request to another resource,
				it may be html, servlet or jsp. This interface can also be used to include the content of another resource also. 
				It is one of the way of servlet collaboration.*/
				
				//request.getRequestDispatcher("Insert.jsp").forward(request, response);
				
				
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
