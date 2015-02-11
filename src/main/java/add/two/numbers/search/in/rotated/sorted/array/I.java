package search.in.rotated.sorted.array;


/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 */
public class I {
	
	public static void main(String[] args) {
		I i = new I();
		//test 1
		int [] a1 = {5, 1, 3};
		int r1 = i.search(a1, 5);
		if(r1 != -1){
			System.out.println("target is " + a1[r1]);
		} else {
			System.out.println("can't find target");
		}
		//test 2
		int [] a2 = {1, 3};
		int r2 = i.search(a2, 3);
		if(r2 != -1){
			System.out.println("target is " + a2[r2]);
		} else {
			System.out.println("can't find target");
		}
		//test 3
		int [] a3 = {1};
		int r3 = i.search(a3, 1);
		if(r3 != -1){
			System.out.println("target is " + a3[r3]);
		} else {
			System.out.println("can't find target");
		}
	}
	
	public int search(int[] A, int target) {
        if(A == null || A.length == 0) {
        	return -1;
        }
        
        int l = 0;
        int r = A.length -1;
        while(l<=r) {
        	int m = (l+r)/2;
        	if(A[m] == target) {//found target element
        		return m;
        	}
        	
        	if(A[l] <= A[m]) {//left side elements are sorted
        		if(A[l]<=target && target<A[m]) {//search in sorted elements
        			if(A[l] == target) {//found target element
                		return l;
                	}
        			r = m-1;
        			continue;
        		} else {
        			l = m+1;
        			continue;
        		}
        	} else {//right side elements are sorted
        		if(A[m]<target && target <= A[r]) {//search in sorted elements
        			if(A[m] == target) {
        				return m;
        			}
        			l = m+1;
        			continue;
        		} else {
        			r = m-1;
        			continue;
        		}
        		
        	}
        }
        return -1;
    }
}
