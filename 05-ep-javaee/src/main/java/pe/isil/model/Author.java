package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author {

    private String firstName;
    private String lastNameFather;
    private String lastNameMother;
    private LocalDate birthDate;
    private String biographic;

}
