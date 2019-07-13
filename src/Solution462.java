import java.util.Arrays;

public class Solution462 {
    public int minMoves2(int[] nums) {
        if(nums==null ||nums.length<=1) {
        	return 0;
        }
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;
        //使用中位数进行求解，由于最终操作后所有元素
        //相同，假设最终元素是x，则nums[l]和nums[r]移动
        //步骤为x-nums[l]+nums[r]-x=nums[r]-nums[l]
        int moves=0;
        while(l<r) {
        	moves+=nums[r--]-nums[l++];
        }
        
        return moves;
    }
    
    public static void main(String[] args) {
		Solution462 s462  =new Solution462();
		int[] nums= {1,2,3};
		System.out.println(s462.minMoves2(nums));
	}
}
