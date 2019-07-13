import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution950 {
	public int[] deckRevealedIncreasing(int[] deck) {
		if (deck == null || deck.length < 0) {
			return null;
		}
		Arrays.sort(deck);
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = deck.length - 1; i > -1; i--) {
			queue.add(deck[i]);
			if (queue.size() == deck.length)
				break;
			int tmp = queue.poll();
			queue.add(tmp);

		}
//		System.out.println(queue);
		int[] res = new int[deck.length];
		int index = deck.length - 1;
		while (!queue.isEmpty()) {
			res[index--] = queue.poll();
		}
		return res;
	}

	public static void main(String[] args) {
		int[] deck = { 17, 13, 11, 2, 3, 5, 7 };
		System.out.println(new Solution950().deckRevealedIncreasing(deck));
	}
}
