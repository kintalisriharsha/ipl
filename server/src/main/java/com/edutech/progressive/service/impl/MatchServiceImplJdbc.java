package com.edutech.progressive.service.impl;

import java.util.List;

import com.edutech.progressive.dao.MatchDAO;
import com.edutech.progressive.entity.Match;
import com.edutech.progressive.service.MatchService;

public class MatchServiceImplJdbc implements MatchService {
    private MatchDAO matchDAO;

    public MatchServiceImplJdbc(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    @Override
    public List<Match> getAllMatches() {
        return matchDAO.getAllMatches();
    }

    @Override
    public Match getMatchById(int matchId) {
        return matchDAO.getMatchById(matchId);
    }

    @Override
    public Integer addMatch(Match match) {
        return matchDAO.addMatch(match);
    }

    @Override
    public void updateMatch(Match match) {
        matchDAO.updateMatch(match);
    }

    @Override
    public void deleteMatch(int matchId) {
        matchDAO.deleteMatch(matchId);
    }
    
}