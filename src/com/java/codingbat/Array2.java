package com.java.codingbat;

import java.util.Arrays;

public class Array2 {
	
	// centered average
	public static int centeredAvg(int[] nums) {
		Arrays.sort(nums);
		int mid = nums.length / 2;
		if(nums.length%2!=0) {
			return nums[mid];
		}
		else {
			int result = (nums[mid] + nums[mid - 1]) / 2;  // refactor this
			return result;
		}
	}
	//1, 1, 6, 7, 2
	// sum67 - return sum of array, except from element 6 to element 7
	public static int sum67(int[] nums) {
		int total = 0;
		boolean flag = true;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == 6) {
				flag = false;
			}
			if(nums[i] == 7) {
				flag = true;
			}
			if(flag) {
				total = total + nums[i];
			}
		}
		return total - 7;
	}
	
	
	public static void main(String[] args) {
		System.out.println(sum67(new int[] {1, 1, 6, 7, 2}));
//		System.out.println(centeredAvg(new int[] {1, 1, 99, 99}));
	}

}
