package br.com.codingInterview.business.exercises.java;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.DelayQueue;

public class MaximumDepthOfBinaryTree {
	
	/**
	 * 
	 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
	 */

	public static void main(String[] args) {
		MaximumDepthOfBinaryTree m = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(8);
        root.left.left.left = new TreeNode(2);
        
        root.right  = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        root.right.right.left.left = new TreeNode(4);
        
		System.out.println(m.maxDepth5(root));
	}
	
    public int maxDepth(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
       List<Integer> depth= new ArrayList<Integer>();
       depth.add(0);
        Integer count=0;        
    	
    	helperMaxDepth(root,count,depth);
    	return depth.get(0);
    }

	private int helperMaxDepth(TreeNode root, Integer count, List<Integer> depth) {
		count++;
		if(root.left != null) {
			helperMaxDepth(root.left, count,depth);
		}		
		if(root.right != null) {
			helperMaxDepth(root.right, count,depth);
		}
		if(root.left == null && root.right == null && count > depth.get(0)) {
			depth.set(0, count);
		}
		return count;
	}
	
    public int maxDepth2(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	return 1+Math.max(maxDepth2(root.left), maxDepth2(root.right));

    }
    
    public int maxDepth3(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	
        int maxDepth =1;
        
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        
        nodes.add(root);
        depth.add(1);
        
        while(!nodes.isEmpty()) {
        	TreeNode node = nodes.pop();
        	int maxNodeDeph = depth.pop();
        	if(node.left ==null && node.right == null) {
        		maxDepth = Math.max(maxDepth, maxNodeDeph);
        	}        	
        	if(node.left != null) {
        		nodes.add(node.left);
        		depth.add(maxNodeDeph+1);
        	} 
        	if(node.right != null) {
        		nodes.add(node.right);
        		depth.add(maxNodeDeph+1);
        	} 
        }
       return maxDepth;
    }
    
    public int maxDepth4(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	Queue<TreeNode> queue = new ArrayDeque<>();
    	queue.add(root);
    	int count = 1;
    	while(!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		
    		if(node.left!= null) {
    			queue.add(node.left);
    		}
    		
    		if(node.right !=null) {
    			queue.add(node.right);
    		}
    		count++;
    		
    	}
    	
    	return count;

    }
    
    public int maxDepth5(TreeNode root)
    {
        Queue<TreeNode> q = new ArrayDeque<>();
        int depth = 0;
        
        if(root != null)
            q.add(root);
        
        while(!q.isEmpty())
        {
            depth++;
            
            for(int count = q.size(); count > 0; count--)
            {
                TreeNode current = q.poll();
                
                if(current.left != null)
                    q.add(current.left);
                if(current.right != null)
                    q.add(current.right);
            }
        }
        return depth;
    }
    
    
	
	}
