package com.Tree;
import java.io.ObjectInputStream.GetField;

import javax.annotation.PostConstruct;

/**
 * hzy：jdk1.8
 */

/**
 * @author 残月
 * @descripition 查找二叉树数中的最大搜索二叉子树
 * @ieda 分两种情况进行讨论：1、如果来自节点node左子树的最大搜索树是以node.left为头的，右子树的的最大搜索树是以node.right 
 * @ieda 为头节点的，那么以node为节点的二叉树是一个二叉搜索树；
 * @ieda 2、如果不满足第一种情况，那么就从node的左子树和右子树中递归寻找二叉搜索树，并返回节点数目较多的那个二叉搜索树的头结点
 * @ieda 具体实现步骤：
 * @ieda a、整体使用二叉树的后序遍历
 * @ieda b、遍历到节点cur，先遍历cur的左子树，记录四个变量，记录搜索树的头结点、搜索树的节点数、最小值和最大值；然后在记录右子树的
 * @ieda 四个变量
 * @ieda c、通过b步骤记录的四个变量返回节点数比较大的二叉搜索树
 * @ieda d、可以使用全局变量实现步骤b中收集变量的问题
 *   
 *    
 * 
 */
public class BiggestSubBST {
	
	public static TreeNode biggestSubBST(TreeNode head) {
		int[] record=new int[3];//记录当前节点的最大搜索树的头结点、节点数、最大值和最小值
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
