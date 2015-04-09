package house.robber;

public class Solution {

	public static void main(String[] args) {
		int[] num = { 1, 5, 7, 2 ,100};
		System.out.println(new Solution().rob(num));
	}

	public int rob(int[] num) {

		if (num == null || num.length == 0) {
			return 0;
		}

		if (num.length == 1) {
			return num[0];
		}
		if (num.length == 2) {
			return num[0] > num[1] ? num[0] : num[1];
		}
		if (num.length == 3) {
			return num[1] > num[0] + num[2] ? num[1] : num[0] + num[2];
		}

		// assume n>=3
		int i = 3;
		int[] dp = new int[num.length];
		dp[0] = num[0];
		dp[1] = num[0] > num[1] ? num[0] : num[1];
		dp[2] = num[1] > num[0] + num[2] ? num[1] : num[0] + num[2];
		while (i < num.length) {
			//dp[i] max sum including num[i] 
			dp[i] = Math.max(dp[i - 2], dp[i - 3]) + num[i];
			i++;
		}
		return Math.max(dp[num.length - 1], dp[num.length - 2]);
	}
}
