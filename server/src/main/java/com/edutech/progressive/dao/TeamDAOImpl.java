package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.controller.TeamController;
import com.edutech.progressive.entity.Team;

public class TeamDAOImpl implements TeamDAO {
    private TeamController teamController;

    public TeamDAOImpl(TeamController teamController) {
        this.teamController = teamController;
    }

    public TeamController getTeamController() {
        return teamController;
    }

    public void setTeamController(TeamController teamController) {
        this.teamController = teamController;
    }

    @Override
    public int addTeam(Team team) {
        return -1;
    }

    @Override
    public Team getTeamById(int teamId) {
        return null;
    }

    @Override
    public void updateTeam(Team team) {
        // statements
    }

    @Override
    public void deleteTeam(int teamId) {
        // statements
    }

    @Override
    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();
        return teams;
    }
    
}
