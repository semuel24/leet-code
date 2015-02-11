package remove.duplicates.from.sorted.list;

import list.common.AList;
import list.common.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return 1->2->3.
 */
public class I {

	public static void main(String [] args) {
		I i = new I();
		int [] a1 = {1,1,2,3,3};
		ListNode head1 = AList.generateAList(a1);
		i.deleteDuplicates(head1);
		AList.printAList(head1);
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return null;
		} else if(head.next == null) {
			return head;
		}
		
		ListNode pback = head, pfordward = head.next;
		while(pfordward != null) {
			if(pfordward.val == pback.val) {//found duplicate-value nodes, delete the duplicate node
				pfordward = pfordward.next;
				pback.next = pfordward;
			}else {
				pback = pfordward;
				pfordward = pfordward.next;
			}
		}
		
		return head;
	}
}
