package unique.path;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
 * @author yaoxu
 *
 */
public class I {

	public static void main(String [] args) {
		I i = new I();
		System.out.println(i.uniquePaths(36, 7));
	}
	
	public int uniquePaths(int m, int n) {
		if(m<1 || n<1) {
			return 0;
		}
		
		if(m==1||n==1) {
			return 1;
		}
		
		if(m>=n) {
			long tmp1 = factorial(m-1,m+n-2);
			return (int)(tmp1/factorial(n-1));
		} else {
			long tmp1 = factorial(n-1,m+n-2);
			return (int)(tmp1/factorial(m-1));
		}
	}
	
	//(s,e]
	private long factorial(int s, int e) {
		if(s < 1 || s >= e ) {
			throw new RuntimeException("");
		}
		
		long total = 1;
		for(int i=s+1; i<=e; i++) {
			total *= i;
		}
		return total;
	}
	
	private long factorial(int n) {
		if(n<1) {
			throw new RuntimeException("n<1 for factorial");
		}
		
		long total = 1;
		for(int i=1; i<=n; i++) {
			total *= i;
		}
		return total;
	}
}
