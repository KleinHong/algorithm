
public class Solution492 {
    public int[] constructRectangle(int area) {
        if(area<1) {
        	return null;
        }
        int tmp=(int) Math.sqrt(area);
        int l=tmp;
        int w=tmp;
        int curArea=l*w;
        while(curArea!=area) {
        	if(curArea>area) {
        		w--;
        	}else {
        		l++;
        	}
        	curArea=l*w;
        }
        int[] res= {l,w};
        return res;
    }
    
    public static void main(String[] args) {
		Solution492 s492 =new Solution492();
		int[] arr=s492.constructRectangle(22);
		for(int c:arr) {
			System.out.print(c+" ");
		}
	}
}
