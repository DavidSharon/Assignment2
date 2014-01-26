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
	private static final int BRICK_WIDTH = 15;

	/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 10;

	/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		
		/* Intializing starting point of first brick */
		
		double firstBrickX=0;
		
		/*Need double counter to know which row and column I am */
		
		for (int row=1; row<=BRICKS_IN_BASE; row++) {
			for (int column=1; column<=(BRICKS_IN_BASE-(row-1)); column++) {
				firstBrickX= computeFirstBrickX(row);
				buildBrick(row,column,firstBrickX);
			}
		}
	}
	
	/* Computes the location of what would be the first Brick X in a row */
	
	private double computeFirstBrickX(double row) {
		double start= getWidth()-((BRICKS_IN_BASE)-(row-1))*(BRICK_WIDTH)/2;
		return(start);
	}
	
	/*Creates the brick based on the row and column */
	
	private void buildBrick (double row, double column, double firstBrickX) {
		double topOfScreen=getHeight();
		GRect brick= new GRect (firstBrickX+BRICK_WIDTH*column,topOfScreen-row*BRICK_HEIGHT,BRICK_WIDTH,BRICK_HEIGHT);
		brick.setFilled(false);
		brick.setColor(Color.black);
		add(brick);
	}
}

