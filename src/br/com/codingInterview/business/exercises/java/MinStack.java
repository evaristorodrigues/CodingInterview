/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Evaristo
 *
 */
public class MinStack {

	/**
	 * @param args
	 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
	 */
	public static void main(String[] args) {
		
		 
		  MinStack obj = new MinStack();
		 
		  obj.push(2147483646 );
		  obj.push(2147483646 );
		  obj.push(2147483647);
		  System.out.println(obj.top());
		  obj.pop();
		  obj.getMin();
		  obj.pop();
		  obj.getMin();
		  obj.pop();
		  obj.push(2147483647);
		  System.out.println(obj.top());
		  obj.getMin();
		  obj.push(-214748364);
		  System.out.println(obj.top());
		  obj.getMin();
		  obj.pop();
		  obj.getMin();
		  int param_3 = obj.top();
		  int param_4 = obj.getMin();
		  System.out.println( param_3 );
		  System.out.println( param_4 );
		 

	}
       /* int min = Integer.MAX_VALUE;
        int posMin =0;
        int last =-1;
        List<Integer> stack = new ArrayList<Integer>();
	
	    *//** initialize your data structure here. *//*
	    public MinStack() {
	        
	    }
	    
	    public void push(int x) {
	        stack.add(x);
	        ++last;
	        if(x < min) {
	        	min =x;
	        	posMin = last;
	        }
	    }
	    
	    public void pop() {
	    	if(last == -1) {
	    		return;
	    	}
	    	stack.remove(last);
	    	if(last == posMin) {
	    		min = Integer.MAX_VALUE;
	    		for(int i =0; i < stack.size(); i++) {
	    			if(stack.get(i) <= min) {
	    				min = stack.get(i);
	    				posMin = i;
	    			}
	    		}
	    	}else if(last < posMin){
	    		--posMin;
	    	}
	    	--last;	        
	    }
	    
	    public int top() {
	    	if(last == -1) {
	    		return 0;
	    	}
	    	return stack.get(last);
	        
	    }
	    
	    public int getMin() {
	    	if(last == -1) {
	    		return 0;
	    	}
	        return stack.get(posMin);
	    }*/
/////////////////////////////////////USANDO STACKS /////////////////////////////////////////	

/*	Stack<Integer> values = new Stack<Integer>(); 
	Stack<Integer> minimus = new Stack<Integer>(); 
    public MinStack() {
        
    }
    
    public void push(int x) {
    	if(minimus.isEmpty() || x <= minimus.peek()) {
    		minimus.push(x);
    	}
    	values.push(x);        
    }
    
    public void pop() {
        if(values.pop().equals(minimus.peek())) {
        	minimus.pop();
        }
    }
    
    public int top() {
        return  values.isEmpty()?0:values.peek();
    }
    
    public int getMin() {
        return minimus.isEmpty()?0:minimus.peek();
    }*/

 ///////////////////// JUST ONE STACK /////////////////////////////////
    
/*    Stack<Integer> values = new Stack<Integer>(); 
    int min = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int x) {
       if(x <= min) {
    	   values.push(min);
    	   min =x;
       }
       values.push(x);
    }
    
    public void pop() {
    if(values.pop().equals(min)) {
    	min = values.pop();
    }
    }
    
    public int top() {
    	return values.isEmpty()?0 :values.peek();

    }
    
    public int getMin() {
      return min;
    }*/
	
/////////////////// Node ///////////////////////
    
    private class Node{
    	Node next;
    	int value;
    	
    	public Node(int value) {
    		this.value = value;
    	}
    }
    Node node = null;
    int min = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int x) {
      if(x <= min) {    	 
       	 Node newNode  = new Node(min);
       	 min =x;
       	 newNode.next = node;
       	 node=newNode;
        }
        Node newNode2 = new Node(x);
        newNode2.next = node;
        node = newNode2;

    }
    
    public void pop() {
     if(node.value == min) {
    	 node = node.next;
    	 min = node.value;
     }
    	 node = node.next;

    }
    
    public int top() {
    	return node.value;
    }
    
    public int getMin() {
    return node != null? min:0;
    }
	}







/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */