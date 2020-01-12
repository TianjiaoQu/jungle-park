//////////////////// HEADER COMMENT ///////////////////////////////////////////////////////////////
//
// Title:           Deer.java is one of nine files for JunglePark 2000, which defines 
//                  Deer class for the deer object in the application
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
 * This class represents a Deer in the JunglePark application
 * @author Tian Qu
 *
 */
public class Deer extends Animal{

  private static final int SCAN_RANGE = 175; // scan range area to check for a threat in the neighborhood
  private static final String IMAGE_FILE_NAME = "images/deer.png";
  private static int nextID = 1; // class variable that represents the identifier of the next deer
                                 // to be created
    
  private static final String TYPE = "DR"; // A String that represents the deer type
  private final int id; // Deer's id: positive number that represents the order of the deer
   
  /**
   * Creates a new Deer object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */  
  public Deer(JunglePark processing) { 
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
  }
   
  /**
   * Checks if there is a threat (a Tiger for instance) at the neighborhood
   * 
   * @param scanRange is an integer that represents the range of the area to be scanned around 
   * the animal
   */
  public boolean scanForThreat(int scanRange) {
    // Check if there is a tiger object in the listGUI that is close to the deer object
    for (int i = 0; i < this.processing.listGUI.size(); i++) {
      if ( (this.processing.listGUI.get(i) instanceof Tiger) && 
          (this.isClose((Tiger)this.processing.listGUI.get(i), scanRange)) )
        return true;
    }
    return false;
  }
   
  /**
   * Defines the behavior of a Deer object in the Jungle park, which is continuously scanning the 
   * area around him to look for a threat (i.e. if there is a tiger located nearby). 
   * If so, it will react by displaying an alert message
   */  
  @Override
  public void action() {
      if(this.scanForThreat(SCAN_RANGE)) { // decide if there is a threat, display "Threat"
        this.processing.fill(0); // specify font color: black
        this.processing.text("THREAT!", this.getPositionX(), this.getPositionY() - 
            this.image.height / 2 - 4);
      }
    
  }

}
