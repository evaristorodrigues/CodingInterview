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
 *103. Binary Tree Zigzag Level Order Traversal
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * @param args
	 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
	 */
	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal b = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = null;
		System.out.println(b.zigzagLevelOrder(root));
	}
	
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
    	List<List<Integer>> result= new ArrayList<List<Integer>>();
    	if(root == null) {
    		return result;
    	}
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	boolean isRight = false;
    	while(!queue.isEmpty()) {
    		int count = queue.size();    		
    	    List<Integer> nivel = new ArrayList<>();
    	    for(int i =0; i < count; i++) {
    	    	TreeNode t = queue.poll();
    	    	if(isRight) {
    	    		nivel.add(0, t.val);
    	    	}else {
    	    		nivel.add(t.val);
    	    	}    	    	
    	    	if(t.left!=null) {
    	    		queue.add(t.left);
    	    	}
    	    	if(t.right!=null) {
    	    		queue.add(t.right);
    	    	}       	    	
    	    }
    	    isRight= !isRight;
    	    result.add(nivel);   	    
    	}    	
    	return result;
    }
   public List<List<Integer>> zigzagLevelOrder(TreeNode root){
	     List<List<Integer>> result = new ArrayList<List<Integer>>();
         return helperZigzagLevelOrder(root, result, 0);
   }

private List<List<Integer>> helperZigzagLevelOrder(TreeNode root, List<List<Integer>> result, int level) {
	if(root == null) {
		return result;
	}
	if((result.size() -1) < level) {
		result.add(new ArrayList<Integer>());
	}
	if(level%2==0) {
		result.get(level).add(root.val);
	}else {
		result.get(level).add(0,root.val);		
	}	
	helperZigzagLevelOrder(root.left, result,level+1);
	helperZigzagLevelOrder(root.right, result,level+1);
	return result;
}

}
