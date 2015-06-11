package rotate.array;

import java.util.ArrayList;

public class Solution2 {

	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
		if(nums == null || nums.size() < 2) {
            return;
        }
		if(nums.get(0) < nums.get(nums.size() - 1)) {
			return;
		}
		int smallIndex = findSmallIndex(nums);
		reverse(nums, 0, smallIndex - 1);
		reverse(nums, smallIndex, nums.size() - 1);
		reverse(nums, 0, nums.size() - 1);
    }
	
	private void reverse(ArrayList<Integer> nums, int start, int end) {
        if(nums == null || nums.size() < 2) {
            return;
        }
        
        while(start < end) {
        	int tmp = nums.get(start);
        	nums.set(start, nums.get(end));
        	nums.set(end, tmp);
        	start ++;
        	end --;
        }
    }
	private int findSmallIndex(ArrayList<Integer> nums) {
		if(nums == null || nums.size() < 2) {
            return -1;
        }
		int smallIndex = 0;
		for(int i = 1; i < nums.size(); i++) {
			if(nums.get(i) < nums.get(smallIndex)) {
				smallIndex = i;
			}
		}
		return smallIndex;
	}
}
