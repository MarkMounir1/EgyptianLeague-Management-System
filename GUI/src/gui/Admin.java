/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.PrintWriter;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Admin  implements Serializable  {
        protected  int numberofteams;
 protected  ArrayList<Team> league;
  protected ArrayList<Player> p1;
   protected ArrayList<Match>matches;

  Scanner input=new Scanner (System.in);
    
     public Admin (int numberofteams) throws FileNotFoundException, IOException, ClassNotFoundException{
         this.numberofteams=numberofteams;
       league = new ArrayList<>();
       p1 = new ArrayList<>();
         matches=new ArrayList<>();
        
         
        //displaymenue(); 
        
        
          
          
       
    }
    
        //Menue
     /////////////////////////////
     

 public void displaymenue() throws FileNotFoundException, IOException, ClassNotFoundException{
     
     
             
 
    while(true) {
       
// 
// ObjectInputStream in1= new ObjectInputStream (new FileInputStream( "D:\\NB\\LMS#1\\Team.bin"));
//  
//       
//        league= (ArrayList<Team>) in1.readObject();
//        
//        ObjectInputStream in2= new ObjectInputStream (new FileInputStream( "D:\\NB\\LMS#1\\Player.bin"));
//       
//        p1 = (ArrayList<Player>) in2.readObject();
        
      
          
          

        
        
            
            System.out.println("");
          System.out.println("To enter team information press (1) ");
          System.out.println("To display team information press (2) ");
            System.out.println("To Edit team information press (3) ");
            System.out.println("To Search for a team  press (4) ");
            System.out.println("To display all matches for certain team press(5)");
            System.out.println("To enter  player information press (6) ");
              System.out.println("To display player information press (7) ");
               System.out.println("To search for a player press (8)  ");
              System.out.println("To update an information for a player press (9)  ");
               System.out.println("To Add a played Match information press (10) ");
               System.out.println("To Display Played Match press (11)");
               System.out.println("To show league table press(12)");
                  System.out.println("To show teams with the most goals(13)");
                   System.out.println("To display players with most goals(14)");
                        System.out.println("To display players with the higher rank(15)");
           System.out.println("To Exit press (0) ");
          int x=input.nextInt();
          
      if(x==1)
       
          enterinfo();
       
      else if (x==2)
          diplayinfo();
      else if (x==3)
          editTeam();
      else if(x==4)
          searchTeam();
      else if(x==5)
          displayteammatches();
      else if (x==6)
          Add_player_information();
      else if (x==7)
          display_player_information();
         else if (x==8)
          Search_for_player();
      else if (x==9)
          Update_Player_Information();
         else if(x==10)
          Add_Played_Match();
         else if (x==11)
             Display_Played_Match();
        else if (x==12)
              sortpoints();
        else if(x==13)
            SortteamGoals();
   
        else if(x==14)
            sortplayersgoals();
        else if(x==15)
            sortplayerrank();
            
                
         
         else if (x==0)
               
       System.exit(0);
      else
             System.out.println("Wrong input");
      
      
      
 
      }
        
        
        
    
}
 
	

 
 
 
 
 //--------------------------------------------------------------------------
 //Teams
 ////////////////////////
   protected  void  enterinfo() throws FileNotFoundException, IOException {
      
       
     ObjectOutputStream o1= new ObjectOutputStream (new FileOutputStream("D:\\NB\\LMS#1\\Team.bin"));
          Team t1= new Team();
  
       boolean done=true; 
        
        if(league.size() == numberofteams) {
            System.out.println("Can't add more clubs to league");
            return;
        }
        
     
        System.out.println("Enter Club Name: ");
        t1.setName(input.next());
        System.out.println("Enter team id: ");
          do
          {
          try    
          {
         
           t1.setId(input.nextInt());
          done=false;
          }
          catch(InputMismatchException ex)
        {
            System.out.println(" Invalid input..An integer is required");
        input.next();
            System.out.println(" Enter team id again:");
            System.out.println("    ");
        }
        }while(done);
         
      
          System.out.println("Enter team's captain: ");
         t1.setCaptain(input.next());
      
         
         league.add(t1);
         
         o1.writeObject(league);
         
          
          
         
        
        
    }
  protected void diplayinfo() throws FileNotFoundException, IOException, ClassNotFoundException {
      
       
      
      
      
      System.out.println("Insert club name: ");
       String line = input.next();
     
         for(Team club :league)
         {
           
             if(club.getName().equals(line))
             
              {
                   System.out.println("team name: "+club.getName());
                System.out.println("team id: "+club.getId());
                   System.out.println("team captain: "+club.getCaptain());
                   System.out.println("Team Players: ");
                  for(Player p :p1)
                  {
                      if(p.getPlayerteam().equals(line))
                         System.out.println(p.getPlayername());
                  }
                   return;
              }
        }
         
           System.out.println("This team is not in the league");

   
     
      
         
  }
    private void editTeam() throws IOException{
        
        
        
      System.out.println("Which club do you want to edit on: ");
        String line = input.next();
        int int1;
        boolean done=true;
        
            for (Team club : league) {
             if(club.getName().equals(line))
             {
                 System.out.println("What do you want to edit :");   
                 System.out.println("1-team name ");
                 System.out.println("2-team id ");
                 System.out.println("3-team capain "); 
                 
                 int int2=input.nextInt();
                 
                 if(int2==1)
                 {
                  System.out.println("Enter the new Club Name: ");
                   line = input.next();
                   club.setName(line);
                 }
                
                 else if(int2==2)
                 {
                     do{
                     try    
                     {
                   System.out.println("Enter  the new team id: ");
                    int1 =input.nextInt();
                    club.setId(int1);
                    done=false;
                     }
                     catch(InputMismatchException ex)
        {
            System.out.println(" Invalid input..An integer is required");
        input.next();
            System.out.println("    ");
        }
        }while(done);
                 }
                        
                   else if(int2==3)
                   {
                      System.out.println("Enter the newteam's captain: ");
          
                      line =input.next();
                      club.setCaptain(line);
                   }
              
            
          
               
             
             
       ObjectOutputStream o1= new ObjectOutputStream (new FileOutputStream("D:\\NB\\LMS#1\\Team.bin"));
       o1.writeObject(league);
       return;
            }
             
                
  }
             System.out.println("This team is not in the league");
    }
  
  private void searchTeam(){
       boolean done=true; 
       System.out.println("Would you like to search with the team's name or id? ");
      System.out.println("1-name 2-ID");
      int x;
       x=input.nextInt();
      if(x==1)
      {
          System.out.println("Enter the team's name: ");
        String line=input.next();
      for(Team club:league)
      {
           if(club.getName().equals(line))
           {
               System.out.println("team name: "+club.getName());
          System.out.println("team id: "+club.getId());
          System.out.println("team captain: "+club.getCaptain());
           System.out.println("Team's players: "+club.getP3()); 
           
            return;
           }
         
          
      }  
        System.out.println("This team is not in the league");
          
      }
      else if(x==2)
      {
         
          do
        {
        try    
        {
           System.out.println("Enter the team's ID:");
      x=input.nextInt();
        done=false;
        }
        catch(InputMismatchException ex)
        {
            System.out.println(" Invalid input..An integer is required");
        input.next();
            System.out.println("    ");
        }
        }while(done);
         
          for(Team club:league)
      {
           if(club.getId()==x)
           {
            System.out.println("team name: "+club.getName());
          System.out.println("team id: "+club.getId());
          System.out.println("team captain: "+club.getCaptain());
           System.out.println("Team's players: "+club.getP3()); 
            return;
           }
          
          
      }
            System.out.println("This team is not in the league");
      
  }
  }
  private void displayteammatches(){
      
      System.out.println("Enter name of team ");
      String line=input.next();
      for(Match match:matches){
          if(match.getTeamA().getName().equals(line) ||match.getTeamB().getName().equals(line))
          {
           //System.out.println("The date: "+match.getDate());
           System.out.println("Match ID:  "+match.getMatchID());
           System.out.println("Referee Name: "+ match.getFootball_Referee());
           System.out.println("Stadium Name: "+ match.getStadium_Name());
           System.out.println("The home team: "+match.getTeamA().getName());
           System.out.println("The away team: "+match.getTeamB().getName());
           System.out.println("The score: ");
           System.out.println(match.getTeamA().getName()+": "+match.getTeamAScore()+" "+match.getTeamB().getName()+": "+ match.getTeamBScore());
        return;
              
          }
      }
        System.out.println("This team is not in the league");
      
  }
  
  
  
  //----------------------------------------------------------------
  //Players
  //----------------------------------------------------------------
   private void Add_player_information() throws IOException
    {
        
        ObjectOutputStream o2= new ObjectOutputStream (new FileOutputStream("D:\\NB\\LMS#1\\Player.bin"));
        Player player1= new Player();

          boolean done=true;
        
      
      
        System.out.println("\nEnter the player's information");
        System.out.println("Insert the Player's name:");
        player1.setPlayername(input.next());
       
        //------------------------------------------------------
      do
        {
        try{
        System.out.println("Insert the Player's age:");
         player1.setPlayerage(input.nextInt());
        done=false;
        }
        catch(InputMismatchException ex)
        {
            System.out.println(" Invalid input..An integer is required");
        input.next();
            System.out.println("    ");
        }
        }while(done);
       
       
        //-----------------------------------------------------
       done=true;
        do
        {
        try{
        System.out.println("Insert the Player's number:");
           player1.setPlayernumber(input.nextInt());
        done=false;
        }
        catch(InputMismatchException ex)
        {
            System.out.println(" Invalid input..An integer is required");
        input.next();
            System.out.println("    ");
        }
        }while(done);
    
      
        //-----------------------------------------------------
        System.out.println("Insert the Player's position:");
         player1.setPlayerposition(input.next());
       
        //----------------------------------------------------
         System.out.println("Insert the Player's team:");
        player1.setPlayerteam(input.next());
        
        

       //----------------------------------------------------
        done=true;
        do
        {
        try{
        System.out.println("Insert the Player's score:");
         player1.setPlayerscore(input.nextInt());
        done=false;
        }
        catch(InputMismatchException ex)
        {
            System.out.println(" Invalid input..An integer is required");
        input.next();
            System.out.println("    ");
        }
        }while(done);
      
       
        //----------------------------------------------------
        done =true;
        do
        {
        try{    
        
        System.out.println("Insert the Player's rank:");
            player1.setPlayerRank(input.nextInt());
        done=false;
        }
        catch(InputMismatchException ex)
        {
            System.out.println(" Invalid input..An integer is required");
        input.next();
            System.out.println("    ");
        }
        }while(done);
  
      
        //----------------------------------------------------
        
       p1.add(player1);
       o2.writeObject(p1);
        
       
         
    }
   private void display_player_information() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        
     
        
        
        System.out.println("Insert plaer name: ");
         String line = input.next();
      
         
     for(Player player1:p1)
     {
    
             if(player1.getPlayername().equals(line)){
         System.out.println("The player's name is:"+" "+player1.getPlayername ());
        System.out.println("The player's age is:"+" "+player1.getPlayerage());
        System.out.println("The player's number is:"+" "+player1.getPlayernumber());
        System.out.println("The player's position is:"+" "+player1.getPlayerposition());
        System.out.println("The player's team is:"+" "+player1.getPlayerteam());
        System.out.println("The player's score is:"+" "+player1.getPlayerscore() );
        System.out.println("The player's rank is:"+" "+player1.getPlayerRank() );
        return;
                 }
     
    }
       System.out.println("This Player is not found");
    }
    private   void Search_for_player()
    {
        int y=0; 
        boolean done=true; 
      
        System.out.println("Enter player's name to search for");
        String x=input.next();
         do
        {
        try    
        {
            System.out.println("Enter player's number to search for");
        y=input.nextInt();
        done=false;
        }
        catch(InputMismatchException ex)
        {
            System.out.println(" Invalid input..An integer is required");
        input.next();
            System.out.println("    ");
        }
        }while(done);
        System.out.println("Enter player's team to search for");
        String z=input.next();
       for(Player player1:p1)
        {
          if(player1.getPlayername().equals(x) && player1.getPlayerteam().equals(z) && player1.getPlayernumber()==y)
        {
        System.out.println("The player's name is:"+" "+player1.getPlayername ());
        System.out.println("The player's age is:"+" "+player1.getPlayerage());
        System.out.println("The player's number is:"+" "+player1.getPlayernumber());
        System.out.println("The player's position is:"+" "+player1.getPlayerposition());
        System.out.println("The player's team is:"+" "+player1.getPlayerteam());
        System.out.println("The player's score is:"+" "+player1.getPlayerscore() );
        System.out.println("The player's rank is:"+" "+player1.getPlayerRank() );
        return;
        }
        }
        System.out.println("This Player is not found");
       
    }
    private void Update_Player_Information() throws IOException
    {
         
        
       System.out.println("Enter the name of the player that you want to update his information:");
        String x= input.next();
        for(Player player1:p1)
        {
        if(player1.getPlayername().equals(x))
        {
            System.out.println("Press 1 to edit his age, 2 to edit his team, 3 to edit his rank, 4 to edit his score, 5 to edit his position, 6 to edit his number");
            int y = input.nextInt();
            //----------------------------
            if(y==1)
            {
                System.out.println("Enter the new age:");
            int z=input.nextInt();
            player1.setPlayerage(z);
            }
            //----------------------------
            else if (y==2)
            {
                System.out.println("Enter the new team:");
            String w=input.next();
         // Team club2=null;
            for(Team club:league)
            {
                if(club.getName().equals(w)){
                   
                    
                    player1.setPlayerteam(w);
                }
            }
          
            }
            //----------------------------
            else if(y==3)
            {
                System.out.println("Enter the new rank:");
               int a=input.nextInt();
               player1.setPlayerRank(a);
            }
            //-----------------------------
            else if(y==4)
            {
                System.out.println("Enter the new score:");
                int b=input.nextInt();
                player1.setPlayerscore(b);
            }
            //-----------------------------
            else if(y==5)
            {
                System.out.println("Enter the new position:");
                String c=input.next();
                player1.setPlayerposition(c);
            }
            //-----------------------------
            else if(y==6)
            {
                System.out.println("Enter the new number:");
                int d=input.nextInt();
                player1.setPlayernumber(d);
            }
            
        
          ObjectOutputStream o2= new ObjectOutputStream (new FileOutputStream("D:\\NB\\LMS#1\\Player.bin"));
          o2.writeObject(p1);
          return;
        }
        
    }
             System.out.println("This Player is not found");
    }
     
 
  
  //-----------------------------------------------------------------
  //Matches
  //-----------------------------------------------------------------
   private void Add_Played_Match() throws IOException{
        Match match=new Match();
     FileWriter  f1 =new FileWriter ("Matches.txt",true);
       PrintWriter o1= new PrintWriter(f1);
         String line;
          int homeGoals=0;
           int awayGoals=0;
          boolean done=true;
         int int3;
//       System.out.println("Enter Date in the form(mm-dd-yyyy)");
//         line=input.next();
//        Date date;
//        try {
//            date = new SimpleDateFormat("MM-dd-yyyy").parse(line);
//           o1.println(input.next());
//        } catch (ParseException ex) {
//            System.out.println("You have to enter date in format mm-dd-yyyy");
//            return;
//        }
          System.out.println("Enter Match ID");
         do
        {
        try{    
        
      
           o1.println(input.nextInt());
               done=false;

        }
        catch(InputMismatchException ex)
        {
            System.out.println(" Invalid input..An integer is required");
        input.next();
            System.out.println("Enter match ID again:");
            System.out.println("    ");
        }
        }while(done);
        
         
        System.out.println("Enter Match Referee");
        o1.println(input.next());
       
        System.out.println("Enter Match Stadium");
         o1.println(input.next());
        
        System.out.println("Enter Home Team: ");
        
         o1.println(input.next());
              System.out.println("Enter Away Team: ");
            o1.println(input.next());


         System.out.println("Enter home team goals: ");
         do
        {
        try{    
        
            homeGoals=input.nextInt();
           o1.println(homeGoals);
               done=false;

        }
       
        catch(InputMismatchException ex)
        {
            done=true;
            System.out.println(" Invalid input..An integer is required");
               input.next();
            System.out.println("Enter home team goals again:");
            System.out.println("    ");
         
        }
        }while(done);
        
        System.out.println("Enter away team goals: ");
        do{
        try    
        {
             awayGoals=input.nextInt();
       o1.println(awayGoals);
        
            done=false;
        }
            catch(InputMismatchException ex)
        {
               done=true;
            System.out.println(" Invalid input..An integer is required");
                        System.out.println("Enter away team goals again:");
        input.next();
            System.out.println("    ");
        }
        }while(done);
       
        if(awayGoals<0){
            System.out.println("you have to enter number of goals ");
            
        }
        
      
        
       
         
         o1.close();
         
         
       
         
                 
        
    } 
   private void Display_Played_Match(){
      for(Match match: matches)
       {
          // System.out.println("The date: "+match.getDate());
           System.out.println("Match ID:  "+match.getMatchID());
           System.out.println("Referee Name: "+ match.getFootball_Referee());
           System.out.println("Stadium Name: "+ match.getStadium_Name());
           System.out.println("The home team: "+match.getTeamA().getName());
           System.out.println("The away team: "+match.getTeamB().getName());
           System.out.println("The score: ");
           System.out.println(match.getTeamA().getName()+":"+match.getTeamAScore()+" "+match.getTeamB().getName()+":"+ match.getTeamBScore());
      
           
                                                       
       }
      
    
    
    
}
   public void sortpoints(){
           
        
        Collections.sort(league, new CustomComparator());
//        for(Team club : league) {
//            System.out.println(club.getName()+" Points: "+ club.getPoints() );
//            
//    }   
            
        }		
 
private void SortteamGoals(){
           
        
        Collections.sort(league, new TeamsbyGoals());
        for(Team club : league) {
            System.out.println(club.getName()+" number of Goals: "+ club.getScoredGoalsCount() );
            
    }   
            
        }
private void sortplayersgoals(){
           
          int i=0;
        Collections.sort(p1, new PlayersbyGoals());
        for(Player p : p1) {
            System.out.println(p.getPlayername()+" number of goals scored: "+ p.getPlayerscore() );
            i++;
              if(i==3)
               break;
    }   
            
        }
private void sortplayerrank(){
           
          int i=0;
        Collections.sort(p1, new PlayersbyRank());
        for(Player p : p1) {
            System.out.println(p.getPlayername()+"'s rank: "+ p.getPlayerRank() );
              i++;
              if(i==3)
               break;
    }   
            
        }
 
 
    
}
