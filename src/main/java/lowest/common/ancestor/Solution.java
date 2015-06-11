package lowest.common.ancestor;

import tree.common.TreeNode;

public class Solution {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        
		if(root == null || root.val == A.val || root.val == B.val) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor(root.left, A, B);
		TreeNode right = lowestCommonAncestor(root.right, A, B);
		
		if(left != null && right != null) {
			return root;
		}
		if(left != null && right == null) {
			return left;
		}
		if(left == null && right != null) {
			return right;
		}
		return null;
    }
}
