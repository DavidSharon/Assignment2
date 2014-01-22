/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		println ("Enter values to compute the Pythagorean Theorem");
		double a= readDouble ("Enter first number a:");
		double b= readDouble ("Enter second number b:");
		println ("c=" + Math.sqrt(a*a+b*b));
	}
}
