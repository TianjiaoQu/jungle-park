//////////////////// HEADER COMMENT ///////////////////////////////////////////////////////////////
//
// Title:           Tiger.java is one of nine files for JunglePark 2000, which defines 
//                  TIger class for the tiger object in the application
// Files:           processingLibrary.jar 
// Course:          CS 300 Fall 2018
//
// Author:          Tian Qu
// Email:           tqu6@wisc.edu
// Lecturer's Name: Gary Dahl
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * This class creates a Tiger in the JunglePark application
 * @author Mouna Kacem, Tian Qu
 */
public class Tiger extends Animal {
  private static final int SCAN_RANGE = 100; // range dimension for scanning the neighborhood for food
  private static final String IMAGE_FILE_NAME = "images/tiger.png";
  private static int nextID = 1; // class variable that represents the identifier of the next tiger
                                 // to be created
  // Tiger's identification fields
  private static final String TYPE = "TGR"; // A String that represents the tiger type
  private final int id; // Tiger's id: positive number that represents the order of the tiger
  
  private int deerEatenCount; // Number of Deers that the current tiger has eaten so far

  /**
   * Creates a new Tiger object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Tiger(JunglePark processing) {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
    deerEatenCount = 0; // Set deerEatenCount field to zero
  }


  /**
   * Tiger's behavior in the Jungle Park
   * Scans for food at the neighborhood of the current tiger. 
   * If the Tiger founds any deer at its proximity, it hops on it, and eats it
   */
  @Override
  public void action() {
     // Check if there is a deer object in the listGUI that is close to the tiger object
    for (int i = 0; i < this.processing.listGUI.size(); i++) {
      if ( (this.processing.listGUI.get(i) instanceof Deer) && 
          (this.isClose((Deer)this.processing.listGUI.get(i), SCAN_RANGE)) ) {
        this.hop( (Deer)this.processing.listGUI.get(i) );
        i=0;
      }
    }
    if(deerEatenCount > 0)
      displayDeerEatenCount(); // display deerEatenCount
  }
  
  /**
   * accessor (getter) method for the deerEatenCount field
   * @return deerEatenCount
   */
  public int getDeerEatenCount() {
    return deerEatenCount;
  }
 
  /**
   * Defines the Tiger hop behaviour: the tiger moves forward to the position of food and eats it
   * If the mouse is over the Tiger, release the mouse
   * @param food is deer object
   */
  public void hop(Deer food) {
    if(isMouseOver())
      mouseReleased();
    
    this.setPositionX(food.getPositionX());
    this.setPositionY(food.getPositionY());
    this.processing.listGUI.remove(food);
    deerEatenCount++;
  }
  
  /**
   * Displays the number of eaten deers if any on the top of the tiger image
   */
  public void displayDeerEatenCount() {
    this.processing.fill(0); // specify font color: black
    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(), this.getPositionY() - 
        this.image.height / 2 - 4);
  }
  
}
