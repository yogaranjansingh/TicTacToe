
public class Board {

	int n;
	String board[][];

	public Board(int n) {
		super();
		this.n = n;
		board = new String[n][n];
	}

	boolean victoryPathComplete(int x, int y, String str) {
		return checkRow(str, x) || checkColumn(str, y) || checkDiagnals(str);
	}

	boolean checkRow(String str, int row) {
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			if (!board[row][i].equals(str)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	boolean checkColumn(String str, int col) {
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			if (!board[i][col].equals(str)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	boolean checkDiagnals(String str) {
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			if (!board[i][i].equals(str)) {
				flag = false;
				break;
			}
		}
		if (flag)
			return flag;
		else {
			flag = true;
			int row = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (!board[row++][i].equals(str)) {
					flag = false;
					break;
				}
			}
		}

		return flag;
	}

	void printBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();

			System.out.println("--------------------------------------------------");
		}
	}

	void fillBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = "| (" + i + "," + j + ")   |";
			}
		}
	}

}
