package reorder.list;

import list.common.AList;
import list.common.ListNode;

public class Solution2 {

	public static void main(String [] args) {
		Solution2 s = new Solution2();
		int[] A = {1,2,3};
		ListNode head = AList.generateAList(A);
		AList.printAList(head);
		s.reorderList(head);
		AList.printAList(head);
	}
	
	public void reorderList(ListNode head) {
		int _length = length(head);
		int breakpoint = breakpoint(_length);
		ListNode half2 = breakList(head, breakpoint);
		half2 = reverse(half2);
		mergeList(head, half2);
	}
	
	private void mergeList(ListNode h1, ListNode h2) {
		
		if(h1 == null || h2 == null) {
			return;
		}
		while(h1 != null && h2 != null) {
			ListNode tmp1 = h1.next;
			ListNode tmp2 = h2.next;
			h1.next = h2;
			h2.next = tmp1;
			
			h1 = tmp1;
			h2 = tmp2;
		}
	}
	
	private ListNode reverse(ListNode _node) {
		if(_node == null){
			return null;
		}else if(_node.next == null){
			return _node;
		}
		
		//always transfer one node from half2 to half1
		ListNode half1 = null;
		ListNode half2 = _node;
		while(half2.next != null) {
			ListNode tmp = half2;
			half2 = half2.next;
			tmp.next = half1;
			half1 = tmp;
		}
		
		//at this moment, half2 points to one single node
		half2.next = half1;
		
		return half2;
	}
	
	private int breakpoint(int _length) {
		return _length%2==0 ? _length/2:(_length/2+1);
	}
	
	//return head of 2nd half list
	//breakpoint means n-th node after which list is broken down
	private ListNode breakList(ListNode head, int breakpoint) {
		if(breakpoint <= 1 ) {
			return null;
		}
		breakpoint --;
		while(breakpoint > 0) {
			head = head.next;
			breakpoint--;
		}
		
		ListNode tmp = head.next;
		head.next = null;
		return tmp;
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
}
