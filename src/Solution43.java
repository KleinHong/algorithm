

public class Solution43 {
	
	public String multiply(String num1, String num2) {
		char[] s1=num1.toCharArray();
		char[] s2=num2.toCharArray();
		int[] result=new int[s1.length+s2.length];
		for(int i=s1.length-1;i>-1;i--) {
			for(int j=s2.length-1;j>-1;j--) {
				int index_cur=i+j+1;
				int index_pre=i+j;
				int curnum=(s2[j]-'0')*(s1[i]-'0')+result[index_cur];
				result[index_cur]=curnum%10;
				result[index_pre]+=curnum/10;
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for(int c:result) {
			sb.append(c);
		}
		int index=0;
		while(index<sb.length()-1 && sb.charAt(index)=='0') {
			index++;
		}
		return sb.toString().substring(index);
		
	}
	
	
	public static void main(String[] args) {
		Solution43 s43=new Solution43();
		System.out.println(s43.multiply("9", "99"));
	}
}
