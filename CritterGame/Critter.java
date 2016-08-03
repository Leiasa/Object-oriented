/* 
 * Name: Leiasa Horanic 
 * Login: cs11wcs 
 * Date: February 22, 2014 
 * File: Critter.java 
 * Sources of Help: Sachi, Wendy
 * 
 * This file Critter consists of four methods one being a constructor of
 * the object critter. There are two methods that deal with getting and
 * setting a location that can be used by critters sub classes. And an
 * abstract method reactTo() which is also in each of the critter sub 
 * classes where the body of the method can be found since it is different
 * for every critter.
 */ 

import objectdraw.*;
import java.awt.*;

/* 
 * Name: Critter
 * Purpose: This class is an abstract class that is basically used to keep
 *          track and handle the subclasses Runner, Chaser, and Random. Also
 *          it is used to get and set location of all the different types of
 *          critters
 */
public abstract class Critter
{
  public Location current;
  public double xloc,yloc;

  /* 
   * Name: Critter
   * Purpose: This is a constructor of the object Critter which can be any 
   *          objects that are of type critter. For example runner is a
   *          critter. It sets the current location of the critter to 
   *          current   
   * Parameters: point, canvas
   * Return: none it is a constructor 
   */
  public Critter(Location loc, DrawingCanvas canvas)
  {
    current = loc;
  }
  /* 
   * Name: setLocation
   * Purpose: This method is setting the current location
   * Parameters: point
   * Return: void 
   */
  public void setLocation(Location point)
  {
    current = point;
  }
  /* 
   * Name: getLocation
   * Purpose: This method gets the current location and returns it
   * Parameters: none
   * Return: type Location current
   */
  public Location getLocation()
  {
    return current; 
  }
  /* 
   * Name: reactTo
   * Purpose: This method consists of just the mehtod header because the 
   *          body of this method is different for each critter
   * Parameters: none
   * Return: void
   */
  public abstract void reactTo(Critter other); 
}
