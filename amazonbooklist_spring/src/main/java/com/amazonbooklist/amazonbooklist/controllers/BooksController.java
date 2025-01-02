package com.amazonbooklist.amazonbooklist.controllers;

import com.amazonbooklist.amazonbooklist.dao.interfaces.BooksDao;
import com.amazonbooklist.amazonbooklist.models.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/isbn/{isbn}")
    public List<Books> getBooksByIsbn(@PathVariable Long isbn){
        List<Books> books = booksDao.findBookById(isbn);
        return books;
    }

    @GetMapping("/title/{title}")
    public List<Books> getBooksByTitle(@PathVariable String title){
        List<Books> books = booksDao.findBooksByTitle(title);
        return books;
    }

    @GetMapping("/author/{author}")
    public List<Books> getBooksByAuthor(@PathVariable String author){
        List<Books> books = booksDao.findBooksByAuthor(author);
        return books;
    }

    @GetMapping("/search/title/{titleKeyword}")
    public List<Books> searchBooksByTitle(@PathVariable String titleKeyword){
        List<Books> books = booksDao.searchBooksByTitle(titleKeyword);
        return books;
    }
}
