package com.amazonbooklist.amazonbooklist.dao.impl;

import com.amazonbooklist.amazonbooklist.dao.interfaces.BooksDao;
import com.amazonbooklist.amazonbooklist.models.Books;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBooksDao implements BooksDao {
    private static final Logger log = LoggerFactory.getLogger(JdbcBooksDao.class);
    private final DataSource dataSource;

    @Autowired
    public JdbcBooksDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Books> findAll() {
        List<Books> books = new ArrayList<>();
        String sql = """
                SELECT * 
                FROM amazon_books_db.books;
                """;

        try(
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
        ){
            while(resultSet.next()){
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String publisher = resultSet.getString("publisher");
                String language = resultSet.getString("language");
                Long isbn = resultSet.getLong("isbn");
                Double price = resultSet.getDouble("price");
                String amazonUrl = resultSet.getString("amazon_url");
                String imageUrl = resultSet.getString("image_url");

                books.add(new Books(title, author, publisher, language, isbn, price, amazonUrl, imageUrl));
            }
        }catch(SQLException e){
            log.error("Error while tyring to Display all Books: {}", e.getMessage());
        }
        return books;
    }

    @Override
    public List<Books> findBookById(Long id) {
        List<Books> books = new ArrayList<>();
        String sql = """
                SELECT *
                FROM amazon_books_db.books
                WHERE isbn = ?;
                """;

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setLong(1, id);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String publisher = resultSet.getString("publisher");
                    String language = resultSet.getString("language");
                    Long isbn = resultSet.getLong("isbn");
                    Double price = resultSet.getDouble("price");
                    String amazonUrl = resultSet.getString("amazon_url");
                    String imageUrl = resultSet.getString("image_url");

                    books.add(new Books(title, author, publisher, language, isbn, price, amazonUrl, imageUrl));
                }
            }
        }catch(SQLException e){
            log.error("Error while trying to Find Books using ISBN number: {}", e.getMessage());
        }
        return books;
    }

    @Override
    public List<Books> findBooksByTitle(String title) {
        List<Books> books = new ArrayList<>();
        String sql = """
                SELECT *
                FROM amazon_books_db.books
                WHERE title = ?;
                """;

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            preparedStatement.setString(1, title);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    String bookTitle = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String publisher = resultSet.getString("publisher");
                    String language = resultSet.getString("language");
                    Long isbn = resultSet.getLong("isbn");
                    Double price = resultSet.getDouble("price");
                    String amazonUrl = resultSet.getString("amazon_url");
                    String imageUrl = resultSet.getString("image_url");

                    books.add(new Books(bookTitle, author, publisher, language, isbn, price, amazonUrl, imageUrl));
                }
            }
        }catch(SQLException e){
            log.error("Error while tyring to Find books by Title: {}", e.getMessage());
        }
        return books;
    }

    @Override
    public List<Books> findBooksByAuthor(String author) {
        return List.of();
    }

    @Override
    public List<Books> searchByBooksByTitle(String titleKeyword) {
        return List.of();
    }

    @Override
    public List<Books> searchByBooksByAuthor(String authorKeyword) {
        return List.of();
    }

    @Override
    public List<Books> searchByPublisher(String publisher) {
        return List.of();
    }
}
