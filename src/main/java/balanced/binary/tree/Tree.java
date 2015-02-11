package balanced.binary.tree;

public class Tree {

	public class Solution {
	    public boolean isBalanced(TreeNode root) {
	    	if(root == null) {//reach a leaf
	    		return true;
	    	}
	    	return isBalanced(root.left) && isBalanced(root.right) && Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
	    }
	    
//	    private int minDepth(TreeNode root) {
//	    	if(root == null) {
//	    		return 0;
//	    	}
//	    	return 1 + Math.min(minDepth(root.left), minDepth(root.right));
//	    }
	    
	    private int maxDepth(TreeNode root) {
	    	if(root == null) {
	    		return 0;
	    	}
	    	
	    	return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	    }
	}
	
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
