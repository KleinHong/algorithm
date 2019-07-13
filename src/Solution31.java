

public class Solution31 {
	public void nextPermutation(int[] nums) {
		int len = nums.length;
		int i = len - 2;
		while (i >= 0 && nums[i] >= nums[i+1]) {
			i--;
		}
		if (i >= 0) {
			int j=len-1;
			while(j>i && nums[i]>nums[j])
				j--;
			swap(nums,i,j);
		}
		reverse(nums, i + 1, len - 1);
		for(int k=0;k<nums.length;k++) {
			System.out.print(nums[k]);
		}
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void reverse(int[] nums, int m, int n) {
		while (m < n) {
			swap(nums, m, n);
			m++;
			n--;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution31 s=new Solution31();
		int[] nums=new int[] {2,3,1};
		s.nextPermutation(nums);

	}
}
