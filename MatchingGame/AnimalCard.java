/* 
 * Name: Leiasa Horanic 
 * Login: cs11wcs 
 * Date: February 3, 2014 
 * File: Hideable.java 
 * Sources of Help: CSE 11 Website PA4 
 * 
 * This program consists of the animal card interface. Enables the 
 * program to access the other interfaces in this directory
 */ 



interface AnimalCard extends Speakable, Highlightable, Hideable
{
  @Override
 /*  
  * Name: equals
  * Purpose: This mehtod is inside each of the animal class. It is stated 
  *          here in this intereface that is why there is no body.
  * Parameters: Object o
  * Return: true or false 
  */
  public abstract boolean equals(Object o);
  
  /*  
   * Name: shown
   * Purpose: This mehtod is inside each of the animal class. It is stated 
   *          here in this intereface that is why there is no body.
   * Parameters: none
   * Return: true or false 
   */
  public boolean shown();
  
} 

