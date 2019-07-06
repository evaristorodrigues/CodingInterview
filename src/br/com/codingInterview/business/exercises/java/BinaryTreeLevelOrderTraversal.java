/**
 * 
 */
package br.com.codingInterview.business.exercises.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Evaristo
 *Binary Tree Level Order Traversal
 */
public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
	 */
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
		TreeNode root = null;
		b.levelOrder(root);
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root == null) {
    		return result;
    	}
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		int count = queue.size();
    	    List<Integer> nivel = new ArrayList<Integer>();
    	    for(int i =0; i < count; i++) {
    	    	TreeNode t = queue.poll();
    	    	nivel.add(t.val);
    	    	if(t.left != null) {
    	    		queue.add(t.left);
    	    	}
    	    	if(t.right != null) {
    	    		queue.add(t.right);
    	    	}
    	    }
    	    result.add(nivel);   	
    	}
        return result;
    }

}
