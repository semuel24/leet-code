package unique.path;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
 *
 */
public class I {

	public static void main(String [] args) {
//		I i = new I();
//		System.out.println(i.uniquePaths(36, 7));
		
		int[][] obstacleGrid = {{0, 1}};
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] g = new int[m][n];
		g[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int i = 1; i < m; i++) {
        	if(obstacleGrid[i][0] == 1 || g[i - 1][0] == 0) {
        		g[i][0] = 0;
        	} else {
        		g[i][0] = 1;
        	}
        }
        for(int i = 1; i < n; i++) {
        	if(obstacleGrid[0][i] == 1 || g[0][i - 1] == 0) {
        		g[0][i] = 0;
        	} else {
        		g[0][i] = 1;
        	}
        }
        for(int i = 1; i < m ; i++) {
            for(int j = 1; j < n ; j++) {
                g[i][j] = obstacleGrid[i][j] == 1 ? 0 : g[i - 1][j] + g[i][j - 1];
            }
        }
        int k =  g[m - 1][n - 1];
		System.out.println(k);
		
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
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0) {
			return 0;
		}
		if(triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
		
        int [][] dp = new int [triangle.size()][triangle.get(triangle.size() - 1).size()];
        for(int i = 0; i < triangle.get(triangle.size() - 1).size(); i ++) {
        	dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }
        
        for(int i = triangle.size() - 2; i >= 0; i --) {
        	for(int j = 0; j < triangle.get(i).size(); j ++) {
        		dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
        	}
        }
        return dp[0][0];
    }
	
	public boolean canJump(int[] A) {
        
		int max = A[0];
		for(int i = 1; i < A.length; i++) {
			if(i > max) {
				break;
			}
			max = Math.max(max, i + A[i]);
		}
		return max >= A.length - 1;
    }
	
	
	
	
	
}
