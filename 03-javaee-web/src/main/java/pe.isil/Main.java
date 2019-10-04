package pe.isil;

import pe.isil.dao.UserDao;
import pe.isil.model.User;

public class Main {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        User user = userDao.isValidLogin("pe.isil", "1234");
        System.out.println("user = " + user);


    }

}
