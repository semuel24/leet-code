package list.common;

public class AList {

	public static ListNode generateAList(int[] _A){
		if(_A == null || _A.length == 0) {
			return null;
		}
		ListNode head = new ListNode(_A[0]);
		ListNode cursor = head;
		for(int i =1; i< _A.length; i++) {
			ListNode n = new ListNode(_A[i]);
			cursor.next = n;
			cursor = cursor.next;
		}		
		return head;
	}
	
	public static void printAList(ListNode _node) {
		while(_node != null) {
			System.out.println(_node.val);
			_node = _node.next;
		}
	}
}
