package com.OtherAlgorithms;
/**
 * hzy：jdk1.8
 */

/**
 * @author 残月
 * @descripition 
 * @ieda
 */
public class RandomNumAndExtend {

	//随机返回一个1-5的的任意整数
	public static int rand1To5() {
		return (int) (Math.random()*5+1);
	}
	
	//以1-p的概率任意产生1的随机函数
	public static int rand1p() {
		double p=0.83;
		return Math.random()<p?0:1;
	}
	//等概率随机产生1-M的随机函数
	public static int rand1ToM(int m) {
		return (int) (Math.random()*m)+1;
	}
	
	
	//使用rand1To5函数等概率产生1-7的随机函数
	public static int rand1To7()  {
		int num=0;
		do {
			num=(rand1To5()-1)*5+rand1To5()-1;
		}while(num>20);
		return num%7+1;
		
	} 
	
	//使用rand1P函数随机产生0和1
	public static int rand01() {
		int num=0;
		do {
			num=rand1p();
		}while(num==rand1p());
		return num;
	}
	//使用rand01函数随机产生1-6
	public static int rand11To6() {
		int num=0;
		do {
			int temp=rand01()*2+rand01();//等概率产生0-3的数
			num=temp*3;
		}while(num>11);
		return num%6+1;
	}
	
	
	//利用rand1ToM函数随机产生1-n的随机数,将数转换成m进制以便判断，如前面的01一样
	
	public static int rand1ToN(int m,int n) {
		int[] nMsys=getMSysNum(n-1,m);
		int[] randNum=getRandMSysNumLessN(nMsys,m);
		return getNumFromMSysNum(randNum,m)+1;
	}
		
	
	
	private static int[] getMSysNum(int value, int m) {
		// TODO Auto-generated method stub
		int[] res=new int[32];
		int index=res.length-1;
		while(value!=0) {
			res[index--]=value%m;
			value=value/m;
		}
		return res;
	}

	private static int[] getRandMSysNumLessN(int[] nMsys, int m) {
		// TODO Auto-generated method stub
		int[] res=new int[nMsys.length];
		int start=0;
		while (nMsys[start]==0) {
			start++;
		}
		int index=start;
		boolean lastEqual=true;
		while(index!=nMsys.length) {
			res[index]=rand1ToM(m)-1;
			if(lastEqual) {
				if(res[index]>nMsys[index]) {
					index=start;
					lastEqual=true;
					continue;
				}else {
					lastEqual=res[index]==nMsys[index];
				}
			}
			index++;
		}
		return res;
	}

	private static int getNumFromMSysNum(int[] randNum, int m) {
		// TODO Auto-generated method stub
		int res=0;
		for(int i=0;i<randNum.length;i++) {
			res=res*m+randNum[i];
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(rand11To6());
		System.out.println(rand1To7());
		System.out.println(rand1ToM(10));
		System.out.println(rand1ToN(10, 8));
		System.out.println(rand1ToN(10, 12));

	}

}
