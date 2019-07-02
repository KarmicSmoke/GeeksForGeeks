package dp;

public class CatalanNumber {

	public static int GenerateCatalanNumber(int n) {

		int[] catalanNumber = new int[n + 1];

		catalanNumber[0] = 1;

		for (int i = 1; i <= n; ++i) {

			int ans = 0;
			for (int k = 0; k <= i - 1; ++k)
				ans += catalanNumber[k]*catalanNumber[i-1-k];
			catalanNumber[i] = ans;
		}

		return catalanNumber[n];
	}

	public static void main(String[] args) {
		System.out.println("9th Catalan Number is :" + GenerateCatalanNumber(9));
	}

}
