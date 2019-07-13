
public class Solution35 {

	public Solution35() {
		// TODO Auto-generated constructor stub
	}
    public int searchInsert(int[] nums, int target) {
    	int left=0,right=nums.length-1;
    	if(nums.length<0) return 0;
    	while(left<=right) {
    		int mid=(right+left)/2;
    		if(nums[mid]==target) 
    			return mid;
    		else if(nums[mid]>target) {
    			right=mid-1;
    			mid=(left+right)/2;
    		}
    		else {
    			left=mid+1;
    			mid=(left+right)/2;
    		}
    		
    	}
		return right+1;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution35 s=new Solution35();
		int[] nums=new int[] {1,3,5,6};
		int target=4;
		System.out.print(s.searchInsert(nums, target));
	}

}
