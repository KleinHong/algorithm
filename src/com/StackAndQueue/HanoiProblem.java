package com.StackAndQueue;
import java.util.Stack;

public class HanoiProblem {
	
	public static String tmp;

	public int hanoiProblem(int num,String left,String mid,String right) {
		// TODO Auto-generated constructor stub
		if(num<1) {
			return 0;
		}
		else {
			return printNumsOfMove1(num,left,mid,right,left,right);
			//return printNumsOfMove1(num,left,mid,right,left,right);
		}
	}
	//递归解法
	public int printNumsOfMove1(int num,String left,String mid,String right,String from,String to) {
		if(num==1) {
			if(from.equals(mid) || to.equals(mid)) {
				System.out.println("Move 1 from "+from+" to "+to);
				return 1;
			}
			else {
				System.out.println("Move 1 from "+from+" to "+mid);
				System.out.println("Move 1 from "+mid+" to "+to);
				return 2;
			}
		}
		if(from.equals(mid) || to.equals(mid)) {
			String another=(from.equals(left) || to.equals(left))?right:left;
			int step1=printNumsOfMove1(num-1,left,mid,right,from,another);
			System.out.println("Move 1 from "+from+" to "+to);
			int step2=1;
			int step3=printNumsOfMove1(num-1,left,mid,right,another,to);
			return step1+step2+step3;
			
		}
		else {
			int step1=printNumsOfMove1(num-1,left,mid,right,from,to);
			System.out.println("Move 1 from "+from+" to "+mid);
			int step2=1;
			int step3=printNumsOfMove1(num-1,left,mid,right,to,from);
			System.out.println("Move 1 from "+mid+" to "+to);
			int step4=1;
			int step5=printNumsOfMove1(num-1,left,mid,right,from,to);
			return step1+step2+step3+step4+step5;
		}
		
		
		
		
		
	}
	
	//循环解法
	
	public static String ltom="1";
	public static String mtol="1";
	public static String mtor="2";
	public static String rtom="2";
	
	public int printNumsOfMove2(int num,String left,String mid,String right) {
		Stack<Integer> sl=new Stack<>();
		Stack<Integer> sm=new Stack<>();
		Stack<Integer> sr=new Stack<>();
		sl.push(Integer.MAX_VALUE);
		sm.push(Integer.MAX_VALUE);
		sr.push(Integer.MAX_VALUE);
		
		for(int i=num;i>0;i--) {
			sl.push(i);
		}
		int step=0;
		tmp=mtor;
		while(sr.size()!=num+1) {
			step+=howToMove(tmp,mtol,sm,sl,mid,left);
			step+=howToMove(tmp,ltom,sl,sm,left,mid);
			step+=howToMove(tmp,mtor,sm,sr,mid,right);
			step+=howToMove(tmp,rtom,sr,sm,right,mid);
		}	
		return step;
	}
	
	public int howToMove(String preStep,String nowStep,Stack<Integer> sf,Stack<Integer> st,String from,String to) {
		if(preStep.equals(nowStep) || sf.peek()>=st.peek()) {
			return 0;
		}
		else {
			tmp=nowStep;
			st.push(sf.pop());
			System.out.println("Move 1 from "+from+" to "+to);
			return 1;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HanoiProblem h=new HanoiProblem();
		System.out.println(h.hanoiProblem(2,"l","m","r"));
		System.out.println("-----------------------------------------------------");
		System.out.println(h.printNumsOfMove2(2,"l","m","r"));
		
	}

}
