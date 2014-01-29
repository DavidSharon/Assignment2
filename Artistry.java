/*
 * File: BouncingBall.java
 * ========================================================
 * A program that simulates a bouncing ball
 */
import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;

public class Artistry extends GraphicsProgram {
	
	/* The size of the ball. */
	private static final double BALL_SIZE = 50;

	/* The amount of time to pause between frames (48fps). */
	private static final double PAUSE_TIME = 1000.0 / 48;

	/* The maximum horizontal velocity of the ball. */
	private static final double BALL_MAX_SPEED = 3.0;

	/* Gravitational acceleration. */
	private static final double GRAVITY = 0.125;

	/* Elasticity. */
	private static final double ELASTICITY = 0.75;

	/* Wall width */
	private static final double WALL_WIDTH=50;
	
	/* Wall Height */
	private static final double WALL_HEIGHT=70;
	
	/* Wall Color */
	
	private static final Color WALL_COLOR= Color.green;
	
	/*Wall speed */
	
	private static final double WALL_SPEED=0.5;
	
	/* Allow for random generator */
	private RandomGenerator rgen = RandomGenerator.getInstance();


	/**
	 * Creates and simulates bouncing a ball across the screen.
	 */
	
	public void run() {
			GOval ball1 = makeBall();
			GOval ball2 = makeBall();
			GOval ball3 = makeBall();
			GOval ball4 = makeBall();
			GRect wall=  makeWall();
			
			bounceBallMoveWall(ball1,ball2,ball3,ball4,wall);
			
	}
	/**
	 * Creates and returns a ball to bounce across the screen.
	 *  
	 * @return The ball that will be bounced.
	 */
	private GOval makeBall() {
		double screenHeight=getHeight();
		double screenWidth=getWidth();
		double startX=rgen.nextDouble(0,screenWidth);
		double startY=rgen.nextDouble(0,screenHeight);
		GOval result = new GOval(startX, startY, BALL_SIZE, BALL_SIZE);
		result.setFilled(true);
		Color randColor=rgen.nextColor();
		result.setColor(randColor);
		return result;
	}

	private GRect makeWall() {
		double screenHeight=getHeight();
		double screenWidth=getWidth();
		double startX= screenWidth-WALL_WIDTH;
		double startY=screenHeight-WALL_HEIGHT;
		GRect result= new GRect(startX,startY,WALL_WIDTH,WALL_HEIGHT);
		result.setFilled(true);
		result.setColor(WALL_COLOR);
		return result;
	}
	/**
	 * Bounces the specified ball across the screen.
	 * 
	 * @param ball The ball to bounce.
	 */
	private void bounceBallMoveWall (GOval ball1, GOval ball2, GOval ball3, GOval ball4, GRect wall) {
		/* Track the ball velocity. */
		double dx1 = rgen.nextDouble(0,BALL_MAX_SPEED);
		double dy1 = 0;
		double dx2 = rgen.nextDouble(0,BALL_MAX_SPEED);
		double dy2 = 0;
		double dx3 = rgen.nextDouble(0,BALL_MAX_SPEED);
		double dy3 = 0;
		double dx4 = rgen.nextDouble(0,BALL_MAX_SPEED);
		double dy4 = 0;
		
		double screenHeight=getHeight();
		double screenWidth=getWidth();
		double wallX= screenWidth-WALL_WIDTH;
		double wallY=screenHeight-WALL_HEIGHT; 
		
		add(ball1);
		add(ball2);
		add(ball3);
		add(ball4);
		add(wall);
		
		/* Loop, simulating bouncing the ball across the screen.
		 */
		while (true) {
			/* Move the ball one step. */
			ball1.move(dx1, dy1);
			ball2.move(dx2, dy2);
			ball3.move(dx3, dy3);
			ball4.move(dx4, dy4);
			
			/*Move wall one step */
			wall.move(wallX, wallY);

			/* Gravity accelerates the ball downward. */
			dy1 += GRAVITY;
			dy2 += GRAVITY;
			dy3 += GRAVITY;
			dy4 += GRAVITY;
			wallX -= WALL_SPEED;

			/* If the ball hit the ground and is still moving downward,
			 * reflect it back up. The check for downward motion is
			 * necessary to make sure that we don't get the ball stuck
			 * in the ground.
			 */
			
			if (hasBallHitBottom(ball1) && dy1 > 0.0) {
				dy1 *= -ELASTICITY;
			}
			if (hasBallHitBottom(ball2) && dy2 > 0.0) {
				dy2 *= -ELASTICITY;
			}
			if (hasBallHitBottom(ball3) && dy3 > 0.0) {
				dy3 *= -ELASTICITY;
			}
			if (hasBallHitBottom(ball4) && dy4 > 0.0) {
				dy4 *= -ELASTICITY;
			}
			
			if (hasBallHitWall(ball1, wall)) {
				dx1 *=-ELASTICITY;
			}
			if (hasBallHitWall(ball2, wall)) {
				dx2 *=-ELASTICITY;
			}
			if (hasBallHitWall(ball3, wall)) {
				dx3 *=-ELASTICITY;
			}
			if (hasBallHitWall(ball4, wall)) {
				dx4 *=-ELASTICITY;
			}
			
			pause(PAUSE_TIME);
		}
	}
	/*Checks if ball has hit wall */
	
	private boolean hasBallHitWall (GOval ball, GRect wall) {
		double ballX= ball.getX() + BALL_SIZE;
		return ballX>= wall.getX();
	}
	/**
	 * Returns whether the ball has hit the bottom of the screen.
	 * 
	 * @param ball The ball to test.
	 * @return Whether it has hit the bottom of the screen.
	 */
	private boolean hasBallHitBottom(GOval ball) {
		/* Determine where the bottom of the ball is. */
		double bottomY = ball.getY() + ball.getHeight();

		/* Return whether it's below the bottom of the window. */
		return bottomY >= getHeight();
	}
}









/* File: Artistry.java
 * Name:
 * Section Leader:
 * ==========================================================
 * Replace these comments with a description of your program.
 * Since this program is more freeform than the rest, tell us
 * a bit about it in these comments!
 */
/*
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GLabel;
import acm.program.*;
import acm.util.*;
import java.awt.Color;
 */

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
 * 
 * Didn't manage to get this to work!
 * Maybe over my head? :)
 */

/*
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
		cleanScreen();
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
 */