package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.controller.MatchController;
import com.edutech.progressive.entity.Match;

public class MatchDAOImpl implements MatchDAO {

    private MatchController matchController;

    public MatchDAOImpl(MatchController matchController) {
        this.matchController = matchController;
    }

    public MatchController getMatchController() {
        return matchController;
    }

    public void setMatchController(MatchController matchController) {
        this.matchController = matchController;
    }

    @Override
    public int addMatch(Match match) {
        return -1;
    }

    @Override
    public Match getMatchById(int matchId) {
        return null;
    }

    @Override
    public void updateMatch(Match match) {
        // statements
    }

    @Override
    public void deleteMatch(int matchId) {
        // statements
    }

    @Override
    public List<Match> getAllMatches() {
        List<Match> matches = new ArrayList<>();
        return matches;
    }

}
