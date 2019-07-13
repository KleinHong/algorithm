import java.util.Arrays;

public class Solution135 {

	public Solution135() {
		// TODO Auto-generated constructor stub
	}
//    public int candy(int[] ratings) {
//    	int len=ratings.length;
//    	int num=0;
//    	int[] temp1=new int[len];
//    	int[] temp2=new int[len];
//    	for(int i=0;i<len;i++) {
//    		temp1[i]=1;
//    		temp2[i]=1;
//    	}
//    	if(ratings.length<1) return 0;
//    	for(int i=0;i<len-1;i++) {
//    		if(ratings[i+1]>ratings[i]) {
//    			temp1[i+1]=temp1[i]+1;
//    		}
//    	}
//    	for(int i=len-2;i>=0;i--) {
//    		if(ratings[i]>ratings[i+1]) {
//    			temp2[i]=temp2[i+1]+1;
//    		}      
//    }
//    	for(int i=0;i<len;i++) {
//    		num+=Math.max(temp1[i], temp2[i]);
//    	}
//    	return num;
//
//}
    public int candy(int[] ratings) {
        int sum = 0;
        int[] left2right = new int[ratings.length];
        int[] right2left = new int[ratings.length];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }
    
    public static void main(String[] args) {
    	int[] a= {1,2,87,87,2,1};
    	Solution135 s=new Solution135();
    	System.out.print(s.candy(a));
    }
}
