/**
 * 
 */
package br.com.codingInterview.business.leetcode.exercises.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evaristo
 *
 */
public class ValidateBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidateBinarySearchTree a = new ValidateBinarySearchTree();
		// [2,1,3];
		TreeNode verdadeiro = new TreeNode(2);
		verdadeiro.left = new TreeNode(1);
		verdadeiro.right = new TreeNode(3);

		// [5,1,4,null,null,3,6]
		TreeNode falso = new TreeNode(5);
		falso.left = new TreeNode(1);
		falso.right = new TreeNode(4);
		falso.right.left = new TreeNode(3);
		falso.right.right = new TreeNode(6);

		// [10,5,15,null,null,6,20]

		TreeNode falso2 = new TreeNode(10);
		falso2.left = new TreeNode(5);
		falso2.right = new TreeNode(15);
		falso2.right.left = new TreeNode(6);
		falso2.right.right = new TreeNode(20);

		System.out.println("Esperamos verdadeiro = " + a.isValidBST(verdadeiro));

		System.out.println("Esperamos falso =" + a.isValidBST(falso));

		System.out.println("Esperamos falso2 =" + a.isValidBST(falso2));

	}

	/*
	 * Integer last_value=null; public boolean isValidBST(TreeNode root) {
	 * if(root==null){ return true; } if(!isValidBST(root.left)){ return false; }
	 * 
	 * if(last_value==null){ last_value = root.val; } else{
	 * if(last_value>=root.val){ return false; } last_value = root.val; }
	 * 
	 * if(!isValidBST(root.right)){ return false; } return true; }
	 */

	

	public boolean isValidBST(TreeNode root) {

		return validate(root, null, null);
	}

	private boolean validate(TreeNode root, Integer minValue, Integer maxValue) {

		if (root == null) {
		  return true;
		}
		
		if(minValue != null && root.val <= minValue) {
		  return false;
		}
		
		if(maxValue != null && root.val >= maxValue) {
		  return false;
		}

		return validate(root.left, minValue, root.val) && validate(root.right, root.val, maxValue);
	}
	
    public List<Integer> inorderTraversal(TreeNode root) {        

        List<Integer> list = new ArrayList<Integer>();
        
        traverse(root,list);
        
        return list;
    }
    
    public void traverse(TreeNode root, List<Integer> list){        
        
        if(root.left != null){
            inorderTraversal(root.left);
        }
        
        list.add(root.val);
        
        if(root.right != null){
            inorderTraversal(root.right);            
        }
    }

}
