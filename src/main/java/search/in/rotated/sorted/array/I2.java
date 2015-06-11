package search.in.rotated.sorted.array;

public class I2 {

	public static void main(String[] args) {
		I2 i = new I2();
		// test 1
		int[] a1 = {5};
		int r1 = i.search(a1, 5);
		if (r1 != -1) {
			System.out.println("target is " + a1[r1]);
		} else {
			System.out.println("can't find target");
		}
	}

	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return -1;
		} else if(nums.length == 1) {
			return target == nums[0] ? 0 : -1;
		}
		
		int start, end;
		if(nums[0] < nums[nums.length - 1]) {//no rotation
			start = 0;
			end = nums.length - 1;
		} else {//has rotation
			int diveIndex = searchDiveIndex(nums);
			
			if(target >= nums[0]) {//search left branch
				start = 0;
				end = diveIndex - 1;
			} else {//search right branch
				start = diveIndex;
				end = nums.length - 1;
			}
		}
		return binarySearch(nums, start, end, target);
	}
	
	private int binarySearch(int[] nums, int start, int end, int target) {
		while(start + 1 < end) {
			int mid = start + (end - start)/2;
			if(nums[mid] == target) {
				return mid;
			} else if(nums[mid] < target) {
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
	
	private int searchDiveIndex(int[] nums) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = nums.length - 1;
		while(start + 1 < end) {
			int mid = start + (end - start)/2;
			if(nums[start] < nums[mid]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		return nums[start] < nums[end] ? nums[start] : nums[end];
	}
}
