/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Evaristo
 *716. Max Stack
 */
public class MaxStack {

	/**
	 * @param args
	 * Design a max stack that supports push, pop, top, peekMax and popMax.
push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
Example 1:
MaxStack stack = new MaxStack();
stack.push(5); 
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5
Note:
-1e7 <= x <= 1e7
Number of operations won't exceed 10000.
The last four operations won't be called when stack is empty.
-------
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	Stack<Integer> values = new Stack<Integer>();
	Stack<Integer> maxValues = new Stack<Integer>();
	public  MaxStack() {
		
	}
	
	public void push(int x) {
		if(maxValues.isEmpty() || x >= maxValues.peek()) {
			maxValues.push(x);
		}
		
		values.push(x);
	}
	
	public void pop() {
		if(values.pop().equals(maxValues.peek())){
			maxValues.pop();
		}
	}
	
	public int top() {
		return values.isEmpty()?0:values.peek();
	}
    public int peekMax() {
    	return maxValues.isEmpty()?0:maxValues.peek();
    }
    
    public int popMax() {
    	if(maxValues.peek().equals(values.peek())) {
    		maxValues.pop();
    		values.pop();	
    	}else {
    		//TODO pensar como resolver
    		int max = maxValues.pop();
    		maxValues.clear();
    		Iterator<Integer> i = values.iterator();
    		int j =0;
    		int pos =0;
    		while(i.hasNext()) {
    			int v = i.next();
    			if(max == v){
    				pos =j;
    			}
    		}
    		maxValues.peek();
    		values.remove(pos);
    		
    	}
    }
}
