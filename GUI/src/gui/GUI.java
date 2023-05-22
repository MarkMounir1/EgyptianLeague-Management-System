/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui;

import javafx.scene.*;
import java.awt.Color;
import static java.awt.Color.GREEN;
import java.awt.Image;
import java.awt.Paint;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
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
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Control;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.util.Callback;
/**
 *
 * @author LEGION
 */
public class GUI  extends Application  {
    


    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)   {
        
     
         launch(args);
         
  
    }

                  
        
    @Override
    public void start(Stage stage) throws FileNotFoundException, IOException ,ClassNotFoundException {
            
   
   Admin adm= new Admin(10);
   


    
ObjectInputStream in1= new ObjectInputStream(new FileInputStream("Teams.bin"));

  adm.league=(ArrayList<Team>)in1.readObject();






        ObjectInputStream in2= new ObjectInputStream(new FileInputStream("Players.bin"));

adm.p1=(ArrayList<Player>)in2.readObject();


ObjectInputStream in3= new ObjectInputStream(new FileInputStream("Matches.bin"));

adm.matches=(ArrayList<Match>)in3.readObject();

       
        

    // --------- Main Border------------//
    BorderPane border= new BorderPane();
     border.getStylesheets().add("/CSS/background.css");
    stage.setTitle("League Management System");
    
      BorderPane border5 = new BorderPane();
                   border5.getStylesheets().add("/CSS/background.css");
    

  
    
    
   
    
    //------------------------Add Team grid -------------------//
        GridPane grid1=new GridPane();
    grid1.setPadding(new Insets(10));
    grid1.setVgap(100);
    grid1.setHgap(20);
    grid1.setAlignment(Pos.CENTER);
     Text txt2= new Text("Add New Team");
 txt2.setFont(Font.font("Courier", FontWeight.BOLD, 28)); 
    grid1.add(txt2,1,0);
    
         Label l1 = new Label("Team Name:");
         l1.setFont(Font.font("Arial", 22));
             TextField tx1 = new TextField();
        Label l2=new Label("Team ID:");
        l2.setFont(Font.font("Arial", 22));
        TextField tx2 = new TextField();
        Label l3= new Label("Team Captian:");
        l3.setFont(Font.font("Arial", 22));
        Button btn1=new Button("ADD");
        btn1.setFont(Font.font("Arial", 22));
        
        
         TextField tx3 = new TextField();
         grid1.add(l1, 0, 1);
         grid1.add(tx1, 1, 1);
         grid1.add(l2, 0, 2); 
   
         grid1.add(tx2, 1, 2);
         grid1.add(l3, 0, 3);
         grid1.add(tx3, 1, 3);
         grid1.add(btn1,3,4);
         
         ////actoin///-------------------------------------------------//
             
              
               
         btn1.setOnAction(e->{
             
     Team t1= new Team();
     
 
      
        t1.setName(tx1.getText());
   
       t1.setId(Integer.parseInt(tx2.getText()));
       
         t1.setCaptain(tx3.getText());
      
         
         adm.league.add(t1);
         
       
       try {
            ObjectOutputStream o1= new ObjectOutputStream (new FileOutputStream("Teams.bin"));
           o1.writeObject(adm.league);
          // o1.close();
           
       } catch (IOException ex) {
           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
       }
           
      
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Added Successfully");
                    alert.setContentText("");
                    alert.show();
                    
                    tx1.clear();
                    tx2.clear();
                    tx3.clear();


             
         ;});
                 
           
         
         
         
         
         
  ///////----------------------- Search Team Grid------------------/////////////


     
         GridPane grid3= new GridPane();
      grid3.setPadding(new Insets(10));
    grid3.setVgap(100);
    grid3.setHgap(20);
        grid3.setAlignment(Pos.CENTER);
     Text txt4= new Text("Search for a Team");
 txt4.setFont(Font.font("Courier", FontWeight.BOLD, 28)); 
    
     grid3.add(txt4,1,0);
    
    Label l101= new Label("Enter Team name");
      l101.setFont(Font.font("Arial", 22));
    TextField tf1= new TextField();
     Button b1= new Button("Search");
       b1.setFont(Font.font("Arial", 22));
   
       
    
    
    grid3.add(l101,0,1);
    grid3.add(tf1,1,1);
    grid3.add(b1,3,2);
    

    
    
    b1.setOnAction(e->{
            GridPane newgrid= new GridPane();
            newgrid.setPadding(new Insets(15));
                newgrid.setVgap(40);
    newgrid.setHgap(20);
    newgrid.setAlignment(Pos.TOP_CENTER);
                Scene scene1 = new Scene(newgrid);
                     scene1.getStylesheets().add("/CSS/background.css");
           

                Stage newWindow = new Stage();
                newWindow.setTitle("Team's details");
                
                   
               String line=tf1.getText();
      for(Team club:adm.league)
      {
           if(club.getName().equals(line))
           {
               Label lb11 = new Label("Team name: ");
               Label lb12 = new Label(club.getName());
                  Label lb13 = new Label("Team ID:");
                 Label lb14= new Label (""+club.getId());
               Label lb15 = new Label("Team Captain:");
           Label lb16 = new Label(club.getCaptain());
              Label lb17 = new Label( "Team's Players:");
              String st=club.getName();
              int i=3;
               for(Player p :adm.p1)
                  {
                      if(p.getPlayerteam().equals(st))
                      {
                          Label ll= new Label(p.getPlayername()+" ");
                           newgrid.add(ll,1,i);
                           ll.setFont(Font.font("Arial", 22));
                           i++;
                      }
                      
                         
                  }
        
            
          lb11.setFont(Font.font("Arial", 22));
          lb12.setFont(Font.font("Arial", 22));
               lb13.setFont(Font.font("Arial", 22));
           lb14.setFont(Font.font("Arial", 22));
           lb15.setFont(Font.font("Arial", 22));
            lb16.setFont(Font.font("Arial", 22));
           lb17.setFont(Font.font("Arial", 22));
      
           
             newgrid.add(lb11,0,0);
              newgrid.add(lb12,1,0);
               newgrid.add(lb13,0,1);
                newgrid.add(lb14,1,1);
                 newgrid.add(lb15,0,2);
                  newgrid.add(lb16,1,2);
                  newgrid.add(lb17,0,3);
        
                  
                    newWindow.setScene(scene1);
                newWindow.setMaximized(true);
                   newWindow.show();
                     tf1.clear();
                   return;
                 
            
         
           }
         
           
      }
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Team not Found");
                    alert.setContentText("");
                    alert.show();
                      tf1.clear();
      
   
    
        
        
        
        
        
        ;});
    
    
    
    
    
    
    
    
         
       /////--------------Update Team Grid-------------------///////  
         
       
          HBox hbx60 = new HBox();
        HBox hbx61 = new HBox();
      
        hbx60.setSpacing(10);
          hbx61.setSpacing(10);
                 
        GridPane grid5 = new GridPane();
        grid5.setPadding(new Insets(10, 10, 10, 10));
        grid5.setVgap(40);
        grid5.setHgap(20);
        grid5.setAlignment(Pos.TOP_CENTER);
       Text txt131= new Text("Update a Team");
    txt131.setFont(Font.font("Courier", FontWeight.BOLD, 28)); 
     grid5.add(txt131,0,0);
     
     
      Label lbl60 = new Label("Team Name:");

        lbl60.setFont(Font.font("Arial", 22));
        TextField txt601 = new TextField();
        
         Button butt601 = new Button("Edit Name");
        Button butt611 = new Button("Edit ID");
        Button butt621 = new Button("Edit Captain");
        hbx60.getChildren().addAll(butt601, butt611, butt621);

        grid5.add(hbx60, 0, 3);
        grid5.add(hbx61, 0, 2);


        hbx60.setSpacing(10);
        hbx60.setPadding(new Insets(6));

        hbx61.getChildren().add(lbl60);
        hbx61.getChildren().add(txt601);
        //********************Edit Team  Name**********************************        
        Label lb631 = new Label("Enter new Name:");
        lb631.setFont(Font.font("Arial", 22));
        TextField txt611 = new TextField();
        Button bt641 = new Button("Update");
        HBox hbx62= new HBox();
           hbx62.setSpacing(10);
            hbx62.getChildren().addAll(lb631,txt611);
        butt601.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                grid5.add(hbx62, 0, 4);
             
                grid5.add(bt641, 4, 6);

            }
        });
    
//********************Edit Team ID**********************************
        Label lb651 = new Label("Enter new ID:");
        lb651.setFont(Font.font("Arial", 22));
        TextField txt621 = new TextField();
        Button bt651 = new Button("Update");
          HBox hbx63= new HBox();
           hbx63.setSpacing(10);
        hbx63.getChildren().addAll(lb651,txt621);
        butt611.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                grid5.add(hbx63,0,4);
         
                grid5.add(bt651, 4, 6);
            }
        });
  
//********************Edit Player Captian**********************************
        Label lb661 = new Label("Enter new Captain:");
        lb661.setFont(Font.font("Arial", 22));
        TextField txt631 = new TextField();
        Button bt661 = new Button("Update");
         HBox hbx64= new HBox();
           hbx64.setSpacing(10);
        hbx64.getChildren().addAll(lb661,txt631);
        butt621.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                grid5.add(hbx64, 0, 4);

                grid5.add(bt661, 4, 6);
            }
        });
    
         
           //----------Actions--Upate team-------------------------------//
        bt641.setOnAction(e -> {

            String line4 = txt601.getText();
            for (Team t : adm.league) {
                if (t.getName().equals(line4)) {

                    t.setName(txt611.getText());

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                   alert.setHeaderText("Team name is updated");
               
                    alert.show();
                        try {
            ObjectOutputStream o1= new ObjectOutputStream (new FileOutputStream("Teams.bin"));
           o1.writeObject(adm.league);
          // o1.close();
           
       } catch (IOException ex) {
           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
       }
                           grid5.getChildren().remove(hbx62);
             
                grid5.getChildren().remove(bt641);
            txt601.clear();
             txt611.clear();
                    return;

                } 
                   
                
            }
             Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Error exist");
                    alert.setContentText("Team not found!!");
                    alert.show();
 
        });

        bt651.setOnAction(e -> {

            String line5 = txt601.getText();
            for (Team t : adm.league) {
                if (t.getName().equals(line5)) {

                    t.setId(Integer.parseInt(txt621.getText()));

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Team ID is updated");
                    alert.setContentText("");
                    alert.show();
                        try {
            ObjectOutputStream o1= new ObjectOutputStream (new FileOutputStream("Teams.bin"));
           o1.writeObject(adm.league);
          // o1.close();
           
       } catch (IOException ex) {
           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
       }
                       grid5.getChildren().remove(hbx63);
               
                grid5.getChildren().remove(bt651);
                  txt601.clear();
                  txt621.clear();
                    return;

                } 
                  
                
            }
              Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("\"Team not found!!");
            
                    alert.show();
             
        });

        bt661.setOnAction(e -> {

            String line6 = txt601.getText();
            for (Team t : adm.league) {
                if (t.getName().equals(line6)) {

                    t.setCaptain(txt631.getText());

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Team captain is updated");
                
                    alert.show();
                        try {
            ObjectOutputStream o1= new ObjectOutputStream (new FileOutputStream("Teams.bin"));
           o1.writeObject(adm.league);
          // o1.close();
           
       } catch (IOException ex) {
           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
       }
                     grid5.getChildren().remove(hbx64);
             
                grid5.getChildren().remove(bt661);
                    txt601.clear();
                     txt631.clear();
                    return;

                }
                  
                
            }
              Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Error exist");
                    alert.setContentText("Team not found!!");
                    alert.show();
            grid5.getChildren().remove(hbx64);
             
                grid5.getChildren().remove(bt661);
                    txt601.clear();
                     txt631.clear();
        });
        
     
         
         
       ///////-------------/Display team matches grid----------------//////////  
       
       
       GridPane grid08= new GridPane();
       grid08.setPadding(new Insets(15));
       grid08.setAlignment(Pos.CENTER);
       grid08.setVgap(100);
       grid08.setHgap(20);

            Text t80= new Text("Display Played Matches");
 t80.setFont(Font.font("Courier", FontWeight.BOLD, 28));
       Label lb80= new Label("Enter The Team's name:");
         lb80.setFont(Font.font("Arial", 22));
        
       TextField tx80= new TextField();
             HBox h80=new HBox(lb80,tx80);
             h80.setSpacing(20);
             
             Button b80= new Button("Search");
         b80.setFont(Font.font("Arial", 22));
             
       grid08.add(t80,0,0);
       grid08.add(h80, 0, 1);
       grid08.add(b80, 3, 2);
       
     //----------------/ 
       
                
         
       
       
        b80.setOnAction(e->{
            
            for(Team t11:adm.league)

            {
                if(t11.getName().equals(tx80.getText()))
                {
                    
                    Stage newWindow5 = new Stage();
                newWindow5.setTitle(" Matches");
                 
         TableView<Match> table2 = new TableView<>();
           table2.setMinSize(1000, 1000);
           table2.getStylesheets().add("/CSS/Scroll.css");

         
         
table2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);



TableColumn<Match, Integer> matchIDColumn1 = new TableColumn<>("Match ID");
matchIDColumn1.setCellValueFactory(new PropertyValueFactory<>("MatchID"));

TableColumn<Match, String> stadiumNameColumn1 = new TableColumn<>("Stadium Name");
stadiumNameColumn1.setCellValueFactory(new PropertyValueFactory<>("Stadium_Name"));

TableColumn<Match, String> refreeNameColumn1 = new TableColumn<>("Refree Name");
refreeNameColumn1.setCellValueFactory(new PropertyValueFactory<>("Football_Referee"));

TableColumn<Match, String> homeTeamColumn1 = new TableColumn<>("Home Team");
//homeTeamColumn.setCellValueFactory(new PropertyValueFactory<>("teamA"));
homeTeamColumn1.setCellValueFactory(cellData -> {
  Match match = cellData.getValue();
  Team homeTeam = match.getTeamA();
  return new SimpleStringProperty(homeTeam.getName());
});

TableColumn<Match, String> awayTeamColumn1 = new TableColumn<>("Away Team");
//awayTeamColumn.setCellValueFactory(new PropertyValueFactory<>("teamB"));
awayTeamColumn1.setCellValueFactory(cellData -> {
  Match match = cellData.getValue();
  Team awayTeam = match.getTeamB();
  return new SimpleStringProperty(awayTeam.getName());
});



TableColumn<Match, Integer> homeTeamGoalsColumn1 = new TableColumn<>("Home Team Goals");
homeTeamGoalsColumn1.setCellValueFactory(new PropertyValueFactory<>("teamAScore"));

TableColumn<Match, Integer> awayTeamGoalsColumn1 = new TableColumn<>("Away Team Goals");
awayTeamGoalsColumn1.setCellValueFactory(new PropertyValueFactory<>("teamBScore"));

table2.getColumns().addAll(matchIDColumn1, stadiumNameColumn1, refreeNameColumn1, homeTeamColumn1, awayTeamColumn1, homeTeamGoalsColumn1, awayTeamGoalsColumn1);

ObservableList<Match> data2= FXCollections.observableArrayList();
        for(Match m1: adm.matches)
        {
            if(m1.getTeamA().getName().equals(tx80.getText()) || m1.getTeamB().getName().equals(tx80.getText()))
            {
                  data2.add(m1);
            }
            
          
        }
        
        
        
for (TableColumn<Match,?> column : table2.getColumns()) {
    column.setStyle("-fx-font-size: 12pt; -fx-font-family: 'Arial'");
}
   
table2.setItems(data2);
         
         ScrollPane scrollPane1 = new ScrollPane();
           scrollPane1.setContent(table2);
           

         scrollPane1.setFitToHeight(true);
        scrollPane1.setFitToWidth(true);
           
           
           Scene scene5= new Scene(scrollPane1);

                        newWindow5.setScene(scene5);
                   newWindow5.setMaximized(true);
                       newWindow5.show();
                       tx80.clear();
                       return;
                }
            }
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Team not found!!");
                  
                    alert.show();
                    tx80.clear();
            
            
                
            
            ;});
       
       
       
       
       
        ///////----------------------- Delete Team Grid------------------/////////////
        GridPane griddelteam = new GridPane();
        griddelteam.setPadding(new Insets(10));
        griddelteam.setVgap(100);
        griddelteam.setHgap(20);
        griddelteam.setAlignment(Pos.CENTER);
        Text txtdelteam1 = new Text("Delet Team");
        txtdelteam1.setFont(Font.font("Courier", FontWeight.BOLD, 28));

        griddelteam.add(txtdelteam1, 1, 0);
        Label lbdelteam1 = new Label("Enter Team Name");
   lbdelteam1.setFont(Font.font("Arial", 22));
        Button butdelteam1 = new Button("Delete ");
           butdelteam1.setFont(Font.font("Arial", 22));
        TextField tfdelteam1 = new TextField();

        

        griddelteam.add(lbdelteam1, 0, 1);
        griddelteam.add(tfdelteam1, 1, 1);
           griddelteam.add(butdelteam1, 3, 2);
        

        butdelteam1.setOnAction(e -> {
             Team t12=null;
             Player p12=null;
        
            String line = tfdelteam1.getText();
            for (Team club : adm.league) {
                if (club.getName().equals(line)) {
                   t12=club;
                
                 
                
                  
                    
                    for (Player player1 : adm.p1) {
                if (player1.getPlayerteam().equals(line)) {
                  p12=player1;
                      
                  
             
                }
                    }
                    
                    
                  
                    Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Message Here...");
            alert.setHeaderText("Deleted Successfully");
            alert.setContentText("");
            alert.show();
          

          
            
                
                     

            
            }
             

            }
                adm.league.remove(t12);
               adm.p1.remove(p12);
                 try {
            ObjectOutputStream o1= new ObjectOutputStream (new FileOutputStream("Teams.bin"));
           o1.writeObject(adm.league);
     
           
       } catch (IOException ex) {
           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
       }
                try {
           ObjectOutputStream o2= new ObjectOutputStream (new FileOutputStream("Players.bin"));
          o2.writeObject(adm.p1);
       
      } catch (IOException ex) {
          Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
      }
                
       
            
          
               
       tfdelteam1.clear();

           
            
             
        });
       
        
       
       
       
       
       
       
    
   
    ///--------------------ADD Players grid-----------------------//
        GridPane grid2=new GridPane();
     grid2.setPadding(new Insets(10));
    grid2.setVgap(40);
    grid2.setHgap(20);
    
     grid2.setAlignment(Pos.CENTER);
       Text txt3= new Text("Add New Player");
     txt3.setFont(Font.font("Courier", FontWeight.BOLD, 28)); 
       grid2.add(txt3,1,0);
    
         Label lb1 = new Label("Player's Name:");
         lb1.setFont(Font.font("Arial", 22));
             TextField t1 = new TextField();
        Label lb2=new Label("Player's number :");
        lb2.setFont(Font.font("Arial", 22));
        TextField t2 = new TextField();
        Label lb3= new Label("Player's Age:");
        lb3.setFont(Font.font("Arial", 22));
           TextField t3 = new TextField();
                Label lb4 = new Label("Player's Team:");
         lb4.setFont(Font.font("Arial", 22));
             TextField t4 = new TextField();
        Label lb5=new Label("Player's Score :");
        lb5.setFont(Font.font("Arial", 22));
        TextField t5 = new TextField();
        Label lb6= new Label("Player's Rank:");
        lb6.setFont(Font.font("Arial", 22));
           TextField t6 = new TextField();
              Label lb7= new Label("Player's Position:");
        lb7.setFont(Font.font("Arial", 22));
          TextField t7 = new TextField();
           
        Button btn2=new Button("ADD");
        btn2.setFont(Font.font("Arial", 22));
      
         grid2.add(lb1, 0, 1);
         grid2.add(t1, 1, 1);
         
         grid2.add(lb2, 0, 2); 
         grid2.add(t2, 1, 2);
         
         grid2.add(lb3, 0, 3);
         grid2.add(t3, 1, 3);
         
         grid2.add(lb4, 0, 4);
         grid2.add(t4, 1, 4);
         
         grid2.add(lb5, 0, 5); 
         grid2.add(t5, 1, 5);
         
         grid2.add(lb6, 0, 6);
         grid2.add(t6, 1, 6);
         
         grid2.add(lb7, 0, 7);
         grid2.add(t7, 1, 7);
        
        grid2.add(btn2,3,9);
        
        
        
        
        
        ///Action//----------------------
         
      
        btn2.setOnAction(e->{
              Player player1= new Player();
              player1.setPlayername(t1.getText());
       player1.setPlayerage(Integer.parseInt(t3.getText()));
       player1.setPlayernumber(Integer.parseInt(t2.getText()));
       player1.setPlayerposition(t7.getText());
      
        String line1=t4.getText();
       for(Team club:adm.league)
            {
                if(club.getName().equals(line1)){
                    
                
                    player1.setPlayerteam(line1);
                    club.setP3(player1);
                 
                   
                }
            }
       
       
       player1.setPlayerscore(Integer.parseInt(t5.getText()));
       player1.setPlayerRank(Integer.parseInt(t6.getText()));
     
       adm.p1.add(player1);
      try {
           ObjectOutputStream o2= new ObjectOutputStream (new FileOutputStream("Players.bin"));
          o2.writeObject(adm.p1);
       
      } catch (IOException ex) {
          Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Added Successfully");
                    alert.setContentText("");
                    alert.show();
                    
                    t1.clear();
                    t2.clear();
                    t3.clear();
                    t4.clear();
                    t5.clear();
                    t6.clear();
                    t7.clear();

      
      
      
        
          ;});
        
        ///----------- Search for a player----------///////////////
        
        
        
        
        GridPane grid03= new GridPane();
      grid03.setPadding(new Insets(10));
    grid03.setVgap(100);
    grid03.setHgap(20);
        grid03.setAlignment(Pos.CENTER);
     Text txt04= new Text("Search for a Player");
 txt04.setFont(Font.font("Courier", FontWeight.BOLD, 28)); 
    
     grid03.add(txt04,1,0);
    
    Label l001= new Label("Enter  Player's Name: ");
             l001.setFont(Font.font("Arial", 22));
    TextField tf01= new TextField();
    Button b001= new Button("Search");
             b001.setFont(Font.font("Arial", 22));

    
    
    grid03.add(l001,0,1);
    grid03.add(tf01,1,1);
    grid03.add(b001,3,2);

    
    
    b001.setOnAction(e->{
            GridPane newgrid1= new GridPane();
            newgrid1.setPadding(new Insets(15));
                newgrid1.setVgap(40);
    newgrid1.setHgap(20);
    newgrid1.setAlignment(Pos.TOP_CENTER);
       
           

                Stage newWindow1 = new Stage();
                newWindow1.setTitle("Player's details");
                
                   
               String line01=tf01.getText();
      for(Player p1:adm.p1)
      {
           if(p1.getPlayername().equals(line01))
           {
               Label lb011 = new Label("Player name: ");
               Label lb012 = new Label(p1.getPlayername());
                  Label lb013 = new Label("Player Age:");
                 Label lb014= new Label (""+p1.getPlayerage());
               Label lb015 = new Label("Player Team:");
           Label lb016 = new Label(p1.getPlayerteam());
              Label lb017 = new Label( "Player's Position:");
                  Label lb018 = new Label(p1.getPlayerposition());
                       Label lb019 = new Label( "Player's Number:");
                  Label lb020 = new Label(""+p1.getPlayernumber());
                       Label lb021 = new Label( "Player's Rank:");
                  Label lb022 = new Label(""+p1.getPlayerRank());
                       Label lb023 = new Label( "Player's Score:");
                  Label lb024 = new Label(""+p1.getPlayerscore());
                  
              
            
        
            
          lb011.setFont(Font.font("Arial", 22));
          lb012.setFont(Font.font("Arial", 22));
               lb013.setFont(Font.font("Arial", 22));
           lb014.setFont(Font.font("Arial", 22));
           lb015.setFont(Font.font("Arial", 22));
            lb016.setFont(Font.font("Arial", 22));
           lb017.setFont(Font.font("Arial", 22));
                lb018.setFont(Font.font("Arial", 22));
                     lb019.setFont(Font.font("Arial", 22));
                          lb020.setFont(Font.font("Arial", 22));
                               lb021.setFont(Font.font("Arial", 22));
                                    lb022.setFont(Font.font("Arial", 22));
                                         lb023.setFont(Font.font("Arial", 22));
                                              lb024.setFont(Font.font("Arial", 22));
      
           
             newgrid1.add(lb011,0,0);
              newgrid1.add(lb012,1,0);
               newgrid1.add(lb013,0,1);
                newgrid1.add(lb014,1,1);
                 newgrid1.add(lb015,0,2);
                  newgrid1.add(lb016,1,2);
                  newgrid1.add(lb017,0,3);
               newgrid1.add(lb018,1,3);
              newgrid1.add(lb019,0,4);
               newgrid1.add(lb020,1,4);
                newgrid1.add(lb021,0,5);
                 newgrid1.add(lb022,1,5);
                  newgrid1.add(lb023,0,6);
                  newgrid1.add(lb024,1,6);
              Scene scene2 = new Scene(newgrid1);
                     scene2.getStylesheets().add("/CSS/background.css");
        newWindow1.setScene(scene2);
                newWindow1.setMaximized(true);
                   newWindow1.show();
                    tf01.clear();
                   return;
         
           }
         
           
      }
      
      
        
                     Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Player not Found");
                    alert.setContentText("");
                    alert.show();
                       tf01.clear();
                   
        
        
        
        
        ;});
    
    
    
        
        
        //**************** Update Player Grid ********************** 
        HBox hb60 = new HBox();
        HBox hb61 = new HBox();
      
        hb60.setSpacing(10);
          hb61.setSpacing(10);
          
   
                
        GridPane grid4 = new GridPane();
        grid4.setPadding(new Insets(10, 10, 10, 10));
        grid4.setVgap(40);
        grid4.setHgap(20);
        grid4.setAlignment(Pos.TOP_CENTER);
       Text txt13= new Text("Update a Player");
    txt13.setFont(Font.font("Courier", FontWeight.BOLD, 28)); 
     grid4.add(txt13,0,0);

        Label lb60 = new Label("Playr Name:");

        lb60.setFont(Font.font("Arial", 22));
        TextField txt60 = new TextField();
       

        Button butt60 = new Button("Edit Age");
        Button butt61 = new Button("Edit Team");
        Button butt62 = new Button("Edit Rank");
        Button butt63 = new Button("Edit Score");
        Button butt64 = new Button("Edit Position");
        Button butt65 = new Button("Edit Number");
        hb60.getChildren().addAll(butt60, butt61, butt62, butt63, butt64, butt65);

        grid4.add(hb60, 0, 3);
        grid4.add(hb61, 0, 2);


        hb60.setSpacing(10);
        hb60.setPadding(new Insets(6));

        hb61.getChildren().add(lb60);
        hb61.getChildren().add(txt60);
        
        

//********************Edit Player Age**********************************        
            Label lb63 = new Label("Enter new Age:");
            lb63.setFont(Font.font("Arial", 22));
            TextField txt61 = new TextField();
            Button bt64 = new Button("Update");
            HBox hb62= new HBox();
               hb62.setSpacing(10);
                hb62.getChildren().addAll(lb63,txt61);
            butt60.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    grid4.add(hb62, 0, 4);

                    grid4.add(bt64, 4, 6);

                }
            });
    
        //********************Edit Team Name**********************************
                Label lb65 = new Label("Enter new Team name:");
                lb65.setFont(Font.font("Arial", 22));
                TextField txt62 = new TextField();
                Button bt65 = new Button("Update");
                  HBox hb63= new HBox();
                   hb63.setSpacing(10);
                hb63.getChildren().addAll(lb65,txt62);
                butt61.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        grid4.add(hb63,0,4);

                        grid4.add(bt65, 4, 6);
                    }
                });

//********************Edit Player Rank**********************************
        Label lb66 = new Label("Enter new Rank:");
        lb66.setFont(Font.font("Arial", 22));
        TextField txt63 = new TextField();
        Button bt66 = new Button("Update");
         HBox hb64= new HBox();
           hb64.setSpacing(10);
        hb64.getChildren().addAll(lb66,txt63);
        butt62.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                grid4.add(hb64, 0, 4);

                grid4.add(bt66, 4, 6);
            }
        });
     
//********************Edit Player Score**********************************
        Label lb67 = new Label("Enter new Score:");
        lb67.setFont(Font.font("Arial", 22));
        TextField txt64 = new TextField();
        Button bt67 = new Button("Update");
         HBox hb65= new HBox();
           hb65.setSpacing(10);
        hb65.getChildren().addAll(lb67,txt64);
        butt63.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                grid4.add(hb65, 0, 4);
             
                grid4.add(bt67, 4, 6);
            }
        });
   
//********************Edit Player Position**********************************
        Label lb68 = new Label("Enter new Position:");
        lb68.setFont(Font.font("Arial", 22));
        TextField txt65 = new TextField();
        Button bt68 = new Button("Update");
         HBox hb66= new HBox();
           hb66.setSpacing(10);
        hb66.getChildren().addAll(lb68,txt65);
        butt64.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                grid4.add(hb66, 0, 4);
             
                grid4.add(bt68, 4, 6);
            }
        });
     
//********************Edit Player Number**********************************
        Label lb69 = new Label("Enter new Number:");
        lb69.setFont(Font.font("Arial", 22));
        TextField txt66 = new TextField();
        Button bt69 = new Button("Update");
         HBox hb67= new HBox();
           hb67.setSpacing(10);
        hb67.getChildren().addAll(lb69,txt66);
        butt65.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                grid4.add(hb67, 0, 4);
             
                grid4.add(bt69, 4, 6);
            }
        });
   
        
        
        
         //-----------------Action---Player update----------------------------------//////
        //Age:
        bt64.setOnAction(e -> {

            String line7 = txt60.getText();
            for (Player p : adm.p1) {
                if (p.getPlayername().equals(line7)) {

                    p.setPlayerage(Integer.parseInt(txt61.getText()));

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Player age is updated");
               
                    alert.show();
                      grid4.getChildren().remove(hb62);
             
                grid4.getChildren().remove(bt64);
                txt60.clear();
                txt61.clear();
                    return;

                } 
                    
                
            }
            Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Player not found!");
                 
                    alert.show();
                        grid4.getChildren().remove(hb62);
             
                grid4.getChildren().remove(bt64);
                txt60.clear();
                txt61.clear();
            
            
        });

        //Team name:
        bt65.setOnAction(e -> {
            String line7 = txt60.getText();
            for (Player p : adm.p1) {
                if (p.getPlayername().equals(line7)) {

                    p.setPlayerteam(txt62.getText());

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Player team is updated");
                 
                    alert.show();
                    grid4.getChildren().remove(hb63);
               
                grid4.getChildren().remove(bt65);
                                txt60.clear();
                                txt62.clear();
                    return;

                } 
                   
                
            }
             Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Player not found!");
                  
                    alert.show();
                                 grid4.getChildren().remove(hb63);
               
                grid4.getChildren().remove(bt65);
                                txt60.clear();
                                txt62.clear();
                

            
        });

        //Player rank:
        bt66.setOnAction(e -> {
            String line7 = txt60.getText();
            for (Player p : adm.p1) {
                if (p.getPlayername().equals(line7)) {

                    p.setPlayerRank(Integer.parseInt(txt63.getText()));

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Player rank is updated");
                    
                    alert.show();
                     grid4.getChildren().remove(hb64);
             
                grid4.getChildren().remove(bt66);
                                txt60.clear();
                                txt63.clear();
                                return;

                } 
                  
                
            }
              Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Player not found!");
                    
                    alert.show();
                           grid4.getChildren().remove(hb64);
             
                grid4.getChildren().remove(bt66);
                                txt60.clear();
                                txt63.clear();
                
        });

        // Player score:
        bt67.setOnAction(e -> {
            String line7 = txt60.getText();
            for (Player p : adm.p1) {
                if (p.getPlayername().equals(line7)) {

                    p.setPlayerscore(Integer.parseInt(txt64.getText()));

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Player score is updated");
                    
                    alert.show();
                      grid4.getChildren().remove(hb65);
            
                grid4.getChildren().remove(bt67);
                                txt60.clear();
                                txt64.clear();
                    return;

                } 
                
                
                
            }
                Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Player not found!");
                    
                    alert.show();
                               grid4.getChildren().remove(hb65);
            
                grid4.getChildren().remove(bt67);
                                txt60.clear();
                                txt64.clear();
            
        });

        //Player position:
        bt68.setOnAction(e -> {
            String line7 = txt60.getText();
            for (Player p : adm.p1) {
                if (p.getPlayername().equals(line7)) {

                    p.setPlayerposition((txt65.getText()));

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Player position is updated");
                    
                    alert.show();
                     grid4.getChildren().remove(hb66);
            
                grid4.getChildren().remove(bt68);
                                txt60.clear();
                                txt65.clear();
                    return;
                    

                } 
                  
                
            }
              Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Player not found!");
                    
                    alert.show();
                       grid4.getChildren().remove(hb66);
            
                grid4.getChildren().remove(bt68);
                                txt60.clear();
                                txt65.clear();
               
            
        });

        //Player number:
        bt69.setOnAction(e -> {
            String line7 = txt60.getText();
            for (Player p : adm.p1) {
                if (p.getPlayername().equals(line7)) {

                    p.setPlayernumber(Integer.parseInt((txt66.getText())));

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Player number is updated");
                    
                    alert.show();
                     grid4.getChildren().remove(hb67);
            
                grid4.getChildren().remove(bt69);
                                txt60.clear();
                                txt66.clear();
                                
                    return;
                    

                } 
                   
                
            }
             Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Player not found!");

                    alert.show();
                       grid4.getChildren().remove(hb67);
            
                grid4.getChildren().remove(bt69);
                                txt60.clear();
                                txt66.clear();
               
            
        });
        
        
         ///////----------------------- Delete Player Grid------------------/////////////
        GridPane griddelplayer = new GridPane();
        griddelplayer.setPadding(new Insets(10));
        griddelplayer.setVgap(100);
        griddelplayer.setHgap(20);
        griddelplayer.setAlignment(Pos.CENTER);
        Text txtdelplayer1 = new Text("Delete player");
        txtdelplayer1.setFont(Font.font("Courier", FontWeight.BOLD, 28));

        griddelplayer.add(txtdelplayer1, 1, 0);

        Label lbdelplayer1= new Label("Enter Player Name");
          lbdelplayer1.setFont(Font.font("Arial", 22));
        Button butdelplayer1 = new Button("Delete ");
          butdelplayer1.setFont(Font.font("Arial", 22));
        TextField tfdelplayer1 = new TextField();

        griddelplayer.add(lbdelplayer1, 0, 1);
        griddelplayer.add(tfdelplayer1, 1, 1);
         griddelplayer.add(butdelplayer1, 2, 3);

        butdelplayer1.setOnAction(e -> {
            Player p18=null;

            String line = tfdelplayer1.getText();
            for (Player player1 : adm.p1) {
                if (player1.getPlayername().equals(line)) {
                           p18=player1;
                        
                    

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Deleted Successfully");
                    alert.setContentText("");
                    alert.show();
                  
                }

            }
             adm.p1.remove(p18);
     

            try {
                ObjectOutputStream o1 = new ObjectOutputStream(new FileOutputStream("Player.bin"));
                o1.writeObject(adm.league);

            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
               try {
           ObjectOutputStream o2= new ObjectOutputStream (new FileOutputStream("Players.bin"));
          o2.writeObject(adm.p1);
       
      } catch (IOException ex) {
          Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
      }
                
            
            
            tfdelplayer1.clear();

        });
        
      
        
        
        ////////-------- Add match-----------//////////
GridPane grid7 = new GridPane();
        grid7.setPadding(new Insets(10));
        grid7.setVgap(40);
        grid7.setHgap(20);

        grid7.setAlignment(Pos.CENTER);
        Text txt5 = new Text("Add New Match");
        txt5.setFont(Font.font("Courier", FontWeight.BOLD, 28));
        grid7.add(txt5, 0, 0);

        Label lb8 = new Label("Home Team name:");
        lb8.setFont(Font.font("Arial", 22));
        TextField t8 = new TextField();
        Label lb9 = new Label("Away Team name:");
        lb9.setFont(Font.font("Arial", 22));
        TextField t9 = new TextField();
        Label lb11 = new Label("Home Team score:");
        lb11.setFont(Font.font("Arial", 22));
        TextField t10 = new TextField();
        Label lb12 = new Label("Away Team score:");
        lb12.setFont(Font.font("Arial", 22));
        TextField t13 = new TextField();
        Label lb13 = new Label("Match ID:");
        lb13.setFont(Font.font("Arial", 22));
        TextField t14 = new TextField();
        Label lb14 = new Label("Match's Referee:");
        lb14.setFont(Font.font("Arial", 22));
        TextField t15 = new TextField();
        Label lb15 = new Label("Stadium name:");
        lb15.setFont(Font.font("Arial", 22));
        TextField t16 = new TextField();

        Button btn3 = new Button("ADD");
        btn3.setFont(Font.font("Arial", 22));

        grid7.add(lb8, 0, 1);
        grid7.add(t8, 1, 1);

        grid7.add(lb9, 0, 2);    
                
        grid7.add(t9, 1, 2);

        grid7.add(lb11, 0, 3);
        grid7.add(t10, 1, 3);

        grid7.add(lb12, 0, 4);
        grid7.add(t13, 1, 4);

        grid7.add(lb13, 0, 5);
        grid7.add(t14, 1, 5);

        grid7.add(lb14, 0, 6);
        grid7.add(t15, 1, 6);

        grid7.add(lb15, 0, 7);
        grid7.add(t16, 1, 7);

        grid7.add(btn3, 3, 8);

////////----ACtion-----///////

         btn3.setOnAction(e->{
             
             
             
        Match match=new Match();
    
          int homeGoals=0;
           int awayGoals=0;
        match.setMatchID(Integer.parseInt(t14.getText()));
               
        
        
        match.setFootball_Referee(t15.getText());
       
        
         match.setStadium_Name(t16.getText());
         
        
        
             Team home =null;
               String line1=t8.getText();
        
         for(Team club:adm.league)
            {
              if(club.getName().equals(line1)){
                  home=club;
                   match.setTeamA(home);
                
              }
                
            }
             
         Team away=null;
          String line2=t9.getText();
           for(Team club:adm.league)
            {
              if(club.getName().equals(line2)){
                  away=club;
                   match.setTeamB(away);
                  
              }
                
            }

    homeGoals=Integer.parseInt(t10.getText());
           match.setTeamAScore(homeGoals);
         

      
     
             awayGoals=Integer.parseInt(t13.getText());
             
       match.setTeamBScore(awayGoals);
   home.setScoredGoalsCount(home.getScoredGoalsCount()+ homeGoals);
        away.setScoredGoalsCount(away.getScoredGoalsCount() + awayGoals);
        home.setReceivedGoalsCount(home.getReceivedGoalsCount()+awayGoals);
        away.setReceivedGoalsCount(away.getReceivedGoalsCount() +homeGoals);
        home.setMatchesPlayed(home.getMatchesPlayed()+1);
        away.setMatchesPlayed(away.getMatchesPlayed()+1);
        if (homeGoals > awayGoals) {            
             home.setPoints(home.getPoints()+3);
             home.setWinCount(home.getWinCount()+1);
             away.setDefeatCount(away.getDefeatCount()+1);
         }
         
         else if (homeGoals < awayGoals) {            
             away.setPoints(away.getPoints()+3);
             away.setWinCount(away.getWinCount()+1);
             home.setDefeatCount(home.getDefeatCount()+1);
         }
         else {
             home.setPoints(home.getPoints()+1);
             away.setPoints(away.getPoints()+1);
             home.setDrawCount(home.getDrawCount()+1);
             away.setDrawCount(away.getDrawCount()+1);
         }      
              
     

      
        
       
         
         adm.matches.add(match);
            adm.sortpoints();
          
       try {
            ObjectOutputStream o1= new ObjectOutputStream (new FileOutputStream("Teams.bin"));
           o1.writeObject(adm.league);
      
           
       } catch (IOException ex) {
           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
       }
          
         
       try {
           
               
           ObjectOutputStream o3= new ObjectOutputStream (new FileOutputStream("Matches.bin"));
           o3.writeObject(adm.matches);
           
       } catch (IOException ex) {
           Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
       }
         
             Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Added Successfully");
                    alert.setContentText("");
                    alert.show();
                    
                 t8.clear();
                 t9.clear();
                 t10.clear();
                 t13.clear();
                 t14.clear();
                 t15.clear();
                 t16.clear();
                 
                 
                 ;});
       
         ///----------------Display all Matches-----------/////////////
         Stage newWindow4 = new Stage();
                newWindow4.setTitle("All Matches");
                 
         TableView<Match> table1 = new TableView<>();
           table1.setMinSize(1000, 1000);
           table1.getStylesheets().add("/CSS/Scroll.css");

         
         
table1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);



TableColumn<Match, Integer> matchIDColumn = new TableColumn<>("Match ID");
matchIDColumn.setCellValueFactory(new PropertyValueFactory<>("MatchID"));

TableColumn<Match, String> stadiumNameColumn = new TableColumn<>("Stadium Name");
stadiumNameColumn.setCellValueFactory(new PropertyValueFactory<>("Stadium_Name"));

TableColumn<Match, String> refreeNameColumn = new TableColumn<>("Refree Name");
refreeNameColumn.setCellValueFactory(new PropertyValueFactory<>("Football_Referee"));

TableColumn<Match, String> homeTeamColumn = new TableColumn<>("Home Team");
//homeTeamColumn.setCellValueFactory(new PropertyValueFactory<>("teamA"));
homeTeamColumn.setCellValueFactory(cellData -> {
  Match match = cellData.getValue();
  Team homeTeam = match.getTeamA();
  return new SimpleStringProperty(homeTeam.getName());
});

TableColumn<Match, String> awayTeamColumn = new TableColumn<>("Away Team");
//awayTeamColumn.setCellValueFactory(new PropertyValueFactory<>("teamB"));
awayTeamColumn.setCellValueFactory(cellData -> {
  Match match = cellData.getValue();
  Team awayTeam = match.getTeamB();
  return new SimpleStringProperty(awayTeam.getName());
});



TableColumn<Match, Integer> homeTeamGoalsColumn = new TableColumn<>("Home Team Goals");
homeTeamGoalsColumn.setCellValueFactory(new PropertyValueFactory<>("teamAScore"));

TableColumn<Match, Integer> awayTeamGoalsColumn = new TableColumn<>("Away Team Goals");
awayTeamGoalsColumn.setCellValueFactory(new PropertyValueFactory<>("teamBScore"));

table1.getColumns().addAll(matchIDColumn, stadiumNameColumn, refreeNameColumn, homeTeamColumn, awayTeamColumn, homeTeamGoalsColumn, awayTeamGoalsColumn);

ObservableList<Match> data1= FXCollections.observableArrayList();
        for(Match m1: adm.matches)
        {
            
            data1.add(m1);
        }
        
        
        
for (TableColumn<Match,?> column : table1.getColumns()) {
    column.setStyle("-fx-font-size: 12pt; -fx-font-family: 'Arial'");
}
   
table1.setItems(data1);
         
         ScrollPane scrollPane = new ScrollPane();
           scrollPane.setContent(table1);
           

         scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
           
           
           Scene scene4= new Scene(scrollPane);
         
         
         
         
        
                                 
     ////---------------Main top Team-----------------//////////     
       HBox hb1=new HBox();
    
    
 Button btt=new Button("Add New Team");
 btt.setFont(Font.font("Gabriola", 18));
     btt.setStyle(("-fx-background-color:#B8D9BA  "));
 Button btt1=new Button("Update a Team");
 btt1.setFont(Font.font("Gabriola", 18));
     btt1.setStyle(("-fx-background-color:#B8D9BA  "));
 Button btt2=new Button("Search for a Team");
 btt2.setFont(Font.font("Gabriola", 18));
     btt2.setStyle(("-fx-background-color:#B8D9BA  "));
     
     Button btt3 = new Button("Display matches");
      btt3.setFont(Font.font("Gabriola", 18));
     btt3.setStyle(("-fx-background-color:#B8D9BA  "));
     
      Button delteambtt = new Button("Delete Team");
        delteambtt.setFont(Font.font("Gabriola", 18));
        delteambtt.setStyle(("-fx-background-color:#B8D9BA  "));
     
 hb1.getChildren().addAll(btt,btt1,btt2,btt3,delteambtt);
 hb1.setAlignment(Pos.CENTER);
 hb1.setSpacing(150);
 hb1.setPadding(new Insets(6));
 
 hb1.setStyle("-fx-background-color:#91C29F   ");

 btt.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
              border.setCenter(grid1);
        }
    });
 
 
 btt1.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
            border.setCenter(grid5);
              
           
        }
    });

 
 
             
btt2.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
              border.setCenter(grid3);
        }
    });


btt3.setOnAction(e->{
    border.setCenter(grid08);
    
    
    
    
    ;});


 delteambtt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                border.setCenter(griddelteam);
            }
        });


     ///-------------------Main Top Players--------------------------------------------///
     
      HBox hb2=new HBox();
   
    
 Button bttn1=new Button("Add New Player");
  bttn1.setFont(Font.font("Gabriola", 18));
    bttn1.setStyle(("-fx-background-color:#B8D9BA  "));
 Button bttn2=new Button("Update a Player");
  bttn2.setFont(Font.font("Gabriola", 18));
      bttn2.setStyle(("-fx-background-color:#B8D9BA  "));
 Button bttn3=new Button("Search for a Player");
  bttn3.setFont(Font.font("Gabriola", 18));
      bttn3.setStyle(("-fx-background-color:#B8D9BA  "));
      Button bttdelplayer = new Button("Delete Player");
        bttdelplayer.setFont(Font.font("Gabriola", 18));
        bttdelplayer.setStyle(("-fx-background-color:#B8D9BA  "));
 
 
 hb2.getChildren().addAll(bttn1,bttn2,bttn3,bttdelplayer);
hb2.setAlignment(Pos.CENTER);
 hb2.setSpacing(250);
 hb2.setPadding(new Insets(6));

 
 hb2.setStyle("-fx-background-color:#91C29F  ");

 bttn1.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
              border.setCenter(grid2);
        }
    });
 
 
 bttn2.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
            
                border.setCenter(grid4);
              
           
        }
    });

 
 
             
bttn3.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
            border.setCenter(grid03);
              
        }
    });


bttdelplayer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                border.setCenter(griddelplayer);

            }
        });



       //------------------Main Top Matches--------------------------------------//

        HBox hb3 = new HBox();

        Button btttn1 = new Button("Add New Match");
        btttn1.setFont(Font.font("Gabriola", 18));
        btttn1.setStyle(("-fx-background-color:#B8D9BA  "));
        Button btttn2 = new Button("Display Matches");
        btttn2.setFont(Font.font("Gabriola", 18));
        btttn2.setStyle(("-fx-background-color:#B8D9BA  "));
        
        hb3.getChildren().addAll(btttn1, btttn2);
        hb3.setAlignment(Pos.CENTER);
        hb3.setSpacing(250);
        hb3.setPadding(new Insets(6));

        hb3.setStyle("-fx-background-color:#91C29F  ");

        btttn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                border.setCenter(grid7);
            }
        });

        btttn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                
          
                  newWindow4.setScene(scene4);
                   newWindow4.setMaximized(true);
                       newWindow4.show();

               

            }
        });

        


      /////////////-----------------login-----------------/////////// 
      
      BorderPane border1= new BorderPane();
      GridPane grid0= new GridPane();
      grid0.setPadding(new Insets(10));
          grid0.setAlignment(Pos.TOP_CENTER);
    grid0.setStyle("-fx-background-color:#E9E6E9");
   
        grid0.setVgap(40);
        grid0.setHgap(20);
        grid0.setMinSize(300, 100);
        
     VBox v1= new VBox();
     
     Label lb0=new Label("Login");
     lb0.setFont(Font.font("Lucida Handwriting", 30));
     
     Label lb01= new Label("Username:");
          lb01.setFont(Font.font("Lucida Handwriting", 18));
              TextField tx0=  new TextField();
     Label lb02= new Label("Password:");
          lb02.setFont(Font.font("Lucida Handwriting", 18));
              PasswordField tx01=  new PasswordField();
              
             
     final ToggleGroup radioGroup = new ToggleGroup();
        RadioButton admin = new RadioButton("Admin");
        admin.setToggleGroup(radioGroup);
        RadioButton user = new RadioButton("User");
        user.setToggleGroup(radioGroup);
        grid0.add(admin,2,6);
        grid0.add(user,3,6);
        Button btn0 = new Button("Login");
        btn0.setMinSize(50, 20);
        Button btn00 = new Button("Sign Up");
        btn00.setMinSize(50, 20);
        

        border1.getStylesheets().add("/CSS/Login.css");
        border1.setLeft(grid0);

        grid0.add(lb0, 2, 3);
        grid0.add(lb01, 1, 4);
        grid0.add(tx0, 2, 4);

        grid0.add(lb02, 1, 5);
        grid0.add(tx01, 2, 5);
        grid0.add(btn0, 3, 7);
          grid0.add(btn00, 4, 7);
     btn00.setOnAction(e->{
       
       
            String username = tx0.getText();
        String password = tx01.getText();
        RadioButton selectedRadio = (RadioButton) radioGroup.getSelectedToggle();
        String role = selectedRadio.getText();
         
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("signup_data.txt", true));
            writer.write(username + "," + password + "," + role + "\n");
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
         
         
         
         Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Message Here...");
                    alert.setHeaderText("Sign up  Successfull");
                    alert.setContentText("");
                    alert.showAndWait();
                    
                    
                     if(admin.isSelected())
            {
            Scene scene1 = new Scene(border, 1000, 650);

            stage.setScene(scene1);

            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            }
            else
            {
                  Stage newWindow5 = new Stage();
                  
                    Scene scene5 = new Scene(border5, 1000, 650);
                  

            stage.setScene(scene5);

            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            }
         

   ;});
        btn0.setOnAction(e -> {
            
            
           String username = tx0.getText();
        String password = tx01.getText();
        boolean loginSuccess = false;
        String role = "";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("signup_data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String fileUsername = parts[0];
                String filePassword = parts[1];
                String fileRole = parts[2];
                if (username.equals(fileUsername) && password.equals(filePassword)) {
                    loginSuccess = true;
                    role = fileRole;
                    break;
                }
            }
            reader.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
            
           if (loginSuccess) {
            // Check if selected radio button matches saved role
            RadioButton selectedRadio = (RadioButton) radioGroup.getSelectedToggle();
            String selectedRole = selectedRadio.getText();
            if (role.equals(selectedRole)) {
                if(admin.isSelected())
            {
            Scene scene1 = new Scene(border, 1000, 650);

            stage.setScene(scene1);

            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            }
            else
            {
                  Stage newWindow5 = new Stage();
                  
                    Scene scene5 = new Scene(border5, 1000, 650);
                  

            stage.setScene(scene5);

            stage.setMaximized(true);
            stage.setResizable(true);
            stage.show();
            }
                
                
            }
             else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Message Here...");
                    alert.setHeaderText("Wrong username or password");
                    alert.setContentText("");
                    alert.showAndWait();
                
            }
           }
             
           
                   
                    
           
            
            
            
            
            
            
          
           
        });

      

               
   
      //------------------------User------------------------------//
        
       
          ////---------------User top Team-----------------//////////     
        HBox hb4 = new HBox();

        
        Button btt5 = new Button("Search for a Team");
        btt5.setFont(Font.font("Gabriola", 18));
        btt5.setStyle(("-fx-background-color:#B8D9BA  "));

        Button btt6 = new Button("Display matches");
        btt6.setFont(Font.font("Gabriola", 18));
        btt6.setStyle(("-fx-background-color:#B8D9BA  "));

        hb4.getChildren().addAll( btt6, btt5);
        hb4.setAlignment(Pos.CENTER);
        hb4.setSpacing(250);
        hb4.setPadding(new Insets(6));

        hb4.setStyle("-fx-background-color:#91C29F   ");

        

        btt5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                       border5.setCenter(grid3);

            }
        });

        btt6.setOnAction(e -> {
           border5.setCenter(grid08);
            ;
        });
        

      
        
       


//-----------------User left------------/////        
        
        
        GridPane Lgrid2 = new GridPane();
        Lgrid2.setPadding(new Insets(10));
        Lgrid2.setVgap(60);
        Lgrid2.setStyle("-fx-background-color:#91C29F   ");
        Lgrid2.setMinWidth(150);

        Button bt12 = new Button("Teams");
        bt12.setMinSize(130, 20);
        bt12.setFont(Font.font("Gabriola", 20));
        bt12.setStyle(("-fx-background-color:#B8D9BA  "));

        Button bt13 = new Button("Players");
        bt13.setMinSize(130, 20);
        bt13.setFont(Font.font("Gabriola", 20));
        bt13.setStyle(("-fx-background-color:#B8D9BA   "));
        Button bt14 = new Button("Matches");
        bt14.setMinSize(130, 20);
        bt14.setFont(Font.font("Gabriola", 20));
        bt14.setStyle(("-fx-background-color:#B8D9BA   "));

        Button bt15 = new Button("Table");
        bt15.setMinSize(130, 20);
        bt15.setFont(Font.font("Gabriola", 20));
        bt15.setStyle(("-fx-background-color:#B8D9BA   "));

        Lgrid2.add(bt12, 0, 1);
        Lgrid2.add(bt13, 0, 2);
        Lgrid2.add(bt14, 0, 3);
        Lgrid2.add(bt15, 0, 4);

        border5.setLeft(Lgrid2);

        bt12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
               border5.setTop(hb4);
                 border5.setCenter(grid08);
            }
        });

        bt13.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                border5.setCenter(grid03);
            }
        });

        bt14.setOnAction(e -> {
              
                  newWindow4.setScene(scene4);
                   newWindow4.setMaximized(true);
                       newWindow4.show();
            
            
        });
        
        ///////----------------------Table-----------------------//////////   

        bt15.setOnAction(e -> {
            
                             Stage newWindow3 = new Stage();
                newWindow3.setTitle("Team's details");
   
           
           
        TableView<Team> table = new TableView<Team>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      
       
      ObservableList<Team> data = FXCollections.observableArrayList();
   
     adm.sortpoints();


data.clear();


for (Team Club : adm.league) {
    data.add(Club);
}


table.setItems(data);
    
        
      table.setEditable(true);
       
      
       TableColumn Col1 = new TableColumn("Team Name");
        Col1.setMinWidth(100);
        Col1.setCellValueFactory(
                new PropertyValueFactory<Team, String>("Name"));
        
        
 
        TableColumn Col2 = new TableColumn("Win Count");
        Col2.setMinWidth(100);
        Col2.setCellValueFactory(
                new PropertyValueFactory<Team, String>("winCount"));
        
                TableColumn Col3 = new TableColumn("Draw Count");
        Col3.setMinWidth(100);
        Col3.setCellValueFactory(
                new PropertyValueFactory<Team, String>("drawCount"));
        
                TableColumn Col4 = new TableColumn("Goals Scored");
        Col4.setMinWidth(100);
        Col4.setCellValueFactory(
                new PropertyValueFactory<Team, String>("scoredGoalsCount"));
        
                TableColumn Col5 = new TableColumn("Goals Received");
        Col5.setMinWidth(100);
        Col5.setCellValueFactory(
                new PropertyValueFactory<Team, String>("receivedGoalsCount"));
        
                  TableColumn Col6 = new TableColumn("Matches Played");
        Col6.setMinWidth(100);
        Col6.setCellValueFactory(
                new PropertyValueFactory<Team, String>("matchesPlayed"));
        
                 TableColumn Col7 = new TableColumn("Points ");
        Col7.setMinWidth(100);
        Col7.setCellValueFactory(
                new PropertyValueFactory<Team, String>("Points"));
        

    
         table.getColumns().addAll(Col1, Col2,Col3,Col4,Col5,Col6,Col7);
         
          for (TableColumn<Team,?> column : table.getColumns()) {
    column.setStyle("-fx-font-size: 12pt; -fx-font-family: 'Arial'");
}
         
        table.getStylesheets().add("/CSS/Scroll.css");
        table.refresh();
   
     Scene scene3 = new Scene(table,1000,600);

            scene3.getStylesheets().add("/CSS/background.css");
            newWindow3.setScene(scene3);
            newWindow3.setMaximized(true);
            newWindow3.show();
            ;
        });

        
         
        
      
      
    
      
      
      
     
//----------------------------Main Left-----------------------------------//
  GridPane Lgrid=new GridPane();
      Lgrid.setPadding(new Insets(10));
    Lgrid.setVgap(60);
 Lgrid.setStyle("-fx-background-color:#91C29F   ");
 Lgrid.setMinWidth(150);

      Button bt1=new Button("Teams");
        bt1.setMinSize(130,20);
        bt1.setFont(Font.font("Gabriola", 20));
        bt1.setStyle(("-fx-background-color:#B8D9BA  "));
       
       
        Button bt2=new Button("Players");
         bt2.setMinSize(130,20);
                 bt2.setFont(Font.font("Gabriola", 20));
                   bt2.setStyle(("-fx-background-color:#B8D9BA   "));
        Button bt3=new Button("Matches");
         bt3.setMinSize(130,20);
                 bt3.setFont(Font.font("Gabriola", 20));
                   bt3.setStyle(("-fx-background-color:#B8D9BA   "));
                   
                    Button bt4=new Button("Table");
         bt4.setMinSize(130,20);
                 bt4.setFont(Font.font("Gabriola", 20));
                   bt4.setStyle(("-fx-background-color:#B8D9BA   "));
                   
                   
        Lgrid.add(bt1, 0, 1);
                Lgrid.add(bt2, 0, 2);
                        Lgrid.add(bt3, 0, 3);
                         Lgrid.add(bt4, 0, 4);
                        
                          border.setLeft(Lgrid);
                          

       
                        
                         bt1.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
            border.setCenter(grid1);
             border.setTop(hb1);



      
           
        }
    });
           
                        
                          bt2.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent t) {
                border.setTop(hb2);
              
                border.setCenter(grid2);
                
                
        }
    });
                          
                          bt3.setOnAction(e->{ 
                              
                              border.setCenter(grid7);
                                    border.setTop(hb3);

                              
                              ;});
                          
                          
                          
                          
                       ///////----------------------Table-----------------------//////////   
                          
                          bt4.setOnAction(e->{
                                     Stage newWindow3 = new Stage();
                newWindow3.setTitle("Team's details");
   
           
           
        TableView<Team> table = new TableView<Team>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      
       
      ObservableList<Team> data = FXCollections.observableArrayList();
   
     adm.sortpoints();


data.clear();


for (Team Club : adm.league) {
    data.add(Club);
}


table.setItems(data);
    
        
      table.setEditable(true);
       
      
       TableColumn Col1 = new TableColumn("Team Name");
        Col1.setMinWidth(100);
        Col1.setCellValueFactory(
                new PropertyValueFactory<Team, String>("Name"));
        
        
 
        TableColumn Col2 = new TableColumn("Win Count");
        Col2.setMinWidth(100);
        Col2.setCellValueFactory(
                new PropertyValueFactory<Team, String>("winCount"));
        
                TableColumn Col3 = new TableColumn("Draw Count");
        Col3.setMinWidth(100);
        Col3.setCellValueFactory(
                new PropertyValueFactory<Team, String>("drawCount"));
        
                TableColumn Col4 = new TableColumn("Goals Scored");
        Col4.setMinWidth(100);
        Col4.setCellValueFactory(
                new PropertyValueFactory<Team, String>("scoredGoalsCount"));
        
                TableColumn Col5 = new TableColumn("Goals Received");
        Col5.setMinWidth(100);
        Col5.setCellValueFactory(
                new PropertyValueFactory<Team, String>("receivedGoalsCount"));
        
                  TableColumn Col6 = new TableColumn("Matches Played");
        Col6.setMinWidth(100);
        Col6.setCellValueFactory(
                new PropertyValueFactory<Team, String>("matchesPlayed"));
        
                 TableColumn Col7 = new TableColumn("Points ");
        Col7.setMinWidth(100);
        Col7.setCellValueFactory(
                new PropertyValueFactory<Team, String>("Points"));
        

    
         table.getColumns().addAll(Col1, Col2,Col3,Col4,Col5,Col6,Col7);
         
          for (TableColumn<Team,?> column : table.getColumns()) {
    column.setStyle("-fx-font-size: 12pt; -fx-font-family: 'Arial'");
}
         
        table.getStylesheets().add("/CSS/Scroll.css");
        table.refresh();
   
     Scene scene3 = new Scene(table,1000,600);
                                
                            
                              
                      
                                 newWindow3.setScene(scene3);
                                 newWindow3.setMaximized(true);
                                 newWindow3.show();
                              
                              
                              
                              
                              
                              ;});                          
                          
                          
     
    
        
           Scene scene = new Scene (border1,1000,650);
                   
           
              stage.setScene(scene);

               stage.setResizable(false);
    
               stage.show(); 
  
    
        
    }
    


    
    
    
    }

  


