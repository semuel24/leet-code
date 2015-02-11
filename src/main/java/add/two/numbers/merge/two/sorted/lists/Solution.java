package merge.two.sorted.lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import list.common.AList;
import list.common.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int [] a1 = {1,4,8};
		int [] a2 = {2,5,7};
		ListNode head1 = AList.generateAList(a1);
		ListNode head2 = AList.generateAList(a2);
		ListNode l = s.mergeTwoLists(head1, head2);
		AList.printAList(l);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//load all lists into a collection
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(l1);
		lists.add(l2);
		
		ListNode p = null, head = null, P_MAX = new ListNode(Integer.MAX_VALUE), p_low = null;
		Object first = null;
		while(true) {//not all lists have reached their ends
			p_low = P_MAX;
			for(ListNode lx : lists) {//loop all lists once, and try to find a node with smallest value
				if(lx == null) {//this list has reached its end
					continue;
				}
				
				if(lx.val < p_low.val) {
					p_low = lx;
				}
			}
			
			//try to append p_low pointing node to p
			if(p_low == null || p_low == P_MAX) {//didn't find node
				break;
			} else {//found a useful node, append
				//initialize head pointer
				if(first == null) {
					p = p_low;
					head = p;
					first = new Object();
				} else {
					p.next = p_low;
					p = p.next;
				}
				
				//move forward the original pointer lx
				Iterator<ListNode> it = lists.iterator();
				ListNode next = null;
				while(it.hasNext()) {
					ListNode lx = (ListNode) it.next();
					if(p_low == lx) {
						ListNode tmp = lx;
						lx = lx.next;
						next = lx;
						tmp.next = null;
						it.remove();
						break;
					}
				}
				lists.add(next);
			}
		}
		return head;
	}
}
