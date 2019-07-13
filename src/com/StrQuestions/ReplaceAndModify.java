package com.StrQuestions;
/**
 * hzy£ºjdk1.8
 */

/**
 * @author ²ÐÔÂ
 * @descripition 
 * @ieda
 */
public class ReplaceAndModify {
	
	public static void replace(char[] chas) {
		if(chas==null || chas.length==0) {
			return;
		}
		int num=0;
		int len=0;
		for(;len<chas.length && chas[len]!=0;len++) {
			if(chas[len]==' ') {
				num++;
			}
		}
		int j=len+2*num-1;
		for(int i=len-1;i>-1;i--) {
			if(chas[i]!=' ') {
				chas[j--]=chas[i];
			}
			else {
				chas[j--]='0';
				chas[j--]='2';
				chas[j--]='%';	
			}
		}
	}
	
	public static void modify(char[] chas) {
		if(chas==null || chas.length==0) {
			return;
		}
		int j=chas.length-1;
		for(int i=chas.length-1;i>-1;i--) {
			if(chas[i]!='*') {
				chas[j--]=chas[i];
			}
		}
		
		for(;j>-1;) {
			chas[j--]='*';
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chas1= {'a',' ','b',' ',' ','c',0,0,0,0,0,0,0,0,0,0,0,0,0};
		char[] chas2= {'a','*','b','*','c','*','*','c'};
		replace(chas1);
		modify(chas2);
		for(char c:chas1) {
			System.out.print(c+" ");
		}
		System.out.println();
		for(char c:chas2) {
			System.out.print(c+" ");
		}
		System.out.println();
		
	}

}
