
public class Solution50 {
    public double myPow(double x, int n) {
        if(x>100 || x<-100)
        	return 0;
        if(n==0)
        	return 1;
        if(n>0)
        	return mutiply(x,n);
        else
        	return  mutiply(1/x,-n);
    }
    
    public double mutiply(double x,int n) {
    	if(n==0)
    		return 1;
    	if(n==1)
    		return x;
    	double res=x*x;
    	if(n%2==1) {
    		x=x*mutiply(res,n/2);
    	}
    	if(n%2==0) {
    		x=mutiply(res,n/2);
    	}
    	return x;
    		
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution50 s=new Solution50();
		System.out.print(s.myPow(1.00012, 1024));
	}
}
