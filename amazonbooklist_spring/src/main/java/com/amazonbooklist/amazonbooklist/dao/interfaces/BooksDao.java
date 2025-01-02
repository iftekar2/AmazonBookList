package com.amazonbooklist.amazonbooklist.dao.interfaces;

import com.amazonbooklist.amazonbooklist.models.Books;

import java.util.List;
import java.util.Optional;

public interface BooksDao {
    //Read operations
    List<Books> findAll();
    List<Books> findBookById(Long id);
    List<Books> findBooksByTitle(String title);
    List<Books> findBooksByAuthor(String author);

    //Search operations
    List<Books> searchByBooksByTitle(String titleKeyword);
    List<Books> searchByBooksByAuthor(String authorKeyword);
    List<Books> findBooksByPriceRange(int minPrice, int maxPrice);
}
