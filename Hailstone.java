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
				a=takeHalf(a);
			} else {
				a=make3nPlusOne(a);
			}
		}
		println ("The process took "+i+" to reach 1");
	}
	private int takeHalf(int n) {
		int original= n;
		n /= 2;
		println(original +" is even so i take half: "+ n);
		return n;
	}
	
	private int make3nPlusOne(int y) {
		int original= y;
		y = 3*y +1;
		println(original +" is odd, so I make 3n+1: "+ y);
		return y;
	}
}

