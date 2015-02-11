package flatten.binary.tree.to.linked.list;

import tree.common.TreeNode;

//http://rleetcode.blogspot.com/2014/02/flatten-binary-tree-to-linked-list-java.html
public class Solution {

//	public void flatten(TreeNode root) {
//		flat(root);
//	}
//	
//	private TreeNode flat(TreeNode root) {
//		if(root == null) {
//			return null;
//		}
//		
//		TreeNode right = flat(root.right);
//		TreeNode left = flat(root.left);
//		
//		root.right = left;
//		root.left = null;
//		TreeNode pointer = root;
//		
//		while(pointer.right != null) {
//			pointer = pointer.right;
//		}
//		pointer.right = right;
//		return root;
//	}
	
	public void flatten(TreeNode root) {
		if(root == null) {
			return;
		}
		
		flatten(root.right);
		flatten(root.left);
		
		TreeNode right = root.right;
		root.right = root.left;
		root.left = null;
		
		TreeNode p = root;
		while(p.right != null) {
			p = p.right;
		}
		p.right = right;
	}
	
	
}
