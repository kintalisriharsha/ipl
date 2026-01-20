package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.repository.CricketerRepository;
import com.edutech.progressive.service.CricketerService;

@Service
public class CricketerServiceImplJpa implements CricketerService {
    private CricketerRepository cricketerRepository;

    @Autowired
    public CricketerServiceImplJpa(CricketerRepository cricketerRepository) {
        this.cricketerRepository = cricketerRepository;
    }

    @Override
    public List<Cricketer> getAllCricketers() throws SQLException {
        return cricketerRepository.findAll();
    }

    @Override
    public Integer addCricketer(Cricketer cricketer) throws SQLException {
        cricketerRepository.save(cricketer);
        return getAllCricketers().size();
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() throws SQLException {
        return cricketerRepository.findAllByOrderByExperienceAsc();
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) throws SQLException{
        return cricketerRepository.findById(cricketerId).get();
    }
    
    @Override
    public void updateCricketer(Cricketer cricketer) throws SQLException{
        Cricketer cricketerDetails = getCricketerById(cricketer.getCricketerId());
        cricketerDetails.setCricketerId(cricketer.getCricketerId());
        cricketerDetails.setTeamId(cricketer.getTeamId());
        cricketerDetails.setCricketerName(cricketer.getCricketerName());
        cricketerDetails.setAge(cricketer.getAge());
        cricketerDetails.setNationality(cricketer.getNationality());
        cricketerDetails.setRole(cricketer.getRole());
        cricketerDetails.setTotal_runs(cricketer.getTotal_runs());
        cricketerDetails.setTotalWickets(cricketer.getTotalWickets());
        cricketerRepository.save(cricketerDetails);
    }

    @Override
    public void deleteCricketer(int cricketerId) throws SQLException{
        cricketerRepository.deleteById(cricketerId);
    }

    @Override
    public List<Cricketer> getCricketersByTeam(int teamId) throws SQLException{
        return cricketerRepository.findByTeamId(teamId);
    }

}

