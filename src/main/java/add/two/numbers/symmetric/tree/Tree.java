package symmetric.tree;

import java.util.ArrayList;
import java.util.List;
import tree.common.TreeNode;

public class Tree {

	public boolean isSymmetric(TreeNode root) {
		
		if(root == null) {
			return true;
		}else if(root.left == null && root.right == null) {
			return true;
		}
		
		List<Integer> l = new ArrayList<Integer>();
		//load list
		inorder(root, l);
		//judge list
		return listSymmetric(l);
	}

	private void inorder(TreeNode _node, List<Integer> _l) {
		if(_node.left != null) {
			inorder(_node.left, _l);
		}
		
		_l.add(_node.val);
		
		if(_node.right != null) {
			inorder(_node.right, _l);
		}
	}
	
	private boolean listSymmetric(List<Integer> _l) {
		if(_l == null) {
			return true;
		} else if(_l.size() == 1) {
			return true;
		}
		
		int head = 0;
		int tail = _l.size()-1;
		while(head<tail) {
			if(_l.get(head) != _l.get(tail)) {
				return false;
			}
			head ++;
			tail --;
		}
		return true;
	}

}
