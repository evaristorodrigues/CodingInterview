/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.Stack;

/**
 * @author evaristosrodrigues
 *
 */

public class StackMin extends Stack<Integer> {

	private static final long serialVersionUID = 1L;
	Stack<Integer> min;
	
	public StackMin() {
		min = new Stack<Integer>();
	}
	

	public Integer push(Integer value) {
		if (min() >= value) {
			min.push(value);
		} 
		super.push(value);
		return value;
	}

	@Override
	public Integer pop() {
		int value = super.pop();
		if(min() == value) {
			min.pop();
		}
		return value ;
	}

	public int min() {
		if(min.isEmpty()) {
			return Integer.MAX_VALUE;
		}else {
			return min.peek();

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackMin stackMin = new StackMin();
		
		stackMin.push(100);
		stackMin.push(20);
        System.out.println(stackMin.min());
		stackMin.push(30);
		stackMin.push(5);
        System.out.println(stackMin.min());
		stackMin.push(1);
        System.out.println(stackMin.min());
        stackMin.pop();
        System.out.println(stackMin.min());
        stackMin.pop();
        System.out.println(stackMin.min());
        stackMin.pop();
        stackMin.pop();
        System.out.println(stackMin.min());
        stackMin.pop();
        System.out.println(stackMin.min());
	}

}
