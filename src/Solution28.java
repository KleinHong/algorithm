
public class Solution28 {

	public Solution28() {
		// TODO Auto-generated constructor stub
	}
    public int strStr(String haystack, String needle) {
    	int left;
    	int len1=haystack.length(),len2=needle.length();
    	if(len1<0 || len2<0 || len2>len1)
    		return -1;
    	for(left=0;left<(len1-len2+1);left++) {
    		int j=0;
    		for(j=0;j<len2;j++) {
    			if(haystack.charAt(left+j)!=needle.charAt(j)) {
    				break;
    			}
    		}
    		if(j==len2)
    			return left;
    	}
		return -1;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {3,2,2,3};
		Solution28 s=new Solution28();
		//s.removeDuplicates(nums);
		System.out.print(s.strStr("hello", "ll"));
	}

}
