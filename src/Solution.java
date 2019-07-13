class Solution {
	public boolean validTicTacToe(String[] board) {
		boolean xwin = false;
		boolean ywin = false;
		int diag = 0, antidiag = 0, turns = 0;
		int[] rows = new int[3];
		int[] cols = new int[3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i].charAt(j) == 'X') {
					++turns;
					++rows[i];
					++cols[j];
					if (i == j) {
						++diag;
					}
					if (i + j == 2) {
						++antidiag;
					}
				}
				if (board[i].charAt(j) == 'O') {
					--turns;
					--rows[i];
					--cols[j];
					if (i == j) {
						--diag;
					}
					if (i + j == 2) {
						--antidiag;
					}
				}
			}
		}
		xwin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 || cols[0] == 3 || cols[1] == 3 || cols[2] == 3 || diag == 3
				|| antidiag == 3;
		ywin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 || cols[0] == -3 || cols[1] == -3 || cols[2] == -3
				|| diag == -3 || antidiag == -3;
		if ((xwin && turns == 0) || (ywin && turns == 1))
			return false;
		return (turns == 0 || turns == 1) && (!xwin || !ywin);
	}
}