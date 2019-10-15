/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Evaristo
 *200. Number of Islands
 */
public class NumberOfIslands {

	/**
	 * 
	 */
	public NumberOfIslands() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
	 */
	public static void main(String[] args) {
		NumberOfIslands n = new NumberOfIslands();
		char[][] grid = null;
		System.out.println(n.numIslands(grid));

	}

    public int numIslands2(char[][] grid) {
        if(grid == null || grid.length ==0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }
        int islands =0;
        
        for(int i=0; i <grid.length; i++ ) {
        	for( int j=0; j < grid[i].length; j++) {
        		if(grid[i][j] == '1') {
        			surroudIsland(grid,i,j);
        			islands++;
        		}
        	}
        }
        return islands;
    }

	private void surroudIsland(char[][] grid, int x, int y) {
		if(x<0 || x > grid.length-1 || y < 0 || y > grid[x].length-1 || grid[x][y] == '0') {
			return;
		}
		grid[x][y]='0';		
		surroudIsland(grid,  x+1, y);
		surroudIsland(grid,  x-1, y);
		surroudIsland(grid,  x, y+1);
		surroudIsland(grid,  x, y-1);		
	}

    public int numIslands(char[][] grid) {
    if(grid == null || grid.length ==0 || grid[0] == null || grid[0].length == 0){
      return 0;
    }	
    int result =0;
    int X = grid.length;
    int Y = grid[0].length;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    Queue<Integer> qx = new LinkedList<Integer>();
    Queue<Integer> qy = new LinkedList<Integer>();
    
    for(int i=0; i < X; i++) {
    	for(int j =0; j < Y; j++) {
    		if(grid[i][j] == '1') {
    			//BFS
    			qx.offer(i);
    			qy.offer(j);
    			while(!qx.isEmpty()) {
    				int x = qx.poll();
    				int y = qy.poll();
    				if(x < 0 || x > X -1 || y < 0 || y > Y-1 || grid[x][y] == '0' ) continue;
    				grid[x][y] = '0';    				
    				for(int k = 0; k < 4; k++) {
    					qx.add(x +dx[k]);
    					qy.add(y+dy[k]);
    				}
    			}
    			result++;    		    
    		}
    	}
    }
    
    return result;
    }
	
	
}
