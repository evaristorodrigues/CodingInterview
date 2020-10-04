/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author evaristosrodrigues
 *
 */
public class UniquePathsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UniquePathsII p = new UniquePathsII();
		
		
		int[][] obstacleGrid = { 
				  {0,0,0},
				  {0,1,0},
				  {0,0,0}};
		System.out.println(p.uniquePathsWithObstacles(obstacleGrid ));

	}
	
    public int uniquePathsWithObstaclesBrute(int[][] obstacleGrid) {
     if( obstacleGrid == null) {
    	 return 0;
     }
     int memo[][] = new int [obstacleGrid.length][obstacleGrid[0].length];
     return countPaths(obstacleGrid,0,0, memo);
    }

	private int countPaths(int[][] obstacleGrid, int r, int c, int[][] memo) {
		if(r < 0 || r >= obstacleGrid.length
				|| c < 0 || c >= obstacleGrid[0].length
				|| obstacleGrid[r][c] ==1) {
			return 0;
		}
		if( memo[r][c] != 0) {
			return memo[r][c];
		}
		if( r == obstacleGrid.length -1 && c == obstacleGrid[0].length - 1) {
			return 1;
		}
		
		memo[r][c] = countPaths(obstacleGrid, r +1, c, memo) + countPaths(obstacleGrid, r, c+1, memo);
		return memo[r][c];
	}
	
	//DP
    public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        if( obstacleGrid == null) {
       	 return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        int[][] path = new int[row][col];
        for( int i =0; i < row; i++) {
        	if(obstacleGrid[i][0] ==1) {
        		break;
        	}else {
        		path[i][0] = 1;
        	}
        }
        for( int i =0; i < col; i++) {
        	if(obstacleGrid[0][i] ==1) {
        		break;
        	}else {
        		path[0][i] = 1;
        	}
        }
        
        for( int i =1; i < row; i++) {
        	for( int j =1; j < col; j++) {
        		if(obstacleGrid[i][j]!=1) {
        		  path[i][j] = path[i-1][j] + path[i][j -1];
        		}
        	}
        }
       return path[row-1][col-1]; 
        
   }
    
	//DP Space(0)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	
        if( obstacleGrid == null) {
       	 return 0;
        }
        
        if(obstacleGrid[0][0] ==1) {
        	return 0;
        }
        
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        obstacleGrid[0][0] =1;
        
        for( int i =1; i < row; i++) {
        	if(obstacleGrid[i][0] == 0 && obstacleGrid[i -1][0]==1) {
        		obstacleGrid[i][0] =1;
        	}else {
        		obstacleGrid[i][0] =0;
        	}

        }
        for( int i =1; i < col; i++) {
        	if(obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1]==1) {
        		obstacleGrid[0][i] =1;
        	}else {
        		obstacleGrid[0][i] =0;
        	}
        }
        
        for( int i =1; i < row; i++) {
        	for( int j =1; j < col; j++) {
        		if(obstacleGrid[i][j]!=1) {
        			obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j -1];
        		}else {
        			obstacleGrid[i][j]=0;
        		}
        	}
        }
       return obstacleGrid[row-1][col-1]; 
        
   }

}
