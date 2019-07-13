import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution748 {
	public String shortestCompletingWord(String licensePlate, String[] words) {
		if (licensePlate == null || words == null) {
			return null;
		}

		int[] match = getStr(licensePlate);
		int count=0;
		for(int c:match) {
			if(c>0) {
				count+=c;
			}
		}
		List<String> ls= new ArrayList<>();
		for(int i=0;i<words.length;i++) {
			if(isContain(words[i],match,count)) {
				ls.add(words[i]);
			}
		}
		Iterator<String> it=ls.iterator();
		String[] strs=new String[ls.size()];
		int index=0;
		while(it.hasNext()) {
			strs[index++]=it.next();
		}
		
		int min=Integer.MAX_VALUE;
		String res=null;
		for(String s:strs
				) {
			if(s.length()<min) {
				res=s;
				min=s.length();
			}
		}
		return res;
	}

	private boolean isContain(String str, int[] match, int count) {
		// TODO Auto-generated method stub
		Map<Character,Integer> map=new HashMap<>();
		for(int i=0;i<26;i++) {
			if(match[i]!=0) {
				char k=(char) ('a'+i);
				map.put(k,match[i]);
			}
		}
		
		for(int i=0;i<str.length();i++
				) {
			if(map.containsKey(str.charAt(i))) {
				int v=map.get(str.charAt(i));
				if(v>0) {
					count--;
				}
				map.put(str.charAt(i), --v);
			}
			else {
				map.put(str.charAt(i),-1);
			}
			
			if(count==0) {
				return true;
			}
		}
		return false;
		
		
	}

	private int[] getStr(String str) {
		// TODO Auto-generated method stub
		int[] nums = new int[26];
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)>='a' && str.charAt(i)<='z') {
				nums[str.charAt(i)-'a']++;
			}
			if(str.charAt(i)>='A' && str.charAt(i)<='Z') {
				nums[str.charAt(i)-'A']++;
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		Solution748 s748=new Solution748();
		String licString="an87005";
		String[] words= {"attack"};
		System.out.println(s748.shortestCompletingWord(licString, words));
	}
}
