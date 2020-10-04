/**
 * 
 */
package br.com.codingInterview.business.hackerearth.exercises.java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author evaristosrodrigues
 *
 */
public class BinaryQueries {

	/**
	 * @param args
	 */
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/teste.txt")));
        int[] lengths = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = lengths[0];
        int q = lengths[1];
        
        StringBuilder binary = new StringBuilder();
        binary.append(Stream.of(br.readLine().split(" ")).collect(Collectors.joining()));
        
        for(int i =0; i < q; i++){
            int[] lineChars = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            //check if it is Odd
            if(lineChars[0] == 1){
                if(binary.charAt(lineChars[1]-1) == '0'){
                    binary.setCharAt(lineChars[1]-1, '1');
                }else{
                    binary.setCharAt(lineChars[1]-1, '0');
                }
                
            }else{
                if(binary.substring(lineChars[2]-1, lineChars[2]).equals("1")){
                  System.out.println("ODD");
                }else{
                   System.out.println("EVEN");  
                     
                }
            }
        }
        br.close();
    }
}
