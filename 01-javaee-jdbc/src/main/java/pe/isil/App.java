package pe.isil;


import pe.isil.dao.UserDAO;
import pe.isil.model.User;

import java.util.List;

public class App {


    public static void main(String[] args) {
        System.out.println("javaee-jdbc");

        UserDAO userDAO = new UserDAO();

        userDAO.create(new User(null, "AAAA", "AAAA"));

        List<User> all = userDAO.findAll();
        all.stream().forEach(u -> System.out.println("user = " + u));




    }
}
