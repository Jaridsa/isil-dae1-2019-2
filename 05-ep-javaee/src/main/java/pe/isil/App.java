package pe.isil;


import pe.isil.dao.AuthorDAO;
import pe.isil.dao.BookDAO;
import pe.isil.model.Author;
import pe.isil.model.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the jungle!");

        Random random = new Random();
        int number = random.nextInt(1000-500)+500;
        String documentNumber = "A"+ number;
        String isbn = "B"+ number;

        Author author1 = new Author();
        author1.setDocumentNumber(documentNumber);
        author1.setFirstName("JK ");
        author1.setLastNameFather("Rowling");
        author1.setLastNameMother("");
        author1.setBirthDate(LocalDate.of(1978,8,1));
        author1.setBiographic("bla bla bla");

        AuthorDAO authorDAO = new AuthorDAO();
        authorDAO.create(author1);

        List<Author> authors = authorDAO.findAll();
        authors.forEach(System.out::println);

        author1 = authorDAO.findOne(documentNumber);
        System.out.println("author = " + author1);

        author1.setLastNameMother("AAAA");
        authorDAO.update(author1);

        author1 = authorDAO.findOne(documentNumber);
        System.out.println("authorUpdated = " + author1);


        Book book1 = new Book();
        book1.setIsbn(isbn);
        book1.setTitle("Harry Potter y la piedra filosofal ");
        book1.setSummary("bla bla bla");
        book1.setLanguages("Español");
        book1.setNumberOfPages(1024);
        book1.setPublicationDate(LocalDate.of(1997,6,26));
        book1.setDocumentNumber(documentNumber);

        BookDAO bookDAO = new BookDAO();
        bookDAO.create(book1);

        List<Book> books = bookDAO.findAll();
        books.forEach(System.out::println);

        book1 = bookDAO.findOne(isbn, documentNumber);
        System.out.println("book = " + book1);

        book1.setTitle("AAAAAAAA");
        bookDAO.update(book1);

        book1 = bookDAO.findOne(isbn, documentNumber);
        System.out.println("book = " + book1);

        bookDAO.delete(book1);
        authorDAO.delete(author1);
    }
}
