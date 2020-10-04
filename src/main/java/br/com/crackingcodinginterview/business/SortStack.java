/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.Stack;

/**
 * @author evaristosrodrigues
 *
 */
public class SortStack{

	/**
	 * @param args
	 */
	public Stack<Integer> sort(Stack<Integer> stack) {
		if (stack == null || stack.isEmpty() || stack.size() < 2) {
			return stack;
		}
		Stack<Integer> stackTemp = new Stack<Integer>();
		int elements = stack.size();
		int countOrdered = 0;
		int count = 0;

		while (countOrdered < elements) { 
			Integer pivot = stack.pop();
			while (!stack.isEmpty()) { 
				Integer temp = stack.pop();
				if (pivot > temp) {
					fillBack(stack, stackTemp, count);
					stack.push(pivot);
					count =0;
					pivot =temp;
				} else {
					stackTemp.push(temp);
					count++;
				}
			}
			fillBack(stack, stackTemp, count);
			stackTemp.push(pivot);
			countOrdered ++;
            count=0;
		}

		fillBack(stack, stackTemp, countOrdered);

		return stack;
	}
	
	public Stack<Integer> sortBasedOnBook(Stack<Integer> stack) {
		Stack<Integer> stackTemp = new Stack<Integer>();
        while(!stack.isEmpty()) {
        	int temp = stack.pop();
        	while(!stackTemp.isEmpty() && stackTemp.peek() > temp) {
        		stack.push(stackTemp.pop());
        	}
        	stackTemp.push(temp);
        }
        fillBack(stack, stackTemp, stackTemp.size());        
        return stack;
	}

	
	
	private void fillBack( Stack<Integer> stack, Stack<Integer> temp, int count) {
		while( count -- > 0) {
			stack.push(temp.pop());
		}
	}
	
	public static void main(String[] args) {
		SortStack sort = new SortStack();
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(7);
		stack.push(2);
		stack.push(3);
		stack.push(1);
		stack.push(5);
		stack.push(5);
		stack.push(6);
		stack.push(4);
		
		System.out.println(sort.sort(stack));
		
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		Stack<Integer> stack2 = new Stack<Integer>();
		
		stack2.push(7);
		stack2.push(2);
		stack2.push(3);
		stack2.push(1);
		stack2.push(5);
		stack2.push(5);
		stack2.push(6);
		stack2.push(4);
     
		System.out.println(sort.sortBasedOnBook(stack2));

		while(!stack2.isEmpty()) {
			System.out.println(stack2.pop());
		}
	}

}
