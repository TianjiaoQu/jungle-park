//////////////////// HEADER COMMENT ///////////////////////////////////////////////////////////////
//
// Title:           AddAnimalButton.java is one of nine files for JunglePark 2000, which defines 
//                  the add animals buttons in the application.
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
 * This class defines the add animals buttons in the application
 * It extends the Button class which implements the ParkGUI interface
 * @author Mouna Kacem, Tian Qu
 */
public class AddAnimalButton extends Button {

  private String type; // type of the animal to add
 
  /**
   * Creates an AddAnimalButton object positioned at a given position of the display window
   * 
   * @param JunglePark park PApplet object that represents the display window
   * @param x x-coordinate of the AddAnimalButton in the display window
   * @param y y-coordinate of the AddAnimalButton in the display window
   * @param type the type of the animal to add
   */
  public AddAnimalButton(String type, float x, float y, JunglePark park) {
      super(x, y, park);
      this.type = type.toLowerCase();
      this.label = "Add " + type;
  }
  
  /**
   * Each time the mouse is pressed over the AddAnimalButtons, a corresponding animal is added.
   * 
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      switch (type) {
        case "tiger": // add new tiger if AddTiger button is pressed
          this.processing.listGUI.add(new Tiger(this.processing));
          break;
        case "deer": // add new deer if AddDeer button is pressed
          this.processing.listGUI.add(new Deer(this.processing));
          break;
      }
    }
  }

}
