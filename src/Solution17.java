import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
    	List<String> ls=new ArrayList<>();
    	if(digits.isEmpty())return ls;
    	String[] map= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    	int i=0;
    	ls=random(digits,map,ls,0,"");
    	return ls;      
    }
    public List<String> random(String str,String[] m,List<String> l,int i,String stemp) {
    	if(i<str.length()-1) {
    		for(int j=0;j<m[str.charAt(i)-'0'].length();j++) {
    			l=random(str,m,l,i+1,stemp+m[str.charAt(i)-'0'].charAt(j));
    		}
    	}
    	else {
    		for(int k=0;k<m[str.charAt(i)-'0'].length();k++) {
    			l.add(stemp+m[str.charAt(i)-'0'].charAt(k));
    		}
    	}
    	return l;
    	
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="";
		Solution17 a=new Solution17();
		System.out.println(a.letterCombinations(s));

	}

}
