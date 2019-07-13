
public class Solution45 {
	public int jump(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}

		int jump = 0;
		int cur = 0;
		int next = 0;
		for (int i = 0; i != nums.length; i++) {
			if (cur < i) { 
				jump++;     //cur����ǰ��Ծ��������ܵ����λ�ã����
				cur = next; //���ִܵﵱǰλ��i���������Ǳ������һ��			
			}
			//next������һ�����������λ�ã��������㷨�ľ���
			next = Math.max(next, i + nums[i]);
			
		}
		return jump;
	}

	public static void main(String[] args) {
		Solution45 s45 = new Solution45();
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(s45.jump(nums));
	}
}
