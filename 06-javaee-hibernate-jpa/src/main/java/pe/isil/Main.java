package pe.isil;

import pe.isil.model.Employee;

import javax.persistence.*;
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


        manager.getTransaction().begin();
        //operaciones a BD
        Employee employee = new Employee();
        employee.setDocumentNumber(10L);
        employee.setFirstName("Jose");
        employee.setLastNameFather("Ventura");
        employee.setLastNameMother("Arteaga");
        employee.setBirthDate(new GregorianCalendar(2000, 3, 31).getTime());

        manager.persist(employee);

        List<Employee> employees = (List<Employee>) manager.createQuery("FROM Employee").getResultList();
        System.out.println("empployees = " + employees);

        manager.getTransaction().commit();


    }

}
