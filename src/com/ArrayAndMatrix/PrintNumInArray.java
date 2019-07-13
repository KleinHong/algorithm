package com.ArrayAndMatrix;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * hzy��jdk1.8
 */

/**
 * @author ����
 * @descripition 
 * @ieda
 */
public class PrintNumInArray {
	
	public static int printHalfMajor(int[] arr) {
		if(arr==null || arr.length<1) {
			throw new RuntimeException("��ǰ���鲻���Ϲ淶");
		}
		int record=1;
		int res=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(res==arr[i]) {
				record++;
			}
			else {
				record--;	
			}
			if(record==0) {
				res=arr[i];
				record=1;
			}
		}
		return res;
		
	}
	
	public static void printNOFKMajor(int[] arr,int k) {
		if(k<2) {
			System.out.println("����һ����Ч��kֵ");
			return;
		}
		Map<Integer,Integer> record=new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			if(record.containsKey(arr[i])) {
				record.put(arr[i],record.get(arr[i])+1);
			}else {
				if(record.size()==k-1) {
					allRecordMinusOne(record);
				}else {
					record.put(arr[i],1);
				}
			}
		}
		Map<Integer,Integer> tmp=getMapOfNum(arr,record);//�洢ÿ�������������г��ֵĴ���
		boolean hasPrint=false;
		for(Entry<Integer, Integer> set:record.entrySet()) {
			Integer key=set.getKey();
			if(tmp.get(key)>arr.length/k) {
				hasPrint=true;
				System.out.print(key+" ");
			}
		}
		System.out.println(hasPrint?"":"û�г��ִ�������n/k����");
		
	}
	

	private static void allRecordMinusOne(Map<Integer, Integer> record) {
		// TODO Auto-generated method stub
		List<Integer> ls=new LinkedList<>();
		for(Entry<Integer, Integer> set:record.entrySet()) {
			Integer key=set.getKey();
			Integer value=set.getValue();
			if(value==1) {
				ls.add(key);
				}
			record.put(key,value-1);
		}
		for(Integer remove:ls) {
			record.remove(remove);
		}
	}

	private static Map<Integer, Integer> getMapOfNum(int[] arr, Map<Integer, Integer> record) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> res=new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) {
			int curNum=arr[i];
			if(record.containsKey(curNum)) {
				if(res.containsKey(curNum)) {
					res.put(curNum,res.get(curNum)+1);
				}else {
					res.put(curNum,1);
				}
			}
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr= {1,1,22,22,22,22,22,2,2,3};
//		System.out.println(printHalfMajor(arr));
		int[] arr= {1,1,1,1,22,22,22,22,2,3};
		printNOFKMajor(arr, 3);
	}

}
