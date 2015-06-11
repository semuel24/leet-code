package count.primes;

/**
 * http://articles.leetcode.com/2010/04/finding-prime-numbers.html
 * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
 */
public class Solution {

	public static void main(String [] args) {
//		System.out.println(new Solution().countPrimes(1000000));
		System.out.println(new Solution().countPrimes(0));
		System.out.println(new Solution().countPrimes(1));
		System.out.println(new Solution().countPrimes(2));
	}
	
	public int countPrimes(int n) {
		n--;
		if(n<2) {
			return 0;
		}
		
		//pre-set
        boolean[] primes = new boolean[n+1];
        primes[0] = false;
        primes[1] = false;
        for(int i=2; i<=n; i++) {
        	primes[i] = true;
        }
        //populate boolean array
        for(int i=2; i<=n; i++) {
        	if(primes[i]) {
        		for(int j=2; j<=n; j++) {
        			if(i*j>n) {
        				break;
        			}
            		primes[i*j] = false;
            	}
        	}
        }
        
        //count
        int count = 0;
        for(int i=2; i<=n; i++) {
        	if(primes[i]) {
//        		System.out.println(i + " ");
        		count ++;
        	}
        }
        return count;
    }
	
}
