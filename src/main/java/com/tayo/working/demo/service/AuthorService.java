package com.tayo.working.demo.service;


import com.tayo.working.demo.dao.AuthorDao;
import com.tayo.working.demo.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorDao authorDao;

    public void delete(Long authorId) {
        authorDao.deleteById(authorId);
    }

    public List<Author> getAuthors() {
        return authorDao.findAll();
    }

    public Author createAuthor(Author author) {
        return authorDao.save(author);
    }

    public Author updateAuthor(Author author) {
        return authorDao.save(author);
    }
}
