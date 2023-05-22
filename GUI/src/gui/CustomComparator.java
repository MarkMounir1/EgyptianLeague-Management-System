/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.util.Comparator;

/**
 *
 * @author LEGION
 */
public class CustomComparator implements Comparator<Team> {

    @Override
    public int compare(Team t, Team t1) {
         if(t.getPoints() > t1.getPoints()) 
            return -1;
        else 
            if (t.getPoints() < t1.getPoints())
                return 1;
           
                
                  else return 0;
            }
        
     
    }

    


 class TeamsbyGoals implements Comparator<Team> {
    @Override
    public int compare(Team t1,Team t2)
    {
          if(t1.getScoredGoalsCount()>t2.getScoredGoalsCount())
          {
              return -1;
          }
          else if(t1.getScoredGoalsCount()<t2.getScoredGoalsCount())
          {
              return 1;
          }
          else return 0;
    }
   }

  class  Goalkeepercomparator implements Comparator<Player>{

    @Override
    public int compare(Player p1, Player p2) {
     if(p1.getPlayerscore()<p2.getPlayerscore())
        {
            return 1;
        }
        else if(p1.getPlayerscore()>p2.getPlayerscore())
        {
            return -1;
        }
        else return 0;
    }
  }

     
      class PlayersbyGoals implements Comparator<Player> {
    @Override
    public int compare(Player p1,Player p2)
     {
         if(p1.getPlayerscore()>p2.getPlayerscore())
         {
             return -1;
         }
         else if(p1.getPlayerscore()<p2.getPlayerscore())
         {
             return 1;
         } 
         else
             return 0;
     }
}

 class PlayersbyRank implements Comparator<Player> {
    @Override
    public int compare(Player p1,Player p2)
    {
           if(p1.getPlayerRank()>p2.getPlayerRank())
           {
               return 1;
           }
           else if(p1.getPlayerRank()<p2.getPlayerRank())
           {
               return -1;
           }
           else return 0;
    }
 }
