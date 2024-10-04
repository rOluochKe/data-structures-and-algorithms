package Java;

import java.util.ArrayList;
import java.util.List;

class Book {
  private String title;
  private String author;
  private String content;

  public Book(String title, String author, String content) {
    this.title = title;
    this.author = author;
    this.content = content;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getContent() {
    return content;
  }
}

class EBookReaderSystem {
  private List<Book> purchasedBooks;

  public EBookReaderSystem() {
    purchasedBooks = new ArrayList<>();
  }

  public void buyBook(Book book) {
    purchasedBooks.add(book);
    System.out.println("Book purchased: " + book.getTitle());
  }

  public void viewPurchasedBooks() {
    System.out.println("Purchased Books:");
    for (Book book : purchasedBooks) {
      System.out.println(book.getTitle() + " by " + book.getAuthor());
    }
  }

  public void readBook(Book book) {
    System.out.println("Reading Book: " + book.getTitle());
    System.out.println(book.getContent());
  }
}

public class EBookReaderSimulation {
  public static void main(String[] args) {
    Book book1 = new Book("Title1", "Author1", "Content1");
    Book book2 = new Book("Title2", "Author2", "Content2");

    EBookReaderSystem readerSystem = new EBookReaderSystem();

    readerSystem.buyBook(book1);
    readerSystem.buyBook(book2);

    readerSystem.viewPurchasedBooks();

    readerSystem.readBook(book1);
  }
}