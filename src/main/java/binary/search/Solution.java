package binary.search;

public class Solution {

	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        
    	if(nums == null || nums.length == 0) {
    		return -1;
    	}
    	
    	int start = 0;
    	int end = nums.length - 1;
    	
    	while(start + 1 < end) {
    		int mid = start + (end - start)/2;
    		if(target == nums[mid]) {
    			end = mid;
    		} else if(target > nums[mid]) {
    			start = mid;
    		} else {
    			end = mid;
    		}
    	}
    	
    	if(nums[start] == target) {
    		return start;
    	}
    	if(nums[end] == target) {
    		return end;
    	}
    	return -1;
    }
    
    public static void main(String [] args) {
    	int [] A = {1,3,5,6,7,7,9,10};
    	System.out.println(new Solution().binarySearch(A, 7));
    }
}
