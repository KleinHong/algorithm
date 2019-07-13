
public class Solution14 {

	public Solution14() {
		// TODO Auto-generated constructor stub
	}
    public String longestCommonPrefix(String[] strs) {
    	StringBuilder s1=new StringBuilder();
    	int[] len=new int[strs.length];
    	if(strs.length==0) return "";
    	int min=strs[0].length();
        for(int i=0;i<strs.length;i++) {
        	len[i]=strs[i].length();
        	if(min>len[i])
        		min=len[i];
        }
        for(int j=0;j<min;j++) {
        	char c=strs[0].charAt(j);
        	for(int k=0;k<strs.length;k++) {
        		if(c!=strs[k].charAt(j))
        			return s1.toString();	
        	}
        	s1.append(c);
        }
        return s1.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution14 a=new Solution14();
		String[] s=new String[] {"flower","flow","flight"};
		System.out.print(a.longestCommonPrefix(s));
	}

}
