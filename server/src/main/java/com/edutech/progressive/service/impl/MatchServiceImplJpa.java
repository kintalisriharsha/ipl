package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Match;
import com.edutech.progressive.repository.MatchRepository;
import com.edutech.progressive.service.MatchService;

@Service
public class MatchServiceImplJpa implements MatchService{

    private MatchRepository matchRepository;

    @Autowired
    public MatchServiceImplJpa(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public List<Match> getAllMatches() throws SQLException {
        return matchRepository.findAll();
    }

    @Override
    public Match getMatchById(int matchId) throws SQLException {
        return matchRepository.findByMatchId(matchId);
    }

    @Override
    public Integer addMatch(Match match) throws SQLException {
        return matchRepository.save(match).getMatchId();
    }

    @Override
    public void updateMatch(Match match) throws SQLException {
        // Match matchDetails = getMatchById(match.getMatchId());
        // matchDetails.setMatchId(match.getMatchId());
        // matchDetails.setFirstTeamId(match.getFirstTeam().getTeamId());
        // matchDetails.setSecondTeamId(match.getSecondTeamId());
        // matchDetails.setMatchDate(match.getMatchDate());
        // matchDetails.setVenue(match.getVenue());
        // matchDetails.setResult(match.getResult());
        // matchDetails.setStatus(match.getStatus());
        // matchDetails.setWinnerTeamId(match.getWinnerTeamId());
        matchRepository.save(match);
    }

    @Override
    public void deleteMatch(int matchId) throws SQLException {
        matchRepository.deleteById(matchId);
    }

    @Override
    public List<Match> getAllMatchesByStatus(String status) {
        return matchRepository.findAllByStatus(status);
    }

}

