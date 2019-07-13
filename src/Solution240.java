
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length<1) {
        	return false;
        }
        
        int indexR=0;
        int indexC=matrix[0].length-1;
        while(indexR<matrix.length && indexC>-1) {
        	if(matrix[indexR][indexC]==target) {
        		return true;
        	}
        	else if(matrix[indexR][indexC]>target) {
        		indexC--;
        	}
        	else if(matrix[indexR][indexC]<target) {
        		indexR++;
        	}
        }
        return false;
    }

}
