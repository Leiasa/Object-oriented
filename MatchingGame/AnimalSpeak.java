/* 
 * Name: Leiasa Horanic 
 * Login: cs11wcs 
 * Date: February 3, 2014 
 * File: AnimalSpeak.java 
 * Sources of Help: Muyao Wu 
 * 
 * This program creates the Animal Speak game. It uses the other animals 
 * classes to run this code which creates a 3 by 2 card layout on the canvas.
 * It then asks the user the question about which animakl makes which sound
 * the user can click to answer the question and depending if they get it
 * wrong or right a string will appear at the bottom saying correct or 
 * incorrect and a framed rectangle outlines the image clicked on.
 */ 

import objectdraw.*;
import java.awt.Color;

/* 
 * Name: AnimalSpeak
 * Purpose: This class calls on several methods that begin the program with
 *           the animal cards. It uses a switch statement to check to see 
 *           which case is being run. Then using the method on mouse click
 *           to decide which if statement should be executed
 */
public class AnimalSpeak extends WindowController

{
  private AnimalCard animal;
  private AnimalCard kitty;
  private AnimalCard puppy;
  private AnimalCard duck;
  private AnimalCard cow;
  private AnimalCard lion;
  private AnimalCard lamb;
  private RandomIntGenerator randInt;
  private Text prompt, result;
  private String correctAnswer = "CORRECT-- Click mouse to restart.";
  private String wrongAnswer = "INCORRECT-- Try Again!";
  private double CENTER_Y = 280; // center y coordinate for prompt string
  private double R_CENTERY = 260; //center y coordnate for result string

  private final static Color COLOR_INCORRECT = Color.RED; 
  private final static Color COLOR_CORRECT = Color.GREEN;

  private boolean hideFramedRect;

  private int STARTY_ROW1 = 2;
  private int STARTY_ROW2 = 104;
  private int X_COLUMN2 = 102;
  private int X_COLUMN3 = 204;
  private int MAX_CARDS = 5; // max number of animal cards

  /* 
   * Name: begin 
   * Purpose: This begin method causes the canvas to start with the animal
   *          cards already on the screen with 3 images in 2 rows. It also
   *          initates the instance variables 
   * Parameters: None 
   * Return: void 
   */

  public void begin()
  {
    randInt = new RandomIntGenerator(0, MAX_CARDS);    
    result = new Text("", 0, 0, canvas);// correct or incorrect answer
    puppy = new Puppy (getImage("puppy.jpg"), new Location(0,STARTY_ROW1),
                       canvas);
    kitty = new Kitty (getImage("kitty.jpg"), 
                       new Location(X_COLUMN2,STARTY_ROW1), canvas);    
    cow = new Cow (getImage("cow.jpg"), new Location(X_COLUMN3,STARTY_ROW1),
                   canvas);
    lion = new Lion (getImage("lion.jpg"), new Location(0,STARTY_ROW2), 
                     canvas);
    duck = new Duck (getImage("duck.jpg"), 
                     new Location(X_COLUMN2,STARTY_ROW2), canvas);
    lamb = new Lamb (getImage("lamb.jpg"), 
                     new Location(X_COLUMN3,STARTY_ROW2), canvas);
    pickAnAnimal();
    hideFramedRect = false;
  }

  /* 
   * Name: onMouseClick 
   * Purpose: This method consists of a set of if statements that
   *          check to see if the mouse click point was on the 
   *          right animal card at the right time 
   * Parameters: point
   * Return: void 
   */
  public void onMouseClick( Location point )
  {
    removeHighlight();
    if(animal == null)
    { 
      canvas.clear();
      begin();
    }
    else if(animal.contains(point))
    {
      animal.showHighlight(COLOR_CORRECT);
      result.setText(correctAnswer);
      result.setColor(COLOR_CORRECT);
      animal = null;
    }
    else if (kitty.contains(point))
    {
      result.setText(wrongAnswer);
      result.setColor(COLOR_INCORRECT);
      kitty.showHighlight(COLOR_INCORRECT);
      hideFramedRect = true;
    }     
    else if (puppy.contains(point))
    {
      result.setText(wrongAnswer);
      result.setColor(COLOR_INCORRECT);
      puppy.showHighlight(COLOR_INCORRECT);
      hideFramedRect = true;
    }
    else if (duck.contains(point))
    {
      result.setText(wrongAnswer);
      result.setColor(COLOR_INCORRECT);
      duck.showHighlight(COLOR_INCORRECT);
      hideFramedRect = true;

    }
    else if (cow.contains(point))
    {
      result.setText(wrongAnswer);
      result.setColor(COLOR_INCORRECT);
      cow.showHighlight(COLOR_INCORRECT);
      hideFramedRect = true;

    }
    else if (lion.contains(point))
    {
      result.setText(wrongAnswer);
      result.setColor(COLOR_INCORRECT);
      lion.showHighlight(COLOR_INCORRECT);
      hideFramedRect = true;

    }
    else if (lamb.contains(point))
    {
      result.setText(wrongAnswer);
      result.setColor(COLOR_INCORRECT);
      lamb.showHighlight(COLOR_INCORRECT);
      hideFramedRect = true;
    }
    double R_CENTERX = ((canvas.getWidth() / 2) - 
                           (result.getWidth() / 2));

    result.moveTo(R_CENTERX, R_CENTERY );
    }  
   /* 
    * Name: removeHighlight 
    * Purpose: removes the high lighted boarder around each animal
    * Parameters: None 
    * Return: void. 
    */  
   public void removeHighlight()
   {
    if(hideFramedRect)
     {
       hideFramedRect = false;
       kitty.hideHighlight();
       puppy.hideHighlight();
       cow.hideHighlight();
       duck.hideHighlight();
       lion.hideHighlight();
       lamb.hideHighlight();
     }
   }
  /* 
   * Name: pickAnAnimal 
   * Purpose: This method consists of a switch statement that lists out
   *           the different possible cases of the animal cards. Also 
   *           because this method is called in begin the prompt is also
   *           listed here which is the question at the bottom of the canvas
   * Parameters: None 
   * Return: void 
   */
  private void pickAnAnimal()
  {
    int x = randInt.nextValue();
    switch (x)
    {
      case 0: animal = kitty;
      break;
      case 1: animal = puppy;
      break;
      case 2: animal = duck;
      break;
      case 3: animal = cow;
      break;
      case 4: animal = lion;
      break;
      case 5: animal = lamb;
      break;
    }
    prompt = new Text("Which animal says " + animal.speak() + "?", 0,0,
                       canvas);
    //question at bottom of canvas asks the question and uses any
    // of the animal's sounds
    double CENTER_X = ((canvas.getWidth() / 2) - (prompt.getWidth() / 2));
    prompt.moveTo(CENTER_X, CENTER_Y); 
    // variable for prompt has to be listed after the promt                                       
   }
}   
