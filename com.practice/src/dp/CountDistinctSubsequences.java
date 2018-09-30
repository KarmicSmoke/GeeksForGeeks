package src.dp;

import java.util.Arrays;

public class CountDistinctSubsequences {

	private static int[] last = new int[256]; // the mapping which quickly tells
						 // us most recent location of
						// last occurrence
						// the character denoted by
						// ASCII

	public static int calc(String str) {

		Arrays.fill(last, -1);
		int[] count = new int[str.length()];

		last[str.charAt(0)] = 0;
		count[0] = 2;

		for (int i = 1; i < str.length(); ++i) {

			count[i] = count[i - 1] * 2;

			if (last[str.charAt(i)] != -1) { // If repetition happens , subtract

				if (last[str.charAt(i)] != 0)
					count[i] -= count[last[str.charAt(i)] - 1]; // Just for any
										// index except
										// the first one
				else
					count[i] = count[i] - 1; // specifically for the first index

			}

			last[str.charAt(i)] = i; // updates the recent location of
						// character at ith pos in string
		}

		return count[str.length() - 1];
	}

	public static void main(String[] args) {
		System.out.println(calc("gfg"));

	}

}
