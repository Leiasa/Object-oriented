/* 
 * Name: Leiasa Horanic 
 * Login: cs11wcs 
 * Date: February 3, 2014 
 * File: Highlightable.java 
 * Sources of Help: CSE 11 Website PA4 
 * 
 * This program consists of the highlightable interface. Enables the 
 * program to highlight the animal cards green and red 
 */ 

import java.awt.Color;

public interface Highlightable
{
  /* 
   * Name: showHighlight
   * Purpose: This mehtod is listed in each animal class. It will show 
   *          highlight when called 
   * Parameters: color
   * Return: void 
   */
  public void showHighlight( Color color ); 
 
  /* 
   * Name: hideHighlight
   * Purpose: This mehtod is listed in each animal class. It will hide
   *           highlight when called
   * Parameters: none
   * Return: void 
   */
  public void hideHighlight();

  /* 
   * Name: getHighlightColor
   * Purpose: This mehtod is listed in each animal class. It gets the color
   *          of the highlight 
   * Parameters: none
   * Return: color
   */  
  public Color getHighlightColor(); 
}
