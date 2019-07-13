
public class Solution402 {
	// 对于数字num，去掉其中k个数字后剩下的数字a1a2a3a4...an要想最小，必须满足
	// a1<a2<a3<...<an个
	@SuppressWarnings("unused")
	public String removeKdigits(String num, int k) {
		if (num == null || num.length() <= k || k < 0) {
			return "0";
		}
		int newlen = num.length() - k;
		char[] tmp = new char[num.length()];
		int index = 0;
		for (int i = 0; i < num.length(); i++) {

			while (index > 0 && (num.charAt(i) < tmp[index - 1]) && k > 0) {
				index--;
				k--;
			}

			tmp[index++] = num.charAt(i);
		}

		
		int count = 0;
		while (count < newlen && tmp[count] == '0') {
			count++;
		}
		return newlen==count?"0":new String(tmp,count,newlen-count);

	}

	public static void main(String[] args) {
		String num = "1234567890";
		System.out.println(new Solution402().removeKdigits(num, 1));
	}
}
