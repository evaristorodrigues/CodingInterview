/**
 * 
 */
package br.com.codingInterview.business.hackerearth.exercises.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Evaristo
 *Transpose
 */
public class Transpose {

	/**
	 * 
	 */
	public Transpose() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * Given a 2D array A, your task is to convert all rows to columns and columns to rows.

Input:
First line contains 2 space separated integers, N - total rows, M - total columns.
Each of the next N lines will contain M space separated integers.

Output:
Print M lines each containing N space separated integers.
	 */
	 public static void main(String args[] ) throws Exception {		 
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = null;
	        while((line = br.readLine()) != null){	            
	            String[] values = line.split(" ");
	            int X = Integer.parseInt(values[0]);
	            int Y = Integer.parseInt(values[1]);
	           // int A[][] = new int[X][Y];
	            int B[][] = new int[Y][X];	         
	            for( int i=0; i < X ; i++){
	                line = br.readLine();
	                values = line.split(" ");
	                for( int j=0; j < Y; j++ ){
	                    B[j][i] = Integer.parseInt(values[j]);
	                }	                    
	            }	            
	            for(int i = 0; i < Y; i++){
	                for( int j =0;j < X; j++){
	                      System.out.print(B[i][j]);
	                      System.out.print(" ");
	                }
	                System.out.println();
	            }
	        }
	    }
}
