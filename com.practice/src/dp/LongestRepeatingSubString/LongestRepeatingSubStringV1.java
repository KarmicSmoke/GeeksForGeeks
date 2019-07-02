package dp.LongestRepeatingSubString;

public class LongestRepeatingSubStringV1 {

	private static String getLongestRepeatingSubstring(String str) {

		int len = str.length();
		int[][] dp = new int[len][len];

		for (int i = 1; i < len; ++i) // 0th row filled
			dp[0][i] = (str.charAt(i) == str.charAt(0)) ? (1) : (0);

		for (int i = 1; i < len; ++i) // step 1
			for (int j = i + 1; j < len; ++j)
				if (str.charAt(i) == str.charAt(j))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = 0;

		for (int i = 1; i < len; ++i) // step 2
			for (int j = i + 1; j < len; ++j)
				if (j - i <= dp[i][j] - 1)
					dp[i][j] = j - i;

		// step 3
		int max = 0, end = 0;

		for (int i = 0; i < len; ++i)
			for (int j = i + 1; j < len; ++j)
				if (max <= dp[i][j]) {
					max = dp[i][j];
					end = i;
				}

		return str.substring(end - max + 1, end + 1);

	}

	public static void main(String[] args) {

		String str = "geeksforgeeks";
		System.out.println(getLongestRepeatingSubstring(str));

	}

}
