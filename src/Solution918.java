import java.util.Random;

public class Solution918 {
	public int maxSubarraySumCircular(int[] A) {
		if (A == null || A.length < 1) {
			return 0;
		}
		int totalMax = A[0];
		int totalMin = A[0];
		int min = A[0];
		int max = A[0];
		int sum = A[0];
		for (int i = 1; i < A.length; i++) {
			sum += A[i];

			if (max + A[i] > A[i]) {
				max += A[i];
			} else {
				max = A[i];
			}

			totalMax = Math.max(totalMax, max);

			if (min + A[i] < A[i]) {
				min += A[i];
			} else {
				min = A[i];
			}
			totalMin = Math.min(totalMin, min);
		}

		if (sum == totalMin) {
			return totalMax;
		}
		return Math.max(totalMax, sum - totalMin);
	}

	public static void main(String[] args) {
		int[] A = new int[5];
		Random r = new Random();
		for (int i = 0; i < 5; i++) {
			A[i] = r.nextInt(5) - r.nextInt(10);
		}
		for (int c : A) {
			System.out.print(c + " ");
		}
		System.out.println();
		System.out.println("------------------");
		System.out.println(new Solution918().maxSubarraySumCircular(A));
	}
}
