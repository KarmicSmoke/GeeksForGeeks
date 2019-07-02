package dp;

public class PrintingMaximumSumIncreasingSubsequence {

	private static int[] dp;// saves sum
	private static int[] previousElementInMSIS; // used only to print LIS

	private static int lengthOfMSIS(int[] arr) {

		int len = arr.length, max, previousElement = -1;
		dp = new int[len];
		previousElementInMSIS = new int[len]; // used only when we need to print
												// LIS

		dp[0] = arr[0];
		previousElementInMSIS[0] = -1;

		for (int i = 1; i < len; ++i) {
			max = arr[i];
			previousElement = -1;
			for (int j = i - 1; j >= 0; --j)
				if (arr[j] < arr[i]) {

					if (max <= dp[j] + arr[i]) {
						previousElement = j;
						max = dp[j] + arr[i];
					}
				}

			dp[i] = max;
			previousElementInMSIS[i] = previousElement;
		}

		max = dp[0];
		for (int i = 1; i < len; ++i)
			max = Math.max(max, dp[i]);

		return max;

	}

	private static String printMSIS(int[] arr, int lengthOfLIS) {

		int len = arr.length, i;
		String str = "";

		for (i = 0; i < len; ++i)
			if (dp[i] == lengthOfLIS)
				break;

		do {
			str += arr[i] + ",";
			i = previousElementInMSIS[i];
		} while (i != -1);

		return str; // actually we are storing in reverse but who cares :) Can
					// use stack too
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 2, 6, 4, 5, 1 };
		int lengthOfMSIS = lengthOfMSIS(arr);
		System.out.println(lengthOfMSIS);
		System.out.println(printMSIS(arr, lengthOfMSIS));

	}

}
