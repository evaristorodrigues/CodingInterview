/**
 * 
 */
package br.com.crackingcodinginterview.business.datastructure;

import java.util.EmptyStackException;

/**
 * @author evaristosrodrigues
 *
 */
public class MyStackNode<T> {
	StackNode<T> head;

	public void push(T value) {

		StackNode<T> node = new StackNode<T>(value);
		node.next = head;
		head = node;
	}

	public T peek() {
		if (head == null) {
			throw new EmptyStackException();
		} else {
			return head.value;
		}
	}

	public T pop() {
		if (head == null) {
			throw new EmptyStackException();
		} else {
			T value = head.value;
			head = head.next;
			return value;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyStackNode<Integer> stack = new MyStackNode<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		System.out.println( "Last Values");		
		System.out.println(stack.peek());
		System.out.println();
		System.out.println( "Removendo last");		
		System.out.println(stack.pop());
		System.out.println( "Last Values");		
		System.out.println(stack.peek());
		stack.push(400);
		System.out.println( "Values");		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}

class StackNode<T> {
	StackNode<T> next;
	T value;

	public StackNode(T value) {
		this.value = value;
	}

}