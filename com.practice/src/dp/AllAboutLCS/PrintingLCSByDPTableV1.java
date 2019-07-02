package dp.AllAboutLCS;

import java.util.HashSet;
import java.util.Set;

public class PrintingLCSByDPTableV1 {

	private static int[][] dp;

	public static void generateLCSDp(String s1, String s2) {

		int l1 = s1.length();
		int l2 = s2.length();

		dp = new int[l1][l2];

		// If index <0 give it some value that for loop does not execute
		int index = s2.indexOf(s1.charAt(0));
		if (index < 0)
			index = l1 + l2;

		// Base value for row 0
		for (int j = index; j < l2; ++j)
			dp[0][j] = 1;

		// If index <0 give it some value that for loop does not execute
		index = s1.indexOf(s2.charAt(0));
		if (index < 0)
			index = l1 + l2;

		// Base value for column 0
		for (int i = index; i < l1; ++i)
			dp[i][0] = 1;

		for (int i = 1; i < l1; ++i) {
			for (int j = 1; j < l2; ++j) {
				if (s1.charAt(i) == s2.charAt(j))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

	}

	private static Set<String> getAllLCS(String s1, String s2, int i, int j) {

		Set<String> s = new HashSet<String>();

		// Unintelligent Base condition used here
		// Intelligent would have been when we would have considered empty
		// strings too
		// Hence in that case dpMap[m+1][n+1] and str1 = s1 .. sm
		// and str2 = x1 .. xn and x0 = s0 = ""

		if (i == 0 && j == 0) {
			if (s1.charAt(0) == s2.charAt(0))
				s.add(s1.charAt(0) + "");
			return s;
		}

		if (i == 0) {
			// Search for s1[0] in s2[0..j]. If exists then s1[0] is LCS(0,j)
			// Else return empty Set
			int result = s2.substring(0, j + 1).indexOf(s1.charAt(0));

			if (result < 0)
				return s;
			else {
				s.add(s1.charAt(0) + "");
				return s;
			}
		}

		if (j == 0) {
			// Search for s2[0] in s1[0..i]. If exists then s2[0] is LCS(i,0)
			// Else return empty Set

			int result = s1.substring(0, i + 1).indexOf(s2.charAt(0));

			if (result < 0)
				return s;
			else {
				s.add(s2.charAt(0) + "");
				return s;
			}

		}
		// Base conditions end now

		if (s1.charAt(i) == s2.charAt(j)) {
			Set<String> temp = getAllLCS(s1, s2, i - 1, j - 1);

			if (temp.size() == 0)
				s.add(s1.charAt(i) + "");
			else
				for (String str : temp)
					s.add(str + s1.charAt(i));

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

		String s1 = "AGTGATG";
		String s2 = "GTTAG";

		int m = s1.length();
		int n = s2.length();

		generateLCSDp(s1, s2);
		System.out.println(getAllLCS(s1, s2, m - 1, n - 1));
	}

}
