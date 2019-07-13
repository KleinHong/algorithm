package com.Tree;
import java.io.ObjectInputStream.GetField;

import javax.annotation.PostConstruct;

/**
 * hzy��jdk1.8
 */

/**
 * @author ����
 * @descripition ���Ҷ��������е����������������
 * @ieda ����������������ۣ�1��������Խڵ�node���������������������node.leftΪͷ�ģ��������ĵ��������������node.right 
 * @ieda Ϊͷ�ڵ�ģ���ô��nodeΪ�ڵ�Ķ�������һ��������������
 * @ieda 2������������һ���������ô�ʹ�node�����������������еݹ�Ѱ�Ҷ����������������ؽڵ���Ŀ�϶���Ǹ�������������ͷ���
 * @ieda ����ʵ�ֲ��裺
 * @ieda a������ʹ�ö������ĺ������
 * @ieda b���������ڵ�cur���ȱ���cur������������¼�ĸ���������¼��������ͷ��㡢�������Ľڵ�������Сֵ�����ֵ��Ȼ���ڼ�¼��������
 * @ieda �ĸ�����
 * @ieda c��ͨ��b�����¼���ĸ��������ؽڵ����Ƚϴ�Ķ���������
 * @ieda d������ʹ��ȫ�ֱ���ʵ�ֲ���b���ռ�����������
 *   
 *    
 * 
 */
public class BiggestSubBST {
	
	public static TreeNode biggestSubBST(TreeNode head) {
		int[] record=new int[3];//��¼��ǰ�ڵ�������������ͷ��㡢�ڵ��������ֵ����Сֵ
		return posOrder(head,record);
		
	}

	private static TreeNode posOrder(TreeNode head, int[] arr) {
		// TODO Auto-generated method stub
		
		if(head ==null){
			arr[0]=0;
			arr[1]=Integer.MAX_VALUE;
			arr[2]=Integer.MIN_VALUE;
			return null;
		}
		int value=head.value;
		TreeNode left=head.left;
		TreeNode right=head.right;
		TreeNode lBST=posOrder(left, arr);
		int lSIZE=arr[0];
		int lMIN=arr[1];
		int lMAX=arr[2];
		TreeNode rBST=posOrder(right, arr);
		int rSIZE=arr[0];
		int rMIN=arr[1];
		int rMAX=arr[2];
		arr[1]=Math.min(lMIN, value);
		arr[2]=Math.max(lMAX, value);
		if(left==lBST && right==rBST && lMAX<value && value<rMIN) {
			arr[0]=lSIZE+rSIZE+1;
			return head;
		}
		arr[0]=Math.max(lSIZE, rSIZE);
		
		return lSIZE>rSIZE?lBST:rBST;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode head=new TreeNode(6);
		TreeNode cur=head;
		cur.left=new TreeNode(1);
		cur.left.left=new TreeNode(0);
		cur.left.right=new TreeNode(3);
		cur.right=new TreeNode(12);
		cur.right.left=new TreeNode(10);
		cur.right.left.left=new TreeNode(4);
		cur.right.left.left.left=new TreeNode(2);
		cur.right.left.left.right=new TreeNode(5);
		cur.right.left.right=new TreeNode(14);
		cur.right.left.right.left=new TreeNode(11);
		cur.right.left.right.right=new TreeNode(15);
		cur.right.right=new TreeNode(13);
		cur.right.right.left=new TreeNode(20);
		cur.right.right.right=new TreeNode(16);
		
//		PrintTree.printTree(head);
//		System.out.println();
		TreeNode res=biggestSubBST(head);
		PrintTree.printTree(res);
		

	}

}
