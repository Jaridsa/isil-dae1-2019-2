package pe.isil.dao;

import javax.servlet.ServletContext;

public class DaoContext {

    protected static String dbUrl;
    protected static String dbUser;
    protected static String dbPassword;

    public static void init( ServletContext context ){

        try {

            Class.forName(context.getInitParameter("JDBC_DRIVER"));

            dbUrl = context.getInitParameter("JDBC_URL");
            dbUser = context.getInitParameter("JDBC_USER");
            dbPassword = context.getInitParameter("JDBC_PASSWORD");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
