package com.java.mostcommon;

import java.util.Arrays;

public class MostCommonProblems {

	/*Addition of digits present in the number*/
	public static int addDigits(int n) {
		int sum = 0;
		while(n>0) {
			int rem = n % 10;
			sum = sum + rem;
			n = n / 10;
			addDigits(n);
		}
		return sum;
	}
	
	
	/*Reverse a string
	 * 
	 * reverse word and sentence
	 * */
	public static String reverseString(String str) {
		char[] carr = str.toCharArray();
		for(int i=0; i<carr.length/2; i++) {
			carr[i] = (char)(carr[i] ^ carr[carr.length-i-1]);
			carr[carr.length-i-1] = (char)(carr[i] ^ carr[carr.length-i-1]);
			carr[i] = (char)(carr[i] ^ carr[carr.length-i-1]);
		}
		return new String(carr);
	}
	
	public static void main(String[] args) {
		
		String h = "code";
		String h1 = "program to reverse a string";
		System.out.println(reverseString(h1));
		
		//int n =  12791562;
		//System.out.println(addDigits(n));
	}
}
