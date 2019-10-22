package pe.isil.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @Column(name = "document_number")
    private Long documentNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name_father")
    private String lastNameFather;

    @Column(name = "last_name_mother")
    private String lastNameMother;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    public Employee() {
    }

    public Employee(Long documentNumber, String firstName, String lastNameFather, String lastNameMother, LocalDate birthDate) {
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastNameFather = lastNameFather;
        this.lastNameMother = lastNameMother;
        this.birthDate = birthDate;
    }

    public Long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNameFather() {
        return lastNameFather;
    }

    public void setLastNameFather(String lastNameFather) {
        this.lastNameFather = lastNameFather;
    }

    public String getLastNameMother() {
        return lastNameMother;
    }

    public void setLastNameMother(String lastNameMother) {
        this.lastNameMother = lastNameMother;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "documentNumber=" + documentNumber +
                ", firstName='" + firstName + '\'' +
                ", lastNameFather='" + lastNameFather + '\'' +
                ", lastNameMother='" + lastNameMother + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
