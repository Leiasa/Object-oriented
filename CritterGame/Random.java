/* 
 * Name: Leiasa Horanic 
 * Login: cs11wcs 
 * Date: February 22, 2014 
 * File: Random.java 
 * Sources of Help: Sachi, Wendy
 * 
 * This file is basically a contructor of the new object random. The code
 * consists of a constructor for the random and one other method that
 * moves the object randomly based on a random generator. 
 */ 

import objectdraw.*;
import java.awt.*;

/* 
 * Name: Random
 * Purpose: This class use a contructor for a new object called random which
 *          looks like a cross. Also this class moves the object randomly 
 *          around based on a random generator, rand. The second method 
 *          also checks to see if the random object has hit the edge and if
 *          it has to move the random object to a new random location using
 *          rand2
 */

public class Random extends Critter
{
  private Line xLine, yLine;
  private RandomDoubleGenerator rand, rand2;
  private DrawingCanvas canvas2;
  private double X, Y, X2, Y2;

  private static final double RANDOM_RADIUS = 7.5;
  private static final double MIN_RAND = -10.0;
  private static final double MAX_RAND = 10.0;
  private static final int RANDOM_DIAMTER = 15;
  private static final Color RANDOM_COLOR = Color.ORANGE;

  /* 
   * Name: Random 
   * Purpose: This is a constructor of the object random which is created by 
   *          two lines forming a cross looking object. It also sets its
   *          color to be orange. There is a random double generator created
   *          here called rand that is used to actually move the random 
   *          object around. There is a second random generator called rand2
   *          this generator is used to find a new value to move the random
   *          object to when it hits the edge of the canvas
   * Parameters: point, canvas
   * Return: none it is a constructor 
   */
  public Random(Location point, DrawingCanvas canvas)
  {
    super(point, canvas);

    xLine = new Line(point.getX(), (double) point.getY() + RANDOM_RADIUS,
                     point.getX() + RANDOM_DIAMTER , 
                     (double) point.getY() + RANDOM_RADIUS, canvas);
    yLine = new Line((double) point.getX() + RANDOM_RADIUS, point.getY(),
                     (double) point.getX( )+ RANDOM_RADIUS,
                     point.getY() + RANDOM_DIAMTER , canvas);
    xLine.setColor(RANDOM_COLOR);//set color
    yLine.setColor(RANDOM_COLOR);//set color
    canvas2 = canvas;
    rand = new RandomDoubleGenerator(MIN_RAND, MAX_RAND);
    //random generator for moving the random around
    rand2 = new RandomDoubleGenerator(0, canvas2.getHeight());
    //random generator for picking a new random location to move the random
    //object when it hits an edge
  }
 
  /* 
   * Name: reactTo
   * Purpose: This method retrevies random doubles from the random double
   *          generator, rand, above and moves the object. In this method
   *          it also checks to see if the random object has hit the edge
   *          of the canvas and if it has to move the random object to a 
   *          new random location using the values generated from rand2.
   * Parameters: other
   * Return: void 
   */
  public void reactTo(Critter other)
  {
    if( other != null)
    {
      X = rand.nextValue();
      Y = rand.nextValue();
      xLine.move(X, 0);
      yLine.move(X, 0);
      xLine.move(0, Y);
      yLine.move(0, Y); 
      Location newLoc = new Location((xLine.getStart().getX()+RANDOM_RADIUS),
                                    (yLine.getStart().getY()-RANDOM_RADIUS));
      setLocation(newLoc);
      X2 = rand2.nextValue();
      Y2 = rand2.nextValue();

      /*This if else if statement is checking to see if the random has hit
       *the edge of the canvas and if it did to move it to a new random
       *location 
       */
      if(this.getLocation().getX() >= 
        (double)canvas2.getWidth()-RANDOM_DIAMTER)
      {
        xLine.moveTo(X2-RANDOM_RADIUS, Y2 );
        yLine.moveTo(X2, Y2 - RANDOM_RADIUS);
        Location newLoc2 = new Location(X2, Y2);
        setLocation(newLoc2);
      }
      else if (this.getLocation().getX() <= 0.0)
      {
        xLine.moveTo(X2-RANDOM_RADIUS, Y2);
        yLine.moveTo(X2, Y2 - RANDOM_RADIUS);
        Location newLoc2 = new Location(X2, Y2);
        setLocation(newLoc2); 
      }
      else if (this.getLocation().getY() >= 
              (double)canvas2.getHeight()-RANDOM_DIAMTER)
      {
        xLine.moveTo(X2 - RANDOM_RADIUS, Y2);
        yLine.moveTo(X2, Y2 - RANDOM_RADIUS);
        Location newLoc2 = new Location(X2, Y2);
        setLocation(newLoc2);
      }
      else if (this.getLocation().getY() <= 0.0)
      {
        xLine.moveTo(X2 - RANDOM_RADIUS, Y2);
        yLine.moveTo(X2, Y2 - RANDOM_RADIUS);
        Location newLoc2 = new Location(X2, Y2);
        setLocation(newLoc2);
      } 
    }  
  }
}
