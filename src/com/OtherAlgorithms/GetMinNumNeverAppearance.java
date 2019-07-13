package com.OtherAlgorithms;

import java.util.Arrays;


public class GetMinNumNeverAppearance {

	public static int getMinNumOfSumNeverAppear(int[] arr) {
		if (arr == null || arr.length < 1) {
			return 1;
		}
		int min = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			min = Math.min(min, arr[i]);
		}
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		for (int i = 0; i != arr.length; i++) {
			for (int j = sum; j >= arr[i]; j--) {
				// 动态规划中的数组会在一次次的循环中将子集和所在位置设置为true，利用两数之和a+b=sum来进行求解，知道了sum值，如何a存在，那么b值一定存在
				dp[j] = dp[j - arr[i]] ? true : dp[j];

			}
		}

		for (int i = 1; i != sum + 1; i++) {
			if (!dp[i]) {
				return i;
			}

		}
		return sum + 1;

	}

	public static int getMinNumOfSumNeverAppear1(int[] arr) {
		if (arr == null || arr.length < 1) {
			return 1;
		}
		int range = 0;
		Arrays.sort(arr);
		if (arr[0] != 1) {
			return getMinNumOfSumNeverAppear(arr);
		} else {
			for (int i = 0; i != arr.length; i++) {
				if (arr[i] > range + 1) {
					return range + 1;
				} else {
					range += arr[i];
				}
			}
		}
		return range + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {1,2,4,8,16,32,64,128,256,512,1024,2048};
		long start=System.currentTimeMillis();
		System.out.println(getMinNumOfSumNeverAppear(arr));
		long end=System.currentTimeMillis();
		System.out.println(end-start+"ms");
		long start1=System.currentTimeMillis();
		System.out.println(getMinNumOfSumNeverAppear1(arr));
		long end1=System.currentTimeMillis();
		System.out.println(end1-start1+"ms");

	}

}
