/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author evaristosrodrigues
 *
 */
public class StackofPlates<T> {
    private int capacity;
    List<Stack<T>> lisOfStack;
    
    public StackofPlates(int capacity) {
	  this.capacity = capacity;
	  Stack<T> stack = new Stack<T>();
	  lisOfStack = new ArrayList<Stack<T>>();
	  lisOfStack.add(stack);
    }
    
    public void push(T item) {
    	Stack<T> stack = lisOfStack.get(lisOfStack.size() - 1);
    	if(stack.size() >= capacity) {
    		Stack<T> newStack = new Stack<T>();
    		newStack.push(item);
    		lisOfStack.add(newStack);
    	}else {
        	stack.push(item);    	
    	}
    }
    
    public T pop() {
    	Stack<T> stack = lisOfStack.get(lisOfStack.size() - 1);
        T value = stack.pop();
        if(stack.isEmpty() &&  lisOfStack.size()  > 1) {
        	lisOfStack.remove(lisOfStack.size() - 1);
        }        
    	return value;
    }
	
    public T peek() {
    	Stack<T> stack = lisOfStack.get(lisOfStack.size() - 1);
    	return stack.peek();
        
    }
    public boolean isEmpty() {
    	Stack<T> stack = lisOfStack.get(lisOfStack.size() - 1);
        return stack.isEmpty(); 
    }
    
    public T popAt(int pos) {
    	if(pos > lisOfStack.size() - 1 || pos < 0) {
    		throw new ArrayIndexOutOfBoundsException();
    	}
    	Stack<T> stack = lisOfStack.get(pos);
    	T value = stack.pop();
        if(stack.isEmpty() &&  lisOfStack.size()  > 1) {
        	lisOfStack.remove(lisOfStack.size() - 1);        	
        }else if(lisOfStack.size() > pos +1) {
        	T item = popAt(pos+1);
        	stack.push(item);
        }        
    	return value;       	
    }
    
    
	
	public List<Stack<T>> getLisOfStack() {
		return lisOfStack;
	}
	
	public static void main(String[] args) {
		StackofPlates<Integer> stacksPlates = new StackofPlates<Integer>(3);
		
		stacksPlates.push(1);
		stacksPlates.push(2);
		stacksPlates.push(3);
		
		stacksPlates.push(4);
		stacksPlates.push(5);
		stacksPlates.push(6);
		
		stacksPlates.push(7);
		System.out.println("Quantidade de Elementos " + stacksPlates.getLisOfStack().size());
		stacksPlates.popAt(1);
		System.out.println("Quantidade de Elementos " + stacksPlates.getLisOfStack().size());		
		stacksPlates.push(7);
		System.out.println("Quantidade de Elementos " + stacksPlates.getLisOfStack().size());		
		System.out.println(stacksPlates.peek());
		System.out.println(stacksPlates.pop());
		System.out.println(stacksPlates.peek());
		System.out.println("Quantidade de Elementos " + stacksPlates.getLisOfStack().size());
		stacksPlates.pop();
		stacksPlates.pop();
		stacksPlates.pop();
		System.out.println(stacksPlates.peek());
		System.out.println("Quantidade de Elementos " + stacksPlates.getLisOfStack().size());
		stacksPlates.pop();
		stacksPlates.pop();
		System.out.println(stacksPlates.peek());
		System.out.println("Quantidade de Elementos " + stacksPlates.getLisOfStack().size());
		stacksPlates.pop();
		System.out.println("Quantidade de Elementos " + stacksPlates.getLisOfStack().size());
        System.out.println(stacksPlates.isEmpty());

	}

}
