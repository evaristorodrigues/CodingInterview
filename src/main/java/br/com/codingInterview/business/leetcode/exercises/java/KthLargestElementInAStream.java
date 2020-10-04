/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author evaristosrodrigues
 *
 */
public class KthLargestElementInAStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int k = 3;
		int[] arr = {4,5,8,2};		
		
		KthLargest kthLargest = new KthLargestElementInAStream().new KthLargest(k, arr);
		System.out.println(kthLargest.add(3));   // returns 4
		System.out.println(kthLargest.add(5));   // returns 5
		System.out.println(kthLargest.add(10));  // returns 5
		System.out.println(kthLargest.add(9));   // returns 8
		System.out.println(kthLargest.add(4));   // returns 8

	}
	class KthLargest {
        PriorityQueue<Integer> heap;
        int k;
	    public KthLargest(int k, int[] nums) {
	    	this.k = k;
	        heap = new PriorityQueue<Integer>();
	        for( int i: nums) {
	        	heap.add(i);
		        if(heap.size() > k) {
		        	heap.poll();
		        }
	        }
	        
	    }
	    
	    public int add(int val) {
	      heap.add(val);
	      if(heap.size() > k) {
	    	  heap.poll();
	      }
	      
	      return heap.peek();
	    }
	}

}
