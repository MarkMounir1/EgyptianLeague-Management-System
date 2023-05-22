/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.io.Serializable;

/**
 *
 * @author LEGION
 */
public class Player implements Serializable{
    private String playerposition;
    private String playername;
    private int playerage;
    private int playernumber;
    private String playerteam;
    private int playerscore;
    private int playerRank;


    public String getPlayerposition() {
        return playerposition;
    }

    public void setPlayerposition(String playerposition) {
        this.playerposition = playerposition;
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public int getPlayerage() {
        return playerage;
    }

    public void setPlayerage(int playerage) {
        this.playerage = playerage;
    }

    public int getPlayernumber() {
        return playernumber;
    }

    public void setPlayernumber(int playernumber) {
        this.playernumber = playernumber;
    }

    public String getPlayerteam() {
        return playerteam;
    }

    public void setPlayerteam(String playerteam) {
        this.playerteam = playerteam;
    }

    

    public int getPlayerscore() {
        return playerscore;
    }

    public void setPlayerscore(int playerscore) {
        this.playerscore = playerscore;
    }

   

    

    public int getPlayerRank() {
        return playerRank;
    }

    public void setPlayerRank(int playerRank) {
        this.playerRank = playerRank;
    
}
}
