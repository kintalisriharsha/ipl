package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.repository.CricketerRepository;

public class CricketerDAOImpl implements CricketerDAO {

    private CricketerRepository cricketerRepository;

    @Autowired
    public CricketerDAOImpl(CricketerRepository cricketerRepository) {
        this.cricketerRepository = cricketerRepository;
    }

    
    public CricketerRepository getCricketerRepository() {
        return cricketerRepository;
    }
    
    public void setCricketerRepository(CricketerRepository cricketerRepository) {
        this.cricketerRepository = cricketerRepository;
    }
    
    @Override
    public int addCricketer(Cricketer cricketer) {
        return -1;
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) {
        return null;
    }

    @Override
    public void updateCricketer(Cricketer cricketer) {
        //statements
    }

    @Override
    public void deleteCricketer(int cricketerId) {
        //statements
    }

    @Override
    public List<Cricketer> getAllCricketers() {
        List<Cricketer> cricketers = new ArrayList<>();
        return cricketers;
    }

}
