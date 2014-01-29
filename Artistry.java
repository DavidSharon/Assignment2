
import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.*;

/**
 * Creates and simulates 4 bouncing balls across the screen with
 * with one wall that moves from the left to the right of the screen
 * If the balls either hit the wall or the bottom of screen, the ball bounces back
 * 
 * HELP: for some reason, wall isn't appearing
 */
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
	private static final double WALL_WIDTH=10;
	
	/* Wall Height */
	private static final double WALL_HEIGHT=70;
	
	/* Wall Color */
	
	private static final Color WALL_COLOR= Color.green;
	
	/*Wall pixel speed */
	
	private static final double WALL_SPEED= 10.0;
	
	/* Allow for random generator */
	private RandomGenerator rgen = RandomGenerator.getInstance();


	
	public void run() {
			signName();
			GOval ball1 = makeBall();
			GOval ball2 = makeBall();
			GOval ball3 = makeBall();
			GOval ball4 = makeBall();
			GRect wall=  makeWall();
			
			bounceBallMoveWall(ball1,ball2,ball3,ball4,wall);
			
	}
	
	/**
	 * Signs name at bottom right of screen
	 */
	
	private void signName() {
		double screenHeight=getHeight();
		double screenWidth=getWidth();
		GLabel name = new GLabel ("David Sharon",screenWidth-10,screenHeight-10 );
		add(name);
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

		/**
		 *Creates a wall that will move from the left screen to the right
		 * @return The wall that will move to left
		 */
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
		
	
		double screenWidth=getWidth();
		double wallX= screenWidth-WALL_WIDTH;
		double screenHeight=getHeight();
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
			wall.move(-WALL_SPEED,0);

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
	/**
	 * Returns if ball has hit wall */
	
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







