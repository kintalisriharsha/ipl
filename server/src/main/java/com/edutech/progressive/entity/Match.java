package com.edutech.progressive.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matchId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "first_team_id")
    private Team firstTeam;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "second_team_id")
    private Team secondTeam;

    @Temporal(TemporalType.DATE)
    private Date matchDate;
    
    private String result;
    private String venue;
    private String status;

    @ManyToOne
    @JoinColumn(name = "winner_team_id")
    private Team winnerTeam;

    public Match() {
    }

    public Match(int matchId, int firstTeamId, int secondTeamId, Date matchDate, String result, String venue,
            String status, int winnerTeamId) {
        this.matchId = matchId;
        this.firstTeam.setTeamId(firstTeamId);
        this.secondTeam.setTeamId(secondTeamId);
        this.matchDate = matchDate;
        this.result = result;
        this.venue = venue;
        this.status = status;
        this.winnerTeam.setTeamId(winnerTeamId);
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Team getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(Team winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

}
