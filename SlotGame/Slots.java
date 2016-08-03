/* 
 * Name: Leiasa Horanic 
 * Login: cs11wcs 
 * Date: February 16, 2014 
 * File: SlotWheel.java 
 * Sources of Help: Sachi, Nick, Wendy
 * 
 * This program creates the layout for the slots which includes JButtons,
 * JLabels, and some framed rectangles. It also constructs all 3 slot wheels
 * using the slot wheel object from class slot wheel and makes them listeners
 * so they know when to spin.
 *
 * 
 */ 
import objectdraw.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
/* 
 * Name: Slots 
 * Purpose: This class extends window controller and implements action 
 *          listener. The class only has two methods begin and action 
 *          preformed.
 */
public class Slots extends WindowController implements ActionListener
{
  private JLabel titleLabel;
  static JButton spinButton;
  private FramedRect slotFrame1, slotFrame2, slotFrame3;
  private SlotWheel slotWheel1, slotWheel2, slotWheel3;
  private Image [] pic;

  private static final Location SLOT_WHEEL_LOC1 = new Location(80,5);
  private static final Location SLOT_WHEEL_LOC2 = new Location(195,5);
  private static final Location SLOT_WHEEL_LOC3 = new Location(310,5);
  private static final Location SLOT_FRAME_LOC1 = new Location(79,4);
  private static final Location SLOT_FRAME_LOC2 = new Location(194,4);
  private static final Location SLOT_FRAME_LOC3 = new Location(309,4);
  
  private static final double IMAGE_WIDTH = 110; 
  private static final double IMAGE_HEIGHT = 145;
  private static final double FRAME_WIDTH = 111; 
  private static final double FRAME_HEIGHT = 146;
  private static final double WHEELS_Y_OFFSET = 5; 
  private static final double SPACE_BETWEEN_WHEELS = 5;
 
  private static final int NUM_OF_IMAGES = 8; 
  private static final int WHEEL_1_TICKS = 22; 
  private static final int WHEEL_2_TICKS = WHEEL_1_TICKS + 6; 
  private static final int WHEEL_3_TICKS = WHEEL_2_TICKS + 6; 
  private static final int WHEEL_1_DELAY = 100; 
  private static final int WHEEL_2_DELAY = WHEEL_1_DELAY + 25;
  private static final int WHEEL_3_DELAY = WHEEL_2_DELAY + 25;
  private static final int FONT_SIZE = 40;  
  private static final int FULL_IMAGE_SUNGOD = 0;
  private static final int HALF_IMAGE_SUNGODBEAR = 1;
  private static final int FULL_IMAGE_BEAR = 2;
  private static final int HALF_IMAGE_BEARTRITON = 3;
  private static final int FULL_IMAGE_TRITON =4;
  private static final int HALF_IMAGE_TRITONLIBRARY = 5;
  private static final int FULL_IMAGE_LIBRARY = 6;
  private static final int HALF_IMAGE_LIBRARYSUNGOD = 7;

  /* 
   * Name: begin
   * Purpose: This method sets up the canvas for the slots game. It creates
   *          JPanels and a JButton along with 3 framed rectangles which 
   *          will frame each slot wheel. It also sets the button and the
   *          slot wheel objects to be action listeners so they will be able
   *          to spin when the spin button is clicked. It also creates an
   *          array which holds all of the images that spin in the slot 
   *          wheels
   * Parameters: None 
   * Return: void 
   */
  public void begin()
  {
    JPanel southPanel = new JPanel();//bottom panel
    JPanel northPanel = new JPanel();//top panel
    JLabel titleLabel = new JLabel("$unGod $lots");//title of game
    titleLabel.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
    spinButton = new JButton("Click to Spin");// new button
    
    southPanel.add(spinButton);
    //adding panel
    Container contentPane = getContentPane();
    contentPane.add( southPanel, BorderLayout.SOUTH);
    contentPane.validate();
   
    spinButton.addActionListener(this);

    northPanel.add(titleLabel);
    //adding panel
    Container contentPane2 = getContentPane();
    contentPane2.add( northPanel, BorderLayout.NORTH);
    contentPane2.validate();
    
    //black frame around each wheel
    slotFrame1 = new FramedRect( SLOT_FRAME_LOC1, FRAME_WIDTH,
                                 FRAME_HEIGHT, canvas);
    slotFrame2 = new FramedRect( SLOT_FRAME_LOC2, FRAME_WIDTH,
                                 FRAME_HEIGHT, canvas);
    slotFrame3 = new FramedRect( SLOT_FRAME_LOC3, FRAME_WIDTH,
                                 FRAME_HEIGHT, canvas);
    
    pic = new Image[NUM_OF_IMAGES];
    pic[FULL_IMAGE_SUNGOD] = getImage("sungod.jpg");
    pic[HALF_IMAGE_SUNGODBEAR] = getImage("sungod-bear.jpg");
    pic[FULL_IMAGE_BEAR] = getImage("bear.jpg");
    pic[HALF_IMAGE_BEARTRITON] = getImage("bear-triton.jpg");
    pic[FULL_IMAGE_TRITON] = getImage("triton.jpg");
    pic[HALF_IMAGE_TRITONLIBRARY] = getImage("triton-library.jpg");
    pic[FULL_IMAGE_LIBRARY] = getImage("library.jpg");
    pic[HALF_IMAGE_LIBRARYSUNGOD] = getImage("library-sungod.jpg");
   
    slotWheel1= new SlotWheel(pic, WHEEL_1_TICKS, WHEEL_1_DELAY,
                              SLOT_WHEEL_LOC1, canvas);
    slotWheel2= new SlotWheel(pic, WHEEL_2_TICKS, WHEEL_2_DELAY,
                              SLOT_WHEEL_LOC2, canvas);
    slotWheel3= new SlotWheel(pic, WHEEL_3_TICKS, WHEEL_3_DELAY,
                              SLOT_WHEEL_LOC3, canvas);
    
    spinButton.addActionListener(slotWheel1);
    spinButton.addActionListener(slotWheel2);
    spinButton.addActionListener(slotWheel3);
  }
  /* 
   * Name: actionPerformed
   * Purpose: This mehtod is empty but needs to be here because this class
   *          implements action listener which is need to add the spin 
   *          button and wheels as action listeners
   * Parameters: evt 
   * Return: void 
   */
  public void actionPerformed( ActionEvent evt )
  {
  }  
}
