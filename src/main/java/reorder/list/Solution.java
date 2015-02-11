package reorder.list;

import list.common.AList;
import list.common.ListNode;

public class Solution {
	
	public static void main(String [] args) {
		Solution s = new Solution();
		int[] A = {1,2,3};
		ListNode head = AList.generateAList(A);
		AList.printAList(head);
		s.reorderList(head);
		AList.printAList(head);

	}
	
	public void reorderList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null) {
			return;
		}

		int _length = length(head);
		for(int i=0; i<_length/2; i++) {
			ListNode tail = lastElement(head);
			tail.next = head.next;
			head.next = tail;
			head = tail.next;
		}
	}
	
	private int length(ListNode _node) {
		if(_node == null) {
			return 0;
		}
		int count = 1;
		while(_node.next != null) {
			_node = _node.next;
			count ++;
		}
		return count;
	}

	//remove tail element from list
	private ListNode lastElement(ListNode _node) {
		if(_node == null) {
			return null;
		} else if(_node.next == null) {
			return _node;
		}
		
		ListNode newTail = null;
		while(_node.next != null) {
			newTail = _node;
			_node = _node.next;
		}
		newTail.next = null;
		return _node;
	}

}