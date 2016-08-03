/* 
 * Name: Leiasa Horanic 
 * Login: cs11wcs 
 * Date: February 22, 2014 
 * File: CrittersSimulator.java 
 * Sources of Help: Sachi, Jesse, Greg
 * 
 * This file is the critter simulator which basically makes the critters
 * move around the canvas. It only has one class that extends active object
 * so therefore it has a constructor and a run method that calls the 
 * critters to react to each other.
 */ 

import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/* 
 * Name: CrittersSimulator
 * Purpose: This class Critters simulator extends active object and 
 *          therefore has a constructor that creates the simulator
 *          and references some objects from the controller class like the
 *          array list. Overall this class cause each critter to react to
 *          the critter it is closest to.
 */
public class CrittersSimulator extends ActiveObject
{
  public ArrayList <Critter> critters;
  private double min;
  private int i, j;
  private static final int DELAY=50;

  /* 
   * Name: CrittersSimulator 
   * Purpose: This is a constructor of the critters simulator that is an
   *          active object. It takes an array list as a formal parameter
   *          and in the constructor the simulator is referencing the same
   *          array list from critters controller. We also call start to
   *          because it is an active object
   * Parameters: critters
   * Return: none it is a constructor 
   */
  public CrittersSimulator(ArrayList <Critter> critters)
  {
    this.critters = critters;
    start();
  }

  /* 
   * Name: run() 
   * Purpose: This is the run method if the active object critters simulator.
   *          In this method there is an infinte while that will continually
   *          keep running. This mehtod has 2 for loops. The first gets an 
   *          element or critter from the array list and assigns it to crit.
   *          Next in the second for loop gets a different element form the
   *          array list and makes it crit2. The it checks to make sure crit
   *          and crit2 are not the same element from the array list and 
   *          also checks to make sure crit and crit2 are not both chasers.
   *          It also gets the distance between crit and the different crit2
   *          and essentially checks to see which other critter crit is 
   *          closest to. Then this method will cause crit to react to crit2
   *          as long as crit  and crit2 passed all the checks
   * Parameters: none
   * Return: void
   */
  public void run()
  {
    Critter crit, crit2;
    while(true)
    {
      pause(DELAY);//pause time
      for(i=0; i < critters.size() && CrittersController.running; i++)
      {
        crit = critters.get(i);//gets crit from array list
        min = Double.MAX_VALUE;// sets min to max value
        Critter closestcrit = null;
        //initally assiging closestcrit since it is a local variable
        for(j=0; j < critters.size(); j++)
        {
          crit2 = critters.get(j);//gets crit2 from array list
          if( i == j)
          //checking to make sure i and j are not the same element from
          //the array list
          {
            continue;
          }
          double minLocal = crit.getLocation().distanceTo
                            (crit2.getLocation());
          //getting a distance
          if(!(crit instanceof Chaser && crit2 instanceof Chaser))
          //making sure crit and crit2 are not both chasers 
          {
            if( min > minLocal )
            {
              min = minLocal;
              closestcrit = crit2;
              //setting crit2 to closestcrit
            }
          }
          else 
          {
            continue;
          } 
        }
        crit.reactTo(closestcrit);
        //having the first we checked react to the closest critter to it
        //if crit and crit2 were both chaser then they will not react   
      } 
    }
  }
}
