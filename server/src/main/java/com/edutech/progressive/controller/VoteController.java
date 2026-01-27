package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Vote;
import com.edutech.progressive.service.impl.VoteServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vote")
public class VoteController {
    private VoteServiceImpl voteService;
    
    @Autowired  
    public VoteController(VoteServiceImpl voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    public ResponseEntity<List<Vote>> getAllVotes() {
        return new ResponseEntity<>(voteService.getAllVotes(),HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Integer> createVote(Vote vote) {
        return new ResponseEntity<>(voteService.createVote(vote),HttpStatus.CREATED);
    }

    @GetMapping("/count")
    // Each key (k) represents a category (categories - “Team”, “Batsman”, “Bowler”, “All-rounder” and “Wicketkeeper”)
    // and each value (v) represents the total number of votes for that category.
    public ResponseEntity<Map<String, Long>> getVotesCountOfAllCategories() {
        return new ResponseEntity<>(voteService.getVotesCountOfAllCategories(),HttpStatus.OK);
    }
}
