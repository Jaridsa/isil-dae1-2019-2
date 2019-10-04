package pe.isil.dao;

import pe.isil.model.User;

import java.sql.*;

public class UserDao extends DaoContext {

    public static User isValidLogin(String login, String password) {

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {

            String sql = "SELECT * FROM t_users WHERE login=? AND password=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setString(1, login);
                ps.setString(2, password);

                try (ResultSet rs = ps.executeQuery()) {

                    if (rs.next()) {

                        return new User(
                                rs.getInt("id"),
                                rs.getString("login"),
                                rs.getString("password")
                        );

                    } else {
                        return null;
                    }

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }


}
