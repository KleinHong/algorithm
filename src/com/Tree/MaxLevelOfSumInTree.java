package com.Tree;
import java.util.HashMap;
import java.util.Map;

/**
 * hzy��jdk1.8
 */

/**
 * @author ����
 * @descripition ����һ����������һ����sum����������������֮��Ϊsum�������ȣ����нڵ�ֵvalue����ѡ���Ƿ���мӷ�����
 * @ieda ʹ��hashmap�Ͷ��������������������ʹ�ñ���maxlen������ǰ�������
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
		//���ҽ���cursum��sumֵ���ʱ�����if��䣬�ò����а�����ǰ��Ľڵ��ȡ�ɲ�ȡ
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
