package remove.linked.list.elements;

public class Solution {
	
	public static void main(String [] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		ListNode node7 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = null;
		
		new Solution().removeElements(node1, 6);
	}

	public ListNode removeElements(ListNode head, int val) {
		if(head == null) {
			return null;
		}
		
		//find 1st non-val node
		while(head != null) {
			if(head.val != val) {
				break;
			}
			head = head.next;
		}
		if(head == null) {
			return null;
		}
		
		/**
		 * come to play
		 * 2 major steps:
		 * 		1. p2 finds a non-val node
		 * 		2. p1 catches up with p2 
		 */
		ListNode p1 = head, p2 = head;
		while(p2 != null && p2.next != null) {
			do {
				p2 = p2.next;
			} while(p2 != null && p2.val == val);
			
			if(p2 == null) {
				p1.next = null;
				return head;
			}
			
			p1.next = p2;
			p1 = p1.next;
		}
		return head;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
