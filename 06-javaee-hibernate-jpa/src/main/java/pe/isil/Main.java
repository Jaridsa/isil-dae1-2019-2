package pe.isil;

import pe.isil.model.Employee;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {

    //@PersistenceContext(unitName = "isilPU")
    private static EntityManager manager;

    //@PersistenceUnit(unitName = "isilPU")
    private static EntityManagerFactory emf;


    public static void main(String[] args) {

        emf = Persistence.createEntityManagerFactory("isilPU");
        manager = emf.createEntityManager();

        insertInitial();
        printEmployees();

        manager.getTransaction().begin();

        Employee employee = manager.find(Employee.class, 10L);

        employee.setLastNameFather("BBBBB");

        manager.getTransaction().commit();

        printEmployees();


    }

    private static void insertInitial() {
        manager.getTransaction().begin();
        //operaciones a BD
        Employee employee = new Employee();
        employee.setDocumentNumber(10L);
        employee.setFirstName("Jose");
        employee.setLastNameFather("Ventura");
        employee.setLastNameMother("Arteaga");
        employee.setBirthDate(LocalDate.of(2000,3,31));

        manager.persist(employee);

        employee.setLastNameFather("AAAAA");

        manager.getTransaction().commit();
    }

    private static void printEmployees() {
        List<Employee> employees = (List<Employee>) manager.createQuery("FROM Employee").getResultList();
        System.out.println("empployees = " + employees);
    }


}
