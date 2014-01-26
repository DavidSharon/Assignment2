/*
 * File: Artistry.java
 * Name:
 * Section Leader:
 * ==========================================================
 * Replace these comments with a description of your program.
 * Since this program is more freeform than the rest, tell us
 * a bit about it in these comments!
 */
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GLabel;
import acm.program.*;
import acm.util.*;
import java.awt.Color;

/* You fill this in.  Remember that you must have
 * 
 * 1. At least one filled object,
 * 2. At least two different colors of objects, and
 * 3. At least three different types of objects (not
 *    counting the GLabel you use to sign your name).
 * 
 * Also, be sure to sign your name in the bottom-right
 * corner of the canvas. Your name should be flush up
 * against the bottom-right corner of the label. We
 * recommend looking at the getDescent() method as a
 * means for calculating where to position the label.
 */

public class Artistry extends GraphicsProgram {
	public void run() {
		int x=0;
		int numberOfShapes= introRequestParamaters(x);
		generateShapesBasedOnParamaters(numberOfShapes);
		signPicture();
	}

	private int introRequestParamaters(int a) {
		explainArtIsRandom();
		int userInput= requestNumberOfShapes(a);
		return(userInput);
	}

	private void explainArtIsRandom() {
		for (int i = 0; i < SMALLNUMBERLIMIT; i++) {
			GLabel artIsRandom = new GLabel("Art is Random", 100, 75);
			artIsRandom.setFont("SansSerif-36");
			artIsRandom.setColor(Color.RED);
			add(artIsRandom);
		}
	}

	private int requestNumberOfShapes (int a) {
		cleanScreen();
		int userShapeInput= readInt ("Enter number of shapes your heart desires: ");
		println ("I am going to give you 300x that number, i.e., "+ userShapeInput*300);
		pause(LARGEPAUSE*2);
		cleanScreen();
		return (userShapeInput*300);
	}

	private void generateShapesBasedOnParamaters(int shapes) {
		int screenWidth =getWidth();
		int screenHeight= getHeight();
		for (int i=0; i<shapes; i++){
			createRect(screenWidth,screenHeight);
			createOval(screenWidth,screenHeight);
			pause(SMALLPAUSE);
		}
	}
	
	private void createRect(int x,int y) {
		int startRectX= rgen.nextInt(x);
		int startRectY= rgen.nextInt(y);
		int endRectX= rgen.nextInt(x);
		int endRectY= rgen.nextInt(y);
		GRect rect= new GRect(startRectX,startRectY,endRectX,endRectY);
		rect.setFilled(true);
		Color rectColor= rgen.nextColor();
		rect.setFillColor(Color.BLUE);
		add(rect);
		return;
	}

	private void createOval(int x, int y) {
		int startOvalX= rgen.nextInt(x);
		int startOvalY= rgen.nextInt(y);
		int endOvalX= rgen.nextInt(x);
		int endOvalY= rgen.nextInt(y);
		GOval oval= new GOval(startOvalX,startOvalY,endOvalX,endOvalY);
		oval.setFilled(true);
		oval.setFillColor(Color.BLUE);
		add(oval);
	}
	
	private void signPicture() {
		int screenWidth =getWidth();
		int screenHeight= getHeight();
		GLabel sign= new GLabel("David Sharon",screenWidth-50,screenHeight-10);
		add(sign);
	}
	
	private void cleanScreen() {
		int screenWidth =getWidth();
		int screenHeight= getHeight();
		GRect blankPage= new GRect(0, 0, screenWidth, screenHeight);
		blankPage.setFilled(true);
		blankPage.setColor(Color.WHITE);
		add(blankPage);
	}

	private RandomGenerator rgen = RandomGenerator.getInstance();

	private final static int SMALLNUMBERLIMIT=1;
	private final static int SMALLPAUSE=20;
	private final static int LARGEPAUSE=1000;	


}
