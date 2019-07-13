
public class Solution79 {
	public boolean exist(char[][] board, String word) {
		int row=board.length;
		int col=board[0].length;
		int[][] flag=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(isExit(board,flag,word,0,i,j)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isExit(char[][] board,int[][] flag,String word,int index,int i,int j) {
		
		if(i<0 || i>=board.length || j<0 || j>=board[0].length ) {
			return false;
		}
		if(flag[i][j]==1 || board[i][j]!=word.charAt(index)) {
			return false;
		}
//		System.out.print(board[i][j]);
		if(index==(word.length()-1)) {
			return true;
		}
		flag[i][j]=1;
		if(isExit(board,flag,word,index+1,i,j+1) || isExit(board,flag,word,index+1,i+1,j) ||
				isExit(board,flag,word,index+1,i,j-1) || isExit(board,flag,word,index+1,i-1,j))	{
			return true;
		}
		flag[i][j]=0;
		return false;
		
		
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution79 s = new Solution79();
		char[][] board= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word="ABCCED";
		
		System.out.print(s.exist(board, word));
	}
}
