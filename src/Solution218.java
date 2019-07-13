import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution218 {
	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> rls = new LinkedList<>();
		if (buildings == null || buildings.length < 1 || buildings[0].length < 1) {
			return rls;
		}
		PriorityQueue<Record> queue = new PriorityQueue<>(new Comparator<Record>() {

			@Override
			public int compare(Record o1, Record o2) {
				// TODO Auto-generated method stub
				if (o1.pos != o2.pos) {
					return o1.pos - o2.pos;
				} else if (o1.height != o2.height) {
					return o1.height - o2.height;
				} else {
					return 0;
				}
			}
		});

		for (int[] arr : buildings) {
			queue.add(new Record(arr[0], -arr[2]));
			queue.add(new Record(arr[1], arr[2]));
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
		maxHeap.offer(0);//保证了数组中间出现0的情况和结尾必须有0的情况；
		int pre = maxHeap.peek();
		while (!queue.isEmpty()) {
			Record cur = queue.poll();
			if (cur.height < 0) {
				maxHeap.offer(-cur.height);
			} else {
				maxHeap.remove(cur.height);
			}
			int curHeight = maxHeap.peek();
			if (curHeight != pre) {
				List<Integer> ls = new LinkedList<Integer>();
				ls.add(cur.pos);
				ls.add(curHeight);
				rls.add(ls);
				pre=curHeight;
			}
		}
		return rls;

	}

	class Record {
		public int pos;
		public int height;

		public Record(int pos, int height) {
			this.pos = pos;
			this.height = height;
		}
	}
	
	public static void main(String[] args) {
		int[][] builds= {{2, 9, 10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
		Solution218 s218=new Solution218();
		System.out.println(s218.getSkyline(builds));
	}
}
