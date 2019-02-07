package com.tayo.working.demo.dao;

import com.tayo.working.demo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Long> {
}
