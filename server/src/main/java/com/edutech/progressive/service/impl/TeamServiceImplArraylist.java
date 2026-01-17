package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.TeamService;

public class TeamServiceImplArraylist implements TeamService {
    List<Team> teams = new ArrayList<>();

    @Override
    public List<Team> getAllTeams() {
        return teams;
    }

    @Override
    public int addTeam(Team team) {
        return -1;
    }

    @Override
    public List<Team> getAllTeamsSortedByName() {
        return teams;
    }
}