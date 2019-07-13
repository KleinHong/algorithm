package com.Tree;
import java.util.HashMap;
import java.util.Map;

/**
 * hzy：jdk1.8
 */

/**
 * @author 残月
 * @descripition 给定一个二叉树和一个数sum，求解二叉树中数字之和为sum的最大深度，其中节点值value可以选择是否进行加法计算
 * @ieda 使用hashmap和二叉树的先序遍历辅助，使用变量maxlen保留当前最大的深度
 */
public class MaxLevelOfSumInTree {
	
	public static int getMaxLength(TreeNode head,int sum) {
		Map<Integer,Integer> map=new HashMap<>();
		map.put(0, 0);
		return preOrder(head,sum,0,1,0,map);
	}


	private static int preOrder(TreeNode head, int sum, int presum, int level, int maxlen, Map<Integer, Integer> map) {
		// TODO Auto-generated method stub
		if(head==null) {
			return maxlen;
		}
		int cursum=presum+head.value;
		if(!map.containsKey(cursum)) {
			map.put(cursum, level);
		}
		//当且仅当cursum和sum值相等时进入该if语句，该步骤中包含了前面的节点可取可不取
		if(map.containsKey(cursum-sum)) {
			maxlen=Math.max(maxlen, level-map.get(cursum-sum));
		}
		maxlen=preOrder(head.left, sum, cursum, level+1, maxlen, map);
		maxlen=preOrder(head.right, sum, cursum, level+1, maxlen, map);
		if(level==map.get(cursum)) {
			map.remove(cursum);
		}
		
		return maxlen;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode head=BuildTree.buildDemoTree();
		System.out.println(getMaxLength(head, 6));
		System.out.println(getMaxLength(head, -9));

	}

}
