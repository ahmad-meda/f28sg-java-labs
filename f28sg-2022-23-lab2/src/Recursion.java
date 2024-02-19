/**
 * @author Ahmad Meda
 *
 */
public class Recursion {

	// Part 1: complete
	/**
	 * @param n
	 * @return the sum of numbers up to the value entered
	 */
	public static int sum(int n){
		
			if (n == 0) { 
				//base case of returning 0 at the end of the recursion and is n = 0
	            return 0;
	        }
	        else {
	        	//recursion takes place to calculate the sum of the numbers
	            return  n + (sum(n-1));
	        }	
	}

	// Part 1 complete
	/**
	 * @param m
	 * @param n
	 * @return returns the product of 2 numbers
	 */
	public static int multiply(int m, int n){
		if(m == 0 || n == 0) {
			return 0;
		}else if(n < 0) { // to calculate the product of a negative and a positive integer
			return (-m + multiply(m, n+1));
		}else { // to calculate the product of 2 positive or 2 negative integers
			return (m + multiply(m, n-1));
		}
	}
	
	// Part 1: complete
	/**
	 * @param n
	 * @return the fibonacci sequence until the value entered
	 */
	public static int Fibonacci(int n){
		if (n == 0){ // returns 0 as the zero'th value in a fibonacci sequence is 0
			return 0;
		}else if (n == 1 || n == 2) { //uses OR operator to check if n is 1 OR 2 
			// returns 1 as the second number in the fibonacci sequence is  1-->(0+1)
			return 1;
		}else { //use of recursion to calculate the fibonacci sequence
			return Fibonacci(n-2) + Fibonacci(n-1);
		}		
	}


}