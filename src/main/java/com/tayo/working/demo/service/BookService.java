package com.tayo.working.demo.service;


import com.tayo.working.demo.dao.AuthorDao;
import com.tayo.working.demo.dao.BookDao;
import com.tayo.working.demo.entity.Author;
import com.tayo.working.demo.entity.Book;
import com.tayo.working.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    @Autowired
    AuthorDao authorDao;

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }


    public Optional<Book> getBookById(Long bookId) {
        if (!bookDao.existsById(bookId)) {
            throw new ResourceNotFoundException("Book with id " + bookId + " not found");
        }
        return bookDao.findById(bookId);
    }


    public Book createBook(Long authorId, Book book) {
        Set<Book> books = new HashSet<>();
        Author author1 = new Author();

        Optional<Author> byId = authorDao.findById(authorId);
        if (!byId.isPresent()) {
            throw new ResourceNotFoundException("Author with id " + authorId + " does not exist");
        }
        Author author = byId.get();

        //tie Author to Book
        book.setAuthor(author);

        Book book1 = bookDao.save(book);
        //tie Book to Author
        books.add(book1);
        author1.setBooks(books);

        return book1;

    }

    public void delete(Long bookId) {
        bookDao.deleteById(bookId);
    }

    public Book updateBook(Book book) {
        return bookDao.save(book);
    }
}
