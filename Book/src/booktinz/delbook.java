package booktinz;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/delbook")  
public class delbook extends HttpServlet {  
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
    	
        String id=request.getParameter("id");
        String author = request.getParameter("author");
		String title = request.getParameter("title");
		
        Book kb = new Book();
        kb.setId(id);
        kb.setAuthor(author);
        kb.setTitle(title);
        
        Data dat = new Data();
        dat.Delete(kb);  
        response.sendRedirect("ViewBooks.jsp");  
    }  
}  