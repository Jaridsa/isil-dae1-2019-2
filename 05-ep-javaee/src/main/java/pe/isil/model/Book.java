package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book {

    private String isbn;
    private String title;
    private String summary;
    private LocalDate publicationDate;
    private Integer numberOfPages;
    private String languages;
    private String documentNumber;

}
