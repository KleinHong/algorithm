package com.Tree;

public class BuildTree {

	public BuildTree() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static TreeNode buildTree() {
		TreeNode head=new TreeNode(1);
		TreeNode cur=head;
		cur.left=new TreeNode(2);		
		cur.left.left=new TreeNode(4);
		cur.left.right=new TreeNode(5);
		cur.right=new TreeNode(3);
		cur.right.left=new TreeNode(6);
		cur.right.right=new TreeNode(7);
		return head;
	}
	
	public static TreeNode buildDemoTree() {
		TreeNode head=new TreeNode(-3);
		TreeNode cur=head;
		cur.left=new TreeNode(3);		
		cur.left.left=new TreeNode(1);
		cur.left.right=new TreeNode(0);
		cur.left.right.left=new TreeNode(1);
		cur.left.right.right=new TreeNode(6);
		cur.right=new TreeNode(-9);
		cur.right.left=new TreeNode(2);
		cur.right.right=new TreeNode(1);
		return head;
	}

}
