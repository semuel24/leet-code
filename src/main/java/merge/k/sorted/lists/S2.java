package merge.k.sorted.lists;

import java.util.List;
import list.common.ListNode;

public class S2 {

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		if (lists.size() == 1) {
			return lists.get(0);
		}

		return merge(lists, 0, lists.size() - 1);
	}

	private ListNode merge(List<ListNode> lists, int start, int end) {
		if(start == end) {
			return lists.get(start);
		}
		
		int mid = start + (end - start) / 2;
		ListNode left = merge(lists, start, mid);
		ListNode right = merge(lists, mid + 1, end);
		return merge2List(left, right);
	}

	private ListNode merge2List(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				head.next = l1;
				head = head.next;
				l1 = l1.next;
			} else {
				head.next = l2;
				head = head.next;
				l2 = l2.next;
			}
		}
		if (l1 != null) {
			head.next = l1;
		} else {
			head.next = l2;
		}
		return dummy.next;
	}
}
