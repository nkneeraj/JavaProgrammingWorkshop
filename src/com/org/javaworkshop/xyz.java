import java.util.Scanner;

public class TicTacToe {

	private static Scanner sc = new Scanner(System.in);
	private static char playerMark;
	private static char computerMark;
	private static char[] gameBoard;
	private static int position;

	// master
	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe Game");
//		gameBoard = createBoard();

//		toss();
//		System.out.println("Enter player Mark");
//		playerMark = playerMark();
//		computerMark = (playerMark == 'X') ? 'O' : 'X';
//		System.out.println("Player Mark: " + playerMark);
//		System.out.println("Computer mark: " + computerMark);

	}

public static void winPosition(char Mark)
	{	char Mark;
		int position = 0;
		for (int i = 1; i < gameBoard.length && gameBoard[i] == ' '; i++) {
			if (i == 1) {
				if ((gameBoard[2] == Mark && gameBoard[3] == Mark)
						|| (gameBoard[4] == Mark && gameBoard[7] == Mark)
						|| (gameBoard[5] == Mark && gameBoard[9] == Mark))
					position = i;
			}
			if (i == 2) {
				if ((gameBoard[1] == Mark && gameBoard[3] == Mark)
						|| (gameBoard[5] == Mark && gameBoard[8] == Mark))
					position = i;
			}
			if (i == 3) {
				if ((gameBoard[2] == Mark && gameBoard[1] == Mark)
						|| (gameBoard[6] == Mark && gameBoard[9] == Mark)
						|| (gameBoard[5] == Mark && gameBoard[7] == Mark))
					position = i;
			}
			if (i == 4) {
				if ((gameBoard[1] == Mark && gameBoard[7] == Mark)
						|| (gameBoard[5] == Mark && gameBoard[6] == Mark))
					position = i;
			}
			if (i == 5) {
				if ((gameBoard[1] == Mark && gameBoard[9] == Mark)
						|| (gameBoard[3] == Mark && gameBoard[7] == Mark)
						|| (gameBoard[2] == Mark && gameBoard[8] == Mark)
						|| (gameBoard[4] == Mark && gameBoard[6] == Mark))
					position = i;
			}
			if (i == 6) {
				if ((gameBoard[3] == Mark && gameBoard[9] == Mark)
						|| (gameBoard[5] == Mark && gameBoard[4] == Mark))
					position = i;
			}
			if (i == 7) {
				if ((gameBoard[1] == Mark && gameBoard[4] == Mark)
						|| (gameBoard[9] == Mark && gameBoard[8] == Mark)
						|| (gameBoard[5] == Mark && gameBoard[3] == Mark))
					position = i;
			}
			if (i == 8) {
				if ((gameBoard[2] == Mark && gameBoard[5] == Mark)
						|| (gameBoard[7] == Mark && gameBoard[9] == Mark))
					position = i;
			}
			if (i == 9) {
				if ((gameBoard[7] == Mark && gameBoard[8] == Mark)
						|| (gameBoard[3] == Mark && gameBoard[6] == Mark)
						|| (gameBoard[5] == Mark && gameBoard[1] == Mark))
					position = i;
			} else
				position = 0;
		}
	}
	}