package dp;

class Pair implements Comparable<Pair> {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pair p) {

		if (this.y < p.x)
			return -1;
		else if (this.y == p.x)
			return 0;
		else
			return 1;

	}

	public String toString() {
		return "( " + x + " , " + y + " )";
	}
}

public class PrintMaximumLengthChainOfPairs {

	private static Pair[] a;

	private static void printLongestLength() {

		int len = a.length, max, previousElement = -1;
		int[] dp = new int[len];
		int[] previousElementInLIS = new int[len]; // used only when we need to
													// print LIS

		dp[0] = 1;
		previousElementInLIS[0] = -1;

		for (int i = 1; i < len; ++i) {
			max = 1;
			previousElement = -1;
			for (int j = i - 1; j >= 0; --j)
				if (a[j].compareTo(a[i]) == -1) {

					if (max <= dp[j] + 1) {
						previousElement = j;
						max = dp[j] + 1;
					}
				}

			dp[i] = max;
			previousElementInLIS[i] = previousElement;
		}

		max = dp[0];
		for (int i = 1; i < len; ++i)
			max = Math.max(max, dp[i]);
		int i;
		for (i = 0; i < len; ++i) // Now Printing Logic begins
			if (dp[i] == max)
				break;

		while (i != -1) { // Just printing in reverse; Stack can be used
			System.out.print(a[i] + " , ");
			i = previousElementInLIS[i];
		}

	}

	public static void main(String[] args) {

		a = new Pair[5];

		a[0] = new Pair(5, 29);
		a[1] = new Pair(39, 40);
		a[2] = new Pair(15, 28);
		a[3] = new Pair(27, 40);
		a[4] = new Pair(50, 90);

		printLongestLength();

	}
}
