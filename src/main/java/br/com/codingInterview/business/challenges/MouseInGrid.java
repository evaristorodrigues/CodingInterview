package br.com.codingInterview.business.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MouseInGrid {
	
	public static void main(String[] args) {
	  int[][] matrix = {{1,1,1,1},
			            {1,1,0,1},
			            {0,1,0,1},
			            {0,1,1,1}};
	  MouseInGrid m = new MouseInGrid();
	  
	  m.findPath(matrix,4);
		
	}

	private  void findPath(int[][] matrix, int e) {
		List<String> paths = new ArrayList<String>();
		
		helper(matrix,0,0,"",e,paths);
		Collections.sort(paths);
		
		for(String s: paths) {
			System.out.print(s);
			System.out.println(" ");
		}
	}

	private  void helper(int[][] matrix, int row, int col, String current, int e, List<String> paths) {
		System.out.println(row+" "+col);
		if(row < 0 || row >= e 
				|| col <0 || col >=e 
				|| matrix[row][col] ==0) {
		   return ;
		} 
		
		 if(row == e-1 && col == e-1) {
			paths.add(current);
				return;
		  }
		   //matrix[row][col] =0;
		  helper(matrix, row, col+1, current+"R", e, paths);		  
		  helper(matrix, row+1, col, current+"D", e, paths);
		  helper(matrix, row-1, col, current+"U", e, paths);
		  helper(matrix, row, col-1, current+"L", e, paths);
		//  matrix[row][col] =0;
	}
	


}
