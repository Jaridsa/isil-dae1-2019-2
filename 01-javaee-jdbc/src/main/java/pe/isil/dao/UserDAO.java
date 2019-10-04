package pe.isil.dao;

import pe.isil.model.User;
import pe.isil.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void create(User user) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "INSERT INTO t_users (login, password) values (?, ?) ";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getPassword());
                statement.executeUpdate();
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

    }

    public void update(User user) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "UPDATE t_users SET login=?, password=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getPassword());
                statement.setInt(3, user.getId());
                statement.executeUpdate();
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void delete(User user) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "DELETE FROM t_users  WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, user.getId());
                statement.executeUpdate();
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "SELECT * FROM t_users";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        User user = new User(
                                resultSet.getInt("id"),
                                resultSet.getString("login"),
                                resultSet.getString("password")
                        );
                        users.add(user);
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return users;
    }

    public User findById(Integer id) {
        User user = null;
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "SELECT * FROM t_users where id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        user = new User(
                                resultSet.getInt("id"),
                                resultSet.getString("login"),
                                resultSet.getString("password")
                        );
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

        return user;
    }

}
