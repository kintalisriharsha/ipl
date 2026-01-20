package com.edutech.progressive.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cricketer implements Comparable<Cricketer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cricketerId;
    private String cricketerName;
    private String nationality;
    private String role;
    private int totalWickets;
    private int teamId;
    private int age;
    private int experience;
    private int total_runs;

    public Cricketer() {
    }

    public Cricketer(int cricketerId, int teamId, String cricketerName, int age, String nationality, int experience,
            String role, int totalRuns, int totalWickets) {
        this.cricketerId = cricketerId;
        this.cricketerName = cricketerName;
        this.nationality = nationality;
        this.role = role;
        this.totalWickets = totalWickets;
        this.teamId = teamId;
        this.age = age;
        this.experience = experience;
        this.total_runs = totalRuns;
    }

    public int getCricketerId() {
        return cricketerId;
    }

    public void setCricketerId(int cricketerId) {
        this.cricketerId = cricketerId;
    }

    public String getCricketerName() {
        return cricketerName;
    }

    public void setCricketerName(String cricketerName) {
        this.cricketerName = cricketerName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public int compareTo(Cricketer o) {
        return Integer.compare(this.getExperience(), o.getExperience());
    }

    public int getTotal_runs() {
        return total_runs;
    }

    public void setTotal_runs(int total_runs) {
        this.total_runs = total_runs;
    }

}

