/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

/* Finds the smallest and largest numbers from a range of integers entered by user.
 * Stops program when SENTINEL entered
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public void run() {
		/* Variable to hold latest number stored */
		int userInput =0;

		println("This program finds the largest and smallest numbers");
		println("Enter "+SENTINEL+" anytime to stop program");
		userInput=getNumFromUser(userInput);
		
		/* Variable to hold lowest number entered so far */
		int userMin=userInput;
		
		/* Variable to hold highest number entered so far */
		int userMax=userInput;
		
		/* Loop that continues until SENTINEL is entered and keeps track of lowest and highest numbers entered so far */
		
		while (userInput != SENTINEL) {
			if (userInput>userMax) {
				userMax=userInput;
			}else{
				if (userInput<userMin){
					userMin=userInput;
				}
			}
			userInput=getNumFromUser(userInput);
		}
		
		/*Checks that SENTINEL not entered in first trial and, if not,
		 * shows smallest and highest number entered so far */
		if (userMax==userMin && userMax==SENTINEL) {
			println (SENTINEL + " entered as first number so program not run");
		}
		else{
			println ("Smallest number: "+userMin);
			println ("Largest number: "+userMax);
		}
	}
	
	/* Gets integer from user and returns that integer */
	
	private int getNumFromUser(int a) {
		int getNum= readInt ("Please enter an integer: ");
		return getNum;
	}
	
	/*Constant that sets number that indicates user has entered entire range */
	private static final int SENTINEL=0;
}