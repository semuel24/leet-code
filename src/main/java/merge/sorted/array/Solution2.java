package merge.sorted.array;

import java.util.ArrayList;

public class Solution2 {

	public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        
		if(A == null || A.size() == 0 || B == null || B.size() == 0) {
			return A;
		}
		
		int i = 0;
		int j = 0;
		ArrayList<Integer> C = new ArrayList<Integer>();
		
		while(i < A.size() && j < B.size()) {
			if(A.get(i) < B.get(j)) {
				C.add(A.get(i));
				i++;
			} else {
				C.add(B.get(j));
				j++;
			}
		}
		
		while(i < A.size()) {
			C.add(A.get(i));
			i++;
		}
		
		while(j < B.size()) {
			C.add(B.get(j));
			j++;
		}
		return C;
    }
}
