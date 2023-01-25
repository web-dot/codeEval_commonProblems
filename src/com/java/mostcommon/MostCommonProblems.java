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
	
	/*Find LCM and HCF for the numbers*/
	public static int findLCM(int n1, int n2) {
		int max = n1 > n2 ? n1 : n2;
		while(true) {
			if((max%n1==0)&&(max%n2==0)) {
				return max;
			}
			max++;
		}
	}
	
	/*Find the HFC for the numbers*/
	public static int findHCF(int n1, int n2) {
		int max = n1 > n2 ? n1 : n2;
		int hcf = 0;
		if(n1 == n2) {
			return n1;
		}
		for(int i=1; i<max; i++) {
			if(n1%i==0 && n2%i==0) {
				hcf = i;
			}
		}
		return hcf;
	}
	
	public static void main(String[] args) {
		
		int n1 = 15;
		int n2 = 15;
		System.out.println(findHCF(n1, n2));
		
		/*
		int n1 = 5;
		int n2 = 27;
		System.out.println(findLCM(n1, n2));
		*/
		/*
		String h = "code";
		String h1 = "program to reverse a string";
		System.out.println(reverseString(h1));
		*/
		//int n =  12791562;
		//System.out.println(addDigits(n));
	}
}
