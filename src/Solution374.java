
public class Solution374 {
	
	public int guessNumber(int n) {
		int left = 1;
		int right = n;

		while (left <= right) {
			int mid = left+(right-left) / 2;//两个int类型的数相加可能会产生溢出
			int tmp = guess(mid);
			if (tmp != 0) {
				if (tmp == -1)
					right = mid - 1;
				else
					left = mid + 1;
			} else {
				return mid;
			}
		}

		return 0;

	}

	private int guess(int mid) {
		// TODO Auto-generated method stub
		int pick=1702766719;
		if(mid>pick)
			return -1;
		if(mid<pick)
			return 1;
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution374().guessNumber(2126753390));
	}


}
