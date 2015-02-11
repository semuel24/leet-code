package add.two.numbers;

import list.common.AList;
import list.common.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8

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
		int [] a1 = {2,4,3};
		int [] a2 = {5,6,4};
		ListNode l1 = AList.generateAList(a1);
		ListNode l2 = AList.generateAList(a2);
		
		Solution s = new Solution();
		ListNode l = s.addTwoNumbers(l1, l2);
		AList.printAList(l);
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    	ListNode head = new ListNode(0);//fake head
    	ListNode p = head;
    	int carry = 0;
    	while(l1 != null || l2 != null || carry != 0) {
    		
    		int sum = 0;
    		if(l1 != null) {
    			sum += l1.val;
    			l1 = l1.next;
    		}
    		if(l2 != null) {
    			sum += l2.val;
    			l2 = l2.next;
    		}
    		sum += carry;
    		carry = sum/10;
    		sum = sum%10;
    		
    		p.next = new ListNode(sum);
    		p = p.next;
    	}
    	
    	return head.next;
    }
}
