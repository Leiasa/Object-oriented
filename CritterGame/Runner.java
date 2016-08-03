/* 
 * Name: Leiasa Horanic 
 * Login: cs11wcs 
 * Date: February 22, 2014 
 * File: Runner.java 
 * Sources of Help: Sachi, Wendy
 * 
 * This file is basically a contructor of the new object runner. The code
 * consists of a constructor for the runner and two other methods. One that
 * gets the current location of the runner and on that moves the object
 * based on how close it is to any other critter. In the end it will have
 * the effect of making the runner object run away from any critter around
 * the canvas.
 */ 

import objectdraw.*;
import java.awt.*;

/* 
 * Name: Runner
 * Purpose: This class uses a contructor for a new object called runner which
 *          looks like a circle. Also this class moves the object runner 
 *          around based on a how close the runner is to other objects and 
 *          checks to see if a runner object hits an edge to move to a new
 *          random.
 *           
 */
public class Runner extends Critter
{
  private FilledOval runner;
  private Location point;
  private DrawingCanvas canvas2;
  private RandomDoubleGenerator rand;
  private double X, Y;
  private static final int RUNNER_WIDTH = 15;
  private static final int RUNNER_HEIGHT = 15;
  private static final Color RUNNER_COLOR = Color.MAGENTA;

  /* 
   * Name: Runner
   * Purpose: This is a constructor of the object runner which is created by 
   *          a filled oval that forms a circle shape. It also sets its color
   *          to be magenta. Also the random double generator is created here
   *          that will be used to move the runner object later.
   * Parameters: point, canvas
   * Return: none it is a constructor 
   */
  public Runner(Location point, DrawingCanvas canvas)
  {
    super(point, canvas);
    this.point = point;
    runner = new FilledOval( point, RUNNER_WIDTH, RUNNER_HEIGHT, canvas);
    runner.setColor(RUNNER_COLOR);//setting color
    canvas2 = canvas;
    rand = new RandomDoubleGenerator(0, canvas2.getHeight());
    //used for moving runner to a new random location when it hits an edge
  }

  /* 
   * Name: reactTo
   * Purpose: This method checks to see which movement will put the runner
   *          object furthest away from any other critter and then moves the
   *          runner by 1 in the x and y direction.In this method
   *          it also checks to see if the runner object has hit the edge
   *          of the canvas and if it has to move the runner object to a 
   *          new random location using the values generated from rand.
   * Parameters: other
   * Return: void 
   */
  public void reactTo(Critter other)
  {
    if(other != null)
    {
      Location runnerLocation = this.getLocation(); 
      double runnerXLoc = runnerLocation.getX();
      double runnerYLoc = runnerLocation.getY();  
      Location otherLocation = other.getLocation(); 
      double otherXLoc =  otherLocation.getX();
      double otherYLoc = otherLocation.getY();
      //These 4 if statements are checking which way to move the runner that
      // will put runner further away from other critter         
      if(runnerXLoc >= otherXLoc)
      {
        runner.move(1, 0);
        runnerXLoc++;
        Location newLoc = new Location(runnerXLoc+1,runnerYLoc);
        setLocation(newLoc);
      }
      if(runnerXLoc < otherXLoc)
      {
        runner.move(-1, 0);
        runnerXLoc--;
        Location newLoc = new Location(runnerXLoc-1,runnerYLoc);
        setLocation(newLoc);
      }
      if(runnerYLoc >= otherYLoc)
      {
        runner.move(0, 1);
        Location newLoc = new Location(runnerXLoc,runnerYLoc+1);
        setLocation(newLoc);
      }
      if(runnerYLoc < otherYLoc)
      {
        runner.move(0, -1);
        Location newLoc = new Location(runnerXLoc,runnerYLoc-1);
        setLocation(newLoc);
      }

      X = rand.nextValue();//getting random x value from double generator
      Y = rand.nextValue();// getting random y value from double generator

      //This if else if statement is checking to see if the runner has hit the
      //edge of the canvas and if it did to move it to a new random location 
      if(this.getLocation().getX() >= 
        (double)canvas2.getWidth()-RUNNER_WIDTH)
      {
        runner.moveTo(X, Y);
        Location newLoc = new Location(X,Y);
        setLocation(newLoc);
      }
      else if (this.getLocation().getX() <= 0.0)
      {
        runner.moveTo(X, Y);
        Location newLoc = new Location(X,Y);
        setLocation(newLoc);
      }
      else if (this.getLocation().getY() >= 
              (double)canvas2.getHeight()-RUNNER_HEIGHT)
      {
        runner.moveTo(X, Y);
        Location newLoc = new Location(X,Y);
        setLocation(newLoc);
      }
      else if (this.getLocation().getY() <= 0.0)
      {
        runner.moveTo(X, Y);
        Location newLoc = new Location(X,Y);
        setLocation(newLoc);
      }
    }
  }
}
