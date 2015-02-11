package binary.tree.preorder.traversal;

import java.util.ArrayList;
import java.util.Stack;

import tree.common.Tree;
import tree.common.TreeNode;

public class Solution {
	
	public static void main(String [] args) {
		Solution s = new Solution();
		TreeNode t = Tree.PlantABinaryTree(null);
		s.preorderTraversal(t);
	}
	
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if(root == null) {
			return al;
		}
		
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		TreeNode tmp = null;
		while(!st.isEmpty()) {
			tmp = st.pop();
			al.add(tmp.val);
			//insert right child
			if(tmp.right != null) {
				st.push(tmp.right);
			}
			//insert left child 
			if(tmp.left != null) {
				st.push(tmp.left);
			}
		}
		
		return al;
    }
	
}
