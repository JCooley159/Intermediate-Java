import java.util.ArrayList;
import java.util.Scanner;

public class BookTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Do you want to create a new Book?");
		System.out.println("1. yes 2. no");
		int option = input.nextInt();
		
		ArrayList<Book> bookArrayList = new ArrayList<Book>();
		
		
		while (option != 2) {
			
			
			System.out.println("What author?");
			String author = input.next();
			System.out.println("How many pages?");
			int pages = input.nextInt();
			System.out.println("What genre?");
			String genre = input.next();
			
			bookArrayList.add(new Book(author, pages, genre));
			
			System.out.println("Okey dokey, your book has been created! Do you want to create another?");
			option = input.nextInt();
			
		}
		
		
		for (Book book : bookArrayList) {
			System.out.println(book.toString());
		}
		
		
		System.out.println("Okay, bye bye! <3");
		
		
		
	}

}
