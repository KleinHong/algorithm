
public class Solution44 {
	public boolean isMatch(String s, String p) {
		if (s.equals("") && p.equals("")) {
			return true;
		}
		if (p.equals("*")) {
			return true;
		}
		boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i <= p.length(); i++) {
			if (p.charAt(i - 1) == '*') {
				dp[i][0] = dp[i - 1][0];
			}
		}
		for (int i = 1; i <= p.length(); i++) {
			for (int j = 1; j <= s.length(); j++) {
				if (p.charAt(i - 1) == '*') {
					dp[i][j] = dp[i][j - 1] || dp[i-1][j];  //��p[i-1]==*ʱ��dp[i][j]��״̬ȡ����p��ǰi-1���ַ����ܲ���ƥ��s[j]֮ǰ���ַ�
															//����p��ǰi�ַ����ܲ���ƥ��s��j-1λ֮ǰ���ַ�
				} else {
					dp[i][j] = (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') && dp[i - 1][j - 1];
				}
			}
		}
		
		return dp[p.length()][s.length()];
	}

	public static void main(String[] args) {
		String s="acdcb";
		String p = "a*c*b";
		Solution44 s44=new Solution44();
		System.out.println(s44.isMatch(s, p));
	}
}
