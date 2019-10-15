package pe.isil;


import pe.isil.dao.AuthorDAO;
import pe.isil.model.Author;
import pe.isil.model.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the jungle!");

        Random random = new Random();

        Author author1 = new Author();
        author1.setDocumentNumber("A"+ random.nextInt()+1);
        author1.setFirstName("JK ");
        author1.setLastNameFather("Rowling");
        author1.setLastNameMother("");
        author1.setBirthDate(LocalDate.of(1978,8,1));
        author1.setBiographic("bla bla bla");

        AuthorDAO authorDAO = new AuthorDAO();
        authorDAO.create(author1);

        List<Author> authors = authorDAO.findAll();
        authors.forEach(System.out::println);

//        Book book1 = new Book();
//        book1.setIsbn("S0001");
//        book1.setTitle("Harry Potter y la piedra filosofal ");
//        book1.setLanguages("Español");
//        book1.setNumberOfPages(1024);
//        book1.setPublicationDate(LocalDate.of(1997,6,26));


    }
}
