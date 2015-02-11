package copy.list.with.random.pointer;

//http://fisherlei.blogspot.com/2013/11/leetcode-copy-list-with-random-pointer.html
public class Solution {
	
	public static void main(String [] args) {
		int [] A = {1};
		RandomListNode L = RandomListNode.GenerateList(A);
		Solution s = new Solution();
		s.copyRandomList(L);
	}
	
    public RandomListNode copyRandomList(RandomListNode head) {
    	//insert copied nodes
    	insertCopied(head);
    	
    	//copy random pointers
    	copyRandom(head);
    	
    	//decouple original and copied nodes
    	return decouple(head);
    }
    
    private void insertCopied(RandomListNode _head) {
    	while(_head != null) {
    		RandomListNode copy = new RandomListNode(_head.label);
    		copy.next = _head.next;
    		_head.next = copy;
    		_head = copy.next;
    	}
    }
    
    private void copyRandom(RandomListNode _head) {
    	while(_head != null) {
    		if(_head.random != null) {
    			_head.next.random = _head.random.next;
    		} else {
    			_head.next.random = null;
    		}
    		_head = _head.next.next;
    	}
    }
    
    private RandomListNode decouple(RandomListNode _head) {
    	if(_head == null) {
    		return null;
    	}
    	RandomListNode copyHead = _head.next;
    	while(_head != null) {
    		RandomListNode tmp = _head.next;
    		_head.next = _head.next.next;
    		_head = _head.next;
    		if(_head != null) {
    			tmp.next = _head.next;
    		}
    	}
    	return copyHead;
    }
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
	
	public static RandomListNode GenerateList(int [] A) {
		if(A == null || A.length == 0) {
			return null;
		}
		
		RandomListNode head = new RandomListNode(A[0]);
		RandomListNode tmp = head;
		for(int i=1; i<A.length; i++) {
			tmp.next = new RandomListNode(A[i]);
			tmp = tmp.next;
		}
		return head;
	}
};