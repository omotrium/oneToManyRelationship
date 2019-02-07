package com.tayo.working.demo.dao;

import com.tayo.working.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long> {
}
