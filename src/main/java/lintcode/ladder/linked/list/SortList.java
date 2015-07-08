package lintcode.ladder.linked.list;

import list.common.ListNode;

public class SortList {

	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		//divide
		ListNode mid = findMid(head);
		ListNode midNext = mid.next;
		mid.next = null;
		//conquer
		ListNode left = sortList(head);
		ListNode right = sortList(midNext);
		//merge
		head = merge(left, right);
		return head;
	}
	

	private ListNode findMid(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			if(fast != null) {
				fast = fast.next;
			} else {
				break;
			}
		}
		return slow;
	}
	
	private ListNode merge(ListNode l1, ListNode l2) {
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
	
	public static void main(String [] args) {
	
		
	}
}
