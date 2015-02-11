package rotate.list;

import list.common.AList;
import list.common.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	
	public static void main(String [] args) {
		int[] A = {1};
		ListNode head = AList.generateAList(A);
		AList.printAList(head);
		Solution s = new Solution();
		head = s.rotateRight(head, 0);
		AList.printAList(head);
	}
	
    public ListNode rotateRight(ListNode head, int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	if(head == null) {
    		return null;
    	}
    	
    	int length = 1;
    	ListNode tail = head;
    	while(tail.next != null) {
    		length ++;
    		tail = tail.next;
    	}
    	
    	n = n%length;
    	if(n == 0) {
    		return head;
    	}
    	
    	int step = length - n - 1;//calculate how many hops from head to reach breanking point
    	ListNode breakpoint = head;
    	for(int i=0; i<step; i++) {
    		breakpoint = breakpoint.next;
    	}
    	
    	//rotate
    	tail.next = head;
    	head = breakpoint.next;
    	breakpoint.next = null;
    	return head;
    }
}