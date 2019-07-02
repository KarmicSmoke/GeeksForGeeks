package dp.CountDigitGroupingsOfANumber;

public class CountDigitGroupingsOfANumberByRecursion {

	public static String number = "11111";

	public static int calc(int beginIndex, int previousSum) {

		if (beginIndex == number.length())
			return 1;

		System.out.println(beginIndex + "," + previousSum);

		int sum = 0, ans = 0;

		for (int i = beginIndex; i < number.length(); ++i) {
			sum += number.charAt(i) - '0';
			if (sum >= previousSum)
				ans += calc(i + 1, sum);
		}

		return ans;

	}

	public static void main(String[] args) {

		System.out.println(calc(0, 0));

	}

}
