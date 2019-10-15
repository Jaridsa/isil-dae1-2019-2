package pe.isil.dao;


import pe.isil.model.Author;
import pe.isil.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO implements DAO<Author, String> {

    @Override
    public void create(Author author) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "INSERT INTO author(document_number, first_name, last_name_father, last_name_mother, birth_date, biography) values (?, ?, ?, ?, ?, ?) ";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, author.getDocumentNumber());
                statement.setString(2, author.getFirstName());
                statement.setString(3, author.getLastNameFather());
                statement.setString(4, author.getLastNameMother());
                statement.setDate(5, Date.valueOf(author.getBirthDate()));
                statement.setString(6, author.getBiographic());
                statement.executeUpdate();
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void delete(Author author) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "DELETE FROM author  WHERE document_number=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, author.getDocumentNumber());
                statement.executeUpdate();
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void update(Author author) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "UPDATE author SET first_name=?, last_name_father=?, last_name_mother=?, birth_date=?, biography= ? WHERE document_number=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, author.getFirstName());
                statement.setString(2, author.getLastNameFather());
                statement.setString(3, author.getLastNameMother());
                statement.setDate(4, Date.valueOf(author.getBirthDate()));
                statement.setString(5, author.getBiographic());
                statement.setString(6, author.getDocumentNumber());
                statement.executeUpdate();
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Author findOne(String documentNumber) {
        Author author = null;
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "SELECT * FROM author where document_number=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, documentNumber);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        author = new Author(
                                resultSet.getString("document_number"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name_father"),
                                resultSet.getString("last_name_mother"),
                                resultSet.getDate("birth_date").toLocalDate(),
                                resultSet.getString("biography")
                        );
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

        return author;
    }

    @Override
    public List<Author> findAll() {
        List<Author> users = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "SELECT * FROM author";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        Author author = new Author(
                                resultSet.getString("document_number"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name_father"),
                                resultSet.getString("last_name_mother"),
                                resultSet.getDate("birth_date").toLocalDate(),
                                resultSet.getString("biography")
                        );
                        users.add(author);
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return users;
    }
}
