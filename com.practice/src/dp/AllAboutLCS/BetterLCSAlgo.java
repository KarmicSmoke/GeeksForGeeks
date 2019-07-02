package dp.AllAboutLCS;

public class BetterLCSAlgo {

	public static int LCS(String s1, String s2) {

		int l1 = s1.length();
		int l2 = s2.length();

		// Accounting for empty string now
		// dpMap[0][] and dpMap[][0] are all empty string LCS
		int[][] dp = new int[l1 + 1][l2 + 1];

		// See how much base conditions reduced
		// More ease will be seen in printing code too
		for (int i = 0; i <= l2; ++i)
			dp[0][i] = 0;

		for (int i = 0; i <= l2; ++i)
			dp[i][0] = 0;

		for (int i = 1; i <= l1; ++i) {
			for (int j = 1; j <= l2; ++j) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))// This place is imp.
															// Remember string
															// actually is from
															// 0 only !!
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[l1][l2];
	}

	public static void main(String[] args) {

		String str1 = "AGTGATG", str2 = "GTTAG";
		System.out.println(LCS(str1, str2));

	}

}
