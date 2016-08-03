/* 
 * Name: Leiasa Horanic
 * Login: cs11wcs
 * Date: February 2, 2014 
 * File: Cow.java 
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
 * Name: Cow
 * Purpose: This controls the cow image. It contructs and controls this
 *          object's string and a framed rectangle to highlight the image.  
 */
public class Cow implements AnimalCard
{
  private static String COW_SPEAK = "Moo";
  private VisibleImage cowImage;
  private FramedRect picFrame, picFrame2;
  // two framed rectangles so the boarder will be 2 pixels
  private DrawingCanvas canvas;
  private int rectShrink = 2;//so the rectangles are not on top pf each other
  public boolean uncovered = false;

  /* 
   * Name: Cow
   * Purpose: The purpose of this is to construct the cow object and framed
   *          rectangle object.
   * Parameters: pic, loc, canvas 
   * Return: None (constructor)
   */
  public Cow(Image pic, Location loc, DrawingCanvas canvas)
  {
    cowImage = new VisibleImage(pic, loc, canvas);// constructor for cow
    picFrame = new FramedRect( loc.getX(), loc.getY(),  cowImage.getWidth(),
                               cowImage.getHeight(), canvas);
    picFrame2 = new FramedRect( loc.getX()+1, loc.getY()+1, 
                                cowImage.getWidth()-rectShrink,
                                cowImage.getHeight()-rectShrink, canvas);
    canvas = canvas;
    picFrame.hide();
    picFrame2.hide();
  }

  /* 
   * Name: speak 
   * Purpose: This method allows the cow object to speak 
   * Parameters: None 
   * Return: the string so the cow image will have a word by it
   */
  public String speak()
  {
    return COW_SPEAK;
  }

  /* 
   * Name: contains
   * Purpose: This method is checking to see if the point is inside the 
   *          image 
   * Parameters: point
   * Return: if the point contains cowImage
   */
  public boolean contains( Location point )
  {
    return cowImage.contains(point);
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
   * Name: getHighlightColor
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
   * Parameters: Object o 
   * Return: It will return true or false
   */
 @Override
 public boolean equals(Object o)
  {
   return this.getClass() .equals(o.getClass()); 
  }
  /* 
   * Name: show
   * Purpose: This method shows the cow image and the boolean uncovered is
   *          true if the cow is shown 
   * Parameters: None. 
   * Return: void. 
   */
  public void show()
  {
    uncovered = true;
    cowImage.show();
  }
  /* 
   * Name: hide
   * Purpose: This method hides the cow image and the boolean uncovered is
   *          false if the cow is hidden 
   * Parameters: None. 
   * Return: void. 
   */
  public void hide()
  {
    uncovered = false;
    cowImage.hide();
  }
  /* 
   * Name: show
   * Purpose: This method checks to see if the cow image is shown
   * Parameters: None. 
   * Return: true or false, and uncovered
   */
  public boolean shown()
  {
    return uncovered;
  }
 



}

