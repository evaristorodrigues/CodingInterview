package br.com.codingInterview.business.hackerearth.exercises.java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DavisStairs {

    // Complete the stepPerms function below.
    static int stepPerms(int n) {
       Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
       
       return (int) (helper(n,memo)%10000000007l);
    }

    // Complete the stepPerms function below.1 3
    static int helper(int n, Map<Integer,Integer> memo) {
        if( memo.get(n)!=null){
            return memo.get(n);
        }else if(n==0 || n == 1){
            memo.put(n,1);
            return 1;
        }else if( n == 2) {
            memo.put(n,2);
            return 2;     	
        }else if( n == 3){
            memo.put(n,4);
            return 4;
        }
        memo.put(n , helper(n-1, memo)+helper(n-2, memo)+helper(n-3, memo));
        return  memo.get(n);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
