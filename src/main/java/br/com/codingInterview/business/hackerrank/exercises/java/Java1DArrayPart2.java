package br.com.codingInterview.business.hackerrank.exercises.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Java1DArrayPart2 {
	

    public static boolean canWin(int leap, int[] game) {
       int position =0;
       while( position < game.length){
           if(position+leap > game.length-1 || position == game.length - 1){          
               return true;
           }else if(game[position +leap] == 0){
               position+=leap;
           }else if(game[position+1]==0 ){
               position++;
           }else if((position - 1) > 0 && game[position-1]==0){
        	   game[position]=1;
               position --;
           }else{
               return false;
           }
       }
       return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("teste.txt"));
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }

}
