package com.recursive;

public class NumsOfExpree {
	public static boolean isValid(char[] chas) {
		if ((chas.length & 1) != 1) {
			return false;
		}
		for (int i = 0; i < chas.length; i = i + 2) {
			if ((chas[i] != '1') && (chas[i] != '0')) {
				return false;
			}
		}

		for (int i = 1; i < chas.length; i = i + 2) {
			if ((chas[i] != '&') && (chas[i] != '|') && (chas[i] != '^')) {
				return false;
			}
		}
		return true;
	}

	public static int nums1(String express, boolean desire) {
		if (express == null || express.equals("")) {
			return 0;
		}
		char[] chas = express.toCharArray();
		if (!isValid(chas)) {
			return 0;
		}
		return p(chas, desire, 0, chas.length - 1);
	}

	private static int p(char[] chas, boolean desire, int l, int r) {
		// TODO Auto-generated method stub
		if (l == r) {
			if (chas[l] == '1') {
				return desire ? 1 : 0;
			} else {
				return desire ? 0 : 1;
			}
		}
		int res = 0;
		if (desire) {
			for (int i = l + 1; i <= r; i += 2) {
				switch (chas[i]) {
				case '&':
					res += p(chas, true, l, i - 1) * p(chas, true, i + 1, r);
					break;
				case '|':
					res += p(chas, true, l, i - 1) * p(chas, false, i + 1, r);
					res += p(chas, false, l, i - 1) * p(chas, true, i + 1, r);
					res += p(chas, true, l, i - 1) * p(chas, true, i + 1, r);
					break;
				case '^':
					res += p(chas, true, l, i - 1) * p(chas, false, i + 1, r);
					res += p(chas, false, l, i - 1) * p(chas, true, i + 1, r);
					break;
				}
			}
		} else {
			for (int i = l + 1; i <= r; i += 2) {
				switch (chas[i]) {
				case '&':
					res += p(chas, true, l, i - 1) * p(chas, false, i + 1, r);
					res += p(chas, false, l, i - 1) * p(chas, true, i + 1, r);
					res += p(chas, false, l, i - 1) * p(chas, false, i + 1, r);
					break;
				case '|':

					res += p(chas, false, l, i - 1) * p(chas, false, i + 1, r);
					break;
				case '^':
					res += p(chas, true, l, i - 1) * p(chas, true, i + 1, r);
					res += p(chas, false, l, i - 1) * p(chas, false, i + 1, r);
					break;
				}
			}
		}
		return res;
	}

	public static int nums2(String express, boolean desire) {
		if (express == null || express.equals("")) {
			return 0;
		}
		char[] chas = express.toCharArray();
		if (!isValid(chas)) {
			return 0;
		}

		int[][] t = new int[chas.length][chas.length];
		int[][] f = new int[chas.length][chas.length];
		t[0][0] = chas[0] == '1' ? 1 : 0;
		f[0][0] = chas[0] == '1' ? 0 : 1;
		for (int i = 2; i < chas.length; i += 2) {
			t[i][i] = chas[i] == '1' ? 1 : 0;
			f[i][i] = chas[i] == '1' ? 0 : 1;
			for (int j = i - 2; j >= 0; j -= 2) {
				for (int k = j; k < i; k += 2) {
					if (chas[k + 1] == '&') {
						t[j][i] += t[j][k] * t[k + 2][i];
						f[j][i] += f[j][k] * f[k + 2][i] + f[j][k] * t[k + 2][i] + t[j][k] * f[k + 2][i];
					} else if (chas[k + 1] == '|') {
						t[j][i] += t[j][k] * t[k + 2][i] + f[j][k] * t[k + 2][i] + t[j][k] * f[k + 2][i];
						f[j][i] += f[j][k] * f[k + 2][i];
					} else {
						t[j][i] += f[j][k] * t[k + 2][i] + t[j][k] * f[k + 2][i];
						f[j][i] += f[j][k] * f[k + 2][i] + t[j][k] * t[k + 2][i];
					}
				}
			}

		}
		return desire ? t[0][chas.length - 1] : f[0][chas.length - 1];
	}

	public static void main(String[] args) {
//		String str = "1&0|1^0^1|1|1&1";
		String str = "1^0|1|1";
		System.out.println(nums1(str, true));
		System.out.println(nums2(str, true));
		System.out.println(nums1(str, false));
		System.out.println(nums2(str, false));
	}
}
