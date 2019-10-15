package br.com.codingInterview.business.datastructure.java;

import java.util.Iterator;
import java.util.Stack;

class MyQueue {
    
    Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
     stack = new Stack<Integer>();  
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {    	
    	stack.add(x);        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	Stack<Integer> stack2 = new Stack<Integer>();
        Iterator<Integer> i = stack.iterator();
        while(i.hasNext()) {
        	stack2.add(stack.pop());          
        }
        int a = stack2.pop();
        Iterator<Integer> b = stack2.iterator();
        stack.clear();
        while(b.hasNext()) {
        	stack.add(stack2.pop());
        }
        
        return a;
    }
    
    /** Get the front element. */
    public int peek() {
      Iterator<Integer> i  =stack.iterator();
      int value = 0;
      while(i.hasNext()) {
    	  value = i.next();
    	  break;
      }
      return value;  
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
    
    
    public static void main(String arg[]) {
    	 MyQueue obj = new MyQueue();
    	 obj.push(1);
    	 obj.push(2);  
    	   // returns 1
    	    // returns 1
    	  // returns false
    	 
    	 System.out.println(obj.peek() + " - "+ obj.pop()+" - "+ obj.empty());

	}
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 * 
 */

  