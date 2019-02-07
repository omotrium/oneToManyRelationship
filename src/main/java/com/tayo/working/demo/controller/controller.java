package com.tayo.working.demo.controller;


import com.tayo.working.demo.entity.Author;
import com.tayo.working.demo.entity.Awards;
import com.tayo.working.demo.exception.ResourceNotFoundException;
import com.tayo.working.demo.entity.Book;
import com.tayo.working.demo.service.AuthorService;
import com.tayo.working.demo.service.AwardsService;
import com.tayo.working.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class controller {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @Autowired
    AwardsService awardsService;

    //Author
    @RequestMapping(value = "/getAllAuthors", method = RequestMethod.GET)
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }

    @RequestMapping(value = "/author", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @RequestMapping(value = "/getAllBooks", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "author/{authorId}", method = RequestMethod.DELETE)
    public void deleteAuthor(@PathVariable("authorId") Long authorId){
        authorService.delete(authorId);
    }

    @RequestMapping(value = "/updateAuthor", method = RequestMethod.PUT)
    public Author updateAuthor(@RequestBody Author author){
        return authorService.updateAuthor(author);
    }

    //Awards
    @RequestMapping(value = "/getAllAwards", method = RequestMethod.GET)
    public List<Awards> getAwards(){
        return awardsService.getAwards();
    }

    @RequestMapping(value = "/awards", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Awards createAwards(@RequestBody Awards awards) {
        return awardsService.createAwards(awards);
    }

    @RequestMapping(value = "/awards/{awardsId}", method = RequestMethod.GET)
    public Optional<Awards> getAwardsById(@PathVariable(value = "awardsId") Long awardsId) {
        return awardsService.getAwardsById(awardsId);
    }

    @RequestMapping(value = "awards/{awardsId}", method = RequestMethod.DELETE)
    public void deleteAwards(@PathVariable("awardsId") Long awardsId){
        awardsService.delete(awardsId);
    }

    @RequestMapping(value = "/updateAwards", method = RequestMethod.PUT)
    public Awards updateAwards(@RequestBody Awards awards){
        return awardsService.updateAwards(awards);
    }




    //Book
    @RequestMapping(value = "/{authorId}/book", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book createBook(@PathVariable(value = "authorId") Long authorId, @RequestBody Book book) {
        return bookService.createBook(authorId, book);
    }

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public Optional<Book> getBookById(@PathVariable(value = "bookId") Long bookId) {
        return bookService.getBookById(bookId);
    }

    @RequestMapping(value = "/delete/{bookId}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable("bookId") Long bookId){
        bookService.delete(bookId);
    }

    @RequestMapping(value = "/updateBook", method = RequestMethod.PUT)
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }





}
