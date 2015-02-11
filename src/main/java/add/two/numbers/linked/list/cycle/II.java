package linked.list.cycle;

//http://umairsaeed.com/2011/06/23/finding-the-start-of-a-loop-in-a-circular-linked-list/
public class II {

	public ListNode detectCycle(ListNode head) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (head == null || head.next == null) {
			return null;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		ListNode meetpoint = null;
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				meetpoint = fast;// fast catches slow
				break;
			}
		}
		
		if(meetpoint == null) {
			return null;
		}
		
		fast = head;
		while(fast.next != null) {
			if(fast == slow) {
				return fast;
			}
			fast = fast.next;
			slow = slow.next;
		}
		
		return null;
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
