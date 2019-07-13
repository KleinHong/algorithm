
public class Solution790 {
	public int numTilings(int N) {
		int f1 = 5;
		int f2 = 2;
		int f3 = 1;
		if (N == 1) {
			return f3;
		}
		if (N == 2) {
			return f2;
		}
		if (N == 3) {
			return f1;
		}
		while (N != 0) {
			int tmp = 2 * f1 % 1000000007 + f3 % 1000000007;
			f3 = f2;
			f2 = f1;
			f1 = tmp % 1000000007;
			N--;
		}

		return f1;
	}

	public static void main(String[] args) {
		Solution790 s790 = new Solution790();
		System.out.println(s790.numTilings(9));
	}
}
