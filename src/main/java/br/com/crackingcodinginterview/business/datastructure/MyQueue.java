/**
 * 
 */
package br.com.crackingcodinginterview.business.datastructure;

import java.util.NoSuchElementException;

/**
 * @author evaristosrodrigues
 *
 */
class QueueNode<T>{
	QueueNode<T> next;
	T value;
	public QueueNode(T value) {
		this.value = value;
    }
}	
public class MyQueue<T> {
	QueueNode<T> first;
	QueueNode<T> last;
	int size;

	public void add(T value) {
		QueueNode<T> node = new QueueNode<T>(value);
		if(last == null) {
			last = node;
		}else {
			last.next = node;
			last = node;
		}
		if( first == null) {
			first = last;
		}
	}
	
	public T peek() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		return first.value;
	}
	
	public T remove() {
		if(!isEmpty()) {
			T value = first.value;
			first = first.next;
			if(first == null) {
				last = null;
			}
			return value;
		}else {
			throw new NoSuchElementException();
		}
	}
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
     MyQueue<Integer> queue = new MyQueue<Integer>();
     
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);

		System.out.println( "First Values");		
		System.out.println(queue.peek());
		System.out.println();
		System.out.println( "Removendo first");		
		System.out.println(queue.remove());
		System.out.println( "First Values");		
		System.out.println(queue.peek());
		queue.add(400);
		System.out.println( "Values");		
		while(!queue.isEmpty()) {
			System.out.println(queue.remove());
		}
     
     
	}




}
