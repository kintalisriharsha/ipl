package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Team;
import com.edutech.progressive.exception.TeamAlreadyExistsException;
import com.edutech.progressive.exception.TeamDoesNotExistException;
import com.edutech.progressive.repository.TeamRepository;
import com.edutech.progressive.service.TeamService;

@Service
public class TeamServiceImplJpa implements TeamService {

    private TeamRepository teamRepository;
    
    @Autowired
    public TeamServiceImplJpa(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> getAllTeams() throws SQLException {
        return teamRepository.findAll();
    }

    @Override
    public int addTeam(Team team) throws SQLException {
        // if(getTeamById(team.getTeamId()) != null){
        //     throw new TeamAlreadyExistsException("Team already exists");
        // }
        return teamRepository.save(team).getTeamId();
    }

    @Override
    public List<Team> getAllTeamsSortedByName() throws SQLException {
        List<Team> teams = getAllTeams();
        teams.sort(Comparator.comparing(Team::getTeamName));
        return teams;
    }

    public Team getTeamById(int teamId) throws SQLException {
        return teamRepository.findByTeamId(teamId);
    }

    @Override
    public void updateTeam(Team team) throws SQLException {
        Team teamDetails = getTeamById(team.getTeamId());
        if(teamDetails != null){
            teamDetails.setTeamName(team.getTeamName());
            teamDetails.setOwnerName(team.getOwnerName());
            teamDetails.setLocation(team.getLocation());
            teamDetails.setEstablishmentYear(team.getEstablishmentYear());
            teamRepository.save(teamDetails);
        }
        // else{
        //     throw new TeamDoesNotExistException();
        // }
    }

    @Override
    public void deleteTeam(int teamId) throws SQLException {
        teamRepository.deleteById(teamId);
    }
}

