package maxmum.depth.binary.tree;

import java.util.ArrayList;
import java.util.List;

import tree.common.TreeNode;

public class Tree {

	int maxH = 0;
	public int maxDepth(TreeNode root) {
//		return recursive(root);
		
//		if(root == null) {
//			return 0;
//		}
//		int h = 1;
//		dfs(root, h);
//		return maxH;
		
		return bylevel(root);
    }
	
	
	private void dfs(TreeNode root, int h) {
		
		if(h > maxH) {
			maxH = h;
		}
		
		if(root.left != null) {
			dfs(root.left, h+1);
		}
		
		if(root.right != null) {
			dfs(root.right, h+1);
		}
	}
	
	
	private int recursive(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(recursive(root.left), recursive(root.right));
	}
	
	private int bylevel(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		//initialize level
		List<TreeNode> currentlevel = new ArrayList<TreeNode>();
		currentlevel.add(root);
		
		int height = 0;
		while(currentlevel.size() != 0) {
			height ++;
			List<TreeNode> nextlevel = new ArrayList<TreeNode>();
			for(TreeNode _t : currentlevel) {
				if(_t.left != null) {
					nextlevel.add(_t.left);
				}
				if(_t.right != null) {
					nextlevel.add(_t.right);
				}
			}
			currentlevel = nextlevel;
		}
		return height;
	}
	
}


