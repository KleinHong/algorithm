package com.BitAlgorithms;
/**
 * hzy：jdk1.8 
 */

/**
 * @author 残月
 * @descripition 获取一个无序数组中k个最小的数
 * @ieda 1、先对数组进行排序，然后获取下标为k-1的数 2、建立一个最大数堆，将数组前k个数加入最大堆，然后从k开始和最大堆数组第一个元素
 *       进行比较，比他小就讲该数与怼顶数交换，然后进行调整，遍历完数组后堆顶数为所求 3、使用BFPRT算法，时间复杂度为O(N)
 */
public class FindKthNum {

	// 建立一个容量为k的大数堆
	public static int[] getMinKNumsByMaxHeap(int[] nums, int k) {
		if (k < 1 || k > nums.length) {
			return nums;
		}
		int[] maxHeap = new int[k];
		for (int i = 0; i < k; i++) {
			heapInsert(maxHeap, nums[i], i);
		}
		for (int i = k; i < nums.length; i++) {
			if (nums[i] < maxHeap[0]) {
				maxHeap[0] = nums[i];
				help(maxHeap, 0, k);
			}
		}
		return maxHeap;
	}

	public static void heapInsert(int[] maxHeap, int num, int index) {
		maxHeap[index] = num;
		while (index != 0) {
			int parent = (index - 1) / 2;
			if (maxHeap[parent] < maxHeap[index]) {
				swap(maxHeap, parent, index);
				index = parent;
			} else {
				break;
			}
		}
	}

	public static void help(int[] maxHeap, int index, int size) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largest = index;
		while (left < size) {
			if (maxHeap[left] > maxHeap[index]) {
				largest = left;
			}
			if (right < size && maxHeap[left] < maxHeap[right]) {
				largest = right;
			}
			if (largest != index) {
				swap(maxHeap, index, largest);
			} else {
				break;
			}
			index = largest;
			left = index * 2 + 1;
			right = index * 2 + 2;
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static int[] getMinKNumsByBFPRT(int[] arr, int k) {
		if (k < 1 || k > arr.length) {
			return arr;
		}
		int minKth = getMINthByBFPRT(arr, k);
		int[] res = new int[k];
		int index = 0;
		for (int i = 0; i != arr.length; i++) {
			if (arr[i] < minKth) {
				res[index++] = arr[i];
			}
		}
		for (; index != res.length; index++) {
			res[index] = minKth;
		}
		return res;
	}

	private static int getMINthByBFPRT(int[] arr, int k) {
		// TODO Auto-generated method stub
		int[] copyArr = copyArray(arr);
		return select(copyArr, 0, copyArr.length - 1, k - 1);
	}

	private static int select(int[] arr, int begin, int end, int i) {
		// TODO Auto-generated method stub
		if (begin == end) {
			return arr[begin];
		}
		int pivot = medianOfMedians(arr, begin, end);
		int[] pivotRange = partition(arr, begin, end, pivot);
		if (i >= pivotRange[0] && i <= pivotRange[1]) {
			return arr[i];
		} else if (i < pivotRange[0]) {
			return select(arr, begin, pivotRange[0] - 1, i);
		} else {
			return select(arr, pivotRange[1] + 1, end, i);
		}
	}

	private static int[] partition(int[] arr, int begin, int end, int pivot) {
		// TODO Auto-generated method stub
		int small = begin - 1;
		int cur = begin;
		int big = end + 1;
		while (cur != big) {
			if (arr[cur] < pivot) {
				swap(arr, ++small, cur++);
			} else if (arr[cur] > pivot) {
				swap(arr, cur, --big);
			} else {
				cur++;
			}
		}
		int[] range = new int[2];
		range[0] = small + 1;
		range[1] = big - 1;
		return range;

	}

	private static int medianOfMedians(int[] arr, int begin, int end) {
		// TODO Auto-generated method stub
		int num = end - begin + 1;
		int offset = num % 5 == 0 ? 0 : 1;
		int[] mArr = new int[num / 5 + offset];
		for (int i = 0; i < mArr.length; i++) {
			int beginI = begin + i * 5;
			int endI = beginI + 4;
			mArr[i] = getMedian(arr, beginI, Math.min(endI, end));
		}
		return select(mArr, 0, mArr.length - 1, mArr.length / 2);
	}

	private static int getMedian(int[] arr, int begin, int end) {
		// TODO Auto-generated method stub
		insertionSort(arr, begin, end);
		int sum = begin + end;
		int mid = (sum / 2) + (sum % 2);
		return arr[mid];
	}

	private static void insertionSort(int[] arr, int begin, int end) {
		// TODO Auto-generated method stub
		for (int i = begin + 1; i != end + 1; i++) {
			for (int j = i; j != begin; j--) {
				if (arr[j - 1] > arr[j]) {
					swap(arr, j - 1, j);
				} else {
					break;
				}
			}
		}
	}

	private static int[] copyArray(int[] arr) {
		// TODO Auto-generated method stub
		int[] res = new int[arr.length];
		for (int i = 0; i != res.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 8, 6, 1, 7,23,9,77,55};
		int[] a = getMinKNumsByMaxHeap(nums, 7);
		for (int c : a) {
			System.out.print(c + " ");
		}
		System.out.println();
		int[] b = getMinKNumsByBFPRT(nums, 7);
		
		for (int c : b) {
			System.out.print(c + " ");
		}
	}

}
