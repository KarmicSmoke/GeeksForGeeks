package dp.MaximizeValueOfTheExpression;

//Maximize -arr[i] + arr[j] - arr[k] + arr[l], such that i < j < k < l

public class MaximizeValueOfTheExpressionDpV1 {

	private static int[] arr;

	private static int compute() {

		int len = arr.length;

		if (len < 4) {
			System.out.println("Cannot be computed");
			return -1;
		}

		int[] maxIJKL = new int[len];// will fill from 0 to len-4
		int[] maxJKL = new int[len]; // will fill from 1 to len -3
		int[] maxKL = new int[len]; // will fill from 2 to len-2
		int[] maxL = new int[len]; // will fill from 3 to len-1

		maxL[len - 1] = arr[len - 1];
		for (int i = len - 1 - 1; i >= 3; --i)
			maxL[i] = Math.max(arr[i], maxL[i + 1]);

		maxKL[len - 2] = -arr[len - 2] + arr[len - 1];
		for (int i = len - 2 - 1; i >= 2; --i)
			maxKL[i] = Math.max(maxKL[i + 1], -arr[i] + maxL[i + 1]);

		maxJKL[len - 3] = arr[len - 3] - arr[len - 2] + arr[len - 1];
		for (int i = len - 3 - 1; i >= 1; --i)
			maxJKL[i] = Math.max(maxJKL[i + 1], +arr[i] + maxKL[i + 1]);

		maxIJKL[len - 4] = -arr[len - 4] + arr[len - 3] - arr[len - 2] - arr[len - 1]; // Can write maxIJKL[len - 4] = -arr[len - 4] + maxJKL[len-3] :)
		for (int i = len - 4 - 1; i >= 0; --i)
			maxIJKL[i] = Math.max(maxIJKL[i + 1], -arr[i] + maxJKL[i + 1]);


		return maxIJKL[0];
	}

	public static void main(String[] args) {
		arr = new int[] { 4, 8, 9, 2, 20 };
		System.out.println(compute());
	}

}
