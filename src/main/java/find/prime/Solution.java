package find.prime;

public class Solution {

	public static void main(String [] args) {
		System.out.println(isPrime(27637));
		System.out.println(isPrime(28283));
	}
	
	private static boolean isPrime(int num) {
		int bar = num/2 + 1;
		for(int i=2; i<bar; i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}
