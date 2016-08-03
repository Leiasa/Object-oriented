/* 
 * Name: Leiasa Horanic 
 * Login: cs11wcs 
 * Date: February 16, 2014 
 * File: SlotWheel.java 
 * Sources of Help: Sachi, Nick, Wendy
 * 
 * This program consists of a constructor for a object slot wheel. The slot
 * wheel created is an active object. This program also implements an action
 * listener so that each slot wheel is able to listen for when the spin
 * button is pressed. Also this program consists of a loop that spins the
 * slot wheels. 
 */ 
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;

/* 
 * Name: SlotWheel 
 * Purpose: This class extends an active object which is the slot wheel and
 *          extends an action listener so that every slot wheel object
 *          created can listen for the action preformed which is the spin
 *          button being pressed. It of course has a constructor which 
 *          constructs the SlotWheel. When the button is clicked the slot
 *          wheels spin each slot wheel spins a different amount of times. 
 */
public class SlotWheel extends ActiveObject implements ActionListener
{
  private FramedRect slotWheelBorder;
  private RandomDoubleGenerator rand;
  private Image [] pic;
  private VisibleImage image;
  private int valueReturned;
  private int tick, delay, tickCount;
  private static final int TWO = 2;
  private static final int NUM_OF_IMAGES = 8; 
  private static final int FULL_IMAGE_SUNGOD = 0;
  private static final int FULL_IMAGE_BEAR = 2;
  private static final int FULL_IMAGE_TRITON =4;
  private static final int FULL_IMAGE_LIBRARY = 6;
  private static final double HIGHEST_VALUE_SUNGOD = 0.25;
  private static final double LOWEST_VALUE_BEAR = 0.25;
  private static final double HIGHEST_VALUE_BEAR = 0.50;
  private static final double LOWEST_VALUE_TRITON = 0.50;
  private static final double HIGHEST_VALUE_TRITON = 0.75;

  boolean spinning;
  
  /* 
   * Name: SlotWheel
   * Purpose: This is the constructor of the object slot wheel. There is a
   *          random generator that essentially picks a solid picture to 
   *          initally fill the slot wheel. Becuase the slot wheel is an
   *          active object start is also called here.
   * Parameters: pic, ticks, delays, location, canvas 
   * Return: no return because it is a constructor 
   */
  public SlotWheel(Image[] pic, int ticks, int delays, Location location,
                   DrawingCanvas canvas)
  {
    tick = ticks;
    delay = delays;
    this.pic = pic;
    tickCount = 0;
    rand = new RandomDoubleGenerator(0, 1);
    valueReturned = getWheelIndex(rand.nextValue());
    image = new VisibleImage( pic[valueReturned], location  ,canvas);

    start();
  }
  /* 
   * Name: run 
   * Purpose: This method is responsible for spinning the slot wheels. It 
   *           spins them a different amount of times depending on which 
   *           slot wheel it is.
   * Parameters: None 
   * Return: void 
   */
  public void run()
  {
    while(true)//infinte loop
    { 
      synchronized(this)//to make sure only this piece of code is ran
      {
        if(tickCount != 0)
        {
          valueReturned++;
          tickCount--;
          //subtracts one from the number of ticks of that specific slot 
          //wheel
          image.setImage(pic[valueReturned % NUM_OF_IMAGES]);
          //changing the image and making it a circular array
         }
         else if (valueReturned % TWO == 1)
         //making sure final picture is a full picture
         {  
           valueReturned++;
           image.setImage(pic[valueReturned % NUM_OF_IMAGES]);
           //changing the image and making it a circular array
         }
      }
      pause(delay);//how fast the wheel is spinning
    } 
  }
  /* 
   * Name: actionPerformed 
   * Purpose: This method checks to see if the user clicked the spin button
   *          and if they did to set the tickCount to the amount of ticks 
   *          that wheel. By doing this tickCount is no longer zero so the 
   *          wheel is ale to spin
   * Parameters: evt
   * Return: void 
   */ 
  public void actionPerformed( ActionEvent evt )
  {
    if(evt.getSource() == Slots.spinButton)
    {
      synchronized(this)
      {
        tickCount = tick;
        //setting the tickCount to the amount of ticks of that slot wheel
      }
    }
  }
  /* 
   * Name: getWheelIndex
   * Purpose: This method is used by the random generator. Basically
   *          whatever numbe the random generator pics 1-0 it will 
   *          always return a whole even int which cooresponds to a
   *          whole picture in the pic array list
   * Parameters: value 
   * Return: int 
   */
  public int getWheelIndex( double value )	
  {
    if( value > 0 && value < HIGHEST_VALUE_SUNGOD )
    {
      return  FULL_IMAGE_SUNGOD;
    } 
    else if ( value > LOWEST_VALUE_BEAR && value < HIGHEST_VALUE_BEAR )
    {
      return FULL_IMAGE_BEAR;
    }
    else if( value > LOWEST_VALUE_TRITON && value <  HIGHEST_VALUE_TRITON )
    {
      return FULL_IMAGE_TRITON;
    }
    else
    {
      return FULL_IMAGE_LIBRARY;
    }
  }
}
