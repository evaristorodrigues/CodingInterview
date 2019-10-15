/**
 * 
 */
package br.com.codingInterview.business.sort.java;

import java.util.Arrays;

/**
 * @author Evaristo
 *
 */
public class CountingSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountingSort s = new CountingSort();
		int k = 9;
		int[] input = {9,5,7,3,2,1,4,-10,-10,-330};
		s.countingSort(input);
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(s.countingSort2(input)));

	}
	
	public  void countingSort(int[] array) { 
		if(array == null) {
			return;
		}
		//popula o minimo e o maximo
		int min=0;
		int max=0;
		for(int i = 0;i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}else if(array[i] < min) {
				min = array[i];
			}
		}
		//Cria o array para calcular as ocorrencias
		int[] count = new int[max-min +1];
		
		//polua as ocorrencias
		for(int i = 0;i < array.length; i++) {
			count[array[i] - min]++;
		}
		int ndx =0;
		for(int i = 0;i < count.length; i++) {
			while(count[i] > 0) {
				array[ndx++] = i+min;
				count[i]--;
			}
		}
	}
	
	public  int[] countingSort2(int[] array) { 
		if(array == null) {
			return null;
		}
		//popula o minimo e o maximo
		int min=0;
		int max=0;
		int aux[] = new int[array.length];
		for(int i = 0;i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}else if(array[i] < min) {
				min = array[i];
			}
		}
		//Cria o array para calcular as ocorrencias
		int[] count = new int[max-min +1];
		
		//popula as ocorrências
		for(int i = 0;i < array.length; i++) {
			count[array[i] - min]++;
		}
		count[0]--;
        //calcula a nova posição de cada valor
		for(int i =1; i < count.length; i++) {
			count[i] += count[i -1];
		}
		
		for( int i = array.length-1; i >=0 ; i--) {
			aux[count[array[i] - min]--]= array[i];
		}
		
		return aux;
	}


	
}
