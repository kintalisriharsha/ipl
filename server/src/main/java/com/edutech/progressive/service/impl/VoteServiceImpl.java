package com.edutech.progressive.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Vote;
import com.edutech.progressive.repository.VoteRepository;

@Service
public class VoteServiceImpl  {
    private VoteRepository voteRepository;

    @Autowired
    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Vote> getAllVotes(){
        return voteRepository.findAll();
    }

    public Integer createVote(Vote vote){
        return voteRepository.save(vote).getVoteId();
    }

    public Map<String, Long> getVotesCountOfAllCategories(){
        Map<String, Long> countsMap = new HashMap<>();
        List<String> categories = List.of("Team","Batsman","Bowler","All-rounder","Wicketkeeper");
        for (String category : categories) {
            Long count = voteRepository.countByCategory(category);
            countsMap.put(category, count);
        }
        return countsMap;
    }
}