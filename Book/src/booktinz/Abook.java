package booktinz;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Abook
 */
@WebServlet("/Abook")
public class Abook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Data data;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Abook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id = request.getParameter("id");
		
		Book book = data.getBook(id);
		request.setAttribute("books", book);
		request.getRequestDispatcher("display.jsp").forward(request, response);
	}

}
