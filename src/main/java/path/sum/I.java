package path.sum;

import tree.common.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author yaoxu
 *
 */
public class I {

	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
        return dfs(root, sum, 0);
    }
	
	private boolean dfs(TreeNode root, int sum, int weight) {
		if(root.left == null && root.right == null) {//a leaf
			return weight + root.val == sum;
		} else if(root.left != null && root.right == null){//only left child
			return dfs(root.left, sum, weight+root.val);
		} else if(root.left == null && root.right != null) {//only right child
			return dfs(root.right, sum, weight+root.val);
		} else {//both children
			return dfs(root.left, sum, weight+root.val) || dfs(root.right, sum, weight+root.val); 
		}
	}
}
