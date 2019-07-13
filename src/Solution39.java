import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<Integer> ls=new ArrayList<>();
    	List<List<Integer>> rlist=new ArrayList<>();
    	if(candidates.length==0 || target<0)
        	return rlist;
    	Arrays.sort(candidates);
    	getList(rlist,ls,candidates,target,0);
    	return rlist;
    }
    
    public void getList(List<List<Integer>> rlist,List<Integer> ls,int[] candidates,int target,int temp){
    	if(target==0) {
    		rlist.add(ls);
    	}
    	if(target<candidates[temp])
    		return;
    	for(int i=temp;i<candidates.length && candidates[i]<=target;i++) {
    		//target-=candidates[i];
    		List<Integer> lstemp=new ArrayList<>(ls);
    		lstemp.add(candidates[i]);
    		getList(rlist,lstemp,candidates,target-candidates[i],i);
    	}
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution39 s=new Solution39();
		int [] nums= {2,3,4};
		System.out.print(s.combinationSum(nums, 8).toString());
	}

}
