
public class Soltion1015 {
	public int smallestRepunitDivByK(int K) {
		if (K % 2 == 0 || K % 5 == 0)
			return -1;
		int num = 1;
		int res = 1;
		while (num % K != 0) {
			num %= K;
			num = num * 10 + 1;
			res++;
		}
		return res;
	}
}
