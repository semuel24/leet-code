package search.in.rotated.sorted.array;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 */
public class II {
	public static void main(String[] args) {
		II ii = new II();
		// test 1
		int[] a1 = { 5, 1, 3 };
		boolean r1 = ii.search(a1, 5);
		System.out.println("r1: " + r1);

		// test 2
		int[] a2 = { 1, 3 };
		boolean r2 = ii.search(a2, 3);
		System.out.println("r2: " + r2);
		
		// test 3
		int[] a3 = { 1 };
		boolean r3 = ii.search(a3, 1);
		System.out.println("r3: " + r3);
	}

	public boolean search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return false;
		}

		int l = 0;
		int r = A.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (A[m] == target) {// found target element
				return true;
			}

			if (A[l] <= A[m]) {// left side elements are sorted
				if(A[l] == A[m]) {
					l++;
					continue;
				}
				
				if (A[l] <= target && target < A[m]) {// search in sorted
														// elements
					if (A[l] == target) {// found target element
						return true;
					}
					r = m - 1;
					continue;
				} else {
					l = m + 1;
					continue;
				}
			} else {// right side elements are sorted
				if (A[m] < target && target <= A[r]) {// search in sorted
														// elements
					if (A[m] == target) {
						return true;
					}
					l = m + 1;
					continue;
				} else {
					r = m - 1;
					continue;
				}

			}
		}
		return false;
	}
}
