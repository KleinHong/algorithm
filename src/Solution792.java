import java.util.LinkedList;

public class Solution792 {
    

	@SuppressWarnings("unchecked")
	public int numMatchingSubseq(String S, String[] words) {

		@SuppressWarnings("rawtypes")
		LinkedList[] map=new LinkedList[26];
    	for(int i=0;i<26;i++) {
    		map[i]=new LinkedList<myMap>();
    	}
    	for(int i=0;i<words.length;i++) {
    		map[words[i].charAt(0)-'a'].add(new myMap(i, 1));
    	}
    	
    	int res=0;
    	for(int j=0;j<S.length();j++) {
    		char cur=S.charAt(j);
    		int index=cur-'a';
    		LinkedList<myMap> ls=map[index];
    		map[index]=new LinkedList<myMap>();
    		while(!ls.isEmpty()) {
    			myMap mm=ls.pollFirst();
    			int num=mm.v;
    			if(words[mm.k].length()<=mm.v) {
    				res++;
    				continue;
    			}else {
    				mm.v=mm.v+1;
    			}
    			map[words[mm.k].charAt(num)-'a'].add(mm);    			
    		}
    	}
    	return res;
        
    }
    
    class myMap{
    	public int k;
    	public int v;
    	public myMap(int k,int v) {
    		this.k=k;
    		this.v=v;
    	}
    }
    
    public static void main(String[] args) {
		String S="abcde";
		String[] words= {"a","bb","acd","ace"};
		Solution792 s792=new Solution792();
		System.out.println(s792.numMatchingSubseq(S, words));
				
	}
}
