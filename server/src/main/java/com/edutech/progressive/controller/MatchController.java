package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Match;
import com.edutech.progressive.service.impl.MatchServiceImplJpa;

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
@RequestMapping("/match")
public class MatchController {

    private MatchServiceImplJpa matchServiceImplJpa;

    @Autowired
    public MatchController(MatchServiceImplJpa matchServiceImplJpa) {
        this.matchServiceImplJpa = matchServiceImplJpa;
    }

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        try {
            return new ResponseEntity<>(matchServiceImplJpa.getAllMatches(), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{matchId}")
    public ResponseEntity<Match> getMatchById(@PathVariable int matchId) {
        try {
            return new ResponseEntity<>(matchServiceImplJpa.getMatchById(matchId), HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addMatch(@RequestBody Match match) {
        try {
            return new ResponseEntity<>(matchServiceImplJpa.addMatch(match), HttpStatus.CREATED);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{matchId}")
    public ResponseEntity<Void> updateMatch(@PathVariable int matchId, @RequestBody Match match) {
        try {
            matchServiceImplJpa.updateMatch(match);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{matchId}")
    public ResponseEntity<Void> deleteMatch(@PathVariable int matchId) {
        try {
            matchServiceImplJpa.deleteMatch(matchId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Match>> getAllMatchesByStatus(@PathVariable String status) {
        return new ResponseEntity<>(matchServiceImplJpa.getAllMatchesByStatus(status), HttpStatus.OK);
    }
}
