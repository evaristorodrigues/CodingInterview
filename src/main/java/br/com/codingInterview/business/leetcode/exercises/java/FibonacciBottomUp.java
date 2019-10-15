package br.com.codingInterview.business.leetcode.exercises.java;

public class FibonacciBottomUp {

	public static void main(String[] args) {
		
      System.out.println(fibonacciBottomUp(10));
	}

	private static Long fibonacciBottomUp(int f) {
		Long[] answer = new Long[f +1];
		answer[0]=0l;
		answer[1]=1l;
		
		for( int i = 2; i <= f; i++) {
			answer[i] = answer[i - 1]+answer[i - 2];  
		}
		return answer[f] ;
	}

}
