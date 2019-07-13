package com.Tree;
/*
 * 按照格式打印二叉树
 */
public class PrintTree {

	public PrintTree() {
		// TODO Auto-generated constructor stub
	}
	
	public static void printTree(TreeNode head) {
		if(head==null) {
			return;
			
		}
		printInOrder(head,0,"H",17);
		
	}
	public static void printInOrder(TreeNode head,int height,String to,int len){
		if(head==null) {
			return;
		}
		printInOrder(head.right,height+1,"v",len);
		String va1=to+head.value+to;
		int lenM =va1.length();
		int lenl=(len-lenM)/2;
		int lenr=len-lenl-lenM;
		va1=getSpace(lenl)+va1+getSpace(lenr);
		System.out.println(getSpace(height*len)+va1);
		printInOrder(head.left,height+1,"^",len);
		
		
	}
	
	public static String getSpace(int num) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<num;i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode head=BuildTree.buildTree();
		printTree(head);

	}

}
