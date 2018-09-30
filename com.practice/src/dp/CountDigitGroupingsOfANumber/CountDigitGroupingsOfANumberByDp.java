package src.dp.CountDigitGroupingsOfANumber;

import java.util.Arrays;

public class CountDigitGroupingsOfANumberByDp {

	public static String number = "1119";
	public static int[][] dp;

	public static int calc(int beginIndex, int previousSum) {

		if (beginIndex == number.length())
			return 1;

		if (dp[previousSum][beginIndex] != -1)
			return dp[previousSum][beginIndex];

		int sum = 0, ans = 0;

		for (int i = beginIndex; i < number.length(); ++i) {
			sum += number.charAt(i) - '0';
			if (sum >= previousSum)
				ans += calc(i + 1, sum);
		}

		dp[previousSum][beginIndex] = ans;
		return ans;

	}

	public static void main(String[] args) {

		int sum = 0;

		for (char s : number.toCharArray())
			sum += s - '0';

		dp = new int[sum][number.length()];

		for (int[] row : dp)
			Arrays.fill(row, -1);

		System.out.println(calc(0, 0));

	}

}
