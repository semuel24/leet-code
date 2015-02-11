package lru.cache;

import java.util.Hashtable;

public class LRUCache {
	
	public static void main(String [] args) {
		LRUCache l = new LRUCache(2);
		l.set(2,1);
		l.set(2,2);
		l.get(2);
		l.set(1,1);
		l.set(4,1);
		l.get(2);
		l.printAscOrder();//expect 4 6 5 3 2
	}
	
	public void printAscOrder() {
		Cache _node = lTail;
		while(_node != null) {
			System.out.println("list node value: " + _node.value);
			_node = _node.previous;
		}
	}
	
	private int size;
	private int capacity;
	/**
	 * oldest nodes stored in the tail, while most recent nodes stored in the head
	 * list and hashtable hold the same copy of objects
	 */
	private Cache lHead;
	private Cache lTail;
	private Hashtable<Integer,Cache> table;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        table = new Hashtable<Integer,Cache>();
        lHead = null;
        lTail = null;
        size = 0;
    }
    
    /**
     * If object not exists in hashtable, return -1 
     * otherwise, get it from hashtable, and append it at he head of list
     */
    public int get(int key) {
    	Cache r = table.get(key);
    	if(r == null) {
    		return -1;
    	} else{
    		//update access time list
    		if(r.previous != null) {
    			//get r from list
    			r.previous.next = r.next;
    			if(r.next != null) {
    				r.next.previous = r.previous;
    			} else {
    				lTail = r.previous;
    			}
    			//append r to the head side
    			r.next = lHead;
    			lHead = r;
    			r.next.previous = r;
    			r.previous = null;
    		} else {
    			//this node is already at the head of the list
    		}
    		return r.value;
    	}
    }
    
    /**
     * if object already exits in bashtable, do nothing
     * otherwise, check if size == capacity
     * 	    if yes,
     * 			remove oldest node from list and hashtable
     * 			insert new node at the tail
     *      if no,
     *      	insert new node at the tail
     */
    public void set(int key, int value) {
    	Cache r = table.get(key);
    	if( r != null ) {
    		//update value of existing node
    		r.value = value;
        	//get the node from list
    		if(r.previous != null) {
    			//get r from list
    			r.previous.next = r.next;
    			if(r.next != null) {
    				r.next.previous = r.previous;
    			} else {
    				lTail = r.previous;
    			}
    			//append r to the head side
    			r.next = lHead;
    			lHead = r;
    			r.next.previous = r;
    			r.previous = null;
    		} else {
    			//this node is already at the head of the list
    		}
        } else {
        	if(capacity == size) {
        		//remove oldest node from list tail
        		Cache oldest = lTail;
        		lTail = oldest.previous;
        		if(lTail != null) {
        			lTail.next = null;
        		}
        		table.remove(oldest.key);//remove from hashtable
        		
        		//insert new from head side
        		insertNode(key, value);
        	} else {
        		//insert new from head side
        		insertNode(key, value);
        		size ++;
        	}
        }
    }
    
    private void insertNode(int key, int value) {
    	Cache c = new Cache();
    	c.key = key;
		c.value = value;
		c.previous = null;
		c.next = lHead;
		lHead = c;
		if(c.next != null) {
			c.next.previous = c;
		}
		if(lTail == null) {
			lTail = c;
		}
		table.put(key, c);
    }
    
    private class Cache{
    	private int key;
    	private int value;
    	private Cache previous;
    	private Cache next;
		
    }
}