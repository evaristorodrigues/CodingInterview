/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.Stack;

/**
 * @author evaristosrodrigues
 *
 */
public class QueueByStacks<T> {

	Stack<T> stack;
	Stack<T> stackQueue;
	
	public QueueByStacks() {
		stack = new Stack<T>();
		stackQueue = new Stack<T>();
	}
	
	public void add(T item) {
		stack.add(item);
	}
	public T remove() {
		fillQueue();
        return stackQueue.pop();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty() && stackQueue.isEmpty();
	}
	
	public T peek() {
	fillQueue();
    return stackQueue.peek();
	}
	
	private void fillQueue() {
		if(stackQueue.isEmpty()) {
			while(!stack.isEmpty()) {
				stackQueue.push(stack.pop());
			}
		}
	}	
	
	public int size() {
		return stack.size()+ stackQueue.size();
	}	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QueueByStacks<Integer> queue = new QueueByStacks<Integer>();
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.remove();
		
		System.out.println(queue.peek());

		while( !queue.isEmpty()) {
			System.out.println(queue.remove());
		}
		System.out.println();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		while( !queue.isEmpty()) {
			System.out.println(queue.remove());
		}
	}
}
