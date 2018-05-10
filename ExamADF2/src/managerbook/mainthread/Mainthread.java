package managerbook.mainthread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

import managerbook.entity.Book;



public class Mainthread {
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Book> listBook = new ArrayList<>();

	public static void main(String[] args) {
		generateMenu();
	}

	public static void generateMenu() {
		int choice;
		while (true) {
			System.out.println("==========================");
			System.out.println("1. Add book records");
			System.out.println("2. Save");
			System.out.println("3. Display book records");
			System.out.println("4. Exit");
			System.out.print("Please enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				addBook();
				break;
			case 2:
				save();
				break;
			case 3:
				dislayBook();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong choice, please choose again");
				break;
			}
		}
	}

	public static void addBook() {
		System.out.println("Please input book info: ");
		System.out.print("Book ID: ");
		String bookID = scanner.nextLine();
		System.out.print("Book Title: ");
		String bookName = scanner.nextLine();
		System.out.print("Author: ");
		String author = scanner.nextLine();
		System.out.print("Price: ");
		int price = scanner.nextInt();
		Book book = new Book(bookID, bookName, author, price);
		listBook.add(book);
	}

	public static void save() {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("books.dat")));
			bw.write(String.format("%15s %30s %20s %10s", "Book ID", "Book Name", "Author", "Price"));
			bw.newLine();
			for (Book book : listBook) {
				bw.write(String.format("%15s %30s %20s %10s", book.getBookID(), book.getBookName(), book.getAuthor(),
						"$" + String.valueOf(book.getPrice())));
				bw.newLine();
			}
			bw.close();
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public static void dislayBook() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("books.dat")));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
