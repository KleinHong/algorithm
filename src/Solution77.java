import java.util.ArrayList;
import java.util.List;

public class Solution77 {
	
    public List<List<Integer>> combine(int n, int k) {
    	List<Integer> ls=new ArrayList<>();
    	List<List<Integer>> rls=new ArrayList<>();
    	if(n<1 || k<1)
    		return rls;
    	getCombine(rls,ls,n,k,1);
    	return rls;
    	
    	
        
    }
    
    public void getCombine(List<List<Integer>> rls,List<Integer> tmp,int n,int k,int num) {
    	if(tmp.size()==k) {
    		List<Integer> tmp1=new ArrayList<>(tmp);
    		rls.add(tmp1);
    		return;
    	}
    	for(int i=num;i<=n;i++) {
//    		if(num>n-k+2)
//    			break;
    		tmp.add(i);
    		getCombine(rls,tmp,n,k,i+1);
    		tmp.remove(tmp.size()-1);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution77 s=new Solution77();
		s.combine(4, 4);
	}

}
