package kth.largest.two.unsorted.array;

public class Drive1 {

	public static void main(String [] args) {
		int A[] = {1,2,3,4};
		int B[] = {5,7};
		int k = 2;
		
		Drive1 d1 = new Drive1();
		System.out.println(d1.FindKthLargestNum(A, B, 0, 0, A.length-1, B.length-1, k));
	}
	
	int FindKthLargestNum(int A[], int B[], int startA, int startB, int endA, int endB, int k){
	    //m is the size of A, n is the size of B
	    int m = endA-startA+1;
	    int n = endB-startB+1;
	    if(m+n < k) return 0;
	    
	    int result;
	    if(A[endA] < B[startB]){
	        if(m >= k){
	            result = A[startA+k-1];
	        }else{
	            result = B[startB+k-m-1];
	        }
	    }else if(A[startA] > B[endB]){
	        if(n >= k){
	            result = B[startB+k-1];
	        }else{
	            result = A[startA+k-m-1];
	        }
	    }else{
	        if((m+n)/2-1 >=k){
	            result = FindKthLargestNum(A, B, startA, startB, (startA+endA)/2-1, (startB+endB)/2-1, k);
	        }else{
	            result = FindKthLargestNum(A, B, (startA+endA)/2, (startB+endB)/2, endA, endB, k-(m+n)/2+1);
	        }
	    }
	    return result;
	}
}
