package src.dp.ChoiceOfArea;

public class ChoiceOfArea {

	public static int ax = 3;
	public static int bx = 2;

	public static int ay = -5;
	public static int by = -10;

	public static int az = -20;
	public static int bz = 5;

	private static int timeTakenFromX(int p1, int p2) {

		p1 = p1 + ax;
		p2 = p2 + bx;

		if (p1 <= 0 || p2 <= 0)
			return 0;

		return 1 + Math.max(timeTakenFromY(p1, p2), timeTakenFromZ(p1, p2));
	}

	private static int timeTakenFromY(int p1, int p2) {

		p1 = p1 + ay;
		p2 = p2 + by;

		if (p1 <= 0 || p2 <= 0)
			return 0;

		return 1 + Math.max(timeTakenFromX(p1, p2), timeTakenFromZ(p1, p2));
	}

	private static int timeTakenFromZ(int p1, int p2) {

		p1 = p1 + az;
		p2 = p2 + bz;

		if (p1 <= 0 || p2 <= 0)
			return 0;

		return 1 + Math.max(timeTakenFromY(p1, p2), timeTakenFromX(p1, p2));

	}

	public static void main(String[] args) {

		int p1 = 20;
		int p2 = 8;

		if (p1 <= 0 || p2 <= 0)
			System.out.println("0");
		else
			System.out.println(
					Math.max(Math.max(timeTakenFromX(p1, p2), timeTakenFromY(p1, p2)), timeTakenFromZ(p1, p2)));

	}

}
