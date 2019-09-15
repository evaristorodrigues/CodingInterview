package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTTraverseInOrder {

	public static void main(String[] args) {
		BSTTraverseInOrder bst = new BSTTraverseInOrder();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left= new TreeNode(6);		
        bst.preorderTraversal(root);
	}

	 public List<Integer> inorderTraversal(TreeNode root) {  
		 List<Integer> list = new ArrayList<>();
		 Stack<TreeNode> stack = new Stack<>();
		 TreeNode curr = root;
		
		 while(!stack.isEmpty() || curr != null) {
			 
			while(curr!= null ) {
				stack.push(curr);
				
				curr = curr.left;
			}
			curr = stack.pop();
			list.add(curr.val);	
			curr = curr.right;			 
			 
		 }
		 
		 return list;
	 }
	 
	 public List<Integer> preorderTraversal(TreeNode root) {  
		 List<Integer> list = new ArrayList<>();
		 Stack<TreeNode> stack = new Stack<>();
		 TreeNode curr = root;
		
		 while(!stack.isEmpty() || curr != null) {
			 
			while(curr!= null ) {
				stack.push(curr);
				list.add(curr.val);
				curr = curr.left;
			}
			curr = stack.pop();
			curr = curr.right;			 
			 
		 }
		 
		 return list; 
	 }
}
