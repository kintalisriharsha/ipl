package com.edutech.progressive.service.impl;

import java.util.List;

import com.edutech.progressive.dao.TeamDAO;
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.TeamService;

public class TeamServiceImplJdbc implements TeamService {
    private TeamDAO teamDAO;

    public TeamServiceImplJdbc(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @Override
    public List<Team> getAllTeams() {
        return teamDAO.getAllTeams();
    }

    @Override
    public int addTeam(Team team) {
        return teamDAO.addTeam(team);
    }

    @Override
    public List<Team> getAllTeamsSortedByName() {
        return List.of();
    }
    
    
}