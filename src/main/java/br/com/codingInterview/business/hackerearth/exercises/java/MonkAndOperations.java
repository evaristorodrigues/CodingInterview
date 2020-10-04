/**
 * 
 */
package br.com.codingInterview.business.hackerearth.exercises.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;


//Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class MonkAndOperations {
  public static void main(String args[] ) throws Exception {

      //BufferedReader
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/teste.txt")));

      long maxRow =0;
      long maxCol=0;
      
      int[] length = Stream.of(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
      int row =length[0];
      int col = length[1];
      
      int[][] matrix = new int[row][col];
      int[][] cols = new int[col][3];
      
      
      for( int i =0; i < row; i++){
          matrix[i] =Stream.of(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
      }
      int[] v = Stream.of(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
      for(int i =0; i < row; i++){
          int value=0;
          int option1=0;
          int option2=0;
          for(int k=0;k < col; k++){
              value+= Math.abs(matrix[i][k]);
              option1+= Math.abs(matrix[i][k] + v[0]);
              option2+= Math.abs(v[1]);
              
              cols[k][0]+=Math.abs(matrix[i][k]);
              cols[k][1]+=Math.abs(matrix[i][k]+v[2]);
              cols[k][2]+=Math.abs(v[3]);
          }
          maxRow += Math.max(value, Math.max(option1,option2));
      }       
      for( int i =0; i < col; i++){
          maxCol+=Math.max(cols[i][0], Math.max(cols[i][1],cols[i][2]));
      }
    System.out.println(Math.max(maxCol, maxRow));
  }
}
