package com.OtherAlgorithms;
import java.beans.Expression;

public class ExpressionNumByEnglishOrChinese {

	public String num1To9(int num) {
		if (num < 1 || num > 19) {
			return "";
		}
		String[] names = { "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
				"Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
				"Nineteen " };
		return names[num - 1];
	}

	public String num1To99(int num) {
		if (num < 1 || num > 99) {
			return "";
		}
		if (num < 20) {
			return num1To9(num);
		}
		int hight = num / 10;
		String[] tynames = { "Twenty ", "Thirty ", "Fourty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety " };
		return tynames[hight - 2] + num1To9(num % 10);
	}

	public String num1To999(int num) {
		if (num < 1 || num > 999) {
			return "";
		}
		if (num < 99) {
			return num1To99(num);
		}
		int hight = num / 100;
		return num1To9(hight) + "Hundred " + num1To99(num % 100);
	}

	public String getNumByEnglish(int num) {
		if (num == 0) {
			return "Zero";
		}
		String res = "";
		if (num < 0) {

			res = "Negative, ";
		}
		if (num == Integer.MIN_VALUE) {
			res += "Two Billion, ";
			num %= -2000000000;
		}
		num = Math.abs(num);
		int hight = 1000000000;
		int hightindex = 0;
		String[] names = { "Billion", "Million", "Thousand", "" };
		while (num != 0) {
			int cur = num / hight;
			num %= hight;
			if (cur != 0) {
				res += num1To999(cur);
				res += names[hightindex] + (num == 0 ? " " : ", ");
			}
			hight /= 1000;
			hightindex++;
		}
		return res;

	}
	
	
	//使用中文表示数字
	
	public String getNumByChinese(int num) {
		if(num==0) {
			return "零";
		}
		String res=num<0?"负":"";
		int yi=Math.abs(num/100000000);
		int resi=Math.abs(num%100000000);
		if(yi==0) {
			return res+num1to99999999(resi);
		}
		res+=num1to9999(yi)+"亿";
		if(resi==0) {
			return res;
		}else {
			if(resi<10000000) {//判断千万位上是否为0
				return res+"零"+num1to99999999(resi);
			}
			else {
				return res+"零"+num1to99999999(resi);
			}
		}
		
	}

	

	private String num1to99999999(int num) {
		// TODO Auto-generated method stub
		if(num<1 || num>99999999) {
			return "";
		}
		int wan=num/10000;
		int resw=num%10000;
		if(wan==0) {
			return num1to9999(resw);
		}
		String res=num1to9999(wan)+"万";
		if(resw==0) {
			return res;
		}
		else {
			if(resw<1000) {
				return res+"零"+num1to9999(resw);
			}else {
				return res+num1to9999(resw);
			}
		}
	}
	private String num1to9999(int num) {
		// TODO Auto-generated method stub
		if(num<1 || num>9999) {
			return "";
		}
		if(num<1000) {
			return num1To999ByChines(num);
		}
		String res=num1To9ByChines(num/1000)+"千";
		int resq=num%1000;
		if(resq==0) {
			return res;
			
		}else {
			if(resq<100) {
				return res+"零"+num1To99ByChines(resq);
			}else {
				return res+num1To999ByChines(resq);
			}
		}
	}
	private String num1To999ByChines(int num) {
		// TODO Auto-generated method stub
		if(num<1 || num>999) {
			return "";
		}
		if(num<100) {
			return num1To99ByChines(num);
		}
		String res=num1To9ByChines(num/100)+"百";
		int resb=num%100;
		if(resb==0) {
			return res;
			
		}else {
			if(resb<10) {
				return res+"零"+num1To9ByChines(resb);
			}else {
				return res+num1To99ByChines(resb);
			}
		}
	}

	private String num1To99ByChines(int num) {
		// TODO Auto-generated method stub
		if(num<1 || num>99) {
			return "";
		}
		if(num<10) {
			return num1To9ByChines(num);
		}
		String res=num1To9ByChines(num/10)+"十";
		int resg=num%10;
		if(resg==0) {
			return res;
			
		}else {
			
			return res+num1To9ByChines(resg);
			
		}
	}
	private String num1To9ByChines(int num) {
		// TODO Auto-generated method stub
		if(num<1 || num>9) {
			return "";
		}
		String[] names= {"一","二","三","四","五","六","七","八","九"};
		return names[num-1];
	}


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = Integer.MIN_VALUE;
		ExpressionNumByEnglishOrChinese en = new ExpressionNumByEnglishOrChinese();
		System.out.println(en.getNumByEnglish(num));
		System.out.println(en.getNumByChinese(num));
	}

}
