package merge.sorted.array;

import java.util.Arrays;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.
 */
public class Solution {
	
	public static void main(String [] args) {
		Solution s = new Solution();
		int [] A = {1, 25, 7, 0, 0, 0};
		int [] B = {6, 2, 0, 0};
		int m = 3;
		int n = 2;
		s.merge(A, m, B, n);
//		s.print(A, m+n);
	}
	
	public void merge(int A[], int m, int B[], int n) {
        
//        Arrays.sort(A, 0, m);
//        Arrays.sort(B, 0, n);
        pushElements(A, m);
        int aStartIndex = A.length-m;
        doMerge(A, B, aStartIndex, m, n);
    }
	
//	private void print(int [] _A, int _l) {
//		System.out.print("printing:");
//		for(int i=0; i<_l; i++) {
//			System.out.print(_A[i] + " ");
//		}
//		System.out.print("");
//	}
	
	/**
	 * push back elements in given array
	 */
	private void pushElements(int [] _A, int _length) { 
		int index = _A.length-1;
		for(int i=_length-1; i>=0; i--) {
			_A[index] = _A[i];
			index--;
		}
	}
	
	//merge B to A
	private void doMerge(int[] A, int [] B, int _as, int _m, int _n) {
		int _bs = 0;//start index for original B, _as is start index for original A
		int org_as = _as;
		
		for(int i=0; i < _m+_n; i++) {//i-index for result A
			
			if(_as == A.length || _bs == _n ) {//one of two arrays is pushed totally
				break;
			}
			
			if(A[_as] <= B[_bs]) {
				A[i] = A[_as];
				_as++;
			} else {
				A[i] = B[_bs];
				_bs++;
			}
		}
		
		if(_as == A.length) {
			for(int i=_bs; i<_n; i++) {//push left-over B elements
				A[_m+_bs] = B[i];
				_bs++;
			}
		} else if(_bs == _n) {//push left-over A elements
			for(int i=_as; i<A.length; i++) {
				A[_as - org_as + _n] = A[i];
				_as++;
			}
		}
	}
}
