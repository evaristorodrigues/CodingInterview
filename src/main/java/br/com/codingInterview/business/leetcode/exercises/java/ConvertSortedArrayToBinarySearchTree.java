/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

/**
 * @author Evaristo
 * 108. Convert Sorted Array to Binary Search Tree
 *
 */
public class ConvertSortedArrayToBinarySearchTree {

	/**
	 * @param args
	 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
	 */
	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree c = new ConvertSortedArrayToBinarySearchTree();
		int[] nums ={-10,-3,0,1,2};
		traverseBST(c.sortedArrayToBST(nums));
		

	}
	
    private static void traverseBST(TreeNode node) {
		System.out.println(node.val);
		if(node.left!=null) {
			traverseBST(node.left);
		}
		
		if(node.right!=null) {
			traverseBST(node.right);
		}
		
	}

	public TreeNode sortedArrayToBST2(int[] nums) {
    	if(nums.length ==0) {
    		return null;
    	}
    	
        return helperArrayToBST2(nums,0, nums.length-1);
    }
   //[7,8]
	private TreeNode helperArrayToBST2(int[] nums, int begin, int end) {
		
		if((end - begin) < 0) {
			return null;
		}
		if((end - begin == 1)) {
			TreeNode node = new TreeNode(nums[begin]);
			node.right= new TreeNode(nums[end]);
			return node;
		}
		int mid = begin+ (int)Math.floor((end-begin)/2);
		TreeNode node = new TreeNode(nums[mid]);
		
		node.left =	helperArrayToBST2(nums,begin,mid-1);
		node.right = helperArrayToBST2(nums,mid+1,end);
		
		return node;
	}

	public TreeNode sortedArrayToBST3(int[] nums) {
    	if(nums ==null || nums.length ==0) {
    		return null;
    	}
    	
        return helperArrayToBST(nums,0, nums.length-1);
    }
   //[7,8]
	private TreeNode helperArrayToBST3(int[] nums, int begin, int end) {
		
    	int mid = (end+begin)/2;
		TreeNode node = new TreeNode(nums[mid]);
		if(begin < mid) {
			node.left =	helperArrayToBST3(nums,begin,mid-1);			
		}
		if(mid < end) {
		    node.right = helperArrayToBST3(nums,mid+1,end);
		}
		
		return node;
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
    	if(nums ==null || nums.length ==0) {
    		return null;
    	}
    	
        return helperArrayToBST(nums,0, nums.length-1);
    }
   //[7,8]
	private TreeNode helperArrayToBST(int[] nums, int begin, int end) {
		if(begin > end) {
			return null;
		}
    	int mid = begin+ (end-begin)/2;
		TreeNode node = new TreeNode(nums[mid]);
			node.left =	helperArrayToBST(nums,begin,mid-1);			
		    node.right = helperArrayToBST(nums,mid+1,end);
		
		return node;
	}
}
