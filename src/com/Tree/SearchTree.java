package com.Tree;
import java.util.Stack;

/*
 * 题目：分别使用递归和循环的方法实现二叉树的前序、中序和后序遍历
 */
public class SearchTree {

	public SearchTree() {
		// TODO Auto-generated constructor stub
	}
	
	//前序遍历
		//1、递归
	public void printTreeByPreOrder1(TreeNode head) {
		if(head==null) {
			return;
		}
		System.out.print(head.value+" ");
		printTreeByPreOrder1(head.left);
		printTreeByPreOrder1(head.right);
		
	}
		//2、循环
	public void printTreeByPreOrder2(TreeNode head) {
		if(head==null) {
			return;
		}
		Stack<TreeNode> s=new Stack<>();
		s.push(head);
		while(!s.isEmpty()) {
			TreeNode cur=s.pop();
			System.out.print(cur.value+" ");
			if(cur.right!=null) {
				s.push(cur.right);
			}
			if(cur.left!=null) {
				s.push(cur.left);
			}
			
		}
		
		
	}
	
	//中序遍历
			//1、递归
	public void printTreeByInOrder1(TreeNode head) {
		if(head==null) {
			return;
		}
		printTreeByInOrder1(head.left);
		System.out.print(head.value+" ");
		printTreeByInOrder1(head.right);
		
	}
	
			//2、循环
	public void printTreeByInOrder2(TreeNode head) {
		if(head!=null) {
			Stack<TreeNode> s=new Stack<>();
			while(!s.isEmpty() || head!=null) {
				if(head!=null) {
					s.push(head);
					head=head.left;
				}
				else {
					head=s.pop();
					System.out.print(head.value+" ");
					head=head.right;
				}
			}
		}
		
	}
	
	//后序遍历
			//1、递归
	
	public void printTreeByPosOrder1(TreeNode head) {
		if(head==null) {
			return;
		}
		printTreeByPosOrder1(head.left);
		printTreeByPosOrder1(head.right);
		System.out.print(head.value+" ");	
	}
	
			//2、循环
				//使用双栈
	public void printTreeByPosOrder2(TreeNode head) {
		if(head!=null) {
			Stack<TreeNode> s1=new Stack<>();
			Stack<TreeNode> s2=new Stack<>();
			s1.push(head);
			while(!s1.isEmpty()) {
				head=s1.pop();
				s2.push(head);
				if(head.left!=null) {
					s1.push(head.left);
				}
				if(head.right!=null) {
					s1.push(head.right);
				}
			}
			while(!s2.isEmpty()) {
				System.out.print(s2.pop().value+" ");
			}
		}
	}
	
				//使用单栈
	public void printTreeByPosOrder21(TreeNode head) {
		if(head!=null) {
			Stack<TreeNode> s=new Stack<>();
			s.push(head);
			TreeNode cur=null;
			while(!s.isEmpty()) {
				cur=s.peek();
				if(cur.left!=null && head!=cur.left && head!=cur.right) {
					s.push(cur.left);
				}
				else if(cur.right!=null && head!=cur.right) {
					s.push(cur.right);
				}
				else {
					System.out.print(s.pop().value+" ");
					head=cur;
				}
			}	
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchTree st=new SearchTree();
		TreeNode head1=BuildTree.buildTree();
		TreeNode head2=BuildTree.buildTree();
		TreeNode head3=BuildTree.buildTree();
		System.out.println("前序遍历：");
		System.out.println("  递归：");
		st.printTreeByPreOrder1(head1);
		System.out.println();
		System.out.println("  循环：");
		st.printTreeByPreOrder2(head1);
		System.out.println();
		
		System.out.println("中序遍历：");
		System.out.println("  递归：");
		st.printTreeByInOrder1(head2);
		System.out.println();
		System.out.println("  循环：");
		st.printTreeByInOrder2(head2);
		System.out.println();
		
		System.out.println("后序遍历：");
		System.out.println("  递归：");
		st.printTreeByPosOrder1(head3);
		System.out.println();
		System.out.println("  循环：");
		st.printTreeByPosOrder2(head3);
		System.out.println();
		st.printTreeByPosOrder21(head3);
		

	}

}
