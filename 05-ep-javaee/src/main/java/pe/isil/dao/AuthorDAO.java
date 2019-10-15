package pe.isil.dao;


import pe.isil.model.Author;
import pe.isil.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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

    }

    @Override
    public void update(Author author) {

    }

    @Override
    public Author findOne(String s) {
        return null;
    }

    @Override
    public List<Author> findAll() {
        return null;
    }
}
