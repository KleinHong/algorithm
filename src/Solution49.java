import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> rls=new ArrayList<>();
        if(strs.length==0)
        	return rls;
        Map<String,List<String>> map=new HashMap<>();
        int[] c=new int[26];
        for(int i=0;i<strs.length;i++) {
        	 Arrays.fill(c, 0);//放在循环中，每遍历一个字符串将字符数组个数清零
        	 for(char count:strs[i].toCharArray())
        		 c[count-'a']++;  
        	 StringBuilder sb=new StringBuilder();
        	 for(int j=0;j<26;j++) {
        		 sb.append("$");
        		 sb.append(c[j]);       		 
        	 }
        	 if(!map.containsKey(sb.toString()))
        		 map.put(sb.toString(), new ArrayList<String>());
        	 map.get(sb.toString()).add(strs[i]);        	 
        }
        return new ArrayList<List<String>>(map.values());        
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution49 s=new Solution49();
		String[] strs= {"eat","tea","tan","ate","nat","bat"};
		System.out.print(s.groupAnagrams(strs));
	}
    
}
