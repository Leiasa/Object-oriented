/* 
 * Name: Leiasa Horanic 
 * Login: cs11wcs 
 * Date: February 22, 2014 
 * File: Chaser.java 
 * Sources of Help: Sachi, Wendy
 * 
 * This file is basically a contructor of the new object chaser. The code
 * consists of a constructor for the chaser and two other methods. One that
 * gets the current location of the cahser and on that moves the object
 * based on how close it is to any other critter. In the end it will have
 * the effect of making the chaser object chase other critters around the
 * canvas 
 */ 

import objectdraw.*;
import java.awt.*;
 
/* 
 * Name: Chaser
 * Purpose: This class use a contructor for a new object called chaser which
 *          is a square. Also this class moves the object chaser 
 *          around based on a how close the chaser is to other objects 
 */
public class Chaser extends Critter
{
  private FilledRect chaser;
  private Location point;
  private DrawingCanvas canvas2;
  private RandomDoubleGenerator rand;
  private double X, Y;
  private static final int CHASER_WIDTH = 15;
  private static final int CHASER_HEIGHT = 15;
  private static final Color CHASER_COLOR = Color.CYAN;

  /* 
   * Name: Chaser 
   * Purpose: This is a constructor of the object chaser which is created by 
   *          using a filled rectangle and making it a square. It also sets
   *          its color to be cyan. Also the random double generator is
   *          created here that will be used to move the runner object 
   *          later.
   * Parameters: point, canvas
   * Return: none it is a constructor 
   */
  public Chaser(Location point, DrawingCanvas canvas)
  {
    super(point, canvas);
    chaser = new FilledRect( point, CHASER_WIDTH , CHASER_HEIGHT, canvas);
    chaser.setColor(CHASER_COLOR);//set color
    canvas2 = canvas;
    rand = new RandomDoubleGenerator(0, canvas2.getHeight());
    //used for moving runner to a new chaser location when it hits an edge
  }

  /* 
   * Name: reactTo
   * Purpose: This method checks to see which movement will put the chaser
   *          object closest to any other critter and then moves the chaser
   *          that chaser by 1 in the x and y direction
   * Parameters: other
   * Return: void 
   */
  public void reactTo(Critter other)
  {
    if(other != null)
    {
      Location chaserLocation = this.getLocation();  
      double chaserXLoc = chaserLocation.getX();
      double chaserYLoc = chaserLocation.getY();  
      Location otherLocation = other.getLocation(); 
      double otherXLoc =  otherLocation.getX();
      double otherYLoc = otherLocation.getY();

      //These 4 if statements are checking which way to move the chaser that
      // will put chaser closer to any other critter   
      if(chaserXLoc >= otherXLoc)
      {
        chaser.move(-1, 0);
        chaserXLoc--;
        Location newLoc = new Location(chaserXLoc-1,chaserYLoc);
        setLocation(newLoc); 
      }
      if(chaserXLoc < otherXLoc)
      {
        chaser.move(1 , 0);
        chaserXLoc++;
        Location newLoc = new Location(chaserXLoc+1,chaserYLoc);
        setLocation(newLoc);
      }
      if(chaserYLoc >= otherYLoc)
      {
        chaser.move(0, - 1);
        Location newLoc = new Location(chaserXLoc,chaserYLoc-1);
        setLocation(newLoc);
      }
      if(chaserYLoc < otherYLoc)
      {
        chaser.move(0, 1);
        Location newLoc = new Location(chaserXLoc,chaserYLoc+1);
        setLocation(newLoc);
      }

      X = rand.nextValue();
      Y = rand.nextValue();

      //This if else if statement is checking to see if the chaser has hit the
      //edge of the canvas and if it did to move it to a new random location 
      if(this.getLocation().getX() >= (double)canvas2.getWidth()-CHASER_WIDTH)
      {
        chaser.moveTo(X, Y);
        Location newLoc = new Location(X,Y);
        setLocation(newLoc);
      }
      else if (this.getLocation().getX() <= 0.0)
      {
        chaser.moveTo(X, Y);
        Location newLoc = new Location(X,Y);
        setLocation(newLoc);
      }
      else if (this.getLocation().getY() >= 
             (double)canvas2.getHeight()-CHASER_HEIGHT)
      {
        chaser.moveTo(X, Y);
        Location newLoc = new Location(X,Y);
        setLocation(newLoc);
      }
      else if (this.getLocation().getY() <= 0.0)
      {
        chaser.moveTo(X, Y);
        Location newLoc = new Location(X,Y);
        setLocation(newLoc);
      }
    }
  }
}
