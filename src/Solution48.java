
public class Solution48 {
	//利用公式交换元素
	/**********************
	 * 套用坐标旋转公式进行计算；旋转四次即可返回原坐标，在此之前需要转换坐标系，
	 * 旋转后在恢复坐标系
	 * @param matrix
	 **********************/
	 public void rotate(int[][] matrix) {
		 int n=matrix.length-1;
		 for(int i=0;i<matrix.length/2;i++) {
			 for(int j=i;j<n-i;j++) {
				 int tmp=matrix[i][j];
				 matrix[i][j]=matrix[n-j][i];
				 matrix[n-j][i]=matrix[n-i][n-j];
				 matrix[n-i][n-j]=matrix[j][n-i];
				 matrix[j][n-i]=tmp;				 
			 }
		 }
	 }
	
	//先导致后对称交换左右元素
	
//    public void rotate(int[][] matrix) {
//        if(matrix.length==0)
//        	return;
//        reverse(matrix);
//        fixmatrix(matrix);
//    }
//    
//    public void reverse(int[][] matrix) {
//    	int r=matrix.length;
//    	for(int i=0;i<r;i++) {
//    		for(int j=0;j<i;j++) {
//    			swap1(matrix,i,j);
//    		}
//    	}
//    }
//    
//    public void fixmatrix(int[][] matrix) {
//    	for(int i=0;i<matrix.length;i++) {
//    		int l=0,r=matrix.length-1;
//    		while(l<r) {
//    			swap2(matrix,i,l,r);
//    			l++;
//    			r--;
//    		}
//    		
//    	}
//    }
//    public void swap1(int[][] matrix,int m,int n) {
//    	int temp=matrix[m][n];
//    	matrix[m][n]=matrix[n][m];
//    	matrix[n][m]=temp;
//    }
//    
//    public void swap2(int[][] matrix,int i,int l,int r) {
//    	int temp=matrix[i][l];
//    	matrix[i][l]=matrix[i][r];
//    	matrix[i][r]=temp;
//    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution48 s=new Solution48();
		//int[][] matrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
		s.rotate(matrix);
		int count=0;
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				
				count++;
				if(count<matrix.length) {
					System.out.print(matrix[i][j]+" ");
				}
				else {
					System.out.print(matrix[i][j]+" ");
					System.out.println();
					count=0;
				}
					
			}
		}
		
	}
}
