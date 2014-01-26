/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public void run() {
		/* Variables to find center dimensions of screen */
		double midXScreen=getWidth()/2;
		double midYScreen=getHeight()/2;
		
		/*Outer ring*/
		GOval outerCircle= new GOval (	midXScreen-LASTCIRCLERADIUS,midYScreen-LASTCIRCLERADIUS,
									  	2*LASTCIRCLERADIUS,2*LASTCIRCLERADIUS);
		outerCircle.setFilled(true);
		outerCircle.setColor(Color.RED);
		add(outerCircle);
		
		/*Middle ring*/
		GOval midCircle= new GOval (	midXScreen-MIDCIRCLERADIUS,midYScreen-MIDCIRCLERADIUS,
										2*MIDCIRCLERADIUS,2*MIDCIRCLERADIUS);
		midCircle.setFilled(true);
		midCircle.setColor(Color.WHITE);
		add(midCircle);
		
		/*Inner ring*/
		GOval innerCircle= new GOval (	midXScreen-INNERCIRCLERADIUS,midYScreen-INNERCIRCLERADIUS,
										2*INNERCIRCLERADIUS,2*INNERCIRCLERADIUS);
		innerCircle.setFilled(true);
		innerCircle.setColor(Color.RED);
		add(innerCircle);
	}
	/*Radii pixel measurement per assignment */
	private final static double LASTCIRCLERADIUS=72.0;
	private final static double MIDCIRCLERADIUS=46.8;
	private final static double INNERCIRCLERADIUS=21.6;
}

