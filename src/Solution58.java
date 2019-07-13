
public class Solution58 {
	public int lengthOfLastWord(String s) {
		if (s == null | s.length() < 1) {
			return 0;
		}
		String[] strs = s.split(" ");
		if(strs.length==0) {
			return 0;
		}
		return strs[strs.length - 1].length();

	}

	public static void main(String[] args) {
//		String s = "Hello Word!";
		String s = "   ";
		Solution58 s58 = new Solution58();
		System.out.println(s58.lengthOfLastWord(s));

	}
}
