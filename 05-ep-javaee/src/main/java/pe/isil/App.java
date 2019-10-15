package pe.isil;


import pe.isil.model.Author;
import pe.isil.model.Book;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to the jungle!");

        Author author1 = new Author();
        author1.setFirstName("JK ");
        author1.setLastNameFather("Rowling");
        author1.setBirthDate(LocalDate.of(1978,8,1);

        Book book1 = new Book();
        book1.setIsbn("S0001");
        book1.setTitle("Harry Potter y la piedra filosofal ");
        book1.setLanguages("Español");
        book1.setNumberOfPages(1024);
        book1.setPublicationDate(LocalDate.of(1997,6,26));


    }
}
