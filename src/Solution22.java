
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution22 {
    public List<String> generateParenthesis(int n) {
    	int l=0,r=0;
    	List<String> ls=new ArrayList<>();
    	generate(ls,"",l,r,n);
    	return ls;
    }
    public void generate(List<String> ls,String temp,int l,int r,int max){
    	if(temp.length()==2*max) {
    		ls.add(temp);
    		return;
    	}
    	if(l<max) {
    		generate(ls,temp+"(",l+1,r,max);
    	}
    	if(r<l) {
    		generate(ls,temp+")",l,r+1,max);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution22 g=new Solution22();
		System.out.print(g.generateParenthesis(2));
	}

}
