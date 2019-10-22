package pe.isil.dao;

import pe.isil.model.Book;
import pe.isil.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements DAO<Book, String> {

    @Override
    public void create(Book book) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "INSERT INTO book(isbn, title, summary, publication_date, number_of_pages, languages, document_number) values (?, ?, ?, ?, ?, ?, ?) ";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, book.getIsbn());
                statement.setString(2, book.getTitle());
                statement.setString(3, book.getSummary());
                statement.setDate(4, Date.valueOf(book.getPublicationDate()));
                statement.setInt(5, book.getNumberOfPages());
                statement.setString(6, book.getLanguages());
                statement.setString(7, book.getDocumentNumber());
                statement.executeUpdate();
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void delete(Book book) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "DELETE FROM book WHERE isbn=? and document_number=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, book.getIsbn());
                statement.setString(2, book.getDocumentNumber());
                statement.executeUpdate();
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void update(Book book) {
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "UPDATE book SET title=?, summary=?, publication_date=?, number_of_pages=?, languages=? WHERE isbn=? and document_number = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, book.getTitle());
                statement.setString(2, book.getSummary());
                statement.setDate(3, Date.valueOf(book.getPublicationDate()));
                statement.setInt(4, book.getNumberOfPages());
                statement.setString(5, book.getLanguages());
                statement.setString(6, book.getIsbn());
                statement.setString(7, book.getDocumentNumber());
                statement.executeUpdate();
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Book findOne(String isbn) {
        Book book = null;
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "SELECT * FROM book where isbn=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, isbn);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        book = new Book(
                                resultSet.getString("isbn"),
                                resultSet.getString("title"),
                                resultSet.getString("summary"),
                                resultSet.getDate("publication_date").toLocalDate(),
                                resultSet.getInt("number_of_pages"),
                                resultSet.getString("languages"),
                                resultSet.getString("document_number")
                        );
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

        return book;
    }

    public Book findOne(String isbn, String documentNumber) {
        Book book = null;
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "SELECT * FROM book where isbn=? and document_number=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, isbn);
                statement.setString(2, documentNumber);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        book = new Book(
                                resultSet.getString("isbn"),
                                resultSet.getString("title"),
                                resultSet.getString("summary"),
                                resultSet.getDate("publication_date").toLocalDate(),
                                resultSet.getInt("number_of_pages"),
                                resultSet.getString("languages"),
                                resultSet.getString("document_number")
                        );
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }

        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            final String sql = "SELECT * FROM book";
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        Book book = new Book(
                                resultSet.getString("isbn"),
                                resultSet.getString("title"),
                                resultSet.getString("summary"),
                                resultSet.getDate("publication_date").toLocalDate(),
                                resultSet.getInt("number_of_pages"),
                                resultSet.getString("languages"),
                                resultSet.getString("document_number")
                        );
                        books.add(book);
                    }
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return books;
    }
}
