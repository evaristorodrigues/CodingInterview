/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.lang.reflect.Array;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * @author evaristosrodrigues
 *
 */
public class ThreeinOne<T> {
	int numberOfStacks =3;
	int stackLength;
	T[] array;
	int[] size;
	
	public ThreeinOne(Class<T> instance,int length) {
		this.stackLength = length;
		this.array = (T[]) Array.newInstance(instance,numberOfStacks* length);
		size = new int[numberOfStacks];
	}
	
	public boolean isEmpty(int stack) {
		if(stack > size.length - 1) {
			throw new NoSuchElementException();
		}
		return size[stack] == 0;
	}
	
	public T peek(int stack) {
		if(stack > size.length - 1) {
			throw new NoSuchElementException();
		}
		if(size[stack] == 0) {
			throw new EmptyStackException();
		}
		
		T value = array[stack * numberOfStacks + size[stack]];
		
		return value;
	}
	
	public T pop(int stack) {
		if( stack > size.length - 1) {
			throw new NoSuchElementException();
		}
		if(size[stack] == 0) {
			throw new EmptyStackException();
		}
		T value = array[stack * numberOfStacks + size[stack]];
		array[stack * numberOfStacks + size[stack]] = null;
		size[stack]--;
		return value;
		
	}
    
	public void push(int stack, T value) {
		if( stack > size.length - 1) {
			throw new NoSuchElementException();
		}
		if(size[stack] >= stackLength) {
			throw new StackOverflowError();
		}
		size[stack]++;
		array[stack*numberOfStacks+size[stack]]= value;
	}
	
	
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreeinOne<Integer> stacks = new ThreeinOne<Integer>(Integer.class, 3);
		
		for(int i =0; i < 3; i++) {
			int aux = (i*10);
			stacks.push(i,1 + aux );
			stacks.push(i,2 + aux);
			stacks.push(i,3 + aux);

			System.out.println( "Last Values");		
			System.out.println(stacks.peek(i));
			System.out.println();
			System.out.println( "Removendo last");		
			System.out.println(stacks.pop(i));
			System.out.println( "Last Values");		
			System.out.println(stacks.peek(i));
			stacks.push(i,4+aux);
			System.out.println( "Values");		
			while(!stacks.isEmpty(i)) {
				System.out.println(stacks.pop(i));
			}
		}	


	}

}
