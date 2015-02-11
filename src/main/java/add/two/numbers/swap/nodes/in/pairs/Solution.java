package swap.nodes.in.pairs;

import list.common.AList;
import list.common.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * @author yaoxu
 *
 */
public class Solution {

	public static void main(String [] args) {
		Solution s = new Solution();
		int[] _A = {1,2,3,4};
		AList.printAList(s.swapPairs(AList.generateAList(_A)));
	}
	
	public ListNode swapPairs(ListNode head) {
		ListNode beforeHead = new ListNode(0);
		beforeHead.next = head;
		 
		ListNode lastSecond = beforeHead;
		ListNode nextFirst = head;
		while(lastSecond.next != null && lastSecond.next.next != null) {
			nextFirst = nextFirst.next.next;
			
			if(nextFirst != null) {//not end
				ListNode p1 = lastSecond.next;
				ListNode p2 = lastSecond.next.next;
				
				lastSecond.next = p2;
				p2.next = p1;
				p1.next = nextFirst;
				
			} else {//reaches the end of list
				ListNode p1 = lastSecond.next;
				ListNode p2 = lastSecond.next.next;
				
				lastSecond.next = p2;
				p2.next = p1;
				p1.next = null;
				break;
			}
			lastSecond = lastSecond.next.next;
		}
		return beforeHead.next;
	}
}
