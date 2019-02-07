package com.tayo.working.demo.dao;

import com.tayo.working.demo.entity.Awards;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AwardsDao extends JpaRepository<Awards, Long> {

}
