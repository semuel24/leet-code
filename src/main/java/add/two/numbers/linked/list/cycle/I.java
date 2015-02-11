package linked.list.cycle;

public class I {

	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	        // IMPORTANT: Please reset any member data you declared, as
	        // the same Solution instance will be reused for each test case.
	        
	    	if(head == null || head.next == null) {
	    		return false;
	    	}
	    	
	    	ListNode fast = head;
	    	ListNode slow = head;
	    	
	    	while(fast.next != null && fast.next.next != null) {
	    		fast = fast.next.next;
	    		slow = slow.next;
	    		if(fast == slow) {
	    			return true;//fast catches slow
	    		}
	    	}
	    	
	    	return false;//fast doesn't catch slow
	    }
	}
	
	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
