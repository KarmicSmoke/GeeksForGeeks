package dp.CountingDistinctOccurenceOfSubsequence;

public class CountDistinctOccurrencesAsASubsequenceNewDp {

	private static int findSubsequenceCount(String str1, String str2) {

		int l1 = str1.length();
		int l2 = str2.length();

		int[][] dp = new int[l1][l2];

		int count = 0;
		for (int i = l1 - 1; i >= 0; --i)
			if (str1.charAt(i) == str2.charAt(l2 - 1)) {
				++count;
				dp[i][l2 - 1] = count;
			}

		for (int i = l1 - 2; i >= 0; --i) {
			for (int j = 0; j <= l2 - 2; ++j) {
				if (str1.charAt(i) != str2.charAt(j))
					dp[i][j] = dp[i + 1][j];
				else
					dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];

			}
		}

		return dp[0][0];

	}

	public static void main(String[] args) {
		String str1 = "banana", str2 = "ana";
		System.out.println(findSubsequenceCount(str1, str2));

	}

}
