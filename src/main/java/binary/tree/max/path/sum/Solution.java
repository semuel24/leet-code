package binary.tree.max.path.sum;

import tree.common.TreeNode;

public class Solution {

	public int maxPathSum(TreeNode root) {
		return maxPath(root).maxPath;
	}

	private Result maxPath(TreeNode root) {
		if (root == null) {
			return new Result(0, Integer.MIN_VALUE);
		}

		Result lResult = maxPath(root.left);
		Result rResult = maxPath(root.right);

		int lSinglePath = lResult.singlePath;
		int rSinglePath = rResult.singlePath;

		int singlePath = Math.max(0,
				Math.max(lSinglePath + root.val, rSinglePath + root.val));
		int maxPath = Math.max(Math.max(lResult.maxPath, rResult.maxPath),
				lSinglePath + rSinglePath + root.val);

		Result r = new Result(singlePath, maxPath);
		return r;
	}

	private class Result {
		public int singlePath;
		public int maxPath;

		public Result(int _singlePath, int _maxPath) {
			this.singlePath = _singlePath;
			this.maxPath = _maxPath;
		}
	}

}
