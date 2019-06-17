package br.com.codingInterview.business.exercises.java;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

	public static void main(String[] args) {
		ClimbStairs s = new ClimbStairs();
		System.out.println(s.climbStairs6(22));
	}
	
	public int climbStairs(int n) {
        
	       if(n <= 3) {
	    	   return n;
	       }
	        
	       return climbStairs(n - 1) +climbStairs(n-2);
	    }

    public int climbStairs2(int n) {
      Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
      return helperClimbStairs(n,cache);
    }
    
    public int helperClimbStairs(int n, Map<Integer, Integer> cache) {
    	if(cache.containsKey(n)) {
    		return cache.get(n);
    	}
        if(n <= 3) {
        	cache.put(n, n);
     	   return n;
        }
        int value = climbStairs(n - 1) +climbStairs(n-2);
        cache.put(n, value);
         
        return value;
    }
    
    
	public int climbStairs3(int n) {
        
	       if(n <= 3) {
	    	   return n;
	       }	    
	       
	       int[] result = new int[n];
	       result[0] = 1;
	       result[1] = 2;
	       result[2] = 3;
	       
	       for(int i = 3; i < n; i++) {
	    	   result[i] = result[i - 1] +  result[i - 2];
	       }	       
	       
	       return result[n - 1];
	  }
	
	public int climbStairs4(int n) {        
	       if(n < 3) {
	    	   return n;
	       }		       
           int previous = 1;
           int current = 2;
	       int aux =0;
	       for(int i = 2; i < n; i++) {
	    	   aux = current;    	   
	    	   current = current + previous;
	    	   previous = aux;
	       }		       
	       return current;
	  }
	
    public int climbStairs5(int n) {
        double sqrt5 = Math.sqrt(5);
        return (int) Math.round(Math.pow((1 + sqrt5) / 2, n + 1) / sqrt5);
    }
    
    public int climbStairs6(int n) {
        int answer = 1;
        for(int i = 0, pre = 0; i < n; i++)
        	pre = (answer += pre) - pre;
        return answer;
    }
}
