package dp.CountingDistinctOccurenceOfSubsequence;

public class CountDistinctOccurrencesAsASubsequence {

	public static int findSubsequenceCount(String str1, String str2, int l1, int l2, int begin1, int begin2) {

		if (begin2 == l2)
			return 1;

		int sum = 0;

		for (int j = begin1; j < l1; ++j)
			if (str1.charAt(j) == str2.charAt(begin2))
				sum += findSubsequenceCount(str1, str2, l1, l2, j + 1, begin2 + 1);

		return sum;
	}

	public static void main(String[] args) {
		String str1 = "geeksforgeeks", str2 = "ge";
		System.out.println(findSubsequenceCount(str1, str2, str1.length(), str2.length(), 0, 0));

	}

}
