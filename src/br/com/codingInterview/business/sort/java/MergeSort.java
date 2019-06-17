package br.com.codingInterview.business.sort.java;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] array = {10,25,15,18,177,68,22,10,11,0,1};
		Arrays.toString(mergeSort(array, array.length));

	}

	private static int[] mergeSort(int[] array, int length) {
		
		if(length < 2) {
			return array;
		}
		int middle = Math.floorDiv(length, 2);
		
		int[] left = new int[middle];
		int[] right = new int[length - middle];
		
		for( int i  = 0; i < middle; i ++) {
			left[i] = array[i];
		}
		for(int j = middle; j < length; j++) {
			right[j - middle] = array[j];
		}
		
		
		
		return merge(mergeSort(left, left.length),mergeSort(right, right.length));
		
		
	}

	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length +  right.length];
		int leftElements = 0;
		int rightElements = 0;
		int resultElement =0;
		
		while(leftElements < left.length  && rightElements < right.length) {
			if(left[leftElements] < right[rightElements]) {
				result[resultElement++] = left[leftElements++];
			}else {
				result[resultElement++] = right[rightElements++];
			}
		}
		
		while(leftElements < left.length ) {
			result[resultElement++] = left[leftElements++];
		}
		while(rightElements < right.length ) {
			result[resultElement++] = right[rightElements++];
		}
		return result;
	}

}
