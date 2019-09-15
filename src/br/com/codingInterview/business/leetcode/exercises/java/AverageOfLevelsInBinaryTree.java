/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Evaristo
 *637. Average of Levels in Binary Tree
 */
public class AverageOfLevelsInBinaryTree {

	/**
	 * @param args
	 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
Accepted
	 */
	public static void main(String[] args) {
		AverageOfLevelsInBinaryTree a = new AverageOfLevelsInBinaryTree();
		TreeNode root = null;
		a.averageOfLevels(root );

	}

	
    public List<Double> averageOfLevels2(TreeNode root) {
    	List<Double> result= new ArrayList<Double>();
        if(root == null) {
        	return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	while(!queue.isEmpty()) {
    		int count= queue.size();
    		double values =0;    		
    		for(int i =0; i < count; i ++) {
    			TreeNode t = queue.poll();
    			values+=t.val;
    			if(t.left!= null) {
    				queue.add(t.left);
    			}
    			if(t.right!=null) {
    				queue.add(t.right);
    			}    			
    		}
    		result.add((values/count));
    	}
    	return result;
    }
    
    public List<Double> averageOfLevels(TreeNode root) {
    	List<Double> result = new ArrayList<Double>();
    	List<Integer> sizes = new ArrayList<Integer>();
        helperAverageOfLevels(root,result,sizes,0 );
        for(int i =0; i < result.size(); i++) {
        	result.set(i, result.get(i)/sizes.get(i));
        }
        return result;
    }


	private  void helperAverageOfLevels(TreeNode root, List<Double> result,List<Integer> sizes,int level) {
		if(root == null) {
			return ;
		}
		if((result.size() -1) < level) {
			result.add(0d);
			sizes.add(0);
		}
		result.set(level, result.get(level)+root.val);
		sizes.set(level, sizes.get(level)+1);
		helperAverageOfLevels(root.left, result,sizes, level + 1);
		helperAverageOfLevels(root.right, result, sizes,level + 1);
	}
}
