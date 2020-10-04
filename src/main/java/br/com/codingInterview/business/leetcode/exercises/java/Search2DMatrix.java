/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author evaristosrodrigues 74. Search a 2D Matrix
 */
public class Search2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return false;
		}
		int col = matrix[0].length - 1;
		int row = 0;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}
		}
		return false;
	}

}
