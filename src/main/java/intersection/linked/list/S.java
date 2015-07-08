package intersection.linked.list;

import list.common.ListNode;

public class S {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null ) {
			return null;
		}
		
		if( headA == headB ) {
		    return headA;
		}
		
		//link headB and tail
		ListNode head = headB;
		while(head.next != null) {
			head = head.next;
		}
		head.next = headB;
		
		//find intersection
		ListNode interNode = detectCycle(headA);
		
		//recover
		head.next = null;
		
		//result
		return interNode;
	}

	private ListNode detectCycle(ListNode head) {

		if (head == null || head.next == null) {
			return null;
		}

		// find cycle by meeting at certain node
		ListNode slow = head;
		ListNode fast = head.next;

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
}
