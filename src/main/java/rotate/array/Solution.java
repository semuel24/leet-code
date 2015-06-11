package rotate.array;

public class Solution {

	public static void main(String [] args) {
		int [] nums = {1,2,3,4,5,6,7};
		int k = 3;
//		int [] nums = {1,2,3,4};
//		int k=1;
		new Solution().rotate(nums, k);
	}
	
	public void rotate(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
//		print(nums);
    }
	
	private void reverse(int [] nums, int startIndex, int endIndex) {
		while(startIndex<endIndex) {
			int temp = nums[startIndex];
			nums[startIndex] = nums[endIndex];
			nums[endIndex] = temp;
			startIndex++;
			endIndex--;
		}
	}
	
//	private void print(int [] nums) {
//		for(int i:nums) {
//			System.out.print(i + "|");
//		}
//		System.out.println("");
//	}
}
