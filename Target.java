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
		/* You fill this in. */
		double midXScreen=getWidth()/2;
		double midYScreen=getHeight()/2;
		GOval outerCircle= new GOval (midXScreen-LASTCIRCLERADIUS,midYScreen-LASTCIRCLERADIUS,
									  midXScreen+LASTCIRCLERADIUS,midYScreen+LASTCIRCLERADIUS);
		outerCircle.setFilled(true);
		outerCircle.setColor(Color.RED);
		GOval innerCircle= new GOval (midXScreen-INNERCIRCLERADIUS,midYScreen-INNERCIRCLERADIUS,
									midXScreen+INNERCIRCLERADIUS,midYScreen+INNERCIRCLERADIUS);
		innerCircle.setFilled(true);
		innerCircle.setColor(Color.RED);
		add(outerCircle);
		add(innerCircle);
	}
	
	private final static double LASTCIRCLERADIUS=72.0;
	private final static double MIDCIRCLERADIUS=46.8;
	private final static double INNERCIRCLERADIUS=21.6;
}

