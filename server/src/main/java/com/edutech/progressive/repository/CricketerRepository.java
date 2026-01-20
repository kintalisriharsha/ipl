package com.edutech.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.core.CrudMethods;

import com.edutech.progressive.entity.Cricketer;

public interface CricketerRepository extends JpaRepository<Cricketer, Integer> {
    List<Cricketer> findAllByOrderByExperienceAsc();
    List<Cricketer> findByTeamId(int teamId); //have to be done
}
