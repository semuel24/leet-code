package validate.binary.search.tree;

public class Solution2 {

	public boolean isValidBST(TreeNode root) {
		return isValid(root).isValid;
	}
	
	private Result isValid(TreeNode root) {
		if(root == null) {
			Result r = new Result(true);
			r.isEmpty = true;
			return r;
		}
		
		Result rleft = isValid(root.left);
		if(!rleft.isValid) {
			return rleft;
		}
		
		Result rright = isValid(root.right);
		if(!rright.isValid) {
			return rright;
		}
		
		if((!rright.isEmpty && root.val >= rright.min) 
				|| (!rleft.isEmpty && root.val <= rleft.max)) {
			return new Result(false);
		}
		Result r = new Result(true);
		r.min = rleft.isEmpty ? root.val : rleft.min;
		r.max = rright.isEmpty ? root.val : rright.max;
		return r;
	}

	private class Result {
		public int min;
		public int max;
		public boolean isValid;
		public boolean isEmpty;
		
		public Result(boolean _isValid) {
			this.isValid = _isValid;
			this.isEmpty = false;
		}
	}

	private class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}
}
