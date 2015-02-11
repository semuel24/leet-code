package remove.duplicates.from.sorted.array;

import java.util.Arrays;

/*
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array A = [1,1,2],

 Your function should return length = 2, and A is now [1,2].
 */
public class I {

	public static void main(String [] args) {
		I i = new I();
		int[] a = {1,1,2};
		int length = i.removeDuplicates(a);
		i.print(a, length);
	}
	
	private void print(int[] _A, int _length) {
		System.out.println("printing array:");
		for(int i=0; i< _length; i++) {
			System.out.print(_A[i] + " ");
		}
	}
	
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0) {
			return 0;
		} else if(A.length == 1) {
			return 1;
		}
		
		Arrays.sort(A);//in-place quick sort O(nlog(n))
		int i=0,j=1;
		while(j<A.length) {
			if(A[j-1] == A[j]) {//duplicate element
				
			} else {//find new element
				i++;
				A[i] = A[j];
			}
			j++;
		}
		return i+1;
	}
}
