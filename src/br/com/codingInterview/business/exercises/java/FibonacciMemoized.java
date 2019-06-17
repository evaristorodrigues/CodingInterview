package br.com.codingInterview.business.exercises.java;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoized {

	public static void main(String[] args) {
		FibonacciMemoized f = new FibonacciMemoized();
		Map<Long, Long> memoized = new HashMap<Long, Long>();
		System.out.println(f.fibonacci(10l, memoized));
	}
	
	public Long fibonacci(Long n, Map<Long, Long> memoized) {
		if(memoized.containsKey(n)) {
			return memoized.get(n);
		}else {
			if(n < 2) {
				memoized.put(n, n);
				return n;
			}
			
			Long value = fibonacci(n - 1, memoized) + fibonacci(n - 2, memoized) ;
			
			memoized.put(n, value);
			
			return value;
			
		}
	}
	

}
