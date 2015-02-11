package tree.common;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

	public static TreeNode PlantABinaryTree(int[] A){
		TreeNode t = new TreeNode(1);
		t.left = null;
		t.right = null;
		return t;
	}

	//['1','#','2'] level traversal
	public static TreeNode InitializeTree(String[] _elements) {
		if(!bValidElements(_elements)) {
			throw new RuntimeException("Invalid tree elements input !");
		}
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(Integer.valueOf(_elements[0]));
		q.add(root);
		int i = 1;
		int length = _elements.length;
		while(q.size() != 0) {
			TreeNode _node = q.poll();
			//try to get next element in array for left child
			if(i <= length-1) {
				if(!_elements[i].equalsIgnoreCase("#")) {
					_node.left = new TreeNode(Integer.valueOf(_elements[i]));
					q.add(_node.left);
				} else {
					_node.left = null;
				}
				i++;
			} else {
				break;
			}
			//try to get next element in array for right child
			if(i <= length-1) {
				if(!_elements[i].equalsIgnoreCase("#")) {
					_node.right = new TreeNode(Integer.valueOf(_elements[i]));
					q.add(_node.right);
				} else {
					_node.right = null;
				}
				i++;
			} else {
				break;
			}
		}
		return root;
	}
	
	public static void main(String [] args) {
		String [] el = {"1", "2", "#", "4", "5"};
		TreeNode root = InitializeTree(el);
	}
	
	private static boolean bValidElements(String [] _elements) {
		if(_elements == null || _elements.length == 0) {
			return false;
		}
		for(String _e : _elements) {
			if(_e.equalsIgnoreCase("#")) {
				continue;
			}
			try {
				Integer.valueOf(_e);
				continue;
			}catch(Exception e) {
				return false;
			}
		}
		return true;
	}
}
