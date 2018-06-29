package booktinz;

public class Book {

	public String id;
	public String author;
	public String title;
	
	public Book(){
		
	}
	
	public Book(String ID, String Author,String Title){
		this.id = ID;
		this.author = Author;
		this.title = Title;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setAuthor(String aut) {
		this.author = aut;
	}
	public void setTitle(String tit) {
		this.title = tit;
	}
	
	public String getId() {
		return this.id;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getTitle() {
		return this.title;
	}
}
