package src.dp.CountingDistinctOccurenceOfSubsequence;

public class CountDistinctOccurrencesAsASubsequenceNewrRecursionMethod {

	private static int findSubsequenceCount(String str1, String str2, int length1, int length2, int begin1, int begin2) {

		if(begin2 == length2)
			return 1;

		if(begin1 == length1)
			return 0;

		if( str1.charAt(begin1) != str2.charAt(begin2) )
			return findSubsequenceCount(str1, str2, length1, length2, begin1+1, begin2);
		else
			return findSubsequenceCount(str1, str2, length1, length2, begin1+1, begin2+1) + findSubsequenceCount(str1, str2, length1, length2, begin1+1, begin2);


	}

	public static void main(String[] args) {
		String str1 = "geeksforgeeks", str2 = "ge";
		System.out.println(findSubsequenceCount(str1, str2, str1.length(), str2.length(), 0, 0));

	}



}
