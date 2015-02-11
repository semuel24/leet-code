package single.number;

public class II {

	public static void main(String [] args) {
		II ii = new II();
		int[] A = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
		int r = ii.singleNumber(A);
		System.out.println("result is: " + r);
	}
	
	
	
	public int singleNumber(int[] A) {
     
		int[] store = new int[32];
		
		for(int i=0; i<A.length; i++) {
			//for each number
			int k = 1;
			for(int j=0; j< 32; j++) {
				//loop each bit of the number
				int tmp = k&A[i]; //check bit
				if(tmp != 0) {
					store[j] += 1;
				}
				k = k<<1;
			}
		}
		
		//remove bit occurrence which can be divided by 3
        for(int i=0; i<32; i++) {
        	while(store[i] >= 3) {
        		store[i] -= 3;
        	}
        }
        
        //fill store[] into an integer
        int bar = 1;
        int result = 0;
        for(int i=0; i<32; i++){
        	if(store[i] == 1) {
        		result = result | bar;
        	}
        	bar = bar<<1;
        }
        
        return result;
    }
}
