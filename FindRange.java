/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public void run() {
		/* You fill this in */
		int userInput =0;
		int userMax=0;
		int userMin=0;
		println("This program finds the largest and smallest numbers");
		println("Enter "+SENTINEL+" anytime to stop program");
		userInput=getNumFromUser(userInput);
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
		if (userMax==userMin && userMax==SENTINEL) {
			println (SENTINEL + "entered as first number so program not run");
		}
		else{
			println ("Smallest number: "+userMin);
			println ("Largest number: "+userMax);
		}
	}
	
	private int getNumFromUser(int a) {
		int getNum= readInt ("Please enter an integer: ");
		return getNum;
	}

	private static final int SENTINEL=0;
}