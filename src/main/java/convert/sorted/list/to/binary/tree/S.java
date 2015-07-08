package convert.sorted.list.to.binary.tree;

import list.common.ListNode;

/**
 * Definition for ListNode. public class ListNode { int val; ListNode next;
 * ListNode(int val) { this.val = val; this.next = null; } } Definition of
 * TreeNode: public class TreeNode { public int val; public TreeNode left,
 * right; public TreeNode(int val) { this.val = val; this.left = this.right =
 * null; } }
 */

public class S {
	public class TreeNode {
		public int val;
		public TreeNode left, right;

		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		return sortedListToBST(head, null);
	}

	// [head, end)
	private TreeNode sortedListToBST(ListNode start, ListNode end) {
		if (start == null || start == end) {
			return null;
		}
		if (start.next == end) {
			return new TreeNode(start.val);
		}

		//guarantee >= 2 nodes
		ListNode mid = findMid(start, end);
		TreeNode left = sortedListToBST(start, mid);
		TreeNode right = sortedListToBST(mid.next, end);
		TreeNode root = new TreeNode(mid.val);
		root.left = left;
		root.right = right;
		return root;
	}

	// [head, end)
	private ListNode findMid(ListNode start, ListNode end) {
		// check edge cases
		if (start == null) {
			throw new RuntimeException("start == null when finding mid");
		}
		if (start == end) {
			throw new RuntimeException("start == end when finding mid");
		}
		if (start.next == end) {
			return start;
		}

		// slow and fast pointers
		ListNode slow = start;
		ListNode fast = start.next;
		while (fast != end) {
			slow = slow.next;
			fast = fast.next;
			if (fast != end) {
				fast = fast.next;
			}
		}
		return slow;
	}
}
