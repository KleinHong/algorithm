import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1046 {
	public int lastStoneWeight(int[] stones) {
		if (stones == null || stones.length < 1) {
			return 0;
		}
		if (stones.length == 1) {
			return stones[0];
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});

		for (int c : stones) {
			maxHeap.add(c);
		}

		while (maxHeap.size() >=2) {
			int w1 = maxHeap.poll();
			int w2 = maxHeap.poll();
			if (w1 != w2) {
				maxHeap.offer(w1 - w2);
			}
		}
		
		if(maxHeap.isEmpty()) {
			return 0;
		}else {
			return maxHeap.poll();
		}
	}
	
	public static void main(String[] args) {
		Solution1046 s1046=new Solution1046();
		int [] nums= {2,7,4,1,8,1};
		System.out.println(s1046.lastStoneWeight(nums));
	}
}
