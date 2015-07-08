package reorder.list;

import list.common.ListNode;

public class S3 {

	public void reorderList(ListNode head) {  
        if(head == null || head.next == null) {
        	return;
        }
        
        //find mid
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        
        //reverse right-side list
        ListNode right = reverse(midNext);
        
        //merge lst and right
        merge(head, right);
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
	
	private ListNode reverse(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		while(head != null) {
			ListNode tmp = head.next;
			head.next = pre;
			pre = head;
			head = tmp;
		}
		return pre;
	}
	
	private void merge(ListNode l1, ListNode l2) {
		while(l1 != null) {
			ListNode tmp1 = l1.next;
			l1.next = l2;
			l1 = tmp1;
			if(l2 != null) {
				ListNode tmp2 = l2.next;
				l2.next = l1;
				l2 = tmp2;
			}
		}
	}
}
