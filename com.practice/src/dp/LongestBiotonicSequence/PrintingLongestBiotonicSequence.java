package dp.LongestBiotonicSequence;

public class PrintingLongestBiotonicSequence {

	private static int[] previousElementInLIS;
	private static int[] forwardElementInLDS;

	private static int[] lengthOfLDS(int[] arr) {

		int len = arr.length, max, forwardElement = -1;
		int[] dp = new int[len];
		forwardElementInLDS = new int[len]; // used only when we need to print
											// LIS

		dp[len - 1] = 1;
		forwardElementInLDS[len - 1] = -1;

		for (int i = len - 2; i >= 0; --i) {
			max = 1;
			forwardElement = -1;
			for (int j = i + 1; j < len; ++j)
				if (arr[j] < arr[i]) {

					if (max <= dp[j] + 1) {
						forwardElement = j;
						max = dp[j] + 1;
					}
				}

			dp[i] = max;
			forwardElementInLDS[i] = forwardElement;
		}

		return dp;
	}

	private static int[] lengthOfLIS(int[] arr) {

		int len = arr.length, max, previousElement = -1;
		int[] dp = new int[len];
		previousElementInLIS = new int[len]; // used only when we need to print
												// LIS

		dp[0] = 1;
		previousElementInLIS[0] = -1;

		for (int i = 1; i < len; ++i) {
			max = 1;
			previousElement = -1;
			for (int j = i - 1; j >= 0; --j)
				if (arr[j] < arr[i]) { // If <= is placed then it becomes non
										// decreasing

					if (max <= dp[j] + 1) {
						previousElement = j;
						max = dp[j] + 1;
					}
				}

			dp[i] = max;
			previousElementInLIS[i] = previousElement;
		}

		return dp;

	}

	private static String printLIS(int[] arr, int index) {

		// First save in array , then print as string in reverse

		int[] indexes = new int[arr.length]; // number of elements in LIS <=
												// index + 1 but still we used
												// len.
		int count = 0;

		while (index != -1) {
			indexes[count++] = index;
			index = previousElementInLIS[index];
		}

		String str = "";

		for (int i = count - 1; i >= 1; --i)
			str += arr[indexes[i]] + ",";

		str += arr[indexes[0]]; // Did this just for no trailing ","

		return str;

	}

	private static String printLDS(int[] arr, int index) {

		// First save in array , then print as string
		int[] indexes = new int[arr.length];
		int count = 0;

		while (index != -1) {
			indexes[count++] = index;
			index = forwardElementInLDS[index];
		}

		String str = "";
		for (int i = 1; i < count; ++i)
			str += arr[indexes[i]] + ",";

		return str;
	}

	private static void lengthOfLongestBiotonicSequence(int[] arr) {

		int len = arr.length, max = 0;

		int[] lisLength = lengthOfLIS(arr);
		int[] ldsLength = lengthOfLDS(arr);

		for (int i = 0; i < len; ++i)
			max = Math.max(lisLength[i] + ldsLength[i] - 1, max);

		System.out.println("Maximum is : " + max);
		System.out.println("All Such Sequences are : ");

		for (int i = 0; i < len; ++i)
			if (lisLength[i] + ldsLength[i] - 1 == max)
				System.out.println(printLIS(arr, i) + "," + printLDS(arr, i));

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 11, 2, 10, 4, 5, 2, 1 };
		lengthOfLongestBiotonicSequence(arr);

	}

}
