package dp.ChoiceOfArea;

import java.util.HashMap;

public class ChoiceOfAreaByDp {

	static class Key {
		int p1;
		int p2;
		char pos;

		public Key(int p1, int p2, char pos) {
			super();
			this.p1 = p1;
			this.p2 = p2;
			this.pos = pos;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + p1;
			result = prime * result + p2;
			result = prime * result + pos;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (p1 != other.p1)
				return false;
			if (p2 != other.p2)
				return false;
			if (pos != other.pos)
				return false;
			return true;
		}



	}

	public static int ax = 3;
	public static int bx = 2;

	public static int ay = -5;
	public static int by = -10;

	public static int az = -20;
	public static int bz = 5;

	public static HashMap<Key,Integer> dpMap = new HashMap<Key,Integer>();

	private static int timeTakenFromX(int p1, int p2) {

		if(dpMap.containsKey(new Key(p1,p2,'X')))
			return dpMap.get(new Key(p1,p2,'X'));

		p1 = p1 + ax;
		p2 = p2 + bx;

		if (p1 <= 0 || p2 <= 0)
			return 0;

		dpMap.put(new Key(p1,p2,'X'), 1 + Math.max(timeTakenFromY(p1, p2), timeTakenFromZ(p1, p2)));
		return dpMap.get(new Key(p1,p2,'X'));
	}

	private static int timeTakenFromY(int p1, int p2) {

		if(dpMap.containsKey(new Key(p1,p2,'Y')))
			return dpMap.get(new Key(p1,p2,'Y'));

		p1 = p1 + ay;
		p2 = p2 + by;

		if (p1 <= 0 || p2 <= 0)
			return  0;

		dpMap.put(new Key(p1,p2,'Y'), 1 + Math.max(timeTakenFromX(p1, p2), timeTakenFromZ(p1, p2)));
		return dpMap.get(new Key(p1,p2,'Y'));
	}

	private static int timeTakenFromZ(int p1, int p2) {

		if(dpMap.containsKey(new Key(p1,p2,'Z')))
			return dpMap.get(new Key(p1,p2,'Z'));

		p1 = p1 + az;
		p2 = p2 + bz;

		if (p1 <= 0 || p2 <= 0)
			return 0;

		dpMap.put(new Key(p1,p2,'Z'), 1 + Math.max(timeTakenFromY(p1, p2), timeTakenFromX(p1, p2)));
		return dpMap.get(new Key(p1,p2,'Z'));

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
