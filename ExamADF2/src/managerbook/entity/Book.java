package managerbook.entity;

public class Book {
	private String bookID;
	private String bookName;
	private String author;
	private int price;

	public Book() {
	}

	public Book(String bookID, String bookName, String author, int price) {
		this.bookID = bookID;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
