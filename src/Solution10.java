
public class Solution10 {
	public boolean isMatch(String s, String p) {
//		if (p == null || p.length() < 1) {
//			return false;
//		}
//		return isValid(s, p) ? process(s, p, 0, 0) : false;
		return isValid(s, p) ? process(s, p) : false;

	}

	private boolean isValid(String s, String p) {
		// TODO Auto-generated method stub
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*' || s.charAt(i) == '.') {
				return false;
			}
		}

		for (int j = 0; j < p.length(); j++) {
			if (p.charAt(j) == '*' && (j == 0 || p.charAt(j - 1) == '*')) {
				return false;
			}
		}
		return true;
	}

//	// �ݹ����
//	private boolean process(String s, String p, int i, int j) {
//		// TODO Auto-generated method stub
//		if(j==p.length()) {
//			return i==s.length();
//		}
//		//�жϵ�ǰ�ַ���һ����Ϊ'*'�������
//		if((j+1)==p.length() ||p.charAt(j+1)!='*') {
//			return i!=s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.') 
//					&& process(s,p,i+1,j+1);
//		}
//		//��һ���ַ���*��
//		while(i!=s.length() && (p.charAt(j)==s.charAt(i) || p.charAt(j)=='.')) {
//			//�ַ���Ƭ���ƥ��+�жϺ����Ƿ�ƥ��
//			//��ƥ��ֱ�ӷ���true
//			//�������ַ������������Ŀ�������Ϊ���ԣ�ĳЩ����������ظ�����/
//			if(process(s,p,i,j+2)) {
//				return true;
//			}
//			//���õ�ǰ�ַ�
//			i++;		
//		}		
//		//��ǰp�ַ���s����ƥ�� 
//		return process(s,p,i,j+2);
//	}

	// ��̬�滮
	private boolean process(String s, String p) {

		if (!isValid(s, p)) {
			return false;
		}
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[s.length()][p.length()] = true;
		// �ų�s�Ѿ�ƥ���꣬����p��δƥ������������
		for (int j = p.length() - 2; j > -1; j = j - 2) {
			if (p.charAt(j) != '*' && p.charAt(j + 1) == '*') {
				dp[s.length()][j] = true;
			} else {
				break;
			}
		}
		if (s.length() > 0 && p.length() > 0) {
			if (p.charAt(p.length() - 1) == '.' || s.charAt(s.length() - 1) == p.charAt(p.length() - 1)) {
				dp[s.length() - 1][p.length() - 1] = true;
			}
		}
		for (int i = s.length() - 1; i > -1; i--) {
			for (int j = p.length() - 2; j > -1; j--) {
				if (p.charAt(j + 1) != '*') {
					dp[i][j] = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dp[i + 1][j + 1];
				} else {
					int si = i;
					while (si != s.length() && (s.charAt(si) == p.charAt(j) || p.charAt(j) == '.')) {
//						System.out.println(si);
//						System.out.println(j);
						if (j <= (p.length() - 2) && dp[si][j + 2]) {
							dp[i][j] = true;
							break;
						}
						si++;
					}

					if (dp[i][j] != true) {
						dp[i][j] = dp[si][j + 2];
					}

				}
			}
		}
		return dp[0][0];

	}

	public static void main(String[] args) {
		String s = "ab";
		String p = ".*c";
		System.out.println(new Solution10().isMatch(s, p));
	}
}
