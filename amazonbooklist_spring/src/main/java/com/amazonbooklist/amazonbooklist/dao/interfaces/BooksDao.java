package com.amazonbooklist.amazonbooklist.dao.interfaces;

import com.amazonbooklist.amazonbooklist.models.Books;

import java.util.List;

public interface BooksDao {
    //Read operations
    List<Books> findAll();
    List<Books> findBookById(Long id);
    List<Books> findBooksByTitle(String title);
    List<Books> findBooksByAuthor(String author);

    //Search operations
    List<Books> searchBooksByTitle(String titleKeyword);
    List<Books> searchBooksByAuthor(String authorKeyword);
    List<Books> searchPublisher(String publisher);
}
