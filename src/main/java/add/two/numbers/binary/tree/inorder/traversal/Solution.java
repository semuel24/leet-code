package binary.tree.inorder.traversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import tree.common.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	
	/**
	 * 1. get a node from stack
	 * 2a. if the node N is a leaf, print it, continue to step 1
	 * 2b. if N is not a leaf, check if N has been visited 
	 *     3a. if not visited, try to get its left child
	 *        4a. if N's left child exists, mark N as visited, and push N and its left child, then continue to step 1
	 *        4b. if N's left child does not exist, print N and push N's right if any, continue to step 1
	 *     3b. if visited, print N, push N's right child to stack if any
	 */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Set<TreeNode> tracker = new HashSet<TreeNode>(); 
    	if(root == null) {
    		return list;
    	}
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	
    	while( !stack.isEmpty() ) {
    		TreeNode top = stack.pop();
    		if(isLeaf(top)) {//leaf
    			list.add(top.val);
    			continue;
    		} else {//not leaf
    			if(tracker.contains(top)) {//visited
    				list.add(top.val);
    				if(top.right != null) {
    					stack.push(top.right);
    				}
    			} else {//first visit
    				//try to get left child
    				if(top.left != null) {//has left child
    					tracker.add(top);
    					stack.push(top);
    					stack.push(top.left);
    				} else {//no left child
    					list.add(top.val);
    					if(top.right != null) {
    						stack.push(top.right);
    					}
    				}
    			}
    		}
    	}
        return list;
    }
    
    private boolean isLeaf(TreeNode _node) {
    	if(_node == null) {
    		return false;
    	} 
    	
    	if(_node.left == null && _node.right == null) {
    		return true;
    	}
    	
    	return false;
    }
}