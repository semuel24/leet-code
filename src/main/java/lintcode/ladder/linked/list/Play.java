package lintcode.ladder.linked.list;

import list.common.AList;
import list.common.ListNode;

public class Play {

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode p = head;
		while (p.next != null) {
			if (p.val == p.next.val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}
		return head;
	}

	public static ListNode deleteDuplicatesII(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;

		while (head.next != null && head.next.next != null) {
			if (head.next.val == head.next.next.val) {
				int val = head.next.val;
				while (head.next != null && head.next.val == val) {
					head.next = head.next.next;
				}
			} else {
				head = head.next;
			}
		}
		return dummy.next;
	}

	public ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode pre = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = pre;
			pre = head;
			head = tmp;
		}
		return pre;
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m >= n) {
			return head;
		}
		ListNode preNode = null;
		ListNode postNode = null;
		ListNode mNode = null;
		ListNode nNode = null;

		// dummy node
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;

		// find m-th node
		preNode = head;
		int i = 0;
		for (; preNode.next != null && i < m - 1; i++) {
			preNode = preNode.next;
		}
		if (i < m - 2 || preNode.next == null) {
			return dummy.next;
		}
		mNode = preNode.next;

		// reverse [m, n]
		ListNode pre = null;
		nNode = mNode;
		for (int j = 0; nNode != null && j <= n - m; j++) {
			ListNode tmp = nNode.next;
			nNode.next = pre;
			pre = nNode;
			nNode = tmp;
		}
		postNode = nNode;
		nNode = pre;

		// re-link
		preNode.next = nNode;
		mNode.next = postNode;

		// result
		return dummy.next;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				head.next = l2;
				l2 = l2.next;
				head = head.next;
			} else if (l2 == null) {
				head.next = l1;
				l1 = l1.next;
				head = head.next;
			} else if (l1 != null && l2 != null) {
				if (l1.val <= l2.val) {
					head.next = l1;
					l1 = l1.next;
					head = head.next;
				} else {
					head.next = l2;
					l2 = l2.next;
					head = head.next;
				}
			}
		}
		return dummy.next;
	}

	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}

		ListNode dummyLess = new ListNode(0);
		ListNode dummyLarge = new ListNode(0);
		ListNode p1 = dummyLess;
		ListNode p2 = dummyLarge;

		// partition the list into 2 sections
		while (head != null) {
			if (head.val < x) {
				p1.next = head;
				p1 = p1.next;
			} else {
				p2.next = head;
				p2 = p2.next;
			}
			head = head.next;
		}

		// link lists
		p1.next = dummyLarge.next;
		if (p2 != null) {
			p2.next = null;
		}

		// result
		return dummyLess.next;
	}

	ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0) {
			return null;
		}

		// move fast pointer for n steps
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy;
		int i = 0;
		for (; fast.next != null && i < n; i++) {
			fast = fast.next;
		}

		// check if n to large
		if (i < n) {
			return head;
		}

		// move slow and fast pointers at same paces
		ListNode slow = dummy;
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		// remove
		slow.next = slow.next.next;

		// result
		return dummy.next;
	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (true) {
			if (fast.next != null) {
				fast = fast.next;
				if (fast == slow) {
					return true;
				}
			} else {
				return false;
			}
			if (fast.next != null) {
				fast = fast.next;
				if (fast == slow) {
					return true;
				}
			} else {
				return false;
			}
			slow = slow.next;
		}
	}

	public ListNode detectCycle(ListNode head) {

		// find cycle by meeting at certain node
		ListNode slow = head;
		ListNode fast = head;

		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		// find the entry point of the cycle
		slow = head;
		while (slow != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public RandomListNode copyRandomList(RandomListNode head) {

		if (head == null) {
			return null;
		}
		RandomListNode orig = head;

		// insert copy
		while (head != null) {
			RandomListNode copy = new RandomListNode(head.label);
			RandomListNode tmp = head.next;
			head.next = copy;
			copy.next = tmp;
			head = tmp;
		}

		// copy random pointers
		head = orig;
		while (head != null) {
			if (head.random != null) {
				head.next.random = head.random.next;
			}
			head = head.next.next;
		}

		// split the list into 2
		RandomListNode dummy1 = new RandomListNode(0);
		RandomListNode dummy2 = new RandomListNode(0);
		RandomListNode p1 = dummy1;
		RandomListNode p2 = dummy2;
		head = orig;
		while (head != null) {
			p1.next = head;
			p1 = p1.next;
			p2.next = head.next;
			p2 = p2.next;
			head = head.next.next;
		}

		// result
		return dummy2.next;
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode d = new ListNode(Integer.MIN_VALUE);
		d.next = head;
		head = head.next;
		d.next.next = null;

		while (head != null) {
			ListNode curHead = head;
			head = head.next;
			curHead.next = null;

			ListNode p = d;
			while (p.next != null) {
				if (curHead.val < p.next.val) {
					ListNode tmp = p.next;
					p.next = curHead;
					curHead.next = tmp;
					break;
				} else {
					p = p.next;
				}
			}

			// append to tail
			if (p.next == null) {
				p.next = curHead;
			}
		}

		return d.next;
	}

	public ListNode addLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int subtotal = 0;
			if (l1 != null) {
				subtotal += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				subtotal += l2.val;
				l2 = l2.next;
			}
			subtotal += carry;
			ListNode p = new ListNode(subtotal % 10);
			head.next = p;
			head = head.next;
			carry = subtotal / 10;
		}
		if (carry != 0) {
			ListNode p = new ListNode(carry);
			head.next = p;
			head = head.next;
		}
		return dummy.next;
	}

	public ListNode reverseKGroup(ListNode head, int k) {

	}

	public static void main(String[] args) {
		int _A[] = { 3760, 2881, 7595, 3904, 5069, 4421, 8560, 8879, 8488,
				5040, 5792, 56, 1007, 2270, 3403, 6062 };
		ListNode head = AList.generateAList(_A);
		new Play().reverseBetween(head, 2, 7);
	}
}
