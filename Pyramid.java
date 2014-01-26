/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

	/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

	/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

	/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		/* You fill this in. */
		Double firstBrickX= computeFirstBrickX(0);
		for (int row=0; row<BRICKS_IN_BASE; row++) {
			for (int column=0; column<BRICKS_IN_BASE; column++) {
				buildBrick(row,column,firstBrickX);
			}
		}
	}
	
	private double computeFirstBrickX(double start) {
		start= (getWidth()-BRICKS_IN_BASE*BRICK_WIDTH)/2;
		return(start);
	}
	
	private void buildBrick (double row, double column, double firstBrickX) {
		GRect brick= new GRect (firstBrickX+BRICK_WIDTH*column,row*BRICK_HEIGHT,BRICK_WIDTH,BRICK_HEIGHT);
		brick.setFilled(false);
		brick.setColor(Color.black);
	}
}

