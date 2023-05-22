/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;


import java.io.Serializable;
import java.util.Date;
public class Match implements Serializable {
    private Team teamA;
 private Team teamB;
 private int teamAScore;
 private int teamBScore;
 private int MatchID;
 private String Football_Referee;
 private String Stadium_Name;
 private Date date;

    public int getMatchID() {
        return MatchID;
    }

    public void setMatchID(int MatchID) {
        this.MatchID = MatchID;
    }

    public String getFootball_Referee() {
        return Football_Referee;
    }

    public void setFootball_Referee(String Football_Referee) {
        this.Football_Referee = Football_Referee;
    }

    public String getStadium_Name() {
        return Stadium_Name;
    }

    public void setStadium_Name(String Stadium_Name) {
        this.Stadium_Name = Stadium_Name;
    }

  public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public int getTeamAScore() {
        return teamAScore;
    }

    public void setTeamAScore(int teamAScore) {
        this.teamAScore = teamAScore;
    }

    public int getTeamBScore() {
        return teamBScore;
    }

    public void setTeamBScore(int teamBScore) {
        this.teamBScore = teamBScore;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
