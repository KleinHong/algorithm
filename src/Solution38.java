
public class Solution38 {

	public Solution38() {
		// TODO Auto-generated constructor stub
	}
	public String countAndSay(int n) {
    	String str="1";
    	if(n<=0) return null;
    	//if(n==1) return str;
    	for(int i=0;i<n-1;i++){
        	StringBuilder s = new StringBuilder() ;
			int j=0;
    		while(j<str.length()) {
    			int count=1;
    			while(j<str.length()-1 && str.charAt(j)==str.charAt(j+1)) {
    				++count;
    				j++;
    			}
    			s.append(count).append(str.charAt(j));
    			j++;
    		}
    		str=s.toString();
    		System.out.println(str);
    	}
		return str;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution38 s=new Solution38();
		int n=4;
		s.countAndSay(n);
	}
}
