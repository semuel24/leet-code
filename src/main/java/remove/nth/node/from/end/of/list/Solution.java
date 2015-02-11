package remove.nth.node.from.end.of.list;

import list.common.AList;
import list.common.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one pass.
 * 
 * @author yaoxu
 * 
 */
public class Solution {
	
	public static void main(String [] args) {
		
		Solution s = new Solution();
		int [] a = {1,2};
		AList.printAList(s.removeNthFromEnd(AList.generateAList(a), 2));
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n == 0) {
			return null;
		}
		
		ListNode fast = head, slow = head;
		int diff = n;
		
		//move fast pointer
		while(fast!= null && diff>0) {
			fast = fast.next;
			diff--;
		}
		
		if(diff > 0) {//does not have enough nodes in list
			return null;
		} else if(fast == null) {//fast reaches null
			return head.next;
		}
		
		//move fast and slow pointers in same pace
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		if(slow.equals(head)) {//remove header
			if(head.next == null) {
				return null;
			} 
		}
		
		//remove node pointed by slow
		if(n==1) {
			slow.next = null;
		} else {
			slow.next = slow.next.next;
		}
		 
		return head;
	}
}
