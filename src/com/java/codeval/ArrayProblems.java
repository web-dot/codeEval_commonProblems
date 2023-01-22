package com.java.codeval;

import java.util.Arrays;

public class ArrayProblems {
	
	
	/*Page 12*/
	
	/*Given a number, create and return a new int array of length n, containing 
	 * the numbers 0,1,2 .., n-1. The given n may be 0, in which case just return 
	 * a length 0 array. 
	 * */
	public static int[] returnArrayOfLength(int n) {
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = i;
		}
		return arr;
	}
	
	/*
	 * Given a int array, return a new array with double the length where its last element
	 *  is the same as the original array, and all the other elements are 0.
	 * */
	public static int[] doubleArrayLength(int[] arr) {
		int[] arrNew = new int[2 * arr.length];
		arrNew[arrNew.length - 1] = arr[arr.length - 1];
		return arrNew;
	}
	
	
	
	public static void main(String[] args) {
		
		//int[] arr = doubleArrayLength(new int[] {4,7,5,9});
		//System.out.println(Arrays.toString(arr));
		
		//int[] arr = returnArrayOfLength(5);
		//System.out.println(Arrays.toString(arr));
	}
}
