
public class Solution88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		if (nums1 == null || nums2 == null) {
			nums1 = (nums1 == null) ? nums2 : nums1;
		}
//		int i = 0;
//		int j = 0;
//		int[] tmp = new int[m];
//		for (int k = 0; k < m; k++) {
//			tmp[k] = nums1[k];
//		}
//		int index = 0;
//		while (index < (m + n)) {
//			while (i < m && j < n) {
//				if (tmp[i] < nums2[j]) {
//					nums1[index++] = tmp[i++];
//				} else {
//					nums1[index++] = nums2[j++];
//				}
//			}
//			while (i < m) {
//				nums1[index++] = tmp[i++];
//			}
//			while (j < n) {
//				nums1[index++] = nums2[j++];
//			}
//		}
		
		int index=m+n-1;
		int i=m-1;
		int j=n-1;
		while(index>-1) {
			while(i>-1 && j>-1) {
				if(nums1[i]>nums2[j]) {
					nums1[index--]=nums1[i--];
				}else {
					nums1[index--]=nums2[j--];
				}
			}
			
			while(i>-1) {
				nums1[index--]=nums1[i--];
			}
			while(j>-1) {
				nums1[index--]=nums2[j--];
			}
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = { 2, 5, 6 };
		Solution88 s88 = new Solution88();
		s88.merge(nums1, 3, nums2, 3);
		for (int c : nums1) {
			System.out.print(c + " ");
		}
	}

}
