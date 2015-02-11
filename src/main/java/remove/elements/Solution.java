package remove.elements;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @author yaoxu
 *
 */
//[1,4,6,3,7,3,3,6,3] 3
public class Solution {

	public int removeElement(int[] A, int elem) {
		if(A == null) {
			return 0;
		}
		int sum = 0;
		for(int i=0; i<A.length; i++) {
			if(A[i] != elem) {
				sum++;
			}
		}
		
		if(sum ==0) {
			return 0;
		}
		
		
		int i = 0, j = A.length-1;
		while(i<=j) {
			while(i< A.length && A[i] != elem) {
				i++;
			}
			
			while(j >= 0 && A[j] == elem){
				j--;
			}
			
			if(i>j) {
				break;
			}
			int tmp = A[i];
			A[i] = A[j];
			A[j] = tmp;
			i++;
			i--;
		}
		return sum;
    }
	
	public static void main(String [] args) {
		int[] a = {1};
		Solution s = new Solution();
		s.removeElement(a, 1);
	}
}
