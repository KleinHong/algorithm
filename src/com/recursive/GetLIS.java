package com.recursive;

import java.util.Random;

public class GetLIS {

	public static int[] getdp1(int[] arr) {
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
	}

	public static int[] getdp2(int[] arr) {
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];
		ends[0] = arr[0];
		dp[0] = 1;
		int right = 0;
		int l = 0;
		int r = 0;
		int m = 0;
		for (int i = 1; i < arr.length; i++) {
			l = 0;
			r = right;
			while (l <= r) {
				m = l + (r - l) / 2;
				if ((arr[i] > ends[m])) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			right = Math.max(right, l);
			ends[l] = arr[i];
			dp[i] = l + 1;
		}
		return dp;
	}

	public static int[] generateLis(int[] arr, int[] dp) {
		int len = 0;
		int index = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > len) {
				len = dp[i];
				index = i;
			}
		}
		int[] res = new int[len];
		res[--len] = arr[index];
		for (int i = index; i > -1; i--) {
			if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
				res[--len] = arr[i];
				index = i;
			}
		}
		return res;
	}

	public static void print(int[] nums) {
		for (int c : nums) {
			System.out.print(c + " ");
		}
		System.out.println();
	}
	
	public static void printMax(int[] nums) {
		int max=0;
		for (int c : nums) {
			if(max<c) {
				max=c;
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		int len=100000;
		int[] arr = new int[len];
		Random rm = new Random();
		for (int i = 0; i < len; i++) {
			arr[i] = rm.nextInt(1000) ;
		}
		print(arr);

		long start1 = System.currentTimeMillis();
		int[] dp1 = getdp1(arr);
		int[] res1 = generateLis(arr, dp1);
		long end1 = System.currentTimeMillis();
		System.out.print("方法1消耗时间：");
		System.out.println(end1 - start1);
		print(res1);
		printMax(dp1);

		long start2 = System.currentTimeMillis();
		int[] dp2 = getdp2(arr);
		int[] res2 = generateLis(arr, dp2);
		long end2 = System.currentTimeMillis();
		System.out.print("方法2消耗时间：");
		System.out.println(end2 - start2);
		print(res2);
		printMax(dp2);

	}

}
