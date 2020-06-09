import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to  Noughts and Crosses \n");

		String playerNames[] = new String[2];
		System.out.println("Enter player 1 name");
		playerNames[0] = sc.nextLine();
		System.out.println("Enter player 2 name");
		playerNames[1] = sc.nextLine();

		System.out.println("Please enter the size of board to start the game, in the rang [3-9]\n");
		int n = sc.nextInt();
		if (n < 3 || n > 9) {
			System.out.println("Invalid Input, Starting game again");
			main(null);
		}

		String symbol[] = { "    X    ", "     O    " };

		Board board = new Board(n);

		board.fillBoard();
		board.printBoard();

		int moveCount = 0;
		boolean matchConcluded = false;

		int playerIndex = 1;

		sc.nextLine();
		String coordinate[] = new String[2];
		int x, y;

		while (moveCount < (n * n) && !matchConcluded) {
			System.out.println(playerNames[playerIndex - 1] + "  your move !! enter x,y eg 0,0");
			String move = "";

			try {
				move = sc.nextLine();
				coordinate = move.split(",");
				x = Integer.valueOf(coordinate[0]);
				y = Integer.valueOf(coordinate[1]);
				if(x>n || x<0 || y>n || y<0)
				{
					throw new Exception("Invalid input, please enter again");
				}
				
				if (playerIndex == 1) {
					playerIndex = 2;
					board.board[x][y] = symbol[0];
				} else {
					playerIndex = 1;
					board.board[x][y] = symbol[1];
				}
				System.out.println("\n***************************************************");
				System.out.println("***************************************************\n");
				board.printBoard();

				if (board.victoryPathComplete(x, y, symbol[playerIndex == 1 ? 1 : 0])) {
					System.out.println("\n***************************************************");
					System.out.println("**********" + playerNames[playerIndex == 1 ? 1 : 0] + " wins*****************");
					System.out.println("********** Game Over *****************");
					System.out.println("\n***************************************************");
					matchConcluded = true;
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
				//e.printStackTrace();
				continue;
			}
			moveCount++;
		}
		
		if(matchConcluded==false && moveCount>8) {
			System.out.println("************Match Drawn **************");
		}
		

		System.out.println("Enter 1 to start again");
		int input = sc.nextInt();
		if (input == 1)
			main(null);
	}

}
