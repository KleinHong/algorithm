import java.util.Stack;

public class Solution20 {

	public Solution20() {
		// TODO Auto-generated constructor stub
	}
    public boolean isValid(String s) {
    	boolean flag=false;
    	int len=s.length();
    	Stack<Character> st=new Stack<Character>();    	
    	if(len==0)return flag;
    	
    	for(int i=0;i<len;i++) {
    		if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{') {
    			st.push(s.charAt(i));
    		}
    		else {
    			if(st.isEmpty()) return flag;
    			if(s.charAt(i)==')' && st.peek()!='(') return flag;
    			if(s.charAt(i)==']' && st.peek()!='[') return flag;
    			if(s.charAt(i)=='}' && st.peek()!='{') return flag;
    			st.pop();
    		}    		 
    	}    	
    	
    	return st.isEmpty();      
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution20 a=new Solution20();
		String s="{{[()]}}";
		System.out.print(a.isValid(s));
	}

}
