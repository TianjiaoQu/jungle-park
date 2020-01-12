//////////////////// HEADER COMMENT ///////////////////////////////////////////////////////////////
//
// Title:           Button.java is one of nine files for JunglePark 2000, which defines 
//                  the base class for three button classes in the application.
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
 * This class represents the base class for three button classes in the application
 * It implements the interface ParkGUI
 * @author Mouna Kacem
 */
public class Button implements ParkGUI {
  private static final int WIDTH = 85; // Width of the Button
  private static final int HEIGHT = 32; // Height of the Button
  protected JunglePark processing; // PApplet object where the button will be displayed
  private float[] position; // array storing x and y positions of the Button with respect to 
                            // the display window 
  protected String label;   // text/label that represents the button

  /**
   * Creates a Button object positioned at a given position of the display window
   * 
   * @param JunglePark processing PApplet object that represents the display window
   * @param x x-coordinate of the Button in the display window
   * @param y y-coordinate of the Button in the display window
   */
  public Button(float x, float y, JunglePark processing) {
    this.processing = processing; // set the PApplet Object where the Button will be drawn
    this.position = new float[2]; // set the position of the Button
    this.position[0] = x;
    this.position[1] = y;
    this.label = "Button"; // set the label of the Button as "Button"
  }
  
  /**
   * Draws the Button to the display window. It also fills the color to dark grey if the mouse is 
   * over the button, otherwise fills the color as light grey.
   */
  @Override
  public void draw() {
    this.processing.stroke(0);// set line value to black
    if (isMouseOver())
      processing.fill(100); // set the fill color to dark gray if the mouse is over the button
    else
      processing.fill(200); // set the fill color to light gray otherwise

    // draw the button (rectangle with a centered text)
    processing.rect(position[0] - WIDTH / 2.0f, position[1] - HEIGHT / 2.0f,
        position[0] + WIDTH / 2.0f, position[1] + HEIGHT / 2.0f);
    processing.fill(0); // set the fill color to black
    processing.text(label, position[0], position[1]); // display the text of the current button
  }

  /**
   * Call each time the mouse is pressed and if the mouse is over the button, "A button was pressed"
   * is print out.
   */
  @Override
  public void mousePressed() {
    if (isMouseOver())
      System.out.println("A button was pressed.");
  }
  
  /**
   * Call each time the mouse is released and do nothing as default.
   */
  @Override
  public void mouseReleased() {}

  /**
   * Checks if the mouse is over the button imgae
   * 
   * @return true if the mouse is over the button, false otherwise
   */
  @Override
  public boolean isMouseOver() {
 // checks if the mouse is over the button
    if (this.processing.mouseX > this.position[0] - WIDTH / 2
        && this.processing.mouseX < this.position[0] + WIDTH / 2
        && this.processing.mouseY > this.position[1] - HEIGHT / 2
        && this.processing.mouseY < this.position[1] + HEIGHT / 2)
      return true;
    return false;
  }
}
