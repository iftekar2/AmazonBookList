package com.amazonbooklist.amazonbooklist.controllers;

import com.amazonbooklist.amazonbooklist.dao.interfaces.BooksDao;
import com.amazonbooklist.amazonbooklist.models.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final BooksDao booksDao;

    @Autowired
    public BooksController(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    @GetMapping()
    public List<Books> getAllBooks(){
        List<Books> books = booksDao.findAll();
        return books;
    }
}
