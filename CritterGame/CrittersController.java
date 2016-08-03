/* 
 * Name: Leiasa Horanic 
 * Login: cs11wcs 
 * Date: February 22, 2014 
 * File: CrittersController.java 
 * Sources of Help: Sachi, Wendy
 * 
 * This file is the controller of all of the critters. This code creates an
 * interactive game for a user through buttons and on mouse clicks. Here 
 * the user can create up to three different types of critters by clicking
 * on the button they want and then clicking on the canvas. There are also
 * buttons for starting and stoping the moverment of the critters along with
 * clearing all of the critters off of the canvas.
 */ 

import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/* 
 * Name: CrittersController
 * Purpose: This class sets up the GUI layout that this program requires for
 *          example the buttons, labels, and panels. Because there are 
 *          buttons this class also implements ActionListener so that it
 *          can listen for things like when each button is pressed. This 
 *          class also contructs three different critters a random, runner
 *          and chaser on an on mouse click with the appropriate button
 */
public class CrittersController extends WindowController implements
                                                         ActionListener
{
  private Chaser Chaser;
  private Random Random;
  private Runner Runner;
 
  private static JButton startButton, stopButton, clearButton,
                         chaserButton, runnerButton, randomButton;
  private static JLabel topInstructionLabel, bottomInstructionLabel;
  public ArrayList <Critter> critters;
  public CrittersSimulator crittSim; 
  static boolean running, chaser, runner, random;
  private static final double CRITTER_RADIUS = 7.5;
  private static final int MIN_CRITTERS = 1;
  private static final int COLUMN_BUTTONS = 3;
  private static final int ROWS_PANEL = 2;

  /* 
   * Name: begin
   * Purpose: This method sets up the canvas using both grid and border
   *          layout. There are also a number of buttons created along
   *          with JPanels and JLabels. In this method the buttons are
   *          initalized as action listeners and an empty array list is
   *          created to later keep track of the critters being created
   * Parameters: None. 
   * Return: void. 
   */
  public void begin()
  {
    JPanel topPanel = new JPanel(new GridLayout(1,COLUMN_BUTTONS));
    JPanel topLabelPanel = new JPanel();
    JPanel topButtonPanel = new JPanel(new GridLayout(1,COLUMN_BUTTONS));
    startButton = new JButton("Start");//start button
    stopButton = new JButton("Stop");//stop button
    clearButton = new JButton("Clear");//clear button
    topInstructionLabel = new JLabel("Please add two or more critters.");

    topLabelPanel.add( topInstructionLabel );
    topButtonPanel.add( startButton );
    topButtonPanel.add( stopButton );
    topButtonPanel.add( clearButton );
    topPanel.add( topLabelPanel );
    topPanel.add( topButtonPanel );

    Container contentPane = getContentPane();
    contentPane.add( topPanel, BorderLayout.NORTH);
    contentPane.validate();
    
    JPanel buttonPanel = new JPanel(new GridLayout(1,COLUMN_BUTTONS));
    //panel for buttons
    JPanel labelPanel = new JPanel(); // panel for label above buttons
    JPanel backPanel = new JPanel(new GridLayout(ROWS_PANEL,1));
    chaserButton = new JButton("Chaser");//chaser button
    runnerButton = new JButton("Runner");//runner button
    randomButton = new JButton("Random");//random all button
    bottomInstructionLabel = new JLabel("Select which critter to place:");
    //label above buttons
   
    //adding components and containers to layout
    backPanel.add( labelPanel );
    backPanel.add( buttonPanel );
    labelPanel.add(  bottomInstructionLabel );
    buttonPanel.add( chaserButton );
    buttonPanel.add( runnerButton );
    buttonPanel.add( randomButton );

    Container contentPane2 = getContentPane();
    contentPane2.add( backPanel, BorderLayout.SOUTH);
    contentPane2.validate();
    
    startButton.addActionListener( this );
    stopButton.addActionListener( this );
    clearButton.addActionListener( this );
    chaserButton.addActionListener( this );
    runnerButton.addActionListener( this );
    randomButton.addActionListener( this );

    critters = new ArrayList <Critter> ();//new empty arraylist
    crittSim = new CrittersSimulator(critters);//new simulator
  }

  /* 
   * Name: actionPerformed
   * Purpose: This method checks to see which buttons are clicked and then 
   *          depending on a which button will call the changeLable method.
   *          There are six buttons total and each of them cause a JLabel to
   *          change depending on the button
   * Parameters: evt
   * Return: void. 
   */
  public void actionPerformed( ActionEvent evt )
  {
    if (evt.getSource() == startButton && critters.size() >= MIN_CRITTERS)
    //checks start button && makes sure there are at least two critters
    {
      running = true;
      changeLabel();
    }
    else if (evt.getSource() == stopButton)//checks stop button
    {
      running = false;
      changeLabel();
    }
    else if ( evt.getSource() == clearButton )
    //checks clear button
    {
     canvas.clear();//removes criiters from canvas
     critters.clear();//removes all critters from array
     running = false;//resets the game
     topInstructionLabel.setText("Please add two or more critters.");
    }
    else if (evt.getSource() == chaserButton)//checks chaser button
    {
      chaser = true;
      bottomInstructionLabel.setText("Click on canvas to place a Chaser");
      runner = false;
      random = false;
    }
     else if (evt.getSource() == runnerButton)//checks runner button
    {
      runner = true;
      bottomInstructionLabel.setText("Click on canvas to place a Runner");
      chaser = false;
      random = false;
    }
     else if (evt.getSource() == randomButton)//checks random button
    {
      random = true;
      bottomInstructionLabel.setText("Click on canvas to place a Random");
      runner = false;
      chaser = false;
    }
  }

  /* 
   * Name: changeLabel
   * Purpose: Basically this method just changes the different JLabels 
   *          by using a boolean set by when a button is pressed to know
   *          what label to change and what to change the label to.     
   * Parameters: none
   * Return: void. 
   */
  public void changeLabel()
  {
    if(running)
    {
      topInstructionLabel.setText("Simulation is running.");
    }
    else
    {
      topInstructionLabel.setText("Simulation is stopped.");
    }
  }

  /* 
   * Name: onMouseClick
   * Purpose: This method constructs three different types of critters. It
   *          uses booleans to check to see which type of critter to create
   *          based on which button the user clicked.    
   * Parameters: point
   * Return: void
   */
  public void onMouseClick(Location point)
  {
    if(critters.size() >= MIN_CRITTERS && critters.size() <= MIN_CRITTERS)
    //if two critters are created changes to start state
    {
     running = true;
     changeLabel();
    }
    if(chaser)//if chaser button is clicked make new chaser on mouse click
    {
      Chaser = new Chaser (new Location 
                          ((double) point.getX() - CRITTER_RADIUS,
                          (double) point.getY()- CRITTER_RADIUS), canvas);
      critters.add(Chaser);//adding to array list
    }
    else if(runner)
    //if runner button is clicked make new runner on mouse click
    {
     Runner = new Runner (new Location 
                         ((double)point.getX() - CRITTER_RADIUS,
                         (double) point.getY()- CRITTER_RADIUS), canvas);
     critters.add(Runner);//adding to array list
    }
    else if(random)
    //if random button is clicked make new random on mouse click
    {
      Random = new Random (new Location
                          ((double)point.getX() - CRITTER_RADIUS, 
                          (double)point.getY() - CRITTER_RADIUS), canvas);
     critters.add(Random);//adding to array list    
    }  
  }
}
