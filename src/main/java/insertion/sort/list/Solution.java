package insertion.sort.list;

import list.common.AList;
import list.common.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {

	public static void main(String [] args) {
		int[] A = {1,2,3,0};
		ListNode head = AList.generateAList(A);
		AList.printAList(head);
		Solution s = new Solution();
		head = s.insertionSortList(head);
		AList.printAList(head);
	}
	
	public ListNode insertionSortList(ListNode head) {
		ListNode half1 = null;
		ListNode half2 = head;
		ListNode half1Head = null;
		
		// get 1st node from h2
		while (half2 != null) {
			ListNode h2Head = half2.next;
			half2.next = null;
			half1 = half1Head;

			// insert to h1 list, and get its position according to sorting
			if (half1 == null) {
				half1 = half2;
				half1Head = half1;
			} else {// h1 list has 2 or more nodes
				ListNode pre = null;
				while (half1 != null) {
					if (half2.val > half1.val) {
						if(half1.next == null){//last node
							half1.next = half2;
							break;
						}else {
							pre = half1;
							half1 = half1.next;
						}
					} else {
						if (pre != null) {
							pre.next = half2;
							half2.next = half1;
							break;
						} else {
							half1Head = half2;
							half2.next = half1;
							break;
						}
					}
				}
			}
			half2 = h2Head;
		}
		return half1Head;
	}
}
