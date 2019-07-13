
public class Solution12 {
    public String intToRoman(int num) {
    	int[] index_num= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    	String[] index_char= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    	StringBuilder str=new StringBuilder();
		int i=0;
    	while(num!=0 && i<index_num.length) {
    		if(num-index_num[i]>=0) {
    			num-=index_num[i];
    			str.append(index_char[i]);
    		}
    		else
    			i++;
    	}
        return str.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=994;
		Solution12 s=new Solution12();
		System.out.println(s.intToRoman(num));

	}

}
