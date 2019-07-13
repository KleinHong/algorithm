import java.util.HashMap;
import java.util.Map;

public class Solution29 {
	public static int add(int m,int n) {
		long num=m^n;
		long temp=m&n;
		while(temp!=0) {
			long a=num;
			temp<<=1;
			num^=temp;
			temp&=a;
		}
		if(num>Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        else if(num<Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        else
        	return (int)num;
		
	}
	
	public static int subtraction(int subtrahend,int subtraction) {
		return add(subtrahend,add(~subtraction,1));
	}
	public static int mutiply(int m, int n) {
		long m1=Math.abs(m),m2=Math.abs(n);
		long sign=((m1<0)^(m2<0))?-1:1;
		int num=0;
		Map<Integer,Integer> map=new HashMap<>();
		map.put(1, 0);
		while(m2>0) {
			long count=1;
			while((m2&1)==0) {
				++count;
				m2=m2>>1;
			}			
			map.replace(1, (int) (map.get(1)+count));
			num+=(m1<<(map.get(1))-1);
			m2>>=count;
		}
		if(sign*num>Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        else if(sign*num<Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        else
    		return (int)(sign*num);
	}
	
    public static int divide(int dividend, int divisor) {
        if(divisor==0)
        	return Integer.MAX_VALUE;
        long d1=Math.abs((long)dividend);
        long d2=Math.abs((long)divisor);
        long div=0;
        long sign=((dividend<0)^(divisor<0))?-1:1;
        while(d1>=d2) {
        	long tem=d2,t=1;
        	while(d1>(tem<<1)) {
        		tem<<=1;
        		t<<=1;
        	}
        	div+=t;
        	d1-=tem;
        	
        }
        if(sign*div>Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        else if(sign*div<Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        else
    		return (int)(sign*div);

    }
    
	public static void main(String[] args) {
		Solution29 s=new Solution29();
		//System.out.print(s.divide(-2147483648,-1));
		System.out.print(add(2147483646,10));
		System.out.println();
		System.out.print(subtraction(10,20));
		System.out.println();
		System.out.print(mutiply(11,11));
		System.out.println();
		System.out.print(add(10,10));
	}
    
}
