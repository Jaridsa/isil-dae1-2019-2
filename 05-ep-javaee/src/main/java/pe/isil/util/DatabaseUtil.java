package pe.isil.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String URL = "jdbc:postgresql://isil-db.c4utrkzk5zgf.us-west-1.rds.amazonaws.com:5432/javaee_db";
    private static final String USER = "javaee_user";
    private static final String PASSWORD = "javaee_user";
    private static final String DRIVER = "org.postgresql.Driver";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
