package com.BitAlgorithms;
/**
 * hzy：jdk1.8
 */

/**
 * @author 残月
 * @descripition 在一个数组中只有一个数出现1次，其他数群出现k次，找到并打印这个数
 * @ieda 将数组中所有数转换成k进制数n，两个k进制数无进位相加结果为（m+n）%k
 */
public class PrintAppearenceOneTimeNum {

	/**
	 * @param args
	 */
	public static void printOne(int[] arr, int k) {
		int[] eO = new int[32];
		for (int cur : arr) {
			setExclusive(eO, cur, k);
		}
		int res = getNumFromKSysNum(eO, k);
		System.out.println(res);

	}



	private static void setExclusive(int[] eO, int cur, int k) {
		// TODO Auto-generated method stub
		int[] curkSysNum = getKSysNumFromNum(cur, k);
		for (int i = 0; i < eO.length; i++) {
			eO[i] = (eO[i] + curkSysNum[i]) % k;
		}

	}

	private static int[] getKSysNumFromNum(int cur, int k) {
		// TODO Auto-generated method stub
		int[] res = new int[32];
		int index = 0;
		while (cur != 0) {
			res[index++] = cur % k;
			cur = cur / k;
		}
		return res;
	}
	
	private static int getNumFromKSysNum(int[] eO, int k) {
		// TODO Auto-generated method stub
		int res = 0;
		for (int i = eO.length - 1; i != -1; i--) {
			res = res * k + eO[i];
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,1,1,1,2,2,2,2,3};
		printOne(arr, 4);
	}

}
