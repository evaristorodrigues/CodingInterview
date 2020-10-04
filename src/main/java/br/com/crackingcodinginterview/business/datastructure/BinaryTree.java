/**
 * 
 */
package br.com.crackingcodinginterview.business.datastructure;

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

public class BinaryTree<T> {
	public TreeNode<T> root;

	public void inOrderTraversal() {
		inOrderTraversal(this.root);
	}

	private void inOrderTraversal(TreeNode<T> node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.println(node.value);
			inOrderTraversal(node.right);
		}
	}
	public void preOrderTraversal() {
		preOrderTraversal(this.root);
	}

	private void preOrderTraversal(TreeNode<T> node) {
		if(node != null) {
			System.out.println(node.value);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	public void postOrderTraversal() {
		postOrderTraversal(this.root);
	}

	private void postOrderTraversal(TreeNode<T> node) {
		if(node!=null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.value);
		}
	}
		
	public void levelOrderTraversal() {
		Queue<TreeNode<T>> queue = new LinkedList<>();
		queue.add(this.root);
		while(!queue.isEmpty()) {
		  int size = queue.size();
		  while( size -- > 0) {
			  TreeNode<T> node = queue.poll();
			  System.out.println(node.value);
			  if( node.left !=null) {
				  queue.add(node.left);
			  }
			  if( node.right !=null) {
				  queue.add(node.right);
			  }
		  }
		}	
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		      1
//	    2           3
//	null null    4
		
		TreeNode<Integer> root = new TreeNode<>(1);
		TreeNode<Integer> node2 = new TreeNode<>(2);
		TreeNode<Integer> node3 = new TreeNode<>(3);
		root.left = node2;
		root.right = node3;
		TreeNode<Integer> node4 = new TreeNode<>(4);
		node3.left = node4;
        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        bt.root = root;
        
        bt.inOrderTraversal();
        System.out.println();
        bt.preOrderTraversal();
        System.out.println();
        bt.postOrderTraversal();
        System.out.println();
        bt.levelOrderTraversal();	
	}

}
