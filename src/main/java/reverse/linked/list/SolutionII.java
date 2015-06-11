package reverse.linked.list;

import list.common.AList;
import list.common.ListNode;

public class SolutionII {

	public static void main(String[] args) {
//		int[] A1 = { 1, 2, 3, 4 };
//		ListNode head1 = AList.generateAList(A1);
//		AList.printAList(head1);
//		head1 = new SolutionII().reverseBetween(head1,1,2);
//		AList.printAList(head1);

		int[] A2 = { 3,5};
		ListNode head2 = AList.generateAList(A2);
		AList.printAList(head2);
		head2 = new SolutionII().reverseBetween(head2,1,1);
		AList.printAList(head2);
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {

		if(head == null) {
			return null;
		}
		if(head.next == null) {
			return head;
		}
		if(n<m || m<1) {
			return null;
		}
		
		if(m==1) {
			ListNode p1 = head;
			ListNode p2 = p1.next;
			p1.next = null;
			int steps = n - m;
			while (p2 != null && steps > 0) {
				ListNode p3 = p2.next;
				p2.next = p1;
				p1 = p2;
				p2 = p3;
				steps--;
			}
			if (p2 == null) {
				head.next = null;
				return p1;
			} else {
				head.next = p2;
				return p1;
			}
		} else {
			int temp_m = m;
			ListNode p0 = head;
			while(temp_m-2>0 && p0 != null) {
				p0 = p0.next;
				temp_m--;
			}
			ListNode p1 = p0.next;
			ListNode p2 = p1.next;
			p1.next = null;
			int steps = n - m;
			while (p2 != null && steps > 0) {
				ListNode p3 = p2.next;
				p2.next = p1;
				p1 = p2;
				p2 = p3;
				steps--;
			}
			if(p2 != null) {
				p0.next.next = p2;
			}
			p0.next = p1;
			return head;
		}
	}
}
