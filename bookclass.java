//Instead of manually assigning class variables, the constructor does it auto
public class bookclass 
{
	String title;
	String author;
	int pages;
	String language;
	
	public bookclass(String title, String author,int pages, String language )
	{
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.language = language;
	}
}
