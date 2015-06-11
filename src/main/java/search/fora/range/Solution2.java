package search.fora.range;

public class Solution2 {

	public static void main(String [] args) {
		
		int [] nums = {5,7,7,8,8,10};
		int[] results = new Solution2().searchRange(nums, 8);
		System.out.println("[" + results[0] + "," + results[1] + "]");
	}

	public int[] searchRange(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			int [] results = {-1,-1}; 
			return results;
		}
		
		int first = find1st(nums, target);
        if(first == -1) {
        	int [] results = {-1,-1}; 
			return results;
        }
        
        int last = findLast(nums, target);
        int [] results = {first, last};
    	return results;
		
	}
	
	private int find1st(int[] A, int target) {
    	int start = 0;
    	int end = A.length - 1;
    	while(start + 1 < end) {
    		int mid = start + (end - start)/2;
    		if(A[mid] == target) {
    			end = mid;
    		} else if(A[mid] < target) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	if(A[start] == target) {
			return start;
		}
		if(A[end] == target) {
			return end;
		}
		return -1;
    }
    
    private int findLast(int[] A, int target) {
    	int start = 0;
    	int end = A.length - 1;
    	while(start + 1 < end) {
    		int mid = start + (end - start)/2;
    		if(A[mid] == target) {
    			start = mid;
    		} else if(A[mid] < target) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	if(A[end] == target) {
			return end;
		}
    	if(A[start] == target) {
			return start;
		}
		return -1;
    }	
}
