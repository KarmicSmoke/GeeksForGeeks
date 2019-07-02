package dp;

public class LongestCommonSubString {

	private static int[][] dp;

	private static int LCSubStr(String s1, String s2, int l1, int l2) {

		for (int i = 0; i < l2; ++i)
			dp[0][i] = (s2.charAt(i) == s1.charAt(0)) ? (1) : (0);

		for (int j = 0; j < l2; ++j)
			dp[j][0] = (s1.charAt(j) == s2.charAt(0)) ? (1) : (0);

		for (int i = 1; i < l1; ++i)
			for (int j = 1; j < l2; ++j)
				dp[i][j] = (s1.charAt(i) == s2.charAt(j)) ? (1 + dp[i - 1][j - 1]) : (0);

		int max = 0;

		for (int i = 0; i < l1; ++i)
			for (int j = 0; j < l2; ++j)
				max = Math.max(max, dp[i][j]);
		return max;

	}

	private static String getLongestCommonSubString(String s1, String s2, int l1, int l2) {

		int max = 0, end = 0;

		for (int i = 0; i < l1; ++i)
			for (int j = 0; j < l2; ++j)
				if (max <= dp[i][j]) {
					end = i;
					max = dp[i][j];
				}

		int begin = end - max + 1;
		return s1.substring(begin, end);
	}

	public static void main(String[] args) {

		String str1 = "OldSite:GeeksforGeeks.org";
		String str2 = "NewSite:GeeksQuiz.com";

		int l1 = str1.length();
		int l2 = str2.length();

		dp = new int[l1][l2];

		System.out.println("Length of Longest Common Substring is " + LCSubStr(str1, str2, l1, l2));
		System.out.println(getLongestCommonSubString(str1, str2, l1, l2));
	}
}
