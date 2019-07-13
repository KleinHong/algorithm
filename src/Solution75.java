
public class Solution75 {
	public void sortColors(int[] nums) {
		if (nums == null || nums.length < 1) {
			return;
		}
		int l = 0, m = 0, r = nums.length - 1;
		while (m <= r) {
			if (m < l || nums[m] == 1) {
				m++;
			} else if (nums[m] == 0) {
				swap(nums, l++, m);
			} else {
				swap(nums, r--, m);
			}
		}
	}

	private void swap(int[] nums, int l, int r) {
		// TODO Auto-generated method stub
		if (l == r) {
			return;
		}
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0 };
		new Solution75().sortColors(nums);
	}
}
