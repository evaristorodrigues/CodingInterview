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
 *107. Binary Tree Level Order Traversal II
 */
public class BinaryTreeLevelOrderTraversalII {

	/**
	 * @param args
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
	 */
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalII b = new BinaryTreeLevelOrderTraversalII();
	}
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> result= new ArrayList<List<Integer>>();
        if(root == null) {
        	return result;
        }
        Queue<TreeNode> queue   = new LinkedList<TreeNode>(); 
        queue.add(root);
        
        while(!queue.isEmpty()) {
        	int count = queue.size();
        	List<Integer> level = new ArrayList<Integer>();
        	for( int i =0; i <count; i++) {
        		TreeNode t = queue.poll();
        		level.add(t.val);
        		if(t.left !=null) {
        			queue.add(t.left);
        		}
        		if(t.right!=null) {
        			queue.add(t.right);
        		}
        	}
        	result.add(0,level);
        }
        
        return result;
    }
    
    //FIXME do recursively dfs

}
