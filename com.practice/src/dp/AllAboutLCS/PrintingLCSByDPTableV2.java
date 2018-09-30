package src.dp.AllAboutLCS;

import java.util.HashSet;
import java.util.Set;

public class PrintingLCSByDPTableV2 {

	private static int[][] dp;

	public static void generateLCSDp(String s1, String s2) {

		int l1 = s1.length();
		int l2 = s2.length();

		// Accounting for empty string now
		// dpMap[0][] and dpMap[][0] are all empty string LCS
		dp = new int[l1 + 1][l2 + 1];

		// See how much base conditions reduced
		// More ease will be seen in printing code too
		for (int i = 0; i <= l2; ++i)
			dp[0][i] = 0;

		for (int i = 0; i <= l2; ++i)
			dp[i][0] = 0;

		for (int i = 1; i <= l1; ++i) {
			for (int j = 1; j <= l2; ++j) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))// This place is imp.
															// Remember string
															// actually is from
															// 0 only !!
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

	}

	private static Set<String> getAllLCS(String s1, String s2, int i, int j) {

		Set<String> s = new HashSet<String>();

		// Awesome Intelligent Base conditions
		// Used here.
		if (i == 0 || j == 0)
			return s;
		// That's all motherfucker :D

		if (s1.charAt(i - 1) == s2.charAt(j - 1)) { // This the only area that
													// require adjustment
			Set<String> temp = getAllLCS(s1, s2, i - 1, j - 1);

			if (temp.size() == 0)
				s.add(s1.charAt(i - 1) + "");
			else
				for (String str : temp)
					s.add(str + s1.charAt(i - 1));

		} else { // Not equal case

			if (dp[i][j - 1] > dp[i - 1][j])
				s = getAllLCS(s1, s2, i, j - 1);
			else if (dp[i][j - 1] < dp[i - 1][j])
				s = getAllLCS(s1, s2, i - 1, j);
			else { // dpMap[i][j-1] == dpMap[i-1][j]
				s = getAllLCS(s1, s2, i, j - 1);
				s.addAll(getAllLCS(s1, s2, i - 1, j));
			}
		}

		return s;

	}

	public static void main(String[] args) {

		// Remember our dpMap table assumes now s1 and s2 begins from 1
		// Hence appropriate changes need to be made
		// At 0 it assumes empty string
		// All this is done as this is actually the best base condition
		// To be used
		String s1 = "AGTGATG";
		String s2 = "GTTAG";

		int m = s1.length();
		int n = s2.length();

		generateLCSDp(s1, s2);
		System.out.println(getAllLCS(s1, s2, m, n));
	}

}
