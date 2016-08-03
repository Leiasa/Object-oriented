/* 
 * Name: Leiasa Horanic
 * Login: cs11wcs
 * Date: February 2, 2014 
 * File: Puppy.java 
 * Sources of Help: Muyao Wu, Sachi
 * 
 * This progarm creates each animal object for the animal speak game. It
 * consists of what the animal should, checks when it is clicked on by
 * the user, and contains the framed rectangle that highlights the
 * image if correct.  
 */ 

import objectdraw.*;
import java.awt.Color;
import java.awt.Image;

/* 
 * Name: Puppy
 * Purpose: This controls the puppy image. It contructs and controls this
 *          object's string and a framed rectangle to highlight the image.  
 */
public class Puppy implements AnimalCard
{
  private static String PUPPY_SPEAK = "Woof";
  private VisibleImage puppyImage;
  private FramedRect picFrame, picFrame2;
  private DrawingCanvas canvas;
  private int rectShrink = 2;
    public boolean uncovered = false;


  /* 
   * Name: Puppy
   * Purpose: The purpose of this is to construct the puppy object and framed
   *          rectangle object.
   * Parameters: pic, loc, canvas 
   * Return: None (constructor)
   */
  public Puppy(Image pic, Location loc, DrawingCanvas canvas)
  {
    puppyImage = new VisibleImage(pic, loc, canvas);
    picFrame = new FramedRect( loc, puppyImage.getWidth(),
                               puppyImage.getHeight(), canvas);
    picFrame2 = new FramedRect( loc.getX()+1, loc.getY()+1, 
                                puppyImage.getWidth()-rectShrink,
                                puppyImage.getHeight()-rectShrink, canvas);
    canvas = canvas;
    picFrame.hide();
    picFrame2.hide();

  }

  /* 
   * Name: speak 
   * Purpose: This method allows the puppy object to speak 
   * Parameters: None 
   * Return: the string so the puppy image will have a word by it
   */
  public String speak()
  {
    return PUPPY_SPEAK;
  }

  /* 
   * Name: contains
   * Purpose: This method is checking to see if the point is inside the 
   *          image 
   * Parameters: point
   * Return: if the point contains puppyImage
   */
  public boolean contains( Location point )
  {
    return puppyImage.contains(point);
  }

  /* 
   * Name: showHighlight 
   * Purpose: This method changes the framed rectangles color 
   * Parameters: color 
   * Return: void
   */
  public void showHighlight( Color color ) 
  { 
    picFrame.setColor(color);
    picFrame.show();
    picFrame2.setColor(color);
    picFrame2.show();

  }
 
  /* 
   * Name: hideHighlight
   * Purpose: This method hides the framed rectangle 
   * Parameters: None 
   * Return: void
   */
  public void hideHighlight()
  { 
    picFrame.hide();
    picFrame2.hide();
  }

  /* 
   * Name: getHighlightColor()
   * Purpose: This method hides the framed rectangle 
   * Parameters: None 
   * Return: gets the current color of the framed rectangle to be able to
   *         highlight
   */
  public Color getHighlightColor()
  {
    return picFrame.getColor();
  }
  /* 
   * Name: equals 
   * Purpose: To check to see if the animal card matches the card of this
   *          class 
   * Parameters: random 
   * Return: It will return true or false depending on if the return
   *         statement is true of false 
   */
@Override
 public boolean equals(Object o)
  {
    return this.getClass() .equals(o.getClass()); 
  }
    /* 
   * Name: show
   * Purpose: This method shows the puppy image and the boolean uncovered is
   *          true if the puppy is shown 
   * Parameters: None. 
   * Return: void. 
   */
  public void show()
  {
    uncovered = true;
    puppyImage.show();
  }
  /* 
   * Name: hide
   * Purpose: This method hides the puppy image and the boolean uncovered is
   *          false if the puppy is hidden 
   * Parameters: None. 
   * Return: void. 
   */
  public void hide()
  {
    uncovered = false;
    puppyImage.hide();
  }
  /* 
   * Name: show
   * Purpose: This method checks to see if the puppy image is shown
   * Parameters: None. 
   * Return: true or false, and uncovered
   */
  public boolean shown()
  {
    return uncovered;
  }


}

