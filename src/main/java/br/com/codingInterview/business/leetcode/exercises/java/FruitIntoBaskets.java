/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @author evaristosrodrigues
 *
 */
public class FruitIntoBaskets {

	/**
	 * @param args
	 * 904. Fruit Into Baskets
	 */
	public static void main(String[] args) {
		FruitIntoBaskets f = new FruitIntoBaskets();
		
		int[] tree = {0,10,33,0,1,2,3,2,2};
		System.out.println(f.totalFruit(tree));
	}
	
    public int totalFruit(int[] tree) {
        if( tree == null) {
        	return 0;
        }
        Map<Integer, Integer> typeFruit = new HashMap<>();
        int left = 0;
        int rigth = 0;
        int max =0;
        
        while(rigth < tree.length) {
        	typeFruit.put(tree[rigth], rigth++);
        	
        	if(typeFruit.size() > 2) {
        		int min= Integer.MAX_VALUE;
        		for(Integer p : typeFruit.values()) {
        			min = Math.min(min, p);
        		}
        		typeFruit.remove(tree[min]);
        		left= min +1;
        	}
        	max = Math.max(max, rigth - left);
        }
        
        return max;
    }

}
