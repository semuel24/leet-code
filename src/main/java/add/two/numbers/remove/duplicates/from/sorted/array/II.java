package remove.duplicates.from.sorted.array;

import java.util.Arrays;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class II {

	public static void main(String [] args) {
		II ii = new II();
		int[] a1 = {1,1,1,1,2};
		int length1 = ii.removeDuplicates(a1);
		ii.print(a1, length1);
		
		int[] a2 = {1,1,1,1,2};
		int length2 = ii.removeDuplicates(a2);
		ii.print(a2, length2);
	}
	
	private void print(int[] _A, int _length) {
		System.out.println("printing array:");
		for(int i=0; i< _length; i++) {
			System.out.print(_A[i] + " ");
		}
		System.out.println("");
	}
	
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0) {
			return 0;
		} else if(A.length == 1) {
			return 1;
		}
		
		Arrays.sort(A);//in-place quick sort O(nlog(n))
		int i = 0, j = 1;
		int occurency = 1;
		
		while(j<A.length) {
			if(A[j-1] == A[j]) {//duplicate element
				if(occurency < 2) {
					occurency++;
					i++;
					A[i] = A[j];
				} else {//count >= 2
					occurency++;
				}
			} else {//find new element
				occurency = 1;//reset counter
				i++;
				A[i] = A[j];
			}
			j++;
		}
		return i+1;
	}
}
