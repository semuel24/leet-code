package search.insert.position;

/**
 * Given a sorted array and a target value, 
 * return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ��� 2
[1,3,5,6], 2 ��� 1
[1,3,5,6], 7 ��� 4
[1,3,5,6], 0 ��� 0
 */
public class Solution1 {
	
	public static void main(String [] args) {
		Solution1 s = new Solution1();
		int [] A = {1,3,5,6};
		System.out.println(s.searchInsert(A, 5));
		System.out.println(s.searchInsert(A, 2));
		System.out.println(s.searchInsert(A, 7));
		System.out.println(s.searchInsert(A, 0));
	}
	
	public int searchInsert(int[] A, int target) {
		int start = 0;
		int end = A.length -1;
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
		
		if(A[start] >= target) {
			return start;
		} else if(A[end] >= target) {
			return end;
		} else {
			return A.length;
		}
	}
}
