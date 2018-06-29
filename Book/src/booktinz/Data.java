package booktinz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Data {
	//Initialize connection.
	Connection connection = null;

	//Prepared Statements and Queries
	PreparedStatement stmt = null;
	
	//Book Instance
//	Book bk;

	//Declared Variables
	String bookId;
	String bookAuthor;
	String bookTitle; 

	//ResultSets
	ResultSet Display = null;
	
	//Connection to Driver and Database.
		public Connection Con() {
		
	    System.out.println("-------- Oracle JDBC Connection ------");

	    try {

	        Class.forName("oracle.jdbc.OracleDriver");

	    } catch (ClassNotFoundException e) {

	        System.out.println("Oracle JDBC Driver, Wetin Happen?");
	        e.printStackTrace();
	    }

	    System.out.println("Oracle JDBC Driver Found!");

	    try {

	        connection = DriverManager.getConnection(
	                "jdbc:oracle:thin:@localhost:1521:orcl", "afo", "healas");

	    } catch (SQLException e) {

	        System.out.println("Database Connection Failed!");
	        e.printStackTrace();

	    }

	    if (connection != null) {
	        System.out.println("You made it, take control of your database now!");
	    } else {
	        System.out.println("Failed to make connection!");
	    }
	    
	    return connection;
	}
		
		public void close() {
			 try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	//Insert into the Database
	public int Insert(Book bk)
	{
		//PreparedStatement is used to execute parameterized query (passing parameter (?) for the values).
		//Its value will be set by calling the setter methods of PreparedStatement.
		String query = "insert into Items values(?,?,?)";
		int i = 0;
		try
		{
			stmt = Con().prepareStatement(query);
	
			//For set clause
			stmt.setString(1, bk.getId());//grab data from the book object. i.e bk.getId()
			stmt.setString(2, bk.getAuthor());
			stmt.setString(3, bk.getTitle());
			
			i = stmt.executeUpdate();
			  
			System.out.println(i+" records inserted");  
			  
			//Con().close(); 
			close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return i;
	}
	
	//Test Insert into the Database
		public void Insert()
		{
			//PreparedStatement is used to execute parameterized query (passing parameter (?) for the values).
			//Its value will be set by calling the setter methods of PreparedStatement.
			String query = "insert into Items values(?,?,?)";
			
			try
			{
				stmt = Con().prepareStatement(query);
		
				//For set clause
				stmt.setString(1, "989");//grab data from the book object. i.e bk.getId()
				stmt.setString(2, "Bolu Jonah");
				stmt.setString(3, "Getting Frustrated");
				
				int i = stmt.executeUpdate();
				  
				System.out.println(i+" records inserted");  
				  
				//Con().close(); 
				close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	//Edit Book details
	public void Edit(Book bk) {
		
		String query = "UPDATE Items SET ID = ?, AUTHOR = ?, TITLE = ? WHERE ID = ? OR AUTHOR = ? OR TITLE = ?";

		try {
			stmt = Con().prepareStatement(query);
			
			//The numbers serially assigns value to the "?".
	
			//For set clause
			stmt.setString(1, bk.getId());//grab data from the book object. i.e bk.getId()
			stmt.setString(2, bk.getAuthor());
			stmt.setString(3, bk.getTitle());
			
			//For Where clause
			stmt.setString(4, bk.getId());//grab data from the book object. i.e bk.getId()
			stmt.setString(5, bk.getAuthor());
			stmt.setString(6, bk.getTitle());
			
			int i = stmt.executeUpdate();
			  
			System.out.println(i+" records Edited");  
			
//			Con().close();
			close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Test Edit Book details
	public void Edit() {
		
		String query = "UPDATE Items SET ID = ?, AUTHOR = ?, TITLE = ? WHERE ID = ? OR AUTHOR = ? OR TITLE = ?";

		try {
			stmt = Con().prepareStatement(query);
			
			//The numbers serially assigns value to the "?".
	
			//For set clause
			stmt.setString(1, "223");//grab data from the book object. i.e bk.getId()
			stmt.setString(2, "Akin Agboola");
			stmt.setString(3, "God is good");
			
			//For Where clause
			stmt.setString(4, "423");//grab data from the book object. i.e bk.getId()
			stmt.setString(5, "Akin Agboola");
			stmt.setString(6, "God bids us to do good");
			
			int i = stmt.executeUpdate();
			  
			System.out.println(i+" records Edited");  
			
//			Con().close();
			close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//Delete Book Detail
	public void Delete(Book bk) {
		String query = "DELETE FROM Items WHERE ID = ? OR AUTHOR = ? OR TITLE = ?";

		try {
			stmt = Con().prepareStatement(query);
			
			//The numbers serially assigns value to the "?".
			
			//For set clause
			stmt.setString(1, bk.getId());//grab data from the book object. i.e bk.getId()
			stmt.setString(2, bk.getAuthor());
			stmt.setString(3, bk.getTitle());
			
			int i = stmt.executeUpdate();
			  
			System.out.println(i+" records Deleted");  
			
//			Con().close();
			close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	//return a book from the DB
	public Book getBook(String id)
	{
		Book bk = new Book();
		String query = "select * from Items where ID = ?";
		
		try
		{
			stmt = Con().prepareStatement(query);
			stmt.setString(1, id);
			
			//stores the Resultset in Display variable.
			Display = stmt.executeQuery();  

	        while(Display.next())

	        {
		            //This is needed to use the Book object as an interface.
	            bk.setId(Display.getString(1));
	            bk.setAuthor(Display.getString(2));//numbers indicate column position in DB.
	            bk.setTitle(Display.getString(3));
	       
             } 
//	        Con().close();
	        close();
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		return bk;
	}
	
	//Get all Books in the Database.
	public ArrayList<Book> getAllBooks()
{
		//Holds all Books in the DB.
		ArrayList<Book> allbooks = new ArrayList<Book>();
		
//		Book bk = new Book();
		String query = "select * from Items";
	try
	{
		stmt = Con().prepareStatement(query);
		
		Display = stmt.executeQuery();  
        while(Display.next())
        {
        	Book bk = new Book();
            //This is needed to use the Book object as an interface.
            bk.setId(Display.getString(1));
            bk.setAuthor(Display.getString(2));//numbers indicate column position in DB.
            bk.setTitle(Display.getString(3));
            
            //put each book in a list
            allbooks.add(bk);
        }
//        Con().close();
        close();
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
	}
	return allbooks;
}

	
	//Get all Books in the Database.
	public void getBooks()
{		
		String query = "select * from Items";
		
	try
	{
		stmt = Con().prepareStatement(query);
		
		Display = stmt.executeQuery();  

		if(Display != null) {
        while(Display.next())
        {
            System.out.println("Id: "+Display.getString(1)+" Author: "+Display.getString(2)+" Title: "+Display.getString(3));
        }
		}
		else {
			System.out.println("Nothing to Display.");
		}
//		Con().close();
		close();
	}
	catch(Exception e1)
	{
		e1.printStackTrace();
	}
	
}
	
	//Test conection
	public static void main(String[] args) {
		Data con = new Data();
		con.Con();
		//con.Insert();
		//con.Edit();
		con.getBooks();
	}

}


















