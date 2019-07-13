
public class Solution6 {

	public String convert(String s, int numRows) {		
		int len=s.length();
		StringBuilder tem = new StringBuilder();
		int k=2*numRows-2;
		if(len<=1) return s;
		for(int i=0;i<numRows;i++)	{
			for(int j=0;i+j<len;j+=k) {
				tem.append(s.charAt(j + i));
				if(i!=0 && i!=numRows-1 && j+k-i<len) {
					tem.append(s.charAt(j+k-i));
				}
			}
						
			
		}
				


		return tem.toString();
		
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="LEETCODEISHIRING";
		Solution6 a=new Solution6();
		String n=a.convert(s, 3);
		System.out.print(n);
	}

}
