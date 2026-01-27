package com.edutech.progressive.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edutech.progressive.entity.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long>{
    Long countByCategory(String category);

    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.team.teamId = :teamId")
    void deleteByTeamId(@Param("teamId") int teamId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.cricketer.cricketerId = :cricketerId")
    void deleteByCricketerId(@Param("cricketerId") int cricketerId);
}
