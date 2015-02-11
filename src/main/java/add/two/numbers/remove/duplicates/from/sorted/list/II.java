package remove.duplicates.from.sorted.list;

import java.util.HashSet;

import list.common.AList;
import list.common.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3,
 * return 2->3.
 */
public class II {
	public static void main(String [] args) {
		II ii = new II();
		int [] a1 = {1,2,3,3,4,4,5};
		ListNode head1 = AList.generateAList(a1);
		head1 = ii.deleteDuplicates(head1);
		AList.printAList(head1);
		
		int [] a2 = {1,1,1,2,3};
		ListNode head2 = AList.generateAList(a2);
		head2 = ii.deleteDuplicates(head2);
		AList.printAList(head2);
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return null;
		} else if(head.next == null) {
			return head;
		}
		
		//pre-process
		HashSet<Integer> duplicates = fristRunDeleteDuplicates(head);
		
		//guarantee first node is not in duplicate set
		while(duplicates.contains(head.val)) {
			head = head.next;
			if(head == null) {
				return null;//all nodes are in duplicate set
			}
		}
		
		//some nodes are not in duplicate set
		ListNode p1 = head.next;
		ListNode p2 = head;
		while(p1 != null){
			if(!duplicates.contains(p1.val)) {
				p2 = p1;
				p1 = p1.next;
			} else {
				p1 = p1.next;
				p2.next = p1;
			}
		}
		
		return head;
	}
	
	/**
	 * pre-process the list, which is borrowed from I
	 */
	private HashSet<Integer> fristRunDeleteDuplicates(ListNode head) {
		HashSet<Integer> duplicates = new HashSet<Integer>();
		ListNode pback = head, pfordward = head.next;
		while(pfordward != null) {
			if(pfordward.val == pback.val) {//found duplicate-value nodes, delete the duplicate node
				if(!duplicates.contains(pback.val)) {
					duplicates.add(pback.val);//add to duplicate set
				}
				pfordward = pfordward.next;
				pback.next = pfordward;
			}else {
				pback = pfordward;
				pfordward = pfordward.next;
			}
		}
		return duplicates;
	}
}
