/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 
 /* Takes a positive integer and shows the steps to reach 1 using the
  * Hailstone Sequence
  */

import acm.program.*;
public class Hailstone extends ConsoleProgram {
	public void run() {
		//* requests the integer to be used for Hailstone
		
		int a= readInt("Enter a positive integer: ");

		//*Validates that a is a positive non 0 number
 
		while (a<1) {
			a= readInt("Enter a positive integer: ");
		}
		//* used as counter for number of steps to reach 1
		int i= 0;
		while (a != 1) {
			i++;
			if (a%2==0) {
				a=takeHalf(a);
			} else {
				a=make3nPlusOne(a);
			}
		}
		println ("The process took "+i+" steps to reach 1");
	}
	
	//*prints line of original number and returns half of that number
	private int takeHalf(int n) {
		int original= n;
		n /= 2;
		println(original +" is even so I take half: "+ n);
		return n;
	}
	
	//*prints line of original number and returns 3n+1 of that number

	private int make3nPlusOne(int y) {
		int original= y;
		y = 3*y +1;
		println(original +" is odd, so I make 3n+1: "+ y);
		return y;
	}
}

