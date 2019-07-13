
public class Solution8 {

	public Solution8() {
		// TODO Auto-generated constructor stub
	}

	public int myAtoi(String str) {
		if(str.isEmpty()) return 0;
		int len=str.length(),sign=1,ret=0;//sign存储符号位，ret保存返回值
		int i=0;
		while(i<len && str.charAt(i)==' ')
			++i;
		//if(i<len &&((str.charAt(i)>='0' && str.charAt(i)<='9') || str.charAt(i)=='-'))
		//if(i<len &&(str.charAt(i)=='+' || str.charAt(i)=='-'))
		if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-'))
			sign=(str.charAt(i++)=='-')?-1:1;
		while(i<len && str.charAt(i)>='0' && str.charAt(i)<='9') {
			if(ret>Integer.MAX_VALUE/10 || (ret==Integer.MAX_VALUE/10 && str.charAt(i)-'0'>7))
				return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
			ret=10*ret+(str.charAt(i++)-'0'); //由于获取的是ascll值需要进行转化						
		}
		return ret*sign;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "42CODEISHIRING";
		Solution8 a = new Solution8();
		int n = a.myAtoi(s);
		System.out.print(n);
	}

}
