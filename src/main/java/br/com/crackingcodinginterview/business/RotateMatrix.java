/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.Arrays;

/**
 * @author evaristosrodrigues
 *
 */
public class RotateMatrix {

	/**
	 * @param args
	 */
	
	public void rotate(byte[][] image) {

		if (image == null) {
			return;
		}
		int length = image.length - 1;
		for (int x = 0; x < image.length/2; x++) {
			for (int y = x; y < length - x; y++) {
           				
	              //save the upper rigth Value
                byte urValue = image[y][length -x];
                //assign the upper left value to upper rigth
                image[y][length -x] = image[x][y];     
                //Assine bottom left to upper left
                image[x][y] = image[length - y][x];
                //Assign bottom right to bottom left
                image[length - y][x]= image[length - x][length -y];
                //assign the upper right value to bottom right value
                image[length - x][length -y] = urValue;
			}

		}
	}
	
	public static void main(String[] args) {
		RotateMatrix rm = new RotateMatrix();
		
		byte[][] image = { {0,0,0,0,0,1},
				           {1,0,0,0,1,1},
				           {1,1,0,1,1,1},
				           {1,1,1,0,1,1},
				           {1,1,0,0,0,1},
				           {1,0,0,0,0,0},
				         };
		
		
		for( int i =0; i < image.length; i++) {
			  System.out.println(Arrays.toString(image[i]));	
			}
		rm.rotate(image);
		System.out.println("New");	
		for( int i =0; i < image.length; i++) {
		  System.out.println(Arrays.toString(image[i]));	
		}
		


	}

}
