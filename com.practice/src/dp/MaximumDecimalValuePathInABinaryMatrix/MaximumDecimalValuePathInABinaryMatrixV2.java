package dp.MaximumDecimalValuePathInABinaryMatrix;

public class MaximumDecimalValuePathInABinaryMatrixV2 {

	private static long calc(long[][] mat) {

		int dimension = mat.length;
		long[][] dp = new long[dimension][dimension];
		long[] powerOfTwo = new long[2 * dimension];

		// Evaluate power of two
		powerOfTwo[0] = 1;
		for (int i = 1; i <= 2 * dimension - 1; ++i)
			powerOfTwo[i] = powerOfTwo[i - 1] * 2;

		// Filling bottom row
		dp[dimension - 1][dimension - 1] = mat[dimension - 1][dimension - 1];
		for (int j = dimension - 2; j >= 0; --j)
			if (mat[dimension - 1][j] == 0)
				dp[dimension - 1][j] = dp[dimension - 1][j + 1];
			else
				dp[dimension - 1][j] = dp[dimension - 1][j + 1]
						+ powerOfTwo[2 * dimension - 1 - (dimension - 1 + j) - 1];

		// Filling Last Column
		for (int i = dimension - 2; i >= 0; --i)
			if (mat[i][dimension - 1] == 0)
				dp[i][dimension - 1] = dp[i + 1][dimension - 1];
			else
				dp[i][dimension - 1] = dp[i + 1][dimension - 1]
						+ powerOfTwo[2 * dimension - 1 - (dimension - 1 + i) - 1];

		// Filling Rest of DP table
		for (int i = dimension - 2; i >= 0; --i)
			for (int j = dimension - 2; j >= 0; --j)
				if (mat[i][j] == 0)
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				else
					dp[i][j] = powerOfTwo[2 * dimension - 1 - (j + i) - 1] + Math.max(dp[i + 1][j], dp[i][j + 1]);

		return dp[0][0];
	}

	public static void main(String[] args) {

		long[][] mat = { { 1, 1, 0, 1 }, { 0, 1, 1, 0 }, { 1, 0, 0, 1 }, { 1, 0, 1, 1 } };
		System.out.println(calc(mat));

	}

}
