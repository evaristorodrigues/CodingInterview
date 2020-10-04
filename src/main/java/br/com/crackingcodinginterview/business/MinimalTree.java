/**
 * 
 */
package br.com.crackingcodinginterview.business;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author evaristosrodrigues
 *
 */

class TreeNode<T> {
	public TreeNode<T> left;
	public TreeNode<T> right;
	public T value;
	
	public TreeNode(T value) {
		this.value = value;
	}
}

public class MinimalTree {

	/**
	 * @param args
	 */
	
	public TreeNode<Integer> createTreeError(int[] array) {
		if( array == null) {
			return null;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		int count =0;
		TreeNode<Integer> root = new TreeNode<Integer>(array[count++]);
		queue.add(root);
		while(!queue.isEmpty() && count< array.length) {
			TreeNode<Integer> curr = queue.poll();
			curr.left = new TreeNode<Integer>(array[count++]);
			if(count < array.length) {
				curr.right = new TreeNode<Integer>(array[count++]);
			}else {
				break;
			}
			queue.add(curr.left);
			queue.add(curr.right);
		}		
		return root;
	}
	
	public TreeNode<Integer>  createBinaryTree(int[] array){
		
		return createBinaryTree(array, 0, array.length-1);
	}
	
	
	private TreeNode<Integer> createBinaryTree(int[] array, int start, int end) {
		if(start > end) {
			return null;
		}
		int mid  = (end + start) / 2;
		
		TreeNode<Integer> node = new TreeNode<Integer>(array[mid]);
		node.left = createBinaryTree(array, start, mid-1);
		node.right = createBinaryTree(array, mid+1, end);
		
		return node;
	}

	public static void main(String[] args) {
		MinimalTree mt = new MinimalTree();
		
		TreeNode<Integer> root = mt.createBinaryTree(new int[] {1,2,3,4,5,6,7,8,9});
		
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			while( size -- > 0 ) {
				TreeNode<Integer> curr = queue.poll();
				System.out.println(curr.value);
				if(curr.left !=null) {
					queue.add(curr.left);
				}
				if(curr.right !=null) {
					queue.add(curr.right);
				}
			}		
			
		}	

	}

}
