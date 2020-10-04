/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.Arrays;

/**
 * @author evaristosrodrigues
 * Leetcode 286
 */
public class WallsAndGates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WallsAndGates g = new WallsAndGates();
		int[][] rooms = new int[][] {{Integer.MAX_VALUE, -1,0, Integer.MAX_VALUE},
			                          {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE, -1},
			                          {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
	    		                          {0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}};
	    //From room to gate
	    long time = System.currentTimeMillis();
		g.wallsAndGates(rooms);
		for( int i =0; i < rooms.length; i++) {
			System.out.println(Arrays.toString(rooms[i]).spli);		
		}
		System.out.println(System.currentTimeMillis() - time);

		rooms = new int[][] {{Integer.MAX_VALUE, -1,0, Integer.MAX_VALUE},
            {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE, -1},
            {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
            {0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}};
    		//From gate to room
    	    long time2 = System.currentTimeMillis();
            g.wallsAndGates2(rooms);
		for( int i =0; i < rooms.length; i++) {
			System.out.println(Arrays.toString(rooms[i]));		
		}
	    System.out.println(System.currentTimeMillis() - time2);

	}
	private void wallsAndGates2(int[][] rooms) {
		if( rooms == null) {
			return;
		}
		for( int x =0; x < rooms.length; x++) {
			for( int y =0; y < rooms[0].length; y++) {
				if(rooms[x][y] == 0) {
					findNearestGate2(rooms, x,y,0);
				}
			}
		}
		
	}
	private void findNearestGate2(int[][] rooms, int x, int y, int count) {
		if(x < 0 || x > rooms.length -1 || y < 0 || y > rooms[0].length -1 || rooms[x][y] < count ) {
			return;
		}
		rooms[x][y]= count;
		
		findNearestGate2(rooms, x+1,y,count+1);
		findNearestGate2(rooms, x-1,y,count+1);
		findNearestGate2(rooms, x,y+1,count+1);
		findNearestGate2(rooms, x,y-1,count+1);
		
	}
	// 1 - wall
	// 0 - Gate
	// INF 2 ^31 -1
	public void wallsAndGates(int[][] rooms) {
		if( rooms == null) {
			return;
		}
		for( int x =0; x < rooms.length; x++) {
			for( int y =0; y < rooms[0].length; y++) {
				if(rooms[x][y] == Integer.MAX_VALUE) {
					rooms[x][y] = findNearestGate(rooms, x,y,0);
				}
			}
		}
	}
	private int findNearestGate(int[][] rooms, int x, int y, int count) {
		if(x < 0 || x > rooms.length -1 || y < 0 || y > rooms[0].length -1 || rooms[x][y] == -1) {
			return Integer.MAX_VALUE;
		}
		if( rooms[x][y] == 0) {
			return count;
		}
		count++;
		int a = rooms[x][y];
		rooms[x][y]= -1;
		
		
		int min= Math.min(findNearestGate(rooms, x,y-1,count),
				    Math.min(findNearestGate(rooms, x,y+1,count),
				    		Math.min(findNearestGate(rooms, x+1,y,count),findNearestGate(rooms, x-1,y,count))
				    )
			  );
		rooms[x][y]= a;
		
		return min;
	}

}
