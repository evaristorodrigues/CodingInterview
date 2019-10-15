/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Evaristo
 *
 */
public class MergeIntervals {

	/**
	 * 
	 */
	public MergeIntervals() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
	 */
	public static void main(String[] args) {
		
		MergeIntervals m= new MergeIntervals();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        intervals = m.merge(intervals);
        
        for(int i = 0; i < intervals.length ; i++) {
        	System.out.print(intervals[i][0]);
        	System.out.print(",");
        	System.out.print(intervals[i][1]);
        	System.out.println();
        }
	}
	
    public int[][] merge(int[][] intervals) {    	
    	if(intervals == null || intervals.length ==0) {
    		return intervals;
    	}
    	Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {				
				return a[0] > b[0] ? 1: a[0] == b[0]? 0: -1;
			}    		
		});
        LinkedList<int[]> result = new LinkedList<int[]>();
        result.add(intervals[0]);
    	for(int i =1; i < intervals.length; i++) {
    		if(intervals[i][0]<= result.getLast()[1]) {
    			result.getLast()[1] = Math.max(intervals[i][1], result.getLast()[1]);
    		}else {
    			result.add(intervals[i]);
    		}
    	}
		return result.toArray(new int[result.size()][]);        
    }

}
