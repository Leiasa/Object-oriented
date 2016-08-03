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
public class Memory extends WindowController

{
  private AnimalCard animal;
  private AnimalCard kitty;
  private AnimalCard puppy;
  private AnimalCard duck;
  private AnimalCard cow;
  private AnimalCard lion;
  private AnimalCard lamb;
  private AnimalCard kitty2;
  private AnimalCard puppy2;
  private AnimalCard duck2;
  private AnimalCard cow2;
  private AnimalCard lion2;
  private AnimalCard lamb2;
  public AnimalCard card1;
  public AnimalCard card2;

  private RandomIntGenerator randInt;
  private Text sound;
  private String correctAnswer = "CORRECT-- Click mouse to restart.";
  private String wrongAnswer = "INCORRECT-- Try Again!";
  private final static Color COLOR_INCORRECT = Color.RED; 
  private final static Color COLOR_CORRECT = Color.GREEN;
  private boolean hideFramedRect;
  private int STARTY_ROW1 = 2;
  private int STARTY_ROW2 = 104;
  private int X_COLUMN2 = 102;
  private int X_COLUMN3 = 204;
  private int valueX;
  private int valueY;
  private int PIC_WIDTH = 102;
  private int PIC_HEIGHT = 102;
  private int MAX_X = 202;
  private int NUMBOFCARDS = 11; // the total amount of animal cards
  private boolean correct = false;
  private double CENTETRY = 420; 
  
  private boolean animalsMatch = false;
  private boolean checkAnimal = true;
  private static FramedRect frame0;
  private static FramedRect frame1;
  private static FramedRect frame2;
  private static FramedRect frame3;
  private static FramedRect frame4;
  private static FramedRect frame5;
  private static FramedRect frame6;
  private static FramedRect frame7;
  private static FramedRect frame8;
  private static FramedRect frame9;
  private static FramedRect frame10;
  private static FramedRect frame11;

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
        randInt = new RandomIntGenerator(0, NUMBOFCARDS );
    sound = new Text("", 0,0, canvas);
    double CENTERX = (canvas.getWidth() / 2) - (sound.getWidth() / 2);
    valueX = 0;
    valueY = 0;
    sound.moveTo(CENTERX,CENTETRY);//moves animal sound to center
    int count = 0;
    
    while (count<=  NUMBOFCARDS) //places animal cards in grid 
    {
      placeNextAnimal(); //calls method with animal constructors
      if(valueX < MAX_X)
      {
        valueX += PIC_WIDTH;
      }
      else
      {
        valueX = 0;
        valueY += PIC_HEIGHT;
      }
        count++;
    }
   
    hideFramedRect = false;
  
  }
   /* 
    * Name: Class or method name 
    * Purpose: This method checks each animal to see if it was clicked. 
    *          If the animal is already shown then the if statement will
    *          return null. If the animal is not shown yet the if statement
    *          returns that animal card 
    * Parameters: point 
    * Return: animal card
    */
   public AnimalCard checkAnimal(Location point)
  {
    if(kitty.contains(point))
    {
      if( kitty.shown() )
      {
        return null;
      }
      return kitty;
    } 
    else if(kitty2.contains(point))
    {
      if( kitty2.shown() )
      {
        return null;
      }
      return kitty2;
    } 

    else if(puppy.contains(point))
   {
      if( puppy.shown())
      {
        return null;
      }
      return puppy;
    } 
    else if(cow.contains(point) )
    {
     
      if( cow.shown() )
      {
        return null;
      }
      return cow;
    } 
    else if(duck.contains(point))
   {
      if( duck.shown())
      {
        return null;
      }
      return duck;
    } 
    else if(lion.contains(point))
   {
      if( lion.shown() )
      {
        return null;
      }
      return lion;
    } 
    else if(lamb.contains(point))
   {
      if( lamb.shown() )
      {
        return null;
      }
      return lamb;
    } 
    else if(puppy2.contains(point))
    {
      if( puppy2.shown() )
      {
        return null;
      }
      return puppy2;
    } 
    else if(cow2.contains(point))
   {
      if( cow2.shown() )
      {
        return null;
      }
      return cow2;
    } 
    else if(duck2.contains(point))
   {
      if( duck2.shown() )
      {
        return null;
      }
      return duck2;
    } 
    else if(lion2.contains(point))
    {
      if( lion2.shown() )
      {
        return null;
      }
      return lion2;
    } 
    else if(lamb2.contains(point))
    {
      if( lamb2.shown() )
      {
        return null;
      }
     return lamb2;      
    }
 return null;
  }

  /* 
   * Name: onMouseClick 
   * Purpose: This method assigns the animals that have been clicked to card1
   *          and card2.When an animal card is set to card1 and card2 it will
   *          show the card. Then it checks to see if the cards have the same 
   *          image. If card1 and card2 are the same it will highlight them
   *          with a green boarder and leave them shown for the entire game. 
   *          If card1 and card2 do not equal then it will highlight them in
   *          red at first and then hide both of the cards. Also this method 
   *          checks to see if both matching images have been shown then
   *          hide the original black boarder. 
   * Parameters: None 
   * Return: void 
   */
 
  public void onMouseClick( Location point )
  { 
    animal = checkAnimal(point);
    if( animal == null && card1 != null && card2 != null && correct )
    {
      return;
    }
    if( card1 == null && card2 == null)
    { 
      card1 = animal;
      card1.show();// show the card clicked
      
    }
    else if( card1 != null && card2 == null)
    {
      card2 = animal;
      card2.show();    
 
      if (card1 .equals(card2))//if same matching cards are clicked
      {
        card1.showHighlight(COLOR_CORRECT);
        card2.showHighlight(COLOR_CORRECT); 
        correct = true;
        sound.setText(card1.speak());
      }
      else
      {
        card1.showHighlight(COLOR_INCORRECT);
        card2.showHighlight(COLOR_INCORRECT);
        correct = false;
      } 
    }
    else if( card1 != null && card2 != null )
    {
      if( !correct )//if card1 and card2 are somthing but do not match
      {
        card1.hide();
        card2.hide();
        card1.hideHighlight();
        card2.hideHighlight();
        card1 = null;//resetting card1
        card2 = null;//resetting card2
        correct = true;
       }
       else if (correct)
       { 
         card1 = null;
         card2 = null;
       } 
    } 
    //checks all cards to know when to hide black boarder
    if (kitty.shown() && kitty2.shown())
    {
      frame0.hide();
      frame6.hide();
    }
    if(puppy.shown() && puppy2.shown())
    {
      frame1.hide();
      frame7.hide();
    }
    if(cow.shown() && cow2.shown())
    {
      frame3.hide();
      frame9.hide();
    }
    if(duck.shown() && duck2.shown())
    {
      frame2.hide();
      frame8.hide();
    }
    if(lion.shown() && lion2.shown())
    {
      frame4.hide();
      frame10.hide();
    }
    if(lamb.shown() && lamb2.shown())
    {
      frame5.hide();
      frame11.hide();
    }     
 }
  /* 
 * Name: placeNextAnimal
 * Purpose: This method has a switch statement that constructs all of the 
 *          animals and the black boarders that go around them. It also
 *          hides the image once it is created so when the game starts 
 *          the user can not see the images.
 * Parameters: None 
 * Return: void 
 */  
  private void placeNextAnimal()
  {
    int x = randInt.nextValue();
    switch (x)
    {
      case 0:  
        if (kitty == null)
        {
          kitty = new Kitty (getImage("kitty.jpg"), 
          new Location(valueX, valueY), canvas);
	  kitty.hide();
          frame0 = new FramedRect (valueX, valueY, 100,100, canvas);
        }
        else 
        {
        placeNextAnimal();
        }      
      break;
      case 1: 
        if (puppy == null) 
        {
          puppy = new Puppy (getImage("puppy.jpg"),
          new Location(valueX, valueY), canvas);
          puppy.hide();
          frame1 = new FramedRect (valueX, valueY, 100,100, canvas);
        }
        else 
        {
          placeNextAnimal();
        }    
      break;
      case 2: 
        if (duck == null) 
        {
          duck = new Duck (getImage("duck.jpg"), 
          new Location(valueX, valueY), canvas);
          duck.hide();
          frame2 = new FramedRect (valueX, valueY, 100,100, canvas);
        }
        else 
        {
          placeNextAnimal();
        }
      break;
      case 3: 
        if(cow == null) 
        { 
          cow = new Cow (getImage("cow.jpg"), new Location(valueX, valueY),
                canvas);
         cow.hide();
         frame3 = new FramedRect (valueX, valueY, 100,100, canvas);

        }
        else 
        {
          placeNextAnimal();
        }
      break;
      case 4: 
        if (lion == null) 
        {
          lion = new Lion (getImage("lion.jpg"), 
          new Location(valueX, valueY), canvas);
          lion.hide();
          frame4 = new FramedRect (valueX, valueY, 100,100, canvas);
        }
        else 
        {
          placeNextAnimal();
        }
      break;
      case 5: 
        if (lamb == null) 
        {
          lamb = new Lamb (getImage("lamb.jpg"), new Location(valueX, valueY),
                           canvas);
          lamb.hide();
          frame5 = new FramedRect (valueX, valueY, 100,100, canvas);

        }
        else 
        {
          placeNextAnimal();
        }
      break;
      case 6: 
        if (kitty2 == null) 
        {
          kitty2 = new Kitty (getImage("kitty.jpg"), 
                   new Location(valueX, valueY), canvas);
         kitty2.hide();
         frame6 = new FramedRect (valueX, valueY, 100,100, canvas);

        }
        else 
        {
          placeNextAnimal();
        }
      break;
      case 7: 
        if(puppy2 == null)  
        {
          puppy2 = new Puppy (getImage("puppy.jpg"),
                   new Location(valueX, valueY), canvas);
         puppy2.hide();
        frame7 = new FramedRect (valueX, valueY, 100,100, canvas);

        }
        else 
        {
          placeNextAnimal();
        }
      break;
      case 8: 
        if(duck2== null) 
        {
          duck2 = new Duck (getImage("duck.jpg"), 
                            new Location(valueX, valueY), canvas);
         duck2.hide();
         frame8 = new FramedRect (valueX, valueY, 100,100, canvas);
        }           
        else 
        {
          placeNextAnimal();
        }
      break;
      case 9: 
        if(cow2 == null) 
        { 
          cow2 = new Cow (getImage("cow.jpg"), new Location(valueX, valueY),
                          canvas);
         cow2.hide();
         frame9 = new FramedRect (valueX, valueY, 100,100, canvas);
        }
        else 
        {
          placeNextAnimal();
        }
      break;
      case 10: 
      if(lion2 == null) 
      {
        lion2 = new Lion (getImage("lion.jpg"), new Location(valueX, valueY),
                          canvas);
        lion2.hide();
         frame10 = new FramedRect (valueX, valueY, 100,100, canvas);
      }
      else 
      {
        placeNextAnimal();
      }
      break;
      case 11: 
      if(lamb2 == null) 
      {
        lamb2 = new Lamb (getImage("lamb.jpg"), new Location(valueX, valueY),
                          canvas);
        lamb2.hide();
        frame11 = new FramedRect (valueX, valueY, 100,100, canvas);
      }
      else 
      {
        placeNextAnimal();
      }
      break;
    }
  }
}   
