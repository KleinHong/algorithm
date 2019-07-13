import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

public class Solution870 {
//	public int[] advantageCount(int[] A, int[] B) {
//		if (A == null || B == null || A.length != B.length) {
//			return null;
//		}
//		PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
//		PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				return o2-o1;
//			}
//		});
//		for(int c:A) {
//			minHeap.add(c);
//		}
//		
//		for(int i=0;i<B.length;i++) {
//			while(!maxHeap.isEmpty() && maxHeap.peek()>B[i]) {
//				minHeap.add(maxHeap.poll());
//			}
//			while(!minHeap.isEmpty() && minHeap.peek()<=B[i]) {
//				maxHeap.add(minHeap.poll());
//			}
//			if(minHeap.isEmpty()) {
//				A[i]=-1;
//				continue;
//			}
//			A[i]=minHeap.poll();
//			
//		}
//		for(int i=0;i<B.length;i++) {
//			if(A[i]==-1) {
//				if(!minHeap.isEmpty()) {
//					A[i]=minHeap.poll();
//				}else {
//					A[i]=maxHeap.poll();
//				}
//			}
//		}
//		return A;
//		
//	}

	
//	public int[] advantageCount(int[] A, int[] B) {
	@Test
	public void advantageCount() {
		int[] A= {2,0,4,1,2,55};
		int[] B= {1,3,0,0,2,44};
		if (A == null || B == null || A.length != B.length) {
			return;
		}
		int[] tmpB = Arrays.copyOf(B, B.length);
		Map<Integer, LinkedList<Integer>> map = new HashMap<>();
		Arrays.sort(A);
		Arrays.sort(tmpB);
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue1 = new LinkedList<Integer>();
		for (int c : A) {
			queue.add(c);
		}
		int i=0;
		for (;i<tmpB.length;i++) {
			int num = queue.poll();
			while (!queue.isEmpty() && num <= tmpB[i]) {
				queue1.add(num);
				num = queue.poll();
			}
			if(!map.containsKey(tmpB[i])) {
				map.put(tmpB[i], new LinkedList<Integer>());
			}
			map.get(tmpB[i]).add(num);
			if(queue.isEmpty()) {
				break;
			}
		}
		while(!queue1.isEmpty()) {
			if(!map.containsKey(tmpB[++i])) {
				map.put(tmpB[i], new LinkedList<Integer>());
			}
			map.get(tmpB[i]).add(queue1.poll());
		}

		for (int j = 0; j < B.length; j++) {
			A[j] = map.get(B[j]).pollFirst();
		}
		for (int c : A) {
			System.out.print(c + " ");
		}
//		return A;
	}

//	public static void main(String[] args) {
//		int[] A= {2,0,4,1,2};
//		int[] B= {1,3,0,0,2};
//		int[] res = new Solution870().advantageCount(A, B);
//		for (int c : res) {
//			System.out.print(c + " ");
//		}
//	}
}
