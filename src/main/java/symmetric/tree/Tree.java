package symmetric.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import tree.common.TreeNode;

public class Tree {

	public boolean isSymmetric(TreeNode root) {

		if (root == null) {
			return true;
		} else if (root.left == null && root.right == null) {
			return true;
		}

		List<Integer> l = new ArrayList<Integer>();
		// load list
		inorder(root, l);
		// judge list
		return listSymmetric(l);
	}

	private void inorder(TreeNode _node, List<Integer> _l) {
		if (_node.left != null) {
			inorder(_node.left, _l);
		}

		_l.add(_node.val);

		if (_node.right != null) {
			inorder(_node.right, _l);
		}
	}

	private boolean listSymmetric(List<Integer> _l) {
		if (_l == null) {
			return true;
		} else if (_l.size() == 1) {
			return true;
		}

		int head = 0;
		int tail = _l.size() - 1;
		while (head < tail) {
			if (_l.get(head) != _l.get(tail)) {
				return false;
			}
			head++;
			tail--;
		}
		return true;
	}

	public int jump(int[] A) {
		if (A == null || A.length <= 1) {
			return 0;
		}

		int[] jump = new int[A.length];
		jump[0] = 0;

		for (int i = 1; i < A.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (A[j] >= i - j) {
					min = Math.min(min, jump[j] + 1);
				}
			}
			jump[i] = min;
		}

		return jump[A.length - 1];
	}

	public boolean wordBreak(String s, Set<String> dict) {

		if (s == null || s.length() == 0) {
			return true;
		}

		boolean[] dp = new boolean[s.length()];

		int maxLength = Integer.MIN_VALUE;
		for (String _word : dict) {
			if (_word.length() > maxLength) {
				maxLength = _word.length();
			}
		}
		if (dict.contains(s.subSequence(0, 1))) {
			dp[0] = true;
		}

		for (int i = 1; i < s.length(); i++) {
			if (dict.contains(s.subSequence(0, i + 1))) {
				dp[i] = true;
				continue;
			}
			for (int j = i - 1; j >= 0 && i - j <= maxLength; j--) {
				if (dict.contains(s.subSequence(j + 1, i + 1)) && dp[j]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length() - 1];
	}

	public int longestIncreasingSubsequence(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		// initialize
		int[] dp = new int[nums.length];
		dp[0] = 1;

		// calculate for each index
		for (int i = 1; i < nums.length; i++) {
			int maxi = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] >= nums[j]) {
					maxi = Math.max(maxi, dp[j] + 1);
				}
			}
			dp[i] = maxi;
		}

		// find max from index
		int max = Integer.MIN_VALUE;
		for (int _val : dp) {
			max = Math.max(max, _val);
		}
		return max;
	}

	public int minCut(String s) {
		if (s == null || s.length() <= 1) {
			return 0;
		}

		boolean[][] IsPalindrome = calPalindrome(s);

		int[] dp = new int[s.length()];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i < s.length(); i++) {
			if (IsPalindrome[0][i]) {
				dp[i] = 0;
				continue;
			}

			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (dp[j] != Integer.MAX_VALUE && IsPalindrome[j + 1][i]) {
					min = Math.min(min, dp[j] + 1);
				}
			}
			dp[i] = min;
		}
		return dp[s.length() - 1];
	}

	public boolean[][] calPalindrome(String s) {
		boolean[][] IsPalindrome = new boolean[s.length()][s.length()];
		IsPalindrome[0][0] = true;

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j)
						&& (j >= i - 1 || IsPalindrome[j + 1][i - 1])) {
					IsPalindrome[j][i] = true;
				}
			}
		}
		return IsPalindrome;
	}

	private boolean isP(String s) {
		if (s == null || s.length() <= 1) {
			return true;
		}

		int start = 0, end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public int minDistance(String word1, String word2) {

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		// initialization
		for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= word2.length(); j++) {
			dp[0][j] = j;
		}

		// recursion
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,
							Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1));
				}
			}
		}

		// result
		return dp[word1.length()][word2.length()];
	}

	public int numDistinct(String S, String T) {
		int[][] dp = new int[S.length() + 1][T.length() + 1];
		// initialization
		for (int i = 0; i <= S.length(); i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; j <= T.length(); j++) {
			dp[0][j] = 0;
		}

		// recursion
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		// result
		return dp[S.length()][T.length()];
	}

	public int longestCommonSubsequence(String S, String T) {
		int[][] dp = new int[S.length() + 1][T.length() + 1];
		// initialization
		for (int i = 0; i <= S.length(); i++) {
			dp[i][0] = 0;
		}
		for (int j = 1; j <= T.length(); j++) {
			dp[0][j] = 0;
		}

		// recursion
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// result
		return dp[S.length()][T.length()];
	}

	public int longestCommonSubstring(String S, String T) {
		int[][] dp = new int[S.length() + 1][T.length() + 1];
		// initialization
		for (int i = 0; i <= S.length(); i++) {
			dp[i][0] = 0;
		}
		for (int j = 1; j <= T.length(); j++) {
			dp[0][j] = 0;
		}

		// recursion
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = 0;
				}
			}
		}

		// find result
		int max = 0;
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null) {
			return false;
		}
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}

		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

		// initialization
		dp[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) {
			if (s1.substring(0, i).equalsIgnoreCase(s3.substring(0, i))) {
				dp[i][0] = true;
			} else {
				dp[i][0] = false;
			}
		}

		for (int j = 1; j <= s2.length(); j++) {
			if (s2.substring(0, j).equalsIgnoreCase(s3.substring(0, j))) {
				dp[0][j] = true;
			} else {
				dp[0][j] = false;
			}
		}

		// recursion
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				dp[i][j] = false;
				if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] |= dp[i - 1][j];
				}
				if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
					dp[i][j] |= dp[i][j - 1];
				}
			}
		}

		// result
		return dp[s1.length()][s2.length()];
	}

	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		// initialization
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;

		// recursion
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if (p.charAt(j - 1) == '?'
						|| p.charAt(j - 1) == s.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					for (int k = 0; k <= i; k++) {
						if (dp[k][j - 1]) {
							dp[i][j] = true;
							break;
						}
					}
				} else {// p.charAt(j - 1) != s.charAt(i - 1)
					dp[i][j] = false;
				}
			}
		}

		// result
		return dp[s.length()][p.length()];
	}

	public int backPack(int m, int[] A) {
		// initialization
		boolean[][] dp = new boolean[A.length + 1][m + 1];
		for (int i = 0; i <= A.length; i++) {
			dp[i][0] = true;
		}
		for (int j = 1; j <= m; j++) {
			dp[0][j] = false;
		}

		// recursion
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i - 1][j]
						|| (j - A[i - 1] >= 0 && dp[i - 1][j - A[i - 1]]);
			}
		}

		// result
		for (int j = m; j >= 0; j--) {
			if (dp[A.length][j]) {
				return j;
			}
		}
		return 0;
	}

	public int backPackII(int m, int[] A, int V[]) {
		// initialization
		int[][] dp = new int[A.length + 1][m + 1];
		for (int i = 0; i <= A.length; i++) {
			dp[i][0] = 0;
		}
		for (int j = 1; j <= m; j++) {
			dp[0][j] = Integer.MIN_VALUE;
		}

		// recursion
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= m; j++) {

				dp[i][j] = j - A[i - 1] >= 0 ? Math.max(dp[i - 1][j],
						dp[i - 1][j - A[i - 1]] + V[i - 1]) : dp[i - 1][j];
			}
		}

		// result
		int max = 0;
		for (int j = 1; j <= m; j++) {
			max = Math.max(max, dp[A.length][j]);
		}
		return max;
	}

	public int kSum(int A[], int k, int target) {
		// initialization
		int[][][] dp = new int[A.length + 1][k + 1][target + 1];
		for (int i = 0; i <= A.length; i++) {
			dp[i][0][0] = 1;
		}

		// recursion
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= k; j++) {
				for (int t = 1; t <= target; t++) {
					dp[i][j][t] = t - A[i - 1] >= 0 ? dp[i - 1][j - 1][t
							- A[i - 1]]
							+ dp[i - 1][j][t] : dp[i - 1][j][t];
				}
			}
		}

		// result
		return dp[A.length][k][target];
	}

	public int MinAdjustmentCost(ArrayList<Integer> A, int target) {

		int max = Integer.MIN_VALUE;
		for (Integer _a : A) {
			max = Math.max(max, _a);
		}

		// initialization
		int[][] dp = new int[A.size() + 1][max + 1];
		for (int i = 1; i <= 1; i++) {
			for (int v = 0; v <= max; v++) {
				dp[i][v] = Math.abs(A.get(i - 1) - v);
			}
		}

		// recursion
		// dp[i][v] = min{dp[i - 1][v'] + |v-A[i - 1]|,|v-v'| <= target}
		for (int i = 2; i <= A.size(); i++) {
			for (int v = 0; v <= max; v++) {
				dp[i][v] = Integer.MAX_VALUE;
				for (int v2 = 0; v2 <= max; v2++) {
					if (Math.abs(v - v2) <= target) {
						if (dp[i - 1][v2] != Integer.MAX_VALUE) {
							dp[i][v] = Math.min(dp[i][v],
									dp[i - 1][v2] + Math.abs(v - A.get(i - 1)));
						}
					}
				}
			}
		}

		// result
		int min = Integer.MAX_VALUE;
		for (int v = 1; v <= max; v++) {
			min = Math.min(min, dp[A.size()][v]);
		}
		return min;
	}

	public static void main(String[] args) {

		int [] minCostItems_ = {11,11,3,5,11,16,12,11,15,11,16,16,16,16,16,11,16};
		ArrayList<Integer> minCostItems = convert(minCostItems_);
		System.out.println(new Tree().MinAdjustmentCost(minCostItems, 0));

		int ksunitems[] = { 1, 2, 3, 4 };
		System.out.println(new Tree().kSum(ksunitems, 2, 5));

		int backpacksize = 10;
		int[] values = { 1, 5, 2, 4 };
		int[] sizes = { 2, 3, 5, 7 };
		System.out.println(new Tree().backPackII(backpacksize, sizes, values));

		int items[] = { 2, 3, 5, 7 };
		System.out.println(new Tree().backPack(11, items));

		System.out.println(new Tree().isMatch("aa", "*"));
		System.out.println(new Tree().isMatch("aa", "a*"));
		System.out.println(new Tree().isMatch("a", "?"));

		System.out.println(new Tree().isMatch("aa", "?"));
		System.out.println(new Tree().isMatch("aa", "ab*"));

		// System.out.println(new Tree().longestCommonSubstring("ABCD",
		// "CBCE"));
		// System.out.println(new Tree().isInterleave("aabcc", "dbbca",
		// "aadbbcbcac"));
		// System.out.println(new Tree().isInterleave("aabcc", "dbbca",
		// "aadbbbaccc"));
	}
	
	private static ArrayList<Integer> convert(int _items[]) {
		ArrayList<Integer> itemList = new ArrayList<Integer>();
		for(int _item : _items) {
			itemList.add(_item);
		}
		return itemList;
	}

}
