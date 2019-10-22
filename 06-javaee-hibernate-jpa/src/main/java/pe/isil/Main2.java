package pe.isil;

import pe.isil.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Main2 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("isilPU");


    public static void main(String[] args) {



    }

    private static void insertInitial() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Employee employee = new Employee();
        employee.setDocumentNumber(10L);
        employee.setFirstName("Jose");
        employee.setLastNameFather("Ventura");
        employee.setLastNameMother("Arteaga");
        employee.setBirthDate(LocalDate.of(2000,3,31));
        manager.getTransaction().commit();
        manager.close();
    }

    private static void printEmployees() {
        EntityManager manager = emf.createEntityManager();
        List<Employee> employees = (List<Employee>) manager.createQuery("FROM Employee").getResultList();
        System.out.println("empployees = " + employees);
        manager.close();
    }


}
