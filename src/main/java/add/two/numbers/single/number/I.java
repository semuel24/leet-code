package single.number;

public class I {

	public int singleNumber(int[] A) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int tmp = 0;
		for(int i=0; i< A.length; i++) {
			tmp ^= A[i];
		}
		
		return tmp;
	}
}
