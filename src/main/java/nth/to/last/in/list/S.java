package nth.to.last.in.list;

import list.common.ListNode;

public class S {

	ListNode nthToLast(ListNode head, int n) {

		// check
		if (head == null || n <= 0) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode slow = head;
		ListNode fast = head;
		
		// fast pointer tries to move n steps
		int i = 0;
		for(; fast.next != null && i < n; i ++) {
			fast = fast.next;
		}
		if(i < n) {
			return null;
		}

		// move slow and fast pointers at same pace
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		//result
		return slow.next;
	}
}
