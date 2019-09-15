/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evaristo
 * 412. Fizz Buzz
 *
 */
public class FizzBuzz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FizzBuzz f = new FizzBuzz();
		System.out.println(f.fizzBuzz2(15));
	}
	
	/**
	 * Write a program that outputs the string representation of numbers from 1 to n.

     But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
     For numbers which are multiples of both three and five output “FizzBuzz”.
 */
	
    public List<String> fizzBuzz(int n) {
    	List<String> list = new ArrayList<String>();
    	for(int i=1; i <= n; i ++) {    		
    		if(i % 3 == 0) {
    			if(i % 5 ==0) {
    				list.add("FizzBuzz");
    			}else {
    				list.add("Fizz");
    			}
    		}else if(i % 5 ==0) {
    			list.add("Buzz");
    		}else {
    			list.add(String.valueOf(i));
    		}
    	}    	
    	return list;
        
    }
    
    public List<String> fizzBuzz2(int n) {
    	List<String> list = new ArrayList<String>();
    	for(int i=1; i <= n; i ++) {  
    		String item="";
    		if(i % 3 == 0) {
    			item="Fizz";    		}
    		if(i % 5 ==0) {
    			item=item+"Buzz";
    		}
    		if(item.isEmpty()){
    			item=""+i;
    		}
    		list.add(item);
    	}    	
    	return list;
        
    }

}
