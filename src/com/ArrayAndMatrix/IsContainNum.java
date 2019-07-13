package com.ArrayAndMatrix;

public class IsContainNum {
	public static boolean isContians(int[][] matrix,int k) {
		int row=0;
		int col=matrix[0].length-1;
		while(row<matrix.length && col>-1) {
			if(matrix[row][col]==k) {
				return true;
			}
			else if(matrix[row][col]>k){
				col--;
			}
			else {
				row++;
			}
		}
		return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix= {{0,1,2,5},{2,3,4,7},{4,4,4,8},{5,7,7,9}};
		System.out.println(isContians(matrix, 7));

	}

}
