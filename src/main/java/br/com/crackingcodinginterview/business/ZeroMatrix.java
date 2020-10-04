/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author evaristosrodrigues
 *
 */
public class ZeroMatrix {

	/**
	 * @param args
	 */
	
	public void toZeroXY(int[][] matrix) {
		if( matrix == null) {
			return;
		}
		Set<Integer> setX = new HashSet<Integer>();
		Set<Integer> setY = new HashSet<Integer>();
	
		for( int x = 0; x < matrix.length; x++) {
			for( int y=0; y < matrix[0].length; y++) {
				if(matrix[x][y] == 0) {
					setX.add(x);
					setY.add(y);
				}
			}
		}
	   toZero(setX, setY, matrix);		
	}
	private void toZero(Set<Integer> setX, Set<Integer> setY, int[][] matrix) {
		for( int x = 0; x < matrix.length; x++) {
			for( int y=0; y < matrix[0].length; y++) {
				if(setX.contains(x)|| setY.contains(y)) {
                  matrix[x][y]=0;
				}
			}
		}		
	}
	public static void main(String[] args) {
		ZeroMatrix zm = new ZeroMatrix();
        int[][] matrix = new int[][] {{1,1,1,0,1},
        	                          {1,1,1,1,1},
        	                          {1,0,1,1,1},
        	                          {1,1,1,1,1}};
        	                          
      zm.toZeroXY(matrix);
      
      for(int[] y : matrix) {
    	  System.out.println(Arrays.toString(y));
      }
	  System.out.println();

      matrix = new int[][] {{1,1,1,0,1},
                            {1,1,1,1,1},
                            {1,0,1,1,1},
                            {1,1,1,1,1}};
          
      zm.toZeroXY2(matrix);

      for(int[] y : matrix) {
    	  System.out.println(Arrays.toString(y));
      }
      
      
      
	}
	/*
	 * 11101 11111 10111 11111
	 */
	private void toZeroXY2(int[][] matrix) {
		if( matrix == null) {
			return; 
		}		
		boolean isfirstColWithZero = false;

		
		//traverse the first row if exists a column if value 0, then isfirstLineWithZero = true and break
//		for( int i =0; i < matrix[0].length; i++) {
//			if(matrix[0][i] == 0) {
//				isfirstRowWithZero = true;
//				break;
//			}
//		}
//		
//		for( int i =0; i < matrix.length; i++) {
//			if(matrix[i][0] == 0) {
//				matrix[0][0] = 0;
//				break;
//			}
//		}
		
		//traverse the other rows if exists 0 the first column of the row will be 0 and the column of first row will be 0
		for( int x =0; x < matrix.length; x++) {
			if(matrix[x][0] == 0) {
				isfirstColWithZero = true;
			}
			
			for( int y = 1; y < matrix[0].length; y++) {
				if(matrix[x][y] ==0) {
					matrix[x][0]=0;
					matrix[0][y]=0;
				}
			}
		}		
		
		//traverse the other column if exists 0 the first column of the line will be 0 and first column will be 0
		for( int x =1; x < matrix.length; x++) {
			for( int y = 1; y < matrix[0].length; y++) {
				if(matrix[x][0] ==0 || matrix[0][y] ==0) {
					matrix[x][y]=0;
				}
			}
		}
		
		
		//update the entire left column if first left column ==0
		if(matrix[0][0] ==0) {
			for( int y =0; y < matrix[0].length; y++) {
				matrix[0][y] =0;
			}

		}
		//update the first line if exists column 0
		if( isfirstColWithZero) {
			for( int x =0; x < matrix.length; x++) {
				matrix[x][0] = 0;
			}
		}
		
	}

}
