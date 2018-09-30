package src.dp.MaximumDecimalValuePathInABinaryMatrix;

public class MaximumDecimalValuePathInABinaryMatrixV1 {

	private static long calc(long[][] mat) {

		int dimension = mat.length;
		long[][] dp = new long[dimension][dimension];

		// Filling bottom row
		dp[dimension - 1][dimension - 1] = mat[dimension - 1][dimension - 1];
		for (int j = dimension - 2; j >= 0; --j)
			if (mat[dimension - 1][j] == 0)
				dp[dimension - 1][j] = 2 * dp[dimension - 1][j + 1];
			else
				dp[dimension - 1][j] = 2 * dp[dimension - 1][j + 1] + 1;

		// Filling Last Column
		for (int i = dimension - 2; i >= 0; --i)
			if (mat[i][dimension - 1] == 0)
				dp[i][dimension - 1] = 2 * dp[i + 1][dimension - 1];
			else
				dp[i][dimension - 1] = 2 * dp[i + 1][dimension - 1] + 1;

		// Filling Rest of DP table
		for (int i = dimension - 2; i >= 0; --i)
			for (int j = dimension - 2; j >= 0; --j)
				if (mat[i][j] == 0)
					dp[i][j] = 2 * Math.max(dp[i + 1][j], dp[i][j + 1]);
				else
					dp[i][j] = 2 * Math.max(dp[i + 1][j], dp[i][j + 1]) + 1;

		return dp[0][0];

	}

	public static void main(String[] args) {
		long[][] mat = { { 1, 1, 0, 1 }, { 0, 1, 1, 0 }, { 1, 0, 0, 1 }, { 1, 0, 1, 1 } };
		System.out.println(calc(mat));

	}

}
