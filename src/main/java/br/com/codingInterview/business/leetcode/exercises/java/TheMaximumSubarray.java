package br.com.codingInterview.business.leetcode.exercises.java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TheMaximumSubarray {
	
	

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {
         int current=arr[0];
         int v1 =arr[0];
         int v2=arr[0];
         int[] result = new int[2];
         result[0]=arr[0];
         result[1]=arr[0];

         for( int i =1; i < arr.length; i++){
             int aux = Math.max(arr[i],arr[i]+Math.max(v1,v2));
             v1 = v2;
             v2 = aux;
             result[1] = Math.max(result[1],Math.max(v1,v2)); 

             current = Math.max(arr[i], arr[i]+current);
             result[0] = Math.max(current, result[0]);
             
         }
         
       return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
