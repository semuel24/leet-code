package first.missing.positive;

public class Solution {
	public static void main(String[] args) {
		int nums1[] = {1, 2, 0};
		System.out.println(new Solution().firstMissingPositive(nums1));
		
		int nums2[] = {3, 4, -1, 1};
		System.out.println(new Solution().firstMissingPositive(nums2));
		
		int nums3[] = {-1, -1, 0};
		System.out.println(new Solution().firstMissingPositive(nums3));
		
		int nums4[] = {-1};
		System.out.println(new Solution().firstMissingPositive(nums4));
	}

	public int firstMissingPositive(int[] nums) {
	
		if(nums == null || nums.length == 0) {
			return 1;
		}
		
		for(int i = 0; i < nums.length; i++) {
			while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != (i + 1)) {
				if(nums[i] == nums[nums[i] - 1]) {
					break;
				}
				
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != (i + 1)) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}
}
