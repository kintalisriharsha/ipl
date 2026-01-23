package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Team;
import com.edutech.progressive.exception.TeamAlreadyExistsException;
import com.edutech.progressive.exception.TeamDoesNotExistException;
import com.edutech.progressive.service.impl.TeamServiceImplArraylist;
import com.edutech.progressive.service.impl.TeamServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    // @Autowired
    private TeamServiceImplArraylist teamServiceImplArraylist;

    // @Autowired
    private TeamServiceImplJpa teamServiceImplJpa;

    
    @Autowired
    public TeamController(TeamServiceImplArraylist teamServiceImplArraylist, TeamServiceImplJpa teamServiceImplJpa) {
        this.teamServiceImplArraylist = teamServiceImplArraylist;
        this.teamServiceImplJpa = teamServiceImplJpa;
    }

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        try {
            return new ResponseEntity<>(teamServiceImplJpa.getAllTeams(),HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);   
        }
    }

    @GetMapping("/{teamId}")
    public ResponseEntity<?> getTeamById(@PathVariable int teamId) {
        try {
            Team team  = teamServiceImplJpa.getTeamById(teamId);
            return new ResponseEntity<>(team ,HttpStatus.OK);
        } 
        catch(TeamDoesNotExistException te){
            return new ResponseEntity<>(te.getMessage(),HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }  

    @PostMapping
    public ResponseEntity<?> addTeam(@RequestBody Team team) {
        try {
            return new ResponseEntity<>(teamServiceImplJpa.addTeam(team),HttpStatus.CREATED);
        } 
        catch(TeamAlreadyExistsException te){
            return new ResponseEntity<>(te.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{teamId}")
    public ResponseEntity<?> updateTeam(@PathVariable int teamId, @RequestBody Team team) {
        try {
            team.setTeamId(teamId);
            teamServiceImplJpa.updateTeam(team);
            return new ResponseEntity<>(HttpStatus.OK);
        } 
        catch(TeamAlreadyExistsException te){
            return new ResponseEntity<>(te.getMessage(),HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable int teamId) {
        try {
            teamServiceImplJpa.deleteTeam(teamId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Team>> getAllTeamsFromArrayList() {
        return new ResponseEntity<>(teamServiceImplArraylist.getAllTeams(),HttpStatus.OK);
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addTeamToArrayList(@RequestBody Team team) {
        return new ResponseEntity<>(teamServiceImplArraylist.addTeam(team),HttpStatus.CREATED);
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Team>> getAllTeamsSortedByNameFromArrayList() {
        return new ResponseEntity<>(teamServiceImplArraylist.getAllTeamsSortedByName(),HttpStatus.OK);
    }
}

