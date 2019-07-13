import java.util.HashSet;
import java.util.Set;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
    	//由于矩阵中存在重复的.号，故再碰到.号跳过该循环
    	HashSet<Character>[] row=new HashSet[9];
    	HashSet<Character>[] col=new HashSet[9];
    	HashSet<Character>[] sub=new HashSet[9];
    	for(int k=0;k<9;k++) {
    		row[k]=new HashSet<Character>();
    		col[k]=new HashSet<Character>();
    		sub[k]=new HashSet<Character>();
    		
    	}
    	for(int i=0;i<9;i++) {
    		for(int j=0;j<9;j++) {
    			char num=board[i][j];
    			if(num=='.') {
    				continue;
    			}
    			if(!row[i].contains(num)) {
    				row[i].add(num);
    			}
    			else
    				return false;
    			if(!col[j].contains(num)) {
    				col[j].add(num);
    			}
    			else
    				return false;
    			if(!sub[(i/3)* 3+j/3].contains(num)) {
    				sub[(i/3)* 3+j/3].add(num);
    			}
    			else
    				return false;		
    		}
    	}
    	return true;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
