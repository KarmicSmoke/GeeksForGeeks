package dp.LongestBiotonicSequence;

import java.util.Arrays;

public class LongestBiotonicSequence {

	private static int[] reverse(int[] arr) {

		int len = arr.length;
		int[] b = new int[len];

		for(int i = 0; i<len ;++i)
			b[i] = arr[len-1-i];

		return b;
	}

	private static int[] lengthOfLIS(int[] arr) {

		int len = arr.length, max;
		int[] dp = new int[len];

		dp[0] = 1;

		for (int i = 1; i < len; ++i) {
			max = 1;
			for (int j = i - 1; j >= 0; --j)
				if (arr[j] < arr[i]) { // If <= is placed then it becomes non
										// decreasing

					if (max <= dp[j] + 1) {
						max = dp[j] + 1;
					}
				}

			dp[i] = max;

		}

		return dp;

	}

	private static int lengthOfLongestBiotonicSequence(int[] arr) {

		int len = arr.length, max = 0;
		int[] lisLength = lengthOfLIS(arr);
		int[] ldsLength = reverse(lengthOfLIS(reverse(arr)));

		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(ldsLength));

		for (int i = 0; i < len; ++i)
			max = Math.max(lisLength[i] + ldsLength[i] - 1, max);

		return max;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		System.out.println(lengthOfLongestBiotonicSequence(arr));
	}

}
