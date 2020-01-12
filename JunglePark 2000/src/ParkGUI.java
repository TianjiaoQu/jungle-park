//////////////////// HEADER COMMENT ///////////////////////////////////////////////////////////////
//
// Title:           ParkGUI.java is one of nine files for JunglePark 2000, which contains signatures 
//                  interacting with the users via GUI
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
 * This class defines the GUI signature methods for the Jungle Park application
 * @author Mouna Kacem
 */
public interface ParkGUI {
  public void draw(); // draws a ParkGUI object (either an animal or a button) to the display window

  public void mousePressed(); // called each time the mouse is Pressed

  public void mouseReleased(); // called each time the mouse is Released

  public boolean isMouseOver(); // checks whether the mouse is over a ParkGUI object

}
