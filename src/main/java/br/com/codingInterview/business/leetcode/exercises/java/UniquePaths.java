/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author evaristosrodrigues
 *62. Unique Paths
 */
public class UniquePaths {

	/**
	 * @param args
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
	 */
	public static void main(String[] args) {
		UniquePaths p = new UniquePaths();
		System.out.println(p.uniquePaths(7, 3));
	}
	
    public int uniquePathsBrute(int m, int n) {
        int[][] paths = new int [m][n];
        
        return	countPathsBrute(paths, 0,0); 
        
    }
	private int countPathsBrute(int[][] paths, int r, int c) {
		if(r < 0 || r >= paths.length
				|| c < 0 || c >= paths[0].length){
				//|| paths[r][c] == 1 ) {
			return 0;
		}
		if( r == paths.length -1 && c == paths[0].length - 1) {
			return 1;
		}else {
	    	paths[r][c]=1;
		    return countPathsBrute(paths,r+1,c)+countPathsBrute(paths, r, c+1)+
		    		countPathsBrute(paths,r-1,c)+countPathsBrute(paths,r,c-1);
		}
	}
	//Using Memo
	
    public int uniquePathsMemo(int m, int n) {
        int[][] paths = new int [m][n];
        
        return	countPathsMemo(paths, 0,0); 
        
    }

    
	private int countPathsMemo(int[][] paths, int r, int c) {
		if(r < 0 || r >= paths.length
				|| c < 0 || c >= paths[0].length){
				//|| paths[r][c] == 1 ) {
			return 0;
		}
		if(paths[r][c] !=0) {
			return paths[r][c];
		}
		if( r == paths.length -1 && c == paths[0].length - 1) {
			return 1;
		}else {
	    	paths[r][c]=countPathsMemo(paths,r+1,c)+countPathsMemo(paths, r, c+1);
	    	return paths[r][c];
		}
	}
	
	//Using DP
    public int uniquePaths(int m, int n) {
     int[][] dp = new int[m][n];
     for( int r =0; r < m; r++) {
    	 for( int c =0; c < n; c++ ) {
    		 if(r ==0 || c ==0) {
    			 dp[r][c] =1;
    		 }else {
    			 dp[r][c] = dp[r-1][c]+ dp[r][c-1];
    		 }
    	 }
      }
     return dp[m-1][n-1]; 
    }
	
	

}
