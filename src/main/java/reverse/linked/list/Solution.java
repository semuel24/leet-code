package reverse.linked.list;

import list.common.AList;
import list.common.ListNode;

public class Solution {

	public static void main(String [] args) {
		int[] A1 = {1,2,3,4};
		ListNode head1 = AList.generateAList(A1);
		AList.printAList(head1);
		head1 = new Solution().reverseList(head1);
		AList.printAList(head1);
		
		int[] A2 = {1};
		ListNode head2 = AList.generateAList(A2);
		AList.printAList(head2);
		head2 = new Solution().reverseList(head2);
		AList.printAList(head2);
	}
	
	public ListNode reverseList(ListNode head) {
        if(head == null) {//empty list
        	return null;
        }
        if(head.next == null) {//only one node in the listf
        	return head;
        }
        //list has at least 2 nodes
        ListNode p1 = head;
        ListNode p2 = head.next;
        p1.next = null;
        while(p2 != null) {
        	ListNode p3 = p2.next;
        	p2.next = p1;
        	p1 = p2;
        	p2 = p3;
        }
        return p1;
    }
}
