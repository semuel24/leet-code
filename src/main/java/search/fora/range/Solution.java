package search.fora.range;

import java.util.ArrayList;

public class Solution {

	/** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        if(A == null || A.size() == 0) {
        	ArrayList<Integer> _result = new ArrayList<Integer>();
        	_result.add(-1);
        	_result.add(-1);
        	return _result;
        }
        
        int first = find1st(A, target);
        if(first == -1) {
        	ArrayList<Integer> _result = new ArrayList<Integer>();
        	_result.add(-1);
        	_result.add(-1);
        	return _result;
        }
        
        int last = findLast(A, target);
        ArrayList<Integer> _result = new ArrayList<Integer>();
    	_result.add(first);
    	_result.add(last);
    	return _result;
    }
    
    private int find1st(ArrayList<Integer> A, int target) {
    	int start = 0;
    	int end = A.size() - 1;
    	while(start + 1 < end) {
    		int mid = start + (end - start)/2;
    		if(A.get(mid) == target) {
    			end = mid;
    		} else if(A.get(mid) < target) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	if(A.get(start) == target) {
			return start;
		}
		if(A.get(end) == target) {
			return end;
		}
		return -1;
    }
    
    private int findLast(ArrayList<Integer> A, int target) {
    	int start = 0;
    	int end = A.size() - 1;
    	while(start + 1 < end) {
    		int mid = start + (end - start)/2;
    		if(A.get(mid) == target) {
    			start = mid;
    		} else if(A.get(mid) < target) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
		if(A.get(end) == target) {
			return end;
		}
		if(A.get(start) == target) {
			return start;
		}
		return -1;
    }
    
    public static void main(String [] args) {
    	ArrayList<Integer> nums = new ArrayList<Integer>();
    	nums.add(5);
    	nums.add(7);
    	nums.add(7);
    	nums.add(8);
    	nums.add(8);
    	nums.add(10);
    	ArrayList<Integer> results = new Solution().searchRange(nums, 8);
    	System.out.println("[" + results.get(0) + "," + results.get(1) + "]");
    }
}
