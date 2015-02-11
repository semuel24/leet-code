package number.sum;

import java.util.Hashtable;
import java.util.UUID;

public class TwoSum {

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID());
	}

	public static int[] twoSum(int[] numbers, int target) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		
		Hashtable<Integer, Integer> tb = new Hashtable<Integer, Integer>();
		int [] result = {0,0};
		for(int i=0; i< numbers.length; i++) {
			
			int tofind = target - numbers[i];
			
			if(tb.containsKey(tofind)) {//find pair
				result[0] = (Integer)tb.get(tofind);
				result[1] = i+1;
				break;
			}
			
			
			 if( !tb.containsKey(numbers[i]) ) {
				 tb.put(numbers[i], i+1);
			 } else {
				 
			 }
		}
		
		
		return result;
	}
}
