import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
    	if(nums.length==0) {
    		return new ArrayList<List<Integer>>();
    	}
    	List<List<Integer>> rls=new ArrayList<>();
    	getPermute(rls,nums,0);
    	return rls;        
    }
    
    public void swap(int[] nums,int i,int j) {
    	int temp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=temp;
    }
    
    public void getPermute(List<List<Integer>> rls,int[] nums,int start) {
    	if(start==nums.length-1) {
    		List<Integer> ls=new ArrayList<>();
    		for(int i=0;i<nums.length;i++) {
    			ls.add(nums[i]);
    		}
    		rls.add(ls);
    		return;
    	}
    	for(int j=start;j<nums.length;j++) {
    		swap(nums,start,j);
    		getPermute(rls,nums,start+1);
    		swap(nums,start,j);
    	}    	
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution46 s=new Solution46();
		int[]nums= {1,2,3};
		System.out.print(s.permute(nums));
	}
}
