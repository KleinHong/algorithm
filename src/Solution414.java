import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution414 {
	public int thirdMax(int[] nums) {

		if (nums == null || nums.length < 1) {
			throw new RuntimeException("当前数组为空");
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		int size;
		if (nums.length < 3) {
			size = 1;
		} else {
			size = 3;
		}
		int index = 0;
		while (minHeap.size() != size && index<nums.length) {
			if (!set.contains(nums[index])) {
				set.add(nums[index]);
				minHeap.offer(nums[index++]);
			} else {
				index++;
			}

		}
		for (int i = index; i < nums.length; i++) {
			if (nums[i] > minHeap.peek() && !set.contains(nums[i])) {
				minHeap.poll();
				minHeap.offer(nums[i]);
				set.add(nums[i]);
			}
		}
		if(minHeap.size()!=3) {			
			while(minHeap.size()!=1) {
				minHeap.poll();
			}
		}
		return minHeap.peek();
		
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		System.out.println(new Solution414().thirdMax(nums));
	}
}
