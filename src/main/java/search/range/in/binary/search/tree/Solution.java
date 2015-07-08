package search.range.in.binary.search.tree;

import java.util.ArrayList;
import tree.common.TreeNode;

public class Solution {

	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
     
		if(root == null) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(k1 <= root.val) {//search left sub-tree
			list.addAll(searchRange(root.left, k1, k2));
		}
		if(k2 >= root.val) {//search right sub-tree
			list.addAll(searchRange(root.right, k1, k2));
		}
		return list;
    }
	
}
