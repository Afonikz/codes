package booktinz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Call queries from the DAO (Data.java).
		private Data dt = new Data();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//text inputs.
		String id = request.getParameter("id");
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		
		//Instance of Book class/bean
		Book bkdata = new Book(id,author,title);
		
		dt.Edit(bkdata);//edit a book
		
		response.sendRedirect("ViewBooks.jsp");
	}

}
