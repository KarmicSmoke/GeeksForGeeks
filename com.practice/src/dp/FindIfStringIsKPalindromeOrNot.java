package src.dp;

public class FindIfStringIsKPalindromeOrNot {

	private static int k;
	private static String str;

	private static void findIfStringIsKPalindromeOrNot() {

		int len = str.length();
		int[][] dp = new int[len][len];

		for (int i = 0; i < len; ++i)
			dp[i][i] = 1;

		for (int i = 0; i <= len - 2; ++i)
			dp[i][i + 1] = (str.charAt(i) == str.charAt(i + 1)) ? (2) : (1);

		for (int i = len - 3; i >= 0; --i)
			for (int j = i + 2; j < len; ++j)
				if (str.charAt(i) == str.charAt(j))
					dp[i][j] = 2 + dp[i + 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);

		if (len - dp[0][len - 1] <= k)
			System.out.println("True");
		else
			System.out.println("False");

	}

	public static void main(String[] args) {

		str = "abcdeca";
		k = 2;
		findIfStringIsKPalindromeOrNot();
	}

}
