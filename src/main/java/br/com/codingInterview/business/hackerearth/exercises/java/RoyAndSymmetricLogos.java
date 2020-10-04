/**
 * 
 */
package br.com.codingInterview.business.hackerearth.exercises.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author evaristosrodrigues
 *
 */
public class RoyAndSymmetricLogos {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testeCases = Integer.parseInt(br.readLine());
        
        for( int i =0; i < testeCases; i++){
            int matrixLength = Integer.parseInt(br.readLine());
            String[][]  matrix = new String[matrixLength][matrixLength];
            for(int l =0; l < matrixLength; l++){
                String line = br.readLine();
                for(int c =0; c < matrixLength; c++){
                    matrix[l][c]=""+line.charAt(c);
                }
            }
            isSymmetric(matrix,matrixLength);
        }

    }
    
    public static void isSymmetric(String[][] matrix, int length){
        
        for(int i = 0; i < length/2; i++){
            for( int k =0; k < length/2; k++){
              //  y lenth-y
                if(matrix[i][k] != matrix[i][(length-1) - k]
                  // x length -x
                    || matrix[i][k] != matrix[(length-1) -i][k]
                    // max y max x
                    ||matrix[i][(length-1) - k]!=  matrix[(length-1) -i][(length-1) - k]){
                   System.out.println("NO");
                   return;
                }
            }
        }
        System.out.println("YES");
    }

}
