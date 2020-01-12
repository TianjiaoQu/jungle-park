//////////////////// HEADER COMMENT ///////////////////////////////////////////////////////////////
//
// Title:           ClearButton.java is one of nine files for JunglePark 2000, which defines 
//                  the clear all animals button in the application.
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
 * This class defines the ClearButton object in the application.
 * It extends the Button class which implements the ParkGUI interface
 * @author Mouna Kacem, Tian Qu
 */
public class ClearButton extends Button{
  /**
   * Creates a ClearButton object positioned at a given position of the display window
   * 
   * @param JunglePark park PApplet object that represents the display window
   * @param x x-coordinate of the ClearButton in the display window
   * @param y y-coordinate of the ClearButton in the display window
   */
  public ClearButton(float x, float y, JunglePark park) {
      super(x, y, park);
      this.label = "Clear Park";
  }
  
  /**
   * Each time the mouse is pressed over the ClearButton, all animals in the park are cleared
   * 
   */
  @Override
  public void mousePressed() {
    if (isMouseOver()) {
      this.processing.clear();
    }
  }

}
