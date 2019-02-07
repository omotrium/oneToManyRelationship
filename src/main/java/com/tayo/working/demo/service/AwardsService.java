package com.tayo.working.demo.service;

import com.tayo.working.demo.dao.AwardsDao;
import com.tayo.working.demo.entity.Awards;
import com.tayo.working.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AwardsService {

    @Autowired
    AwardsDao awardsDao;

    public void delete(Long awardsId) {

        awardsDao.deleteById(awardsId);
    }

    public List<Awards> getAwards() {
        return awardsDao.findAll();
    }

    public Awards createAwards(Awards awards) {
        return awardsDao.save(awards);
    }

    public Awards updateAwards(Awards awards) {
        return awardsDao.save(awards);
    }

    public Optional<Awards> getAwardsById(Long awardsId) {



            return awardsDao.findById(awardsId);
        }


}
