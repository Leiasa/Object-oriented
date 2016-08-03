/* 
 * Name: Leiasa Horanic 
 * Login: cs11wcs 
 * Date: February 3, 2014 
 * File: Hideable.java 
 * Sources of Help: CSE 11 Website PA4 
 * 
 * This program consists of the speakable interface. Enables the 
 * program to give the animals a string to speak and checks to 
 * see if the point is contained.
 */ 


import objectdraw.*;

public interface Speakable
{
  /* 
   * Name: speak
   * Purpose: This mehtod is listed in each animal class. It creates the
   *          animal sound 
   * Parameters: none
   * Return: string 
   */
  public String speak();

  /* 
   * Name: contains
   * Purpose: This mehtod is listed in each animal class
   * Parameters: point
   * Return: true of false
   */
  public boolean contains( Location Point);
}
