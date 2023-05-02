public class Book {

	public static void main(String[] args) 
	{
		bookclass book1 = new bookclass("Harry Potter", "Jk Rowling", 500,"English" );
		//book1.title = "Harry Potter";
		//book1.author = "Jk Rowling";
		//book1.pages = 500;
		//book1.language = "English";
		
		bookclass book2 = new bookclass("Cats", "Cat Man", 421,"English");
		//book2.title = "Cats";
		//book2.author = "Cat Man";
		//book2.pages = 421;
		//book2.language = "English";
		
		System.out.println(book1.title);
		System.out.println(book2.title);
	}

}
