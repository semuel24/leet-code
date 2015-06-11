package median.of.two.sorted.arrays;

public class IterativeSolution {

	public static void main(String [] args) {
		int[] A1 = {1,2,3,4,5,6};
		int[] B1 = {2,3,4,5};
		System.out.println(new IterativeSolution().findMedianSortedArrays(A1, B1));
		
		int[] A2 = {1,2,3};
		int[] B2 = {4,5};
		System.out.println(new IterativeSolution().findMedianSortedArrays(A2, B2));
		
		int[] A3 = {1};
		int[] B3 = {};
		System.out.println(new IterativeSolution().findMedianSortedArrays(A3, B3));
		
		int[] A4 = {3};
		int[] B4 = {4};
		System.out.println(new IterativeSolution().findMedianSortedArrays(A4, B4));
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		if(nums1 == null) {
			nums1 = new int[0];
		}
		if(nums2 == null) {
			nums2 = new int[0];
		}
		
        if((nums1.length + nums2.length) % 2 == 0) {
			return (findKth(nums1, nums2, (nums1.length + nums2.length) / 2) + findKth(
					nums1, nums2, (nums1.length + nums2.length) / 2 + 1)) / 2.0;
        } else {
        	return findKth(nums1, nums2, (nums1.length + nums2.length) / 2 + 1) ;
        }
    }
	
	//k starting from 1
	private double findKth(int[] A, int[] B, int k) {
		
		//handle one empty array
		if(A.length == 0) {
			return B.length % 2 == 0 ? (B[B.length / 2 - 1] + B[B.length / 2]) / 2.0
					: B[B.length / 2];
		}
		if(B.length == 0) {
			return A.length % 2 == 0 ? (A[A.length / 2 - 1] + A[A.length / 2]) / 2.0
					: A[A.length / 2];
		}
		
		int start1 = 0;
		int start2 = 0;
		int toThrow = k - 1;//need to throw k - 1 elements in total
		
		while(toThrow > 0) {
			if(toThrow == 1) {//handle throwing the last element
				if(start1 >= A.length) {//nums1 has NO elements
					start2 ++;
					break;
				} else if(start2 > B.length) {//nums2 has NO elements
					start1 ++;
					break;
				}
				
				int trash = A[start1] <= B[start2] ? start1++
						: start2++;
				break;
			}
			
			//[[try to throw (toThrow / 2) elements]]
			int A_key = A.length - (start1 + 1) < toThrow / 2 ? Integer.MAX_VALUE
					: A[start1 + toThrow / 2];
			int B_key = B.length - (start2 + 1) < toThrow / 2 ? Integer.MAX_VALUE
					: B[start2 + toThrow / 2];
			
			//both arrays have enough elements to throw
			if(A_key <= B_key) {//throw from A
				start1 += toThrow / 2;
			} else {//throw from B
				start2 += toThrow / 2;
			}
			toThrow -= toThrow / 2;//throw half of the left
		}
		
		//avoid start1 and start2 overflow
		if(start1 >= A.length) {
			return B[start2];
		} else if(start2 >= B.length){
			return A[start1];
		} else {
			return Math.min(A[start1], B[start2]);
		}
    }
}
