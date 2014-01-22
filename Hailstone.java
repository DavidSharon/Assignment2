/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int a= readInt("Enter a number");
		int i= 0;
		while (a != 1) {
			i++;
			if (a%2==0) {
				takeHalf(a);
			} else {
				make3nPlusOne(a);
			}
		}
		println ("The process took "+i+" to reach 1");
	}
	private int takeHalf(int n) {
		return n /= 2;
	}
	
	private int make3nPlusOne(int y) {
		return y = 3*y +1;
	}
}

