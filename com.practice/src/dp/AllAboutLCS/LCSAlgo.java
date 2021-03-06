package dp.AllAboutLCS;

public class LCSAlgo {

	public static int LCS(String s1, String s2) {

		int l1 = s1.length();
		int l2 = s2.length();

		int[][] dp = new int[l1][l2];

		// If index <0 give it some value that for loop does not execute
		int index = s2.indexOf(s1.charAt(0));
		if (index < 0)
			index = l1 + l2;

		// Base value for row 0
		for (int j = index; j < l2; ++j)
			dp[0][j] = 1;

		// If index <0 give it some value that for loop does not execute
		index = s1.indexOf(s2.charAt(0));
		if (index < 0)
			index = l1 + l2;

		// Base value for column 0
		for (int i = index; i < l1; ++i)
			dp[i][0] = 1;

		for (int i = 1; i < l1; ++i) {
			for (int j = 1; j < l2; ++j) {
				if (s1.charAt(i) == s2.charAt(j))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[l1 - 1][l2 - 1];

	}

	public static void main(String[] args) {

		String str1 = "B", str2 = "C";
		System.out.println(LCS(str1, str2));

	}

}
