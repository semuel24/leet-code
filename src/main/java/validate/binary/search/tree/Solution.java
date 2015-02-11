package validate.binary.search.tree;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */

import tree.common.TreeNode;

public class Solution {
  
    public boolean isValidBST(TreeNode root) {
    	if(root == null) {
    		return true;
    	}
    	
    	return isValidBST(root.left) && isValidBST(root.right) && v(root);
    }
    
    //root is guaranteed not null
    private boolean v(TreeNode root) {
    	if(        (root.left == null || (root.left.val < root.val)) 
    			&& (root.right == null || (root.val < root.right.val))) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
