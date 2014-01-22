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
		int n= readInt("Enter a number");
		int i= 0;
		while (n != 1) {
			i++;
			if (n%2==0) {
				takeHalf();
			} else {
				make3nPlusOne();
			}
		}
		println ("The process took "+i+" to reach 1");
	}
	private void takeHalf() {
		n=n/2;
	}
	
	private void make3nPlusOne() {
		n=3*n +1;
	}
}

