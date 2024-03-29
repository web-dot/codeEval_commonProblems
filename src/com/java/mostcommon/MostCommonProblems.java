package com.java.mostcommon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonProblems {

	/* Addition of digits present in the number */
	public static int addDigits(int n) {
		int sum = 0;
		while (n > 0) {
			int rem = n % 10;
			sum = sum + rem;
			n = n / 10;
			addDigits(n);
		}
		return sum;
	}

	/*
	 * Reverse a string
	 * 
	 * reverse word and sentence
	 */
	public static String reverseString(String str) {
		char[] carr = str.toCharArray();
		for (int i = 0; i < carr.length / 2; i++) {
			carr[i] = (char) (carr[i] ^ carr[carr.length - i - 1]);
			carr[carr.length - i - 1] = (char) (carr[i] ^ carr[carr.length - i - 1]);
			carr[i] = (char) (carr[i] ^ carr[carr.length - i - 1]);
		}
		return new String(carr);
	}

	/* Find LCM and HCF for the numbers */
	public static int findLCM(int n1, int n2) {
		int max = n1 > n2 ? n1 : n2;
		while (true) {
			if ((max % n1 == 0) && (max % n2 == 0)) {
				return max;
			}
			max++;
		}
	}

	/* Find the HFC for the numbers */
	public static int findHCF(int n1, int n2) {
		// 6
		// 8
		int max = n1 > n2 ? n1 : n2;
		int hcf = 0;
		if (n1 == n2) {
			return n1;
		}
		for (int i = 1; i < max; i++) {
			if (n1 % i == 0 && n2 % i == 0) {
				hcf = i;
			}
		}
		return hcf;
	}

	/*
	 * HCF code Refactor
	 * 
	 * -> the above approach works, but if i look closely, the HCF of two numbers
	 * will always either be equal to or less than the smaller number. -> so the
	 * above code can be re-factored, in which i set a min variable to the SMALLER
	 * number, and i will keep testing if both the numbers are divisible by the min
	 * variable, if true i will return, if not i will decrement the min.
	 * 
	 */
	public static int findHCFByMin(int n1, int n2) {
		int min = n1 < n2 ? n1 : n2;
		int hcf = 1;
		while (true) {
			if (n1 % min == 0 && n2 % min == 0) {
				hcf = min;
				break;
			}
			min--;
		}
		return hcf;
	}

	/* Armstrong Number */
	public static double requiredSum(int num) {
		int i = countDigits(num);
		double sum = 0;
		while (num > 0) {
			int digit = num % 10;
			num = num / 10;
			sum += Math.pow(digit, i);
		}
		return sum;
	}

	public static int countDigits(int num) {
		int i;
		for (i = 0; num > 0; i++) {
			num = num / 10;
		}
		return i;
	}

	/* Perfect Number */
	public static boolean isPerfect(int num) {
		int[] divisors = new int[10];
		int k = 0;
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				divisors[k] = i;
				k++;
			}
		}
		int sum = 0;
		for (int i = 0; i < divisors.length; i++) {
			sum = sum + divisors[i];
		}
		return sum == num;
	}

	/* Given a number find the frequency of digits in the number */
	public static Map findFrequencyOfDigits(int num) {
		// 112575
		int[] digits = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Map<Integer, Integer> countsMap = new HashMap<>();

		while (num > 0) {
			int rem = num % 10;
			for (int i : digits) {
				if (rem == i) {
					if (countsMap.containsKey(rem)) {
						countsMap.put(rem, countsMap.get(rem) + 1);
					} else {
						countsMap.put(rem, 1);
					}
				}
			}
			num = num / 10;
		}
		return countsMap;
	}

	/* Fibonacci series */
	public static int[] getFibonacci(int range) {
		int a = 0;
		int b = 1;
		int c = 0;
		int[] seq = new int[range];
		for (int i = 0; i < range; i++) {
			c = a + b;
			b = c;
			a = b;
			seq[i] = c;
		}
		return seq;
	}

	/**
	 * Find Factorial of a number
	 */
	public static int findFactorial(int num) {
		int factorial = 1;
		for (int i = 1; i < num; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}

	/*
	 * Sum of factors of a given number
	 */
	public static int sumOfFactors(int num) {
		int sum = 0;
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				sum = sum + i;
			}
		}
		return sum;
	}

	/**
	 * prime factors of a number
	 */
	public static List<Integer> primeFactors(int num) {
		List<Integer> primes = new ArrayList<>();
		for (int i = 1; i < num; i++) {
			if (num % i == 0) {
				if(isPrime(i)) {
					primes.add(i);
				}
			}
		}
		return primes;
	}

	public static boolean isPrime(int num) {
		for(int i=2; i<num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * prime numbers within given range
	 * */
	public static List<Integer> findPrimes(int n1, int n2){
		List<Integer> l1 = new ArrayList<>();
		for(int i=n1; i<n2; i++) {
			if(isPrime(i)) {
				l1.add(i);
			}
		}
		return l1;
	}
	
	// twin primes between range
	public static int[] twinPrime(int n1, int n2) {
		int[] arr = new int[2];
		for(int i=n1; i<=n2; i++) {
			boolean g = prime(i);
			boolean h = prime(i+2);
			if(g&&h) {
				arr[0]=i;
				arr[1]=i+2;
			}
		}
		return arr;
	}
	
	
	// prime function alternate
	public static boolean prime(int m) {
		int count = 0;
		for(int i=1; i<m; i++) {
			if(m % i == 0) {
				count++;
			}
		}
		return count == 2;
	}
	
	/**
	 * sum of last two digits of a given number
	 * */
	public static int sumOfLast(int n) {
		int count = 0;
		int sum = 0;
		while(n > 0) {
			int rem = n % 10;
			sum = sum + rem;
			n = n / 10;
			count++;
			if(count == 2) {
				break;
			}
		}
		return sum;
	}
	
	// alternate 
	public static int sumOfNums(int a) {
		int sum = 0;
		int num = 0;
		int i = 1;
		while(i <= 2) {
			num = a % 10;
			sum = sum + num;
			a = a / 10;
			i++;
		}
		return sum;
	}
	
	// sum of numbers from a given digit
	public static int sumOfAllNums(int n) {
		int rem = 0;
		int sum = 0;
		while(n > 0) {
			rem = n % 10;
			sum = sum + rem;
			n = n / 10;
		}
		return sum;
	}
	
	// sum of prime numbers given within the range
	public static int sumOfPrimes(int n1, int n2) {
		int sum = 0;
		for(int i=n1; i<n2; i++) {
			int count = 0;
			for(int j=1; j<=i; j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count == 2) {
				sum = sum + i;
			}
		}
		return sum;
	}
	
	// prime numbers within the range
	public static int[] primesInRange(int n1, int n2) {
		int[] arr = new int[n2-n1];
		int k = 0;
		for(int i=n1; i<n2; i++) {
			int count = 0;
			for(int j=1; j<=i; j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count == 2) {
				arr[k] = i;
				k++;
			}
		}
		return arr;
	}
	
	//Factors of given numbers
	public static List<Integer> findFactors(int nums){
		List<Integer> factorsList = new ArrayList<>();
		for(int i=1; i<nums; i++) {
			if(nums % i == 0) {
				factorsList.add(i);
			}
		}
		return factorsList;
	}

	public static void main(String[] args) {
		System.out.println(findFactors(57));
	}
}
