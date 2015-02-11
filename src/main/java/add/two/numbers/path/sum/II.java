package path.sum;

import java.util.ArrayList;

import tree.common.Tree;
import tree.common.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 * @author yaoxu
 *
 */
public class II {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
		ArrayList<TreeNode> a = new ArrayList<TreeNode>();
		path(root, sum, 0, a, answer);
		return answer;
	}
	
	
	private void path(
			final TreeNode _node, 
			final int _sum, 
			final int _weight, 
			final ArrayList<TreeNode> _path, 
			final ArrayList<ArrayList<Integer>> _answer) {
		
		if(_node == null) {
			return;
		}
		
		if(_node.left == null && _node.right == null) {//a leaf
			if(_node.val + _weight == _sum) {
				_path.add(_node);
				ArrayList<Integer> _tmp = copy(_path);
				_path.remove(_node);
				_answer.add(_tmp);
			}
		} else if(_node.left != null && _node.right == null){//only has left child
			_path.add(_node);
			path(_node.left, _sum, _weight+_node.val, _path, _answer);
			_path.remove(_node);
		} else if(_node.left == null && _node.right != null) {//only has right child
			_path.add(_node);
			path(_node.right, _sum, _weight+_node.val, _path, _answer);
			_path.remove(_node);
		} else {//has both children
			_path.add(_node);
			path(_node.left, _sum, _weight+_node.val, _path, _answer);
			path(_node.right, _sum, _weight+_node.val, _path, _answer);
			_path.remove(_node);
		}
	}
	
	private ArrayList<Integer> copy(ArrayList<TreeNode> _path) {
		ArrayList<Integer> _r = new ArrayList<Integer>();
		for(TreeNode _node : _path) {
			_r.add(_node.val);
		}
		
		return _r; 
	}
	
	public static void main(String [] args) {
		
		String [] input = {"0","1","1"};
		TreeNode root = Tree.InitializeTree(input);
		II s = new II();
		s.pathSum(root, 1);
	}
}














