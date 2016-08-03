/* 
 * Name: Leiasa Horanic 
 * Login: cs11wcs
 * Date: February 16, 2014 
 * File: ReverseRecurse.java 
 * Sources of Help: Nick, Dennis
 *
 * This program is interactive in that it requires input from a user. When
 * the program is first run it will ask the user to input an integer. This
 * integer is then used to create an array of that size. The program then 
 * tells the user to input integers to fill that size array that was created.
 * Then the user inputs EOF and the program goes on to print the array, 
 * reverser the array, make a copy of the array, and then reverse that array. 
 */ 

import java.util.Scanner;

/* 
 * Name: ReverseRecurse 
 * Purpose: Basically this class creates an array based off of user input.
 *          Then this class uses different methods to print the array, 
 *          reverse the array, copy the array, and reverse the copied array.  
 */
public class ReverseRecurse
{
  private int counter;
  private int number;
  private int [] initArray;
  private int [] newinitArray;
  /* 
   * Name: initArray
   * Purpose: This method uses a scanner to get the user input. Then using
   *          that input it constructs an array of that size and fills it
   *          with what the user inputs to fill the array. It also checks to
   *          make sure the user actually input integers to fill the array.
   * Parameters: None 
   * Return: initArray 
   */
  public int[] initArray()
  {
    Scanner input = new Scanner( System.in );//scanner to get user input
    System.out.print( "Maximum number of integers you wish to enter? " );
    //asking user how big they want the array to be
    number = input.nextInt(); // number is equal to the user input
    while ( number <= 0)
    //checking to make sure user input a int greater than 0 so array can be
    //made
    {
      System.out.println("You must enter a value > 0; Try again.");
      System.out.println("");
      System.out.print( "Maximum number of integers you wish to enter? " );
      //asking user again how big they want the array to be
      number = input.nextInt(); // number is equal to the user input
    }
    if( number > 0)
    {
    initArray = new int[number];// creating array of size inputed by user
    System.out.println("");//creating a blank line between
    System.out.println("Enter up to " + number + " integers:");
    // asking user to what ints they want to fill array
    }
    while ( input.hasNextInt() && counter < number)
    //counting how many ints user inputs
    {
      initArray[counter] = input.nextInt();
      counter++;
    }
    if( counter < number)
    //if counted ints entered is less than how big the initArray was
    //constructed make a new array this new size
    {
     newinitArray =  new int[counter];
     System.arraycopy(initArray, 0, newinitArray, 0, counter);
     return newinitArray;
    }
    return initArray;
  }
  /* 
   * Name: printArray 
   * Purpose: This method checks to make sure the array is not empty. If it 
   *          is not then it prints the each int of the array on the same 
   *          line with one space in between.
   * Parameters: array
   * Return: void 
   */
  public void printArray( int[] array )
  {
    if( counter == 0 )
    //if nothing is inputed counter is 0 and array is empty
    {
      System.out.println("Empty array");
    }
    else
    {
      for( int i=0; i < array.length; i++)
      {
        System.out.print(array[i]+" ");//spacing between outputed array
      }
      System.out.println("");
    }
  }
  /* 
   * Name: reverse 
   * Purpose: This method checks to make sure the original array is not 
   *          equal to null. If is not then it will reverse the orginal
   *          array
   * Parameters: originalArray, low, high
   * Return: void 
   */
  public void reverse( int[] originalArray, int low, int high )
  {
    if(originalArray != null)
    {
      if(low<high)
      //reversing array
      {
        int tmp = originalArray[low];
        originalArray[low] = originalArray[high];
        originalArray[high] = tmp;
        reverse(originalArray, ++low, --high);
      }
    } 
  }
  /* 
   * Name: reverse 
   * Purpose: This method checks to make sure the array is not empty. If it 
   *          is not then it makes a new array called copiedArray and then
   *          copies the orginalArray. Next this method reverse the 
   *          copiedArray.
   * Parameters: originalArray
   * Return: copiedArray, null
   */
  public int[] reverse( int[] originalArray )
  {
    if( originalArray != null)
        {
      int[] copiedArray = new int[originalArray.length];
      //creating a copied array to manipulate
      System.arraycopy(originalArray, 0, copiedArray, 0, 
                       originalArray.length);
      reverse(copiedArray, 0, copiedArray.length-1);//reversing copiedArray
      return copiedArray;
    }
    return null;   
  }
}

