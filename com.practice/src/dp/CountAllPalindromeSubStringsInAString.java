package dp;

public class CountAllPalindromeSubStringsInAString {

	private static String str;

	private static int countPalindrome() {

		int len = str.length();
		boolean[][] dp = new boolean[len][len]; // Everything initialized by
												// false

		// Base Condition 1
		for (int i = 0; i < len; ++i)
			dp[i][i] = true;

		// Base Condition 2
		for (int i = 0; i <= len - 2; ++i)
			dp[i][i + 1] = (str.charAt(i) == str.charAt(i + 1)) ? (true) : (false);

		for (int i = len - 3; i >= 0; --i)
			for (int j = i + 2; j < len; ++j)
				if (str.charAt(i) == str.charAt(j))
					dp[i][j] = dp[i + 1][j - 1];
				else
					dp[i][j] = false;

		int count = 0;
		for (int i = 0; i < len; ++i)
			for (int j = 0; j < len; ++j)
				if (dp[i][j] && j - i >= 1) // Palindrome length >=2
					++count;

		return count;

	}

	public static void main(String[] args) {
		str = "abbaeae";
		System.out.println(countPalindrome());

	}

}
