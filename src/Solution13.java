import java.util.HashMap;
import java.util.Map;

public class Solution13 {

	public Solution13() {
		// TODO Auto-generated constructor stub
	}
    public int romanToInt(String s) {
    	if(s.length()==0)return 0;
    	Map<Character,Integer> map=new HashMap<>();
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);
		
		int i=0,num=0,tem=0;
		while(i<s.length()) {
			tem=map.get(s.charAt(i));
			int j=i+1;
			if((j<s.length()) && (tem<map.get(s.charAt(j)))) {
				num=num-tem;
			}
			else
				num=num+tem;
			++i;
		}
		//num=num+map.get(s.charAt(s.length()-1));
		return num;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution13 a=new Solution13();
		System.out.print(a.romanToInt("MCMXCIV"));

	}

}
