public class Solution11 {

	public Solution11() {
		// TODO Auto-generated constructor stub
	}
    public int maxArea(int[] height) {
    	int start=0,end=height.length-1;
    	int area=0;
    	while(start<end) {
    		area=Math.max(area, (end-start)*Math.min(height[start], height[end]));
    		if(height[start]<height[end])
    			start++;
    		else
    			end--;
    		
    	}
    	return area;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution11 a=new Solution11();
		int[] height= {1,8,6,2,5,4,8,3,7};
		System.out.print(a.maxArea(height));

	}

}
